package entities;

import render.Animation;
import render.Model;
import render.ModelManager;
import gameStates.GameStateManager;
import utils.Direction;
import entities.Projectile;

public final class Player extends Entity {

	private int shotDelay;
	
	private int deathTime;
	
	private Animation walking;
	private Animation death;
	
	public Player(int posx, int posy) {
		super(posx, posy, ModelManager.model(ModelManager.PLAYER));
	
		this.movementSpeed = 7;
		this.shotDelay = 0;
		
		this.deathTime = 0;
		
		this.walking = new Animation(10, ModelManager.model(ModelManager.PLAYER_RUN1), ModelManager.model(ModelManager.PLAYER_RUN2), ModelManager.model(ModelManager.PLAYER_RUN3));
		this.death = new Animation(10, ModelManager.model(ModelManager.PLAYER_DEATH));
	}
	
	public Projectile shootFireball() {
		if(shotDelay < 0) {
			this.shotDelay = 30;
			if(this.facing == Direction.RIGHT) {
				return new Projectile(this.posx + this.getModel().width +2, this.posy + this.getModel().height/2, facing);
			} else {
				return new Projectile(this.posx - ModelManager.model(ModelManager.FIREBALL_PLAYER).width -2, this.posy + this.getModel().height/2, facing);
			}
		}
		return null;
	}
	
	@Override
	public void move() {
		if(!this.dead) 
			super.move();
			
			this.shotDelay--;
		if(this.shotDelay == -30) {
			this.shotDelay = -1;
		}
		
		if(this.dead) {
			this.deathTime++;
		}
		changeAnimations();
	}
	
	public boolean shouldRespawn() {
		return deathTime >= 75;
	}
	
	private void changeAnimations() {
		if(this.fallSpeed < 0 && this.isInAir) {
			this.setModel(ModelManager.model(ModelManager.PLAYER_JUMP));
		} else {
			if(this.left || this.right) {
				this.setModel(walking.getCurrentFrame());
			} else {
				this.setModel(ModelManager.model(ModelManager.PLAYER));
			}
		}
		if(this.dead) {
			this.setModel(death.getCurrentFrame());
		}
	}
	
	@Override
	public void onEntityCollision(Entity entity, GameStateManager gsm) {
		if(entity instanceof Slime || entity instanceof Dragon) {
			this.setDead(true);
		}
	}
}