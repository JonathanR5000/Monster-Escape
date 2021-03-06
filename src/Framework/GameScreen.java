package Framework;

import java.awt.Graphics;

import javax.swing.JPanel;

import input.Keyboard;
import Game.Game;

public class GameScreen extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public GameScreen() {
		super();
		System.out.println("[Render][GameScreen]: Creating game screen");
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keyboard());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(Game.isRunning()) {
			Game.getStateManager().render(g);
		}
		repaint();
	}
}