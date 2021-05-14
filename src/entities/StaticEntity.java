package entities;

import gameStates.GameStateManager;
import render.Model;

public class StaticEntity {

	private Model model;
	
	protected int posx;
	protected int posy;
	
	public StaticEntity(int posx, int posy, Model model) {
		this.posx = posx;
		this.posy = posy;
		this.model = model;
	}
	
	public int getPosX() {
		return posx;
	}
	
	public int getPosY() {
		return posy;
	}
	
	public Model getModel() {
		model.x = posx;
		model.y = posy;
		return model;
	}
	
	protected void setModel(Model model) {
		this.model = model;
	}
	
	public void onEntityCollision(Entity entity, GameStateManager gsm) {
		return;
	}
}