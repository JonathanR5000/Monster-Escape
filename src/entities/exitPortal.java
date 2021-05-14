package entities;

import gameStates.GameStateManager;
import render.Animation;
import render.ModelManager;
import states.LevelOneState;

public class exitPortal extends StaticEntity{
	
	private Animation hoverEffect;
	
	public exitPortal(int posx, int posy) {
		super(posx, posy, ModelManager.model(ModelManager.PORTAL1));
		
		this.hoverEffect = new Animation(10, ModelManager.model(ModelManager.PORTAL1), ModelManager.model(ModelManager.PORTAL2), ModelManager.model(ModelManager.PORTAL3));
	}
	
	@Override
	public void onEntityCollision(Entity entity, GameStateManager gsm) {
		if(entity instanceof Player) {
			gsm.addState(new LevelOneState(gsm));
		}
	}
}