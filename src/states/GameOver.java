package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Framework.DisplayManager;
import gameStates.GameState;
import gameStates.GameStateManager;

public class GameOver extends GameState{

	public GameOver(GameStateManager gsm) {
		super(gsm);
		System.out.println("[GameStates][GameOver]: Creating game over state...");
	}
	
	@Override
	public void init() {}
	
	@Override
	public void tick() {}
	
	@Override
	public void render(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, DisplayManager.WIDTH, DisplayManager.HEIGHT);
		
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Arial", Font.PLAIN, 80));
		graphics.drawString("Game Over!", 500, 200);
		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("Arial", Font.PLAIN, 20));
		graphics.drawString("Press any button to continue", 600, 250);
	}
	
	@Override
	public void keyPressed(int key) {}
	
	@Override
	public void keyReleased(int key) {
		this.gsm.clearStack();
		this.gsm.addState(new MenuState(gsm));
	}
}