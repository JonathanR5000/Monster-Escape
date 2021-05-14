package render;

import java.util.HashMap;

public class ModelManager {
	// Left at 1:19
	
	private static final HashMap<String, Model> models = new HashMap<>();
	
	public static final String PLAYER = "stand";
	public static final String PLAYER_ICON = "health_icon";
	public static final String TILE_A = "tile_A";
	public static final String TILE_B = "tile_B";
	public static final String TILE_C = "tile_C";
	public static final String TILE_D = "tile_D";
	public static final String TILE_E = "tile_E";
	public static final String TILE_F = "tile_F";
	public static final String LAVA = "tile_G";
	public static final String TILE_H = "tile_H";
	public static final String TILE_I = "tile_I";
	public static final String TILE_J = "tile_J";
	public static final String TILE_K = "tile_K";
	public static final String TILE_L = "tile_L";
	public static final String TILE_M = "tile_M";
	public static final String TILE_N = "tile_N";
	public static final String TILE_O = "tile_O";
	public static final String TILE_P = "tile_P";
	public static final String TILE_Q = "tile_Q";
	public static final String TILE_R = "tile_R";
	public static final String TILE_S = "tile_S";
	public static final String FIREBALL_DRAGON = "dragon_shot";
	public static final String FIREBALL_PLAYER = "player_shot";
	public static final String PLAYER_JUMP = "jump";
	public static final String PLAYER_RUN1 = "run01";
	public static final String PLAYER_RUN2 = "run02";
	public static final String PLAYER_RUN3 = "run03";
	public static final String PLAYER_DEATH = "dead";
	public static final String PLAYER_SHOOT = "player_shoot";
	public static final String SLIME = "slime01";
	public static final String SLIME_SLITHER1 = "slime02";
	public static final String SLIME_SLITHER2 = "slime03";
	public static final String FLYING_EYE = "eyeFly01";
	public static final String FLYING_EYE_FLY1 = "eyeFly02";
	public static final String FLYING_EYE_FLY2 = "eyeFly03";
	public static final String DRAGON = "fireMonster01";
	public static final String DRAGON_WALK1 = "fireMonster02";
	public static final String DRAGON_WALK2 = "fireMonster03";
	public static final String DRAGON_WALK3 = "fireMonster04";
	public static final String PORTAL1 = "endGoal01";
	public static final String PORTAL2 = "endGoal02";
	public static final String PORTAL3 = "endGoal03";
	public static final String HEALTHBAR1 = "Health0";
	public static final String HEALTHBAR2 = "Health1";
	public static final String HEALTHBAR3 = "Health2";
	public static final String HEALTHBAR4 = "Health3";
	public static final String HEALTHBAR5 = "Health4";
	public static final String HEALTHBAR6 = "Health5";
	public static final String HEALTHBAR_LIFE_POWERUP = "healthPowerUp";
	public static final String PLAYER_LIFE_POWERUP = "lifePowerUp";
	
	public static void init() {
		System.out.println("[Resources][ModelManager]: Initialization...");
		
		models.put(PLAYER, new Model(60, 60, PLAYER));
		models.put(PLAYER_ICON, new Model(40 , 40, PLAYER_ICON));
		models.put(TILE_A, new Model(40, 40, TILE_A));
		models.put(TILE_B, new Model(40, 40, TILE_B));
		models.put(TILE_C, new Model(40, 40, TILE_C));
		models.put(TILE_D, new Model(40, 40, TILE_D));
		models.put(TILE_E, new Model(40, 40, TILE_E));
		models.put(TILE_F, new Model(40, 40, TILE_F));
		models.put(LAVA, new Model(40, 40, LAVA));
		models.put(TILE_H, new Model(40, 40, TILE_H));
		models.put(TILE_I, new Model(40, 40, TILE_I));
		models.put(TILE_J, new Model(40, 40, TILE_J));
		models.put(TILE_K, new Model(40, 40, TILE_K));
		models.put(TILE_L, new Model(40, 40, TILE_L));
		models.put(TILE_M, new Model(40, 40, TILE_M));
		models.put(TILE_N, new Model(40, 40, TILE_N));
		models.put(TILE_O, new Model(40, 40, TILE_O));
		models.put(TILE_P, new Model(40, 40, TILE_P));
		models.put(TILE_Q, new Model(40, 40, TILE_Q));
		models.put(TILE_R, new Model(40, 40, TILE_R));
		models.put(TILE_S, new Model(40, 40, TILE_S));
		models.put(FIREBALL_DRAGON, new Model(30, 30, FIREBALL_DRAGON));
		models.put(FIREBALL_PLAYER, new Model(30, 30, FIREBALL_PLAYER));
		models.put(PLAYER_JUMP, new Model(60, 60, PLAYER_JUMP));
		models.put(PLAYER_RUN1, new Model(60, 60, PLAYER_RUN1));
		models.put(PLAYER_RUN2, new Model(60, 60, PLAYER_RUN2));
		models.put(PLAYER_RUN3, new Model(60, 60, PLAYER_RUN3));
		models.put(PLAYER_DEATH, new Model(60, 60, PLAYER_DEATH));
		models.put(PLAYER_SHOOT, new Model(60, 60, PLAYER_SHOOT));
		models.put(SLIME, new Model(60, 60, SLIME));
		models.put(SLIME_SLITHER1, new Model(60, 60, SLIME_SLITHER1));
		models.put(SLIME_SLITHER2, new Model(60, 60, SLIME_SLITHER2));
		models.put(FLYING_EYE, new Model(60, 60, FLYING_EYE));
		models.put(FLYING_EYE_FLY1, new Model(60, 60, FLYING_EYE_FLY1));
		models.put(FLYING_EYE_FLY2, new Model(60, 60, FLYING_EYE_FLY2));
		models.put(DRAGON, new Model(60, 60, DRAGON));
		models.put(DRAGON_WALK1, new Model(60, 60, DRAGON_WALK1));
		models.put(DRAGON_WALK2, new Model(60, 60, DRAGON_WALK2));
		models.put(DRAGON_WALK3, new Model(60, 60, DRAGON_WALK3));
		models.put(PORTAL1, new Model(60, 60, PORTAL1));
		models.put(PORTAL2, new Model(60, 60, PORTAL2));
		models.put(PORTAL3, new Model(60, 60, PORTAL3));
		models.put(HEALTHBAR1, new Model(100, 30, HEALTHBAR1));
		models.put(HEALTHBAR2, new Model(100, 30, HEALTHBAR2));
		models.put(HEALTHBAR3, new Model(100, 30, HEALTHBAR3));
		models.put(HEALTHBAR4, new Model(100, 30, HEALTHBAR4));
		models.put(HEALTHBAR5, new Model(100, 30, HEALTHBAR5));
		models.put(HEALTHBAR6, new Model(100, 30, HEALTHBAR6));
		models.put(HEALTHBAR_LIFE_POWERUP, new Model(40, 40, HEALTHBAR_LIFE_POWERUP));
		models.put(PLAYER_LIFE_POWERUP, new Model(40, 40, PLAYER_LIFE_POWERUP));
	}
	
	public static Model model(String key) {
		return models.get(key);
	}
}