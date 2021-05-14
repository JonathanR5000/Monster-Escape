package entities;

import Framework.DisplayManager;

public class Camera extends StaticEntity{

	public Camera(Entity player) {
		super(player.posx - DisplayManager.WIDTH / 2, player.posy - DisplayManager.HEIGHT / 2, null);
	}
	
	public void setPosition(int x, int y) {
		this.posx = x - DisplayManager.WIDTH / 2;
		this.posy = y - DisplayManager.HEIGHT / 2;
	}
}