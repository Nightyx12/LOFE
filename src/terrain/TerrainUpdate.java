package terrain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;

import blocks.Break_Build;
import gameplay.Gameplay;
import main.Main;
import player.Mouvement;

public class TerrainUpdate {
	
	public static int MouseX = MouseInfo.getPointerInfo().getLocation().x;
	public static int MouseY = MouseInfo.getPointerInfo().getLocation().y;
	
	public static Color GridColor = new Color(255,0,0,255);	
	
	public static void PointerDetection(Graphics g, int playerX, int playerY) {	
		g.setColor(GridColor);
			for(int i = 0; i < (Main.SH/TerrainDraw.blockSize); i++) {
				for(int j = 0; j < (Main.SW/TerrainDraw.blockSize); j++) {
					Break_Build.x1 = (playerX + Mouvement.Xshard) - ((Main.SW/2)/TerrainDraw.blockSize) + j;
					Break_Build.y1 = (playerY + Mouvement.Xshard) - ((Main.SH/2)/TerrainDraw.blockSize) + i;
					
					Rectangle Grid = new Rectangle(TerrainDraw.blockSize*j + Main.PosX, TerrainDraw.blockSize*i - 5 + Main.PosY, TerrainDraw.blockSize, TerrainDraw.blockSize);
					
					if(Gameplay.Cursor.intersects(Grid)) {
						g.drawRect(TerrainDraw.blockSize*j, TerrainDraw.blockSize*i - 5, TerrainDraw.blockSize, TerrainDraw.blockSize);
					}
				        
				}
			}
		}
	
	public static void updateBlock(double chunk[][], int chunkhp[][], int playerX, int playerY, int choice) {
		for(int i = 0; i < (Main.SH/TerrainDraw.blockSize); i++) {
			for(int j = 0; j < (Main.SW/TerrainDraw.blockSize); j++) {
				Break_Build.x1 = (playerX + Mouvement.Xshard) - ((Main.SW/2)/TerrainDraw.blockSize) + j;
				Break_Build.y1 = (playerY + Mouvement.Xshard) - ((Main.SH/2)/TerrainDraw.blockSize) + i -2;
				
				Rectangle Grid = new Rectangle(TerrainDraw.blockSize*j + Main.PosX, TerrainDraw.blockSize*i - 5 + Main.PosY, TerrainDraw.blockSize, TerrainDraw.blockSize);
				
				if(Gameplay.Cursor.intersects(Grid)) {
					
					if(choice == 0) {//breakblock
						
						Break_Build.breakBlock(chunkhp, chunk, playerX, playerY);
						
					}else if(choice == 1) {	//placeBlock
						
						
						Break_Build.placeBlock(chunkhp, chunk);
						
					}
					
						
					
				}
			        
			}
		}
	}
	
}
