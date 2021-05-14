package entities;

import render.Model;
import render.ModelManager;
import utils.Direction;

public class Projectile extends Entity{
	
	private int lifetime;

	public Projectile(int posx, int posy, Direction facing) {
		super(posx, posy, ModelManager.model(ModelManager.FIREBALL_PLAYER));
		this.facing = facing;
		this.lifetime = 0;
		this.fallSpeed = fallSpeed / 2;
	}

	@Override
	public void move() {
		if(this.facing == Direction.RIGHT) {
			this.posx += 10;
		} else {
			this.posx -= 10;
		}
		this.lifetime++;
	}
	
	public boolean shouldDespawn() {
		return this.lifetime > 50;
	}
	
	public void setShouldDespawn() {
		this.lifetime = 50;
	}
}