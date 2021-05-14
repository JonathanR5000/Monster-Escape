package world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import entities.Dragon;
import entities.Lava;
import entities.Player;
import entities.Slime;
import entities.StaticEntity;
import entities.exitPortal;
import render.Model;
import render.ModelManager;

public class Map {

	private Player player;
	private ArrayList<StaticEntity> blocks;
	private ArrayList<Slime> slime;
	private ArrayList<Dragon> dragon;

	private int height;
	private int width;
	
	public Map(int levelIndex) {
		this.blocks = new ArrayList<>();
		this.slime = new ArrayList<>();
		this.dragon = new ArrayList<>();
		
		System.out.println("[World][Map]: Loading map file "+ levelIndex);
		this.loadFile(levelIndex);
	}
	
	public ArrayList<StaticEntity> getBlocks(){
		return blocks;
	}
	
	public ArrayList<Slime> getSlime(){
		return slime;
	}
	
	public ArrayList<Dragon> getDragon(){
		return dragon;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	private void loadFile(int levelIndex) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File("Maps/level"+levelIndex+".txt")));
			
			this.height = Integer.parseInt(reader.readLine());
			this.width = Integer.parseInt(reader.readLine());
			
			Model blockModelA = ModelManager.model("tile_A");
			Model blockModelB = ModelManager.model("tile_B");
			Model blockModelC = ModelManager.model("tile_C");
			Model blockModelD = ModelManager.model("tile_D");
			Model blockModelE = ModelManager.model("tile_E");
			Model blockModelF = ModelManager.model("tile_F");
			Model blockModelG = ModelManager.model("tile_G");
			Model blockModelH = ModelManager.model("tile_H");
			Model blockModelI = ModelManager.model("tile_I");
			Model blockModelJ = ModelManager.model("tile_J");
			Model blockModelK = ModelManager.model("tile_K");
			Model blockModelL = ModelManager.model("tile_L");
			Model blockModelM = ModelManager.model("tile_M");
			Model blockModelN = ModelManager.model("tile_N");
			Model blockModelO = ModelManager.model("tile_O");
			Model blockModelP = ModelManager.model("tile_P");
			Model blockModelQ = ModelManager.model("tile_Q");
			Model blockModelR = ModelManager.model("tile_R");
			Model blockModelS = ModelManager.model("tile_S");
			
			// Create animation for portal
			// Replace letters with powerUps
			// How to include the healhBar? (In levelOne State) once lifePowerUp is observed, increase playerLives++
			// Draw background in maybe levelOneState?
			// Try to develop isFlying animation on eyeFly monster
			
			for(int y = 0; y < height; y++) {
				String line = reader.readLine();
				String[] singles = line.split("\\s+");
				for(int x = 0; x < width; x++) {
					switch(singles[x]) {
					case "X":
						this.player = new Player(x * blockModelA.width, y * blockModelA.height);
						break;
					case "A":
						this.blocks.add(new StaticEntity(x * blockModelA.width, y * blockModelA.height, blockModelA));
						break;
					case "B":
						this.blocks.add(new StaticEntity(x * blockModelB.width, y * blockModelB.height, blockModelB));
						break;
					case "C":
						this.blocks.add(new StaticEntity(x * blockModelC.width, y * blockModelC.height, blockModelC));
						break;
					case "D":
						this.blocks.add(new StaticEntity(x * blockModelD.width, y * blockModelD.height, blockModelD));
						break;
					case "E":
						this.blocks.add(new StaticEntity(x * blockModelE.width, y * blockModelE.height, blockModelE));
						break;
					case "F":
						this.blocks.add(new StaticEntity(x * blockModelF.width, y * blockModelF.height, blockModelF));
						break;
					case "G":
						this.blocks.add(new StaticEntity(x * blockModelG.width, y * blockModelG.height, blockModelG));
						break;
					case "H":
						this.blocks.add(new StaticEntity(x * blockModelH.width, y * blockModelH.height, blockModelH));
						break;
					case "I":
						this.blocks.add(new StaticEntity(x * blockModelI.width, y * blockModelI.height, blockModelI));
						break;
					case "J":
						this.blocks.add(new StaticEntity(x * blockModelJ.width, y * blockModelJ.height, blockModelJ));
						break;
					case "K":
						this.blocks.add(new StaticEntity(x * blockModelK.width, y * blockModelK.height, blockModelK));
						break;
					case "L":
						this.blocks.add(new StaticEntity(x * blockModelL.width, y * blockModelL.height, blockModelL));
						break;
					case "M":
						this.blocks.add(new StaticEntity(x * blockModelM.width, y * blockModelM.height, blockModelM));
						break;
					case "N":
						this.blocks.add(new StaticEntity(x * blockModelN.width, y * blockModelN.height, blockModelN));
						break;
					case "O":
						this.blocks.add(new StaticEntity(x * blockModelO.width, y * blockModelO.height, blockModelO));
						break;
					case "P":
						this.blocks.add(new StaticEntity(x * blockModelP.width, y * blockModelP.height, blockModelP));
						break;
					case "Q":
						this.blocks.add(new StaticEntity(x * blockModelQ.width, y * blockModelQ.height, blockModelQ));
						break;
					case "R":
						this.blocks.add(new StaticEntity(x * blockModelR.width, y * blockModelR.height, blockModelR));
						break;
					case "S":
						this.blocks.add(new StaticEntity(x * blockModelS.width, y * blockModelS.height, blockModelS));
						break;
					case "1":
						this.slime.add(new Slime(x * blockModelA.width, y * blockModelA.height));
						break;
					case "2":
						this.dragon.add(new Dragon(x * blockModelA.width, y * blockModelA.height));
						break;
					case "*":
						this.blocks.add(new exitPortal(x * blockModelA.width, y * blockModelA.height - 20));
						break;
					case "^":
						this.blocks.add(new Lava(x * blockModelL.width, y * blockModelL.height));
						break;
					}
				}
			}
		} catch(Exception e) {
			System.err.println("[World][Map]: Couldn't load map file "+ levelIndex);
			this.loadFile(levelIndex - 1);
		}
	}
}