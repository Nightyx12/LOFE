package player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import blocks.Blocks;
import gui.Inventory;
import main.Main;
import main.Separate;

public class Animation {

	public static BufferedImage DamageA;
	public static boolean PlayDamageA = false;
	public static int timePlay = 0;
	public static int maxTimePlay = 5;
	
	public static boolean PlayDiedA = false;
	public static int timePlay1 = 0;
	public static int maxTimePlay1 = 50;
	public static Font AFont = new Font("Calibri", Font.BOLD, 80);
	
	public static boolean PlayNameA = false;
	public static int timePlay2 = 0;
	public static int maxTimePlay2 = 50;
	public static Font AFont2 = new Font("Calibri", Font.BOLD, 15);
	
	public static void DrawDamageA(Graphics g) {
		g.drawImage(DamageA, Player.playerX - 5 + (timePlay/2), Player.playerY - 10 + (timePlay/2), 10 - timePlay, 10 - timePlay, null);
		g.drawImage(DamageA, Player.playerX + 15 + (timePlay/2), Player.playerY - 10 + (timePlay/2), 10 - timePlay, 10 - timePlay, null);
		timePlay++;
		if(timePlay == maxTimePlay) {
		PlayDamageA = false;
		timePlay = 0;
		}
	}
	
	public static void DrawDiedA(Graphics g) {
		g.setColor(new Color(120,0,0,5 * timePlay1));
		g.setFont(AFont);
		g.drawString("You Died", Main.SW/2 - 130, Main.SH/2 - 20);
		timePlay1++;
		if(timePlay1 == maxTimePlay1) {
		PlayDiedA = false;
		timePlay1 = 0;
		}
	}
	
	public static void DrawNameA(Graphics g) {
		g.setColor(new Color(0,0,0,255));
		g.setFont(AFont2);
		if(Inventory.SelectedID != 0.0) {
		g.drawString(Blocks.NAME[Separate.getID2(Inventory.SelectedID)][Separate.getTAG2(Inventory.SelectedID)], main.Main.SW/2-242, main.Main.SH - 90);
		}
		timePlay2++;
		if(timePlay2 == maxTimePlay2) {
		PlayNameA = false;
		timePlay2 = 0;
		}
	}
	
}
