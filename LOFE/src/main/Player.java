package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {

	public static int playerX = 466 + 220;
	public static int playerY = 200;
	public static int playerSize = 10;
	public static Rectangle player = new Rectangle(playerX,playerY,playerSize,playerSize);
	
	public static void DrawPlayer(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(playerX,playerY,playerSize,playerSize);
	}
	
}
