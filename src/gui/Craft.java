package gui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gameplay.Gameplay;
import main.Main;
import terrain.TerrainUpdate;

public class Craft {

	public static boolean Opened = false;
	
	public static int v, v1;
	public static int[] v3 = new int[10];
	
	public static BufferedImage craftWindow;
	public static BufferedImage craftButton;
	
	public static boolean canCraft = false;
	
	public static Double[] c1 = {300.0, 6.0, 313.0};
	public static int[] c2 = {2, 1, 2};
	
	public static void DrawcraftWindow(Graphics g) {
		g.drawImage(craftWindow, main.Main.SW/2-306, main.Main.SH/2 - 18 - 126, 612, 252, null);
	}
	
	public static void OpenCraftWindow() {
		Rectangle Button = new Rectangle(Main.SW/2 + 316 + Main.PosX, Main.SH/2 - 140 + Main.PosY, 62, 62);
		Rectangle Button2 = new Rectangle(Main.SW/2 + 316 + Main.PosX, Main.SH/2 - 68 + Main.PosY, 62, 62);
		Rectangle Cursor = new Rectangle(TerrainUpdate.MouseX, TerrainUpdate.MouseY, 1, 1);
		
		if(Cursor.intersects(Button)) {
			Inventory.Opened = false;
			Craft.Opened = true;
			Gameplay.draged = false;
		}else if(Cursor.intersects(Button2)) {
			Inventory.Opened = false;
			Settings.Opened = true;
			Gameplay.draged = false;
		}
	}
	
	public static void craft(double ID, int count, double IDresult, int countResult) {
		if(Inventory.ItemID.contains(ID)) {
			v = Inventory.Search(Inventory.ItemID, ID);
			if(Inventory.ItemCount.get(v) >= count) {
				//can craft
				canCraft = true;
					//remove Item need to Craft
				Inventory.ItemCount.set(v, Inventory.ItemCount.get(v) - count);
				if(Inventory.ItemCount.get(v) == 0) {
					Inventory.ItemID.set(v, 0.0);
				}
				if(Inventory.ItemID.contains(IDresult)) {
					v = Inventory.Search(Inventory.ItemID, IDresult);
					Inventory.ItemCount.set(v, Inventory.ItemCount.get(v) + countResult);					
				}else {
				v = Inventory.Search(Inventory.ItemID, 0);
				Inventory.ItemID.set(v, IDresult);
				Inventory.ItemCount.set(v, countResult);
				}
				Inventory.SelectedID = Inventory.ItemID.get(Inventory.SelectedSlot);
			}else {
				//can't craft
				canCraft = false;
			}
		}
	}
	
	public static void craft2(double ID1, double ID2, int count1, int count2, double IDresult, int countResult) {
		if(Inventory.ItemID.contains(ID1) && Inventory.ItemID.contains(ID2)) {
			v = Inventory.Search(Inventory.ItemID, ID1);
			v1 = Inventory.Search(Inventory.ItemID, ID2);
			
			if(Inventory.ItemCount.get(v) >= count1 && Inventory.ItemCount.get(v1) >= count2) {
				//can Craft
				
					//remove Item need to craft
					Inventory.ItemCount.set(v, Inventory.ItemCount.get(v) - count1);
					Inventory.ItemCount.set(v1, Inventory.ItemCount.get(v1) - count2);
					if(Inventory.ItemCount.get(v) == 0) {
						Inventory.ItemID.set(v, 0.0);
					}
					if(Inventory.ItemCount.get(v1) == 0) {
						Inventory.ItemID.set(v1, 0.0);
					}
					
					//give the result to the player
					if(Inventory.ItemID.contains(IDresult)) {
						v = Inventory.Search(Inventory.ItemID, IDresult);
						Inventory.ItemCount.set(v, Inventory.ItemCount.get(v) + countResult);
					}else {
						v = Inventory.Search(Inventory.ItemID, 0);
						Inventory.ItemID.set(v, IDresult);
						Inventory.ItemCount.set(v, countResult);
					}
					
					Inventory.SelectedID = Inventory.ItemID.get(Inventory.SelectedSlot);
				
			}else {
				//can't Craft
			}
			
		}
	}
	
	public static void craft4(Double[] IDs, int[] Count, double IDresult, int CountResult) {
		A:{
		//Craft Possible ?
		for(int i = 0; i < IDs.length; i++) {			
			if(Inventory.ItemID.contains(IDs[i])) {
				v = Inventory.Search(Inventory.ItemID, IDs[i]);
				if(Inventory.ItemCount.get(v) >= Count[i]) {	
				}else {
					//No
					System.out.println("Not enough item");
					break A;
				}
				
			}else {
				//No
				System.out.println("Not enough item");
				break A;
			}
		}
		
		//remove item 
		for(int i = 0; i < IDs.length; i++) {
			Inventory.TakeOffInv(IDs[i], Count[i]);
		}
		//Give item 
		Inventory.TakeInInv(IDresult, CountResult);
		
		
		}
		
	}
	
}
