package blocks.functionalBlocks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import blocks.Textures;
import main.Separate;

public class Furnace {
	
	public static BufferedImage FurnaceWindow;
	public static boolean Opened = false;
	
	public static double Slot1 = 0.0;
	public static double Slot2 = 0.0;
	public static double Slot3 = 0.0;
	public static double Slot4 = 0.0;
	
	public static void DrawWindow(Graphics g) {
		g.drawImage(FurnaceWindow, main.Main.SW/2-306, main.Main.SH/2 - 18 - 126, 612, 252, null);
		
		g.drawImage(Textures.BlockTex[Separate.getID2(Slot1)][Separate.getTAG2(Slot1)], main.Main.SW/2-230, main.Main.SH/2 - 120, 80, 80, null);
		g.drawImage(Textures.BlockTex[Separate.getID2(Slot2)][Separate.getTAG2(Slot2)], main.Main.SW/2-230, main.Main.SH/2 , 80, 80, null);
		g.drawImage(Textures.BlockTex[Separate.getID2(Slot3)][Separate.getTAG2(Slot3)], main.Main.SW/2 + 46, main.Main.SH/2 - 60 , 80, 80, null);
		g.drawImage(Textures.BlockTex[Separate.getID2(Slot4)][Separate.getTAG2(Slot4)], main.Main.SW/2 + 154, main.Main.SH/2 - 60 , 80, 80, null);
	}
	
	public static void DrawWindow2(Graphics g) {
		
	}
	

}
