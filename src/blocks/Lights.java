package blocks;

import java.awt.Color;

import terrain.Terrain;

public class Lights {
	
	public static int x1, y1;
	
	public static int[] ID = {0,1,2,3,4,5,6,7,8,9,10};
	public static Color[] LightColour = {new Color(255,255,0,0), new Color(255,255,0,5), new Color(255,255,0,10), new Color(255,255,0,15),
			new Color(255,255,0,20), new Color(255,255,0,25), new Color(255,255,0,30), new Color(255,255,0,35), new Color(255,255,0,40),
			new Color(255,255,0,45), new Color(255,255,0,50)};

	//Torch emit 5x5
	
	public static void Emit(int y, int x) {		
		Terrain.chunkColour[y-2][x] = 10;		
		Terrain.chunkColour[y-3][x] = 9;
		Terrain.chunkColour[y-1][x] = 9;
		Terrain.chunkColour[y-2][x-1] = 9;
		Terrain.chunkColour[y-2][x+1] = 9;		
		Terrain.chunkColour[y][x] = 8;
		Terrain.chunkColour[y-4][x] = 8;
		Terrain.chunkColour[y-3][x-1] = 8;
		Terrain.chunkColour[y-3][x+1] = 8;
		Terrain.chunkColour[y-1][x-1] = 8;
		Terrain.chunkColour[y-1][x+1] = 8;
		Terrain.chunkColour[y-2][x+2] = 8;
		Terrain.chunkColour[y-2][x-2] = 8;		
	}
	
	public static void ResetEmit(int y, int x, int playerX, int playerY) {
		Terrain.chunkColour[y-2][x] = 0;		
		Terrain.chunkColour[y-3][x] = 0;
		Terrain.chunkColour[y-1][x] = 0;
		Terrain.chunkColour[y-2][x-1] = 0;
		Terrain.chunkColour[y-2][x+1] = 0;		
		Terrain.chunkColour[y][x] = 0;
		Terrain.chunkColour[y-4][x] = 0;
		Terrain.chunkColour[y-3][x-1] = 0;
		Terrain.chunkColour[y-3][x+1] = 0;
		Terrain.chunkColour[y-1][x-1] = 0;
		Terrain.chunkColour[y-1][x+1] = 0;
		Terrain.chunkColour[y-2][x+2] = 0;
		Terrain.chunkColour[y-2][x-2] = 0;	
		
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++){
				x1 = (x-5) + j;
				y1 = (y-5) + i;
				if(Terrain.chunk[y1-2][x1] == 8) {
					Emit(y1, x1);
				}
			}
		}
		
	}
	
}
