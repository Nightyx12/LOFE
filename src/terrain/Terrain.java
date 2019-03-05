package terrain;

import blocks.Blocks;

public class Terrain {
	
	public static int worldSizeX = 6561;
	public static int worldSizeY = 729;	

	public static double[][] chunk = new double[worldSizeY][worldSizeX];
	public static int[][] chunkhp = new int[worldSizeY][worldSizeX];
	public static int[][] chunkColour = new int[worldSizeY][worldSizeX];
	
	public static void Init(double[][] chunk, int[][] chunkhp, int worldSizeX, int worldSizeY) {
		 for(int i = 0; i < worldSizeY; i++){
		        for(int j = 0; j < worldSizeX; j++){
		        	
		        	chunk[i][j] = 0.0;
		        	chunkhp[i][j] = 0;
		        	chunkColour[i][j] = 0;
		        }
		 }
	}
	
	public static void TreeGen(double[][] chunk, int baseY, int baseX) {
		chunk[baseY][baseX] = 5;
		chunk[baseY-1][baseX] = 5;
		chunk[baseY-2][baseX] = 5;
		chunk[baseY-3][baseX] = 5;
		
		chunk[baseY-4][baseX] = 5.1;
		
		chunk[baseY-4][baseX-1] = 7;
		chunk[baseY-4][baseX+1] = 7;
		chunk[baseY-4][baseX-2] = 7;
		chunk[baseY-4][baseX+2] = 7;
		
		chunk[baseY-5][baseX-1] = 7;
		chunk[baseY-5][baseX-2] = 7;
		chunk[baseY-5][baseX] = 7;
		chunk[baseY-5][baseX+1] = 7;
		chunk[baseY-5][baseX+2] = 7;
		
		chunk[baseY-6][baseX-1] = 7;
		chunk[baseY-6][baseX] = 7;
		chunk[baseY-6][baseX+1] = 7;
		
			chunkhp[baseY][baseX] = Blocks.BLOCKHP[5][0];
			chunkhp[baseY-1][baseX] = Blocks.BLOCKHP[5][0];
			chunkhp[baseY-2][baseX] = Blocks.BLOCKHP[5][0];
			chunkhp[baseY-3][baseX] = Blocks.BLOCKHP[5][0];
			
			chunkhp[baseY-4][baseX] = Blocks.BLOCKHP[5][1];
			
			chunkhp[baseY-4][baseX-1] = Blocks.BLOCKHP[7][0];
			chunkhp[baseY-4][baseX+1] = Blocks.BLOCKHP[7][0];
			chunkhp[baseY-4][baseX-2] = Blocks.BLOCKHP[7][0];
			chunkhp[baseY-4][baseX+2] = Blocks.BLOCKHP[7][0];
			
			chunkhp[baseY-5][baseX-1] = Blocks.BLOCKHP[7][0];
			chunkhp[baseY-5][baseX-2] = Blocks.BLOCKHP[7][0];
			chunkhp[baseY-5][baseX] = Blocks.BLOCKHP[7][0];
			chunkhp[baseY-5][baseX+1] = Blocks.BLOCKHP[7][0];
			chunkhp[baseY-5][baseX+2] = Blocks.BLOCKHP[7][0];
			
			chunkhp[baseY-6][baseX-1] = Blocks.BLOCKHP[7][0];
			chunkhp[baseY-6][baseX] = Blocks.BLOCKHP[7][0];
			chunkhp[baseY-6][baseX+1] = Blocks.BLOCKHP[7][0];			
	}
	
	public static void IslandGen(double[][] chunk, int worldSizeX, int worldSizeY) {
		chunk[worldSizeY/2 - 2][worldSizeX/2 - 2] = 2;
		chunk[worldSizeY/2 - 2][worldSizeX/2 - 1] = 2;
		chunk[worldSizeY/2 - 2][worldSizeX/2] = 2;
		chunk[worldSizeY/2 - 2][worldSizeX/2 + 1] = 2;
		chunk[worldSizeY/2 - 2][worldSizeX/2 + 2] = 2;
		
		chunk[worldSizeY/2 - 1][worldSizeX/2 - 2] = 1;
		chunk[worldSizeY/2 - 1][worldSizeX/2 - 1] = 1;
		chunk[worldSizeY/2 - 1][worldSizeX/2] = 1;
		chunk[worldSizeY/2 - 1][worldSizeX/2 + 1] = 1;
		chunk[worldSizeY/2 - 1][worldSizeX/2 + 2] = 1;
		
		chunk[worldSizeY/2][worldSizeX/2 - 1] = 3;
		chunk[worldSizeY/2][worldSizeX/2] = 3;
		chunk[worldSizeY/2][worldSizeX/2 + 1] = 3;
		
		chunk[worldSizeY/2 + 1][worldSizeX/2 - 1] = 3;
		chunk[worldSizeY/2 + 1][worldSizeX/2] = 4;
		chunk[worldSizeY/2 + 1][worldSizeX/2 + 1] = 3;
		
		chunk[worldSizeY/2 + 2][worldSizeX/2] = 3;
		chunk[worldSizeY/2 + 3][worldSizeX/2] = 3;
		
		
			chunkhp[worldSizeY/2 - 2][worldSizeX/2 - 2] = Blocks.BLOCKHP[2][0];
			chunkhp[worldSizeY/2 - 2][worldSizeX/2 - 1] = Blocks.BLOCKHP[2][0];
			chunkhp[worldSizeY/2 - 2][worldSizeX/2] = Blocks.BLOCKHP[2][0];
			chunkhp[worldSizeY/2 - 2][worldSizeX/2 + 1] = Blocks.BLOCKHP[2][0];
			chunkhp[worldSizeY/2 - 2][worldSizeX/2 + 2] = Blocks.BLOCKHP[2][0];
			
			chunkhp[worldSizeY/2 - 1][worldSizeX/2 - 2] = Blocks.BLOCKHP[1][0];
			chunkhp[worldSizeY/2 - 1][worldSizeX/2 - 1] = Blocks.BLOCKHP[1][0];
			chunkhp[worldSizeY/2 - 1][worldSizeX/2] = Blocks.BLOCKHP[1][0];
			chunkhp[worldSizeY/2 - 1][worldSizeX/2 + 1] = Blocks.BLOCKHP[1][0];
			chunkhp[worldSizeY/2 - 1][worldSizeX/2 + 2] = Blocks.BLOCKHP[1][0];
			
			chunkhp[worldSizeY/2][worldSizeX/2 - 1] = Blocks.BLOCKHP[3][0];
			chunkhp[worldSizeY/2][worldSizeX/2] = Blocks.BLOCKHP[3][0];
			chunkhp[worldSizeY/2][worldSizeX/2 + 1] = Blocks.BLOCKHP[3][0];
			
			chunkhp[worldSizeY/2 + 1][worldSizeX/2 - 1] = Blocks.BLOCKHP[3][0];
			chunkhp[worldSizeY/2 + 1][worldSizeX/2] = Blocks.BLOCKHP[4][0];
			chunkhp[worldSizeY/2 + 1][worldSizeX/2 + 1] = Blocks.BLOCKHP[3][0];
			
			chunkhp[worldSizeY/2 + 2][worldSizeX/2] = Blocks.BLOCKHP[3][0];
			chunkhp[worldSizeY/2 + 3][worldSizeX/2] = Blocks.BLOCKHP[3][0];
	}
	
}
