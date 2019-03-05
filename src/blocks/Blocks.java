package blocks;

public class Blocks {
	
	public static int IDmax = 400;
	public static int MaxIDTag = 10;

	//new System
	public static Double[][] ID = new Double[IDmax][MaxIDTag];
	public static String[][] NAME = new String[IDmax][MaxIDTag];
	public static int[][] BLOCKHP = new int[IDmax][MaxIDTag];
	public static int[][] TRAVERSABLE = new int[IDmax][MaxIDTag];
	public static int[][] DURABILITY = new int[IDmax][MaxIDTag];
	
	public static void InitIDs() {
		//Blocks
		ID[0][0] = 0.0;
		ID[1][0] = 1.0;
		ID[2][0] = 2.0;
		ID[3][0] = 3.0;
		ID[4][0] = 4.0;
		ID[5][0] = 5.0;
		ID[5][1] = 5.1;
		ID[6][0] = 6.0;
		ID[7][0] = 7.0;
		ID[8][0] = 8.0;
		ID[9][0] = 9.0;
		ID[10][0] = 10.0;
		ID[10][1] = 10.1;
		ID[10][2] = 10.2;
		ID[10][3] = 10.3;
		ID[10][4] = 10.4;
		ID[10][5] = 10.5;
		ID[11][0] = 11.0;
		ID[12][0] = 12.0;
		ID[13][0] = 13.0;
		ID[14][0] = 14.0;
		ID[16][0] = 16.0;
		ID[17][0] = 17.0;
		ID[19][0] = 19.0;
		ID[19][1] = 19.1;
		ID[19][2] = 19.2;
		ID[19][3] = 19.3;
		ID[19][4] = 19.4;
		ID[19][5] = 19.5;
		ID[19][6] = 19.6;
		ID[24][0] = 24.0;
		ID[24][1] = 24.1;
		ID[24][2] = 24.2;
		ID[24][3] = 24.3;
		
		//Items
		
		ID[300][0] = 300.0;
		ID[301][0] = 301.0;
		ID[302][0] = 302.0;
		ID[304][0] = 304.0;
		ID[306][0] = 306.0;
		ID[310][0] = 310.0;
		ID[310][1] = 310.1;
		ID[310][2] = 310.2;
		ID[313][0] = 313.0;
		ID[314][0] = 314.0;
		ID[315][0] = 315.0;
				
		
	}
	
	public static void InitName() {
		//Blocks
		NAME[0][0] = "AIR";
		NAME[1][0] = "DIRT";
		NAME[2][0] = "GRASS";
		NAME[3][0] = "STONE";
		NAME[4][0] = "UMBREAKABLE_BLOCK";
		NAME[5][0] = "LOG";
		NAME[5][1] = "LOG_WITH_LEAVES";
		NAME[6][0] = "PLANKS";
		NAME[7][0] = "LEAVES";
		NAME[8][0] = "TORCH";
		NAME[9][0] = "SIGN";
		NAME[10][0] = "LOCKED_DOOR_UP";
		NAME[10][1] = "LOCKED_DOOR_DOWN";
		NAME[10][2] = "OPENED_DOOR_UP";
		NAME[10][3] = "OPENED_DOOR_DOWN";
		NAME[10][4] = "LOCKED_DOOR";
		NAME[10][5] = "OPENED_DOOR";
		NAME[11][0] = "SAPLING";
		NAME[12][0] = "CLAY";
		NAME[13][0] = "POLISHED_CLAY";
		NAME[14][0] = "SAND";
		NAME[16][0] = "CRAFTING_BENCH";
		NAME[17][0] = "FURNACE";
		NAME[19][0] = "BARREL_STAGE_0";
		NAME[19][1] = "BARREL_STAGE_1";
		NAME[19][2] = "BARREL_STAGE_2";
		NAME[19][3] = "BARREL_STAGE_3";
		NAME[19][4] = "BARREL_STAGE_4";
		NAME[19][5] = "BARREL_STAGE_5";
		NAME[19][6] = "BARREL_STAGE_6";
		NAME[24][0] = "PLATFORM";
		NAME[24][1] = "PLATFORM_2";
		NAME[24][2] = "PLATFORM_3";
		NAME[24][3] = "PLATFORM_4";
		
		//Items
		NAME[300][0] = "STICK";
		NAME[301][0] = "WOODEN_PICKAXE";
		NAME[302][0] = "WOODEN_AXE";
		NAME[304][0] = "WOODEN_SHOVEL";
		NAME[306][0] = "COAL";
		NAME[310][0] = "RED_APPLE";
		NAME[310][1] = "GREEN_APPLE";
		NAME[310][2] = "YELLOW_APPLE";
		NAME[313][0] = "STRING";
		NAME[314][0] = "ORANGE";
		NAME[315][0] = "LEMON";
		
	}
	
	public static void InitBlockHP() {
		//Blocks
		BLOCKHP[0][0] = 0;
		BLOCKHP[1][0] = 100;
		BLOCKHP[2][0] = 200;
		BLOCKHP[3][0] = 300;
		BLOCKHP[4][0] = -100;
		BLOCKHP[5][0] = 200;
		BLOCKHP[5][1] = 100;	//Then 200
		BLOCKHP[6][0] = 200;
		BLOCKHP[7][0] = 100;
		BLOCKHP[8][0] = 100;
		BLOCKHP[9][0] = 100;
		BLOCKHP[10][0] = 200;
		BLOCKHP[10][1] = 200;
		BLOCKHP[10][2] = 200;
		BLOCKHP[10][3] = 200;
		BLOCKHP[10][4] = 0;
		BLOCKHP[10][5] = 0;
		BLOCKHP[11][0] = 100;
		BLOCKHP[12][0] = 400;
		BLOCKHP[13][0] = 300;
		BLOCKHP[14][0] = 100;
		BLOCKHP[16][0] = 200;
		BLOCKHP[17][0] = 300;
		BLOCKHP[19][0] = 200;
		BLOCKHP[19][1] = 200;
		BLOCKHP[19][2] = 200;
		BLOCKHP[19][3] = 200;
		BLOCKHP[19][4] = 200;
		BLOCKHP[19][5] = 200;
		BLOCKHP[19][6] = 200;
		BLOCKHP[24][0] = 200;
		BLOCKHP[24][1] = 200;
		BLOCKHP[24][2] = 200;
		BLOCKHP[24][3] = 200;
		
		//Item
		BLOCKHP[300][0] = 0;
		BLOCKHP[301][0] = 0;
		BLOCKHP[302][0] = 0;
		BLOCKHP[304][0] = 0;
		BLOCKHP[306][0] = 0;
		BLOCKHP[310][0] = 0;
		BLOCKHP[310][1] = 0;
		BLOCKHP[310][2] = 0;
		BLOCKHP[313][0] = 0;
		BLOCKHP[314][0] = 0;
		BLOCKHP[315][0] = 0;
		
	}
	
	public static void InitTraversable() {
		TRAVERSABLE[0][0] = 1;
		TRAVERSABLE[1][0] = 0;
		TRAVERSABLE[2][0] = 0;
		TRAVERSABLE[3][0] = 0;
		TRAVERSABLE[4][0] = 0;
		TRAVERSABLE[5][0] = 1;
		TRAVERSABLE[5][1] = 1;
		TRAVERSABLE[6][0] = 0;
		TRAVERSABLE[7][0] = 1;
		TRAVERSABLE[8][0] = 1;
		TRAVERSABLE[9][0] = 1;
		TRAVERSABLE[10][0] = 0;
		TRAVERSABLE[10][1] = 0;
		TRAVERSABLE[10][2] = 1;
		TRAVERSABLE[10][3] = 1;
		TRAVERSABLE[10][4] = -1;
		TRAVERSABLE[10][5] = -1;
		TRAVERSABLE[11][0] = 1;
		TRAVERSABLE[12][0] = 0;
		TRAVERSABLE[13][0] = 0;
		TRAVERSABLE[14][0] = 0;
		TRAVERSABLE[16][0] = 1;
		TRAVERSABLE[17][0] = 1;
		TRAVERSABLE[19][0] = 1;
		TRAVERSABLE[19][1] = 1;
		TRAVERSABLE[19][2] = 1;
		TRAVERSABLE[19][3] = 1;
		TRAVERSABLE[19][4] = 1;
		TRAVERSABLE[19][5] = 1;
		TRAVERSABLE[19][6] = 1;
		TRAVERSABLE[24][0] = 2;
		TRAVERSABLE[24][1] = 2;
		TRAVERSABLE[24][2] = 2;
		TRAVERSABLE[24][3] = 2;
		
		TRAVERSABLE[300][0] = -1;
		TRAVERSABLE[301][0] = -1;
		TRAVERSABLE[302][0] = -1;
		TRAVERSABLE[304][0] = -1;
		TRAVERSABLE[306][0] = -1;
		TRAVERSABLE[310][0] = -1;
		TRAVERSABLE[310][1] = -1;
		TRAVERSABLE[310][2] = -1;
		TRAVERSABLE[313][0] = -1;
		TRAVERSABLE[314][0] = -1;
		TRAVERSABLE[315][0] = -1;
	}
	
	public static void InitDurability() {
		DURABILITY[0][0] = 0;
		DURABILITY[1][0] = 0;
		DURABILITY[2][0] = 0;
		DURABILITY[3][0] = 0;
		DURABILITY[4][0] = 0;
		DURABILITY[5][0] = 0;
		DURABILITY[5][1] = 0;
		DURABILITY[6][0] = 0;
		DURABILITY[7][0] = 0;
		DURABILITY[8][0] = 0;
		DURABILITY[9][0] = 0;
		DURABILITY[10][0] = 0;
		DURABILITY[10][1] = 0;
		DURABILITY[10][2] = 0;
		DURABILITY[10][3] = 0;
		DURABILITY[10][4] = 0;
		DURABILITY[10][5] = 0;
		DURABILITY[11][0] = 0;
		DURABILITY[12][0] = 0;
		DURABILITY[13][0] = 0;
		DURABILITY[14][0] = 0;
		DURABILITY[16][0] = 0;
		DURABILITY[17][0] = 0;
		DURABILITY[19][0] = 0;
		DURABILITY[19][1] = 0;
		DURABILITY[19][2] = 0;
		DURABILITY[19][3] = 0;
		DURABILITY[19][4] = 0;
		DURABILITY[19][5] = 0;
		DURABILITY[19][6] = 0;
		DURABILITY[24][0] = 0;
		DURABILITY[24][1] = 0;
		DURABILITY[24][2] = 0;
		DURABILITY[24][3] = 0;
		
		DURABILITY[300][0] = 0;
		DURABILITY[301][0] = 16;
		DURABILITY[302][0] = 16;
		DURABILITY[304][0] = 16;
		DURABILITY[306][0] = 0;
		DURABILITY[310][0] = 0;
		DURABILITY[310][1] = 0;
		DURABILITY[310][2] = 0;
		DURABILITY[313][0] = 0;
		DURABILITY[314][0] = 0;
		DURABILITY[315][0] = 0;
		
	}
	
	public static void InitAll() {
		InitIDs();
		InitName();
		InitBlockHP();
		InitTraversable();
		
		Textures.InitAllTex();
		
	}
	

	
}
