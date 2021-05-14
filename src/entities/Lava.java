package entities;

import gameStates.GameStateManager;
import render.Model;
import render.ModelManager;

public class Lava extends StaticEntity{

	public Lava(int posx, int posy) {
		super(posx, posy, ModelManager.model(ModelManager.LAVA));
	}
	
	@Override 
	public void onEntityCollision(Entity entity, GameStateManager gsm) {
		entity.setDead(true);
	}
}