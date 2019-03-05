package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import blocks.Blocks;
import main.Separate;
import player.Food;
import player.Life;
import player.Player;
import terrain.Terrain;

public class F3Menu {
	
	public static boolean F3Pressed = false;
	
	public static Font F3Font = new Font("Serif Bold", 1, 17);
	public static Font F3Font2 = new Font("Serif Bold", 1, 12);
	
	public static void F3Draw(Graphics g) {
		g.setColor(new Color(0,0,0,255));
		g.setFont(F3Font);
		g.drawString(" F3 - Menu ", 25, 25);
		g.setFont(F3Font2);
		g.drawString(" X: " + Player.playerCoordX + " Y: " + (Player.playerCoordY-2), 30, 45);
		g.drawString(" SelectedID: " + Inventory.SelectedID + " , " + Blocks.NAME[Separate.getID2(Inventory.SelectedID)][Separate.getTAG2(Inventory.SelectedID)] + " " + Inventory.ItemCount.get(Inventory.SelectedSlot), 30, 60);
		g.drawString(" Light: " + Terrain.chunkColour[Player.playerCoordY-3][Player.playerCoordX], 30, 75);
		g.drawString(" day: " + gameplay.Time.day + " , time: " + gameplay.Time.time, 30, 90);
		g.drawString(" DragedID: " + Inventory.DragedID + " DragedCount: " + Inventory.DragedCount, 30, 105);
		g.drawString(" Hp: " + Life.hp + " / " + Life.maxhp + ", Death: " + Life.death, 30, 120);
		g.drawString(" Fp: " + Food.fp + " / " + Food.maxfp + ", Saturation: " + Food.saturation, 30, 135);
	}

}
