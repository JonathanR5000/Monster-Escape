package entities;

import gameStates.GameStateManager;
import render.Animation;
import render.ModelManager;
import utils.Direction;

public class Slime extends Entity{
	
	private Animation slither;

	public Slime(int posx, int posy) {
		super(posx, posy, ModelManager.model(ModelManager.SLIME));
		this.left = true;
		this.movementSpeed = 2;
		
		this.slither = new Animation(10, ModelManager.model(ModelManager.SLIME) ,ModelManager.model(ModelManager.SLIME_SLITHER1), ModelManager.model(ModelManager.SLIME_SLITHER2));
	}

	@Override
	public Direction checkCollision(StaticEntity block, GameStateManager gsm) {
		switch(super.checkCollision(block, gsm)) {
		case LEFT:
			this.left = true;
			this.right = false;
			return Direction.LEFT;
		case RIGHT:
			this.right = true;
			this.left = false;
			return Direction.RIGHT;
		default:
			return null;
		}
	}
	
	@Override
	public void move() {
		super.move();
		if(this.left || this.right) {
			this.setModel(slither.getCurrentFrame());
		}
	}
	
	@Override
	public void onEntityCollision(Entity entity, GameStateManager gsm) {
		if(entity instanceof Projectile) {
			this.setDead(true);
			((Projectile) entity).setShouldDespawn();
		}
	}	
}