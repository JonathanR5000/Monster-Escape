package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Framework.DisplayManager;
import entities.Camera;
import entities.Dragon;
import entities.Entity;
import entities.Player;
import entities.Projectile;
import entities.Slime;
import entities.StaticEntity;
import gameStates.GameState;
import gameStates.GameStateManager;
import render.ModelManager;
import render.Renderer;
import world.Map;

public class LevelOneState extends GameState{

	private Player player;
	private Camera camera;
	
	private ArrayList<StaticEntity> blocks;
	private ArrayList<Projectile> projectilesOnSceen;
	private ArrayList<Slime> slimeInLevel;
	private ArrayList<Dragon> dragonInLevel;
	public ArrayList<StaticEntity> extraEntities;
	
	private static int playerLives = 6;
	private static int levelIndex = 0;
	public static final boolean[] items = new boolean[6];
	
	public LevelOneState(GameStateManager gsm) {
		super(gsm);
		System.out.println("[GameStates][LevelOneState]: Creating level state...");
	}
	
	@Override
	public void init() {
		levelIndex++;
		this.reset();
	}
	
	private void reset() {
		Map map = new Map(levelIndex);
		
		this.player = map.getPlayer();
		this.camera = new Camera(player);
		this.blocks = map.getBlocks();
		this.projectilesOnSceen = new ArrayList<>();
		this.slimeInLevel = map.getSlime();
		this.dragonInLevel = map.getDragon();
		this.extraEntities = new ArrayList<>();
	}
	
	@Override
	public void tick() {
		this.moveEntities();
		this.checkCollisions();
		
		this.findEntitiesToDespawn();
		this.respawnPlayerIfNecessary();

		this.camera.setPosition(player.getPosX(), player.getPosY());
	}
	
	@Override
	public void render(Graphics graphics) {
		Renderer.renderEntity(player, camera, graphics);
		
		for(StaticEntity block : this.blocks) {
			Renderer.renderEntity(block, camera, graphics);
		}
		
		for(Projectile arrow : this.projectilesOnSceen) {
			Renderer.renderEntity(arrow, camera, graphics);
		}
		
		for(Slime slime : this.slimeInLevel) {
			Renderer.renderEntity(slime, camera, graphics);
		}
		
		for(Dragon dragon : this.dragonInLevel) {
			Renderer.renderEntity(dragon, camera, graphics);
		}
		
		for(StaticEntity extra : this.extraEntities) {
			Renderer.renderEntity(extra, camera, graphics);
		}
		
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, DisplayManager.HEIGHT - 85, DisplayManager.WIDTH, 85);
		if(playerLives == 6) {
			Renderer.renderModel(ModelManager.model(ModelManager.HEALTHBAR6), DisplayManager.WIDTH - 1430, DisplayManager.HEIGHT - 75, graphics);
		}
		else if(playerLives == 5) {
			Renderer.renderModel(ModelManager.model(ModelManager.HEALTHBAR5), DisplayManager.WIDTH - 1430, DisplayManager.HEIGHT - 75, graphics);
		}
		else if(playerLives == 4) {
			Renderer.renderModel(ModelManager.model(ModelManager.HEALTHBAR4), DisplayManager.WIDTH - 1430, DisplayManager.HEIGHT - 75, graphics);
		}
		else if(playerLives == 3) {
			Renderer.renderModel(ModelManager.model(ModelManager.HEALTHBAR3), DisplayManager.WIDTH - 1430, DisplayManager.HEIGHT - 75, graphics);
		}
		else if(playerLives == 2) {
			Renderer.renderModel(ModelManager.model(ModelManager.HEALTHBAR2), DisplayManager.WIDTH - 1430, DisplayManager.HEIGHT - 75, graphics);
		}
		else if(playerLives == 1) {
			Renderer.renderModel(ModelManager.model(ModelManager.HEALTHBAR1), DisplayManager.WIDTH - 1430, DisplayManager.HEIGHT - 75, graphics);
		}
		else if(playerLives == 0) {
			//  render nothing
		}
	}

	@Override
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_LEFT) {
			this.player.setLeft(true);
		}
		else if(key == KeyEvent.VK_RIGHT) {
			this.player.setRight(true);
		}
		else if(key == KeyEvent.VK_UP) {
			this.player.jump();
		}
		else if(key == KeyEvent.VK_SPACE) {
			Projectile p = this.player.shootFireball();
			if(p != null) this.projectilesOnSceen.add(p);
		}
	}

	@Override
	public void keyReleased(int key) {
		if(key == KeyEvent.VK_LEFT) {
			this.player.setLeft(false);
		}
		else if(key == KeyEvent.VK_RIGHT) {
			this.player.setRight(false);
		}
	}
	
	/**Calls Entity.move() on all entities<br>
	 * Doesn't move camera because it must be moved after checking collisions<br>
	 * Called at beginning of tick
	 */
	private void moveEntities() {
		this.player.move();

		if(!this.player.isDead()) { // Add other eneies later
			for(Slime slime : this.slimeInLevel) {
				slime.move();
			}
			
			for(Dragon dragon : this.dragonInLevel) {
				dragon.move();
			}
			
			for(Projectile prj : this.projectilesOnSceen) {
				prj.move();
			}
			for(StaticEntity entity : this.extraEntities) {
				if(entity instanceof Entity) {
					((Entity) entity).move();
				}
			}
		}
	}
	
	/**Handles collision between entities<br>
	 * Iterates through this.blocks and check collision with player<br>
	 * For every block iterates through enemies and arrows and check collisions with them<br>
	 * For every enemy iterates through arrows and check collision between them
	 */
	private void checkCollisions() {
		for(StaticEntity block : this.blocks) {
			this.player.checkCollision(block, gsm);
			
			for(Slime slime : this.slimeInLevel) {
				slime.checkCollision(block, gsm);
				for(Projectile arrow : this.projectilesOnSceen) {
					arrow.checkCollision(slime, gsm);
				}
				slime.checkCollision(player, gsm);
			}
			
			for(Dragon dragon : this.dragonInLevel) {
				dragon.checkCollision(block, gsm);
				for(Projectile arrow : this.projectilesOnSceen) {
					arrow.checkCollision(dragon, gsm);
				}
				dragon.checkCollision(player, gsm);
			}
			
			for(Projectile fireBall : this.projectilesOnSceen) {
				fireBall.checkCollision(block, gsm);
			}
			
			for(StaticEntity entity : this.extraEntities) {
				if(entity instanceof Entity) {
					((Entity) entity).checkCollision(block, gsm);
				}
			}
		}

		for(StaticEntity entity : this.extraEntities) {
			this.player.checkCollision(entity, gsm);
		}
	}

	/**Removes enemies and projectiles if they should despawn or if they're dead*/
	private void findEntitiesToDespawn() {
		for(int i = 0; i < this.projectilesOnSceen.size(); i++) {
			if(this.projectilesOnSceen.get(i).shouldDespawn())
				this.projectilesOnSceen.remove(i);
		}
		// Add other for loop for other enemies
		for(int i = 0; i < this.slimeInLevel.size(); i++) {
			if(this.slimeInLevel.get(i).isDead())
				this.slimeInLevel.remove(i);
		}
		
		for(int i = 0; i < this.dragonInLevel.size(); i++) {
			if(this.dragonInLevel.get(i).isDead())
				this.dragonInLevel.remove(i);
		}
		
		for(int i = 0; i < this.extraEntities.size(); i++) {
			if(this.extraEntities.get(i) instanceof Entity) {
				if(((Entity) this.extraEntities.get(i)).isDead())
					this.extraEntities.remove(i);
			}
		}
	}
	
	/**Checks if player should respawn<br>
	 * If so resets the level or pass to game over state
	 */
	private void respawnPlayerIfNecessary() {
		if(this.player.shouldRespawn()) {
			this.player.setDead(false);
			playerLives--;
			if(playerLives >= 0) {
				this.reset();
			} else {
				this.gsm.addState(new GameOver(gsm));
				levelIndex = 0;
				playerLives = 6;
			}
		}
	}
}
