package Game;

import java.awt.EventQueue;

import javax.swing.Timer;

import Framework.DisplayManager;
import Framework.GameLoop;
import gameStates.GameStateManager;
import render.ModelManager;

public class Game {

	private static Timer timer;
	private static boolean running = false;
	
	private static GameStateManager stateManager;
	
	public static void main(String[]args) {
		System.out.println("[Main][Game]: Starting...");
		
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				ModelManager.init();
				DisplayManager.createDisplay();
				
				startGame();
				System.out.println("[Main][Game]: Started");
			}
		});
	}
	
	public static void startGame() {
		stateManager = new GameStateManager();
		
		running = true;
		timer = new Timer(20, new GameLoop());
		timer.start();
	}
	
	public static boolean isRunning() {
		return running;
	}
	
	public static GameStateManager getStateManager() {
		return stateManager;
	}
}