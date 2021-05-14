package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Framework.DisplayManager;
import gameStates.GameState;
import gameStates.GameStateManager;

public class MenuState extends GameState {

	private String[] optionsMenu;
	private int selected;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
		System.out.println("[GameStates][MenuState]: Creating menu...");
	}

	@Override
	public void init() {
		this.optionsMenu = new String[] {"Start", "Options", "Quit"};
		this.selected = 0;
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics graphics) {
		graphics.setColor(new Color(47, 80, 124));
		graphics.fillRect(0, 0, DisplayManager.WIDTH, DisplayManager.HEIGHT);
		
		graphics.setColor(Color.ORANGE);
		graphics.setFont(new Font("Arial", Font.PLAIN, 80));
		graphics.drawString("Monster Escape", 450, 200);
		
		graphics.setFont(new Font("Arail", Font.PLAIN, 42));
		for(int i = 0; i < optionsMenu.length; i++) {
			if(selected == i) graphics.setColor(Color.RED);
			else graphics.setColor(Color.WHITE);
			
			graphics.drawString(optionsMenu[i], DisplayManager.WIDTH / 2 - 100, 305 + i * 120);
		}
	}

	@Override
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_UP) {
			if(selected > 0) selected--;
		}
		else if(key == KeyEvent.VK_DOWN) {
			if(selected < optionsMenu.length-1) selected++;
		}
		else if(key == KeyEvent.VK_ENTER) {
			if(selected == 0) {
				gsm.addState(new LevelOneState(gsm));
			} else if(selected == 2) {
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(int key) {}

}