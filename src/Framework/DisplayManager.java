package Framework;

import javax.swing.JFrame;

public class DisplayManager {

	public static final int WIDTH = 1440;
	public static final int HEIGHT = 800;
	
	public static void createDisplay() {
		System.out.println("[Render][Display Manager]: Creating a window...");
		
		JFrame window = new JFrame("Platform Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 50, WIDTH, HEIGHT);
		window.add(new GameScreen());
		window.setResizable(false);
		window.setVisible(true);
	}	
}