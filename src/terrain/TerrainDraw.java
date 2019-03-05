package terrain;

import java.awt.Color;
import java.awt.Graphics;

import blocks.Lights;
import blocks.Textures;
import main.Main;
import main.Separate;
import player.Mouvement;
import player.Player;

public class TerrainDraw {
	
	public static int x;
	public static int y;
	
	
	public static int blockSize = 20;
	
	public static void SetColour(Graphics g, int chunk[][], int i, int j) {
		g.setColor(Lights.LightColour[chunk[i][j]]);
	}
	
	public static void SetImage(Graphics g, double chunk[][], int y, int x, int i, int j) {
		g.drawImage(Textures.BlockTex[Separate.getID(chunk, y, x)][Separate.getTAG(chunk, y, x)], blockSize*j, blockSize*i, blockSize, blockSize, null);
	}
		
		
		
	
	
	public static void drawTerrain(Graphics g, double chunk[][], int playerX, int playerY, int playerYshard, int playerXshard) {
		for(int i = 0; i < (Main.SH/blockSize)+2; i++) {
			for(int j = 0; j < (Main.SW/blockSize)+2; j++) {
				x = Player.playerCoordX - Player.playerX/blockSize + j;
				y = Player.InitPlayerCoordY - Player.playerY/blockSize + i;
//				x = playerX - (Main.SW/blockSize)/2 + j;
//				y = playerY - (Main.SH/blockSize)/2 + i;
				
					SetImage(g, chunk, y, x, i, j);
			        
			}
		}
	}
	
	public static void drawLight(Graphics g, int chunk[][], int playerX, int playerY, int playerYshard, int playerXshard) {
		for(int i = 0; i < (Main.SH/blockSize); i++) {
			for(int j = 0; j < (Main.SW/blockSize); j++) {
				x = playerX - ((Main.SW/2)/blockSize) + j;
				y = (playerY  + (playerYshard/10)) - ((Main.SH/2)/blockSize) + i;
				
					SetColour(g, chunk, y, x);
					g.fillRect(blockSize*j, blockSize*i+35, blockSize, blockSize);
			        
			}
		}
	}
	
}
