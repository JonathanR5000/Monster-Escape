package entities;

import gameStates.GameStateManager;
import render.Animation;
import render.ModelManager;
import utils.Direction;

public class Dragon extends Entity{
	
	private Animation walk;

	public Dragon(int posx, int posy) {
		super(posx, posy, ModelManager.model(ModelManager.DRAGON));
		this.left = true;
		this.movementSpeed = 2;
		
		this.walk = new Animation(10, ModelManager.model(ModelManager.DRAGON) ,ModelManager.model(ModelManager.DRAGON_WALK1), ModelManager.model(ModelManager.DRAGON_WALK2), ModelManager.model(ModelManager.DRAGON_WALK3));
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
			this.setModel(walk.getCurrentFrame());
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