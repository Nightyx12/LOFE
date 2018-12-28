package gui;

import java.awt.Color;
import java.awt.Graphics;

import blocks.Air;
import blocks.Dirt;
import blocks.Grass;
import blocks.Stone;
import main.Main;

public class Inventory {

	public static Color Slot1 = Dirt.DirtBlockColor;
	public static Color Slot2 = Grass.GrassBlockColor;
	public static Color Slot3 = Stone.StoneBlockColor;
	public static Color Slot4 = Air.AirBlockColor;
	
	public static boolean Inventory = false;
	
	public static void Inventory(Graphics g) {
		
		g.setColor(new Color(255,255,255,100));
		g.fillRect(10, main.Main.SH - 276, 538, 226);
		
		g.setColor(new Color(150,150,150,150));
		g.drawRect(10, main.Main.SH - 276, 538, 226);
		
		//slot
		g.setColor(new Color(150,150,150,100));
	
		for(int i = 0; i < 10; i++) {
			g.drawRect(20 + (52*i), main.Main.SH - 266, 50, 50);
			g.drawRect(20 + (52*i), main.Main.SH - 214, 50, 50);
			g.drawRect(20 + (52*i), main.Main.SH - 162, 50, 50);
			g.drawRect(20 + (52*i), main.Main.SH - 110, 50, 50);
		}
		
	}

	public static void drawSelectedSlot(Color c1,Color c2,Color c3,Color c4) {
		Slot1 =	c1;
		Slot2 = c2;
		Slot3 = c3;
		Slot4 = c4;
	}
	
	public static void drawInventoryBar(Graphics g) {
		g.setColor(new Color(0,0,0));
		g.drawRect(Main.SW/2 - 100, Main.SH - 100, 50, 50);
		g.drawRect(Main.SW/2 - 50, Main.SH - 100, 50, 50);
		g.drawRect(Main.SW/2, Main.SH - 100, 50, 50);
		g.drawRect(Main.SW/2 + 50, Main.SH - 100, 50, 50);
	
		g.setColor(Dirt.DirtBlockColor);
			g.fillRect(Main.SW/2 - 95, Main.SH - 95, 40, 40);
		g.setColor(Grass.GrassBlockColor);
			g.fillRect(Main.SW/2 - 45, Main.SH - 95, 40, 40);
		g.setColor(Stone.StoneBlockColor);
			g.fillRect(Main.SW/2 + 5, Main.SH - 95, 40, 40);
		g.setColor(Air.AirBlockColor);
			g.fillRect(Main.SW/2 + 55, Main.SH - 95, 40, 40);
				//Inventory Slot selected
				g.setColor(gui.Inventory.Slot1);
					g.drawRect(Main.SW/2 - 95, Main.SH - 95, 40, 40);
				g.setColor(gui.Inventory.Slot2);
					g.drawRect(Main.SW/2 - 45, Main.SH - 95, 40, 40);
				g.setColor(gui.Inventory.Slot3);
					g.drawRect(Main.SW/2 + 5, Main.SH - 95, 40, 40);
				g.setColor(gui.Inventory.Slot4);
					g.drawRect(Main.SW/2 + 55, Main.SH - 95, 40, 40);
	}
	
}
