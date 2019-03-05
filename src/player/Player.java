package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Main;
import terrain.Terrain;

public class Player {

	public static BufferedImage[] PlayerTexs = new BufferedImage[4];
	public static byte Tex = 0;

	public static int playerSize = 20;
	public static int playerCoordX = Terrain.worldSizeX/2;
	public static int playerCoordY = Terrain.worldSizeY/2;
	public static final int InitPlayerCoordX = playerCoordX;
	public static final int InitPlayerCoordY = playerCoordY;
	
	public static int playerX = Main.SW/2-playerSize/2;
	public static int playerY = Main.SH/2-playerSize/2;
	
	public static void drawPlayer(Graphics g) {
		playerX = ((Main.SW/2)-(playerSize/2));
		playerY = ((Main.SH/2)-(playerSize/2));
		
		if(!Animation.PlayDamageA) {
			g.drawImage(Player.PlayerTexs[Tex], playerX, playerY, playerSize, playerSize, null);
		}else {
			g.drawImage(Player.PlayerTexs[Tex], playerX + 2, playerY + 2, playerSize - 4, playerSize - 4, null);
		}
		
	}
	
	
	
}
