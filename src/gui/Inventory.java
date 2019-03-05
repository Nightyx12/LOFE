package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import blocks.Blocks;
import blocks.Textures;
import gameplay.Gameplay;
import main.Main;
import main.Separate;
import player.Animation;
import terrain.TerrainUpdate;

public class Inventory {

	public static BufferedImage HotBar;
	public static BufferedImage Inventory;
	
	public static int SelectedSlot;
	public static double SelectedID = 0;
	
	public static Double DragedID;
	public static int DragedCount;
	public static boolean inCursor = false;
	
	public static Double KID;
	public static int KCount;
	public static int KSlot;
	
	public static List<Double> ItemID = new ArrayList<Double>();
	public static List<Integer> ItemCount = new ArrayList<Integer>();	
	
	public static boolean Opened = false;
	
	public static int s;
	
	public static int v;
	
	public static void Init() {
		for(int i = 0; i < 48; i++) {
			ItemID.add(0.0);
			ItemCount.add(0);
		}
		ItemID.set(0, 11.0);
		ItemCount.set(0, 2);
		ItemID.set(1, 310.0);
		ItemCount.set(1, 2);
		ItemID.set(2, 16.0);
		ItemCount.set(2, 1);
		ItemID.set(3, 313.0);
		ItemCount.set(3, 50);
	}
	
	public static void SetSlotclick() {
		A:{
		for(int i = 0; i < 8; i++) {
			Rectangle Slot = new Rectangle(main.Main.SW/2 - 239 + (60*i) + Main.PosX, main.Main.SH - 80 + Main.PosY, 60, 60);
			Rectangle Cursor = new Rectangle(TerrainUpdate.MouseX, TerrainUpdate.MouseY, 1, 1);
			
			if(Cursor.intersects(Slot)){
				SelectedSlot = i;
				SelectedID = ItemID.get(i);
				Animation.PlayNameA = true;
				break A;
			}
			
		}	
		
		Gameplay.TerrainAction = true;
		
	}
		
	}
	
	public static void SetSlot(KeyEvent e) {
		A:{
		if(e.getKeyCode() == KeyEvent.VK_1) {
			SelectedSlot = 0;
			Animation.PlayNameA = true;
			break A;
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			SelectedSlot = 1;
			Animation.PlayNameA = true;
			break A;
		}
		if(e.getKeyCode() == KeyEvent.VK_3) {
			SelectedSlot = 2;
			Animation.PlayNameA = true;
			break A;
		}
		if(e.getKeyCode() == KeyEvent.VK_4) {
			SelectedSlot = 3;
			Animation.PlayNameA = true;
			break A;
		}
		if(e.getKeyCode() == KeyEvent.VK_5) {
			SelectedSlot = 4;
			Animation.PlayNameA = true;
			break A;
		}
		if(e.getKeyCode() == KeyEvent.VK_6) {
			SelectedSlot = 5;
			Animation.PlayNameA = true;
			break A;
		}
		if(e.getKeyCode() == KeyEvent.VK_7) {
			SelectedSlot = 6;
			Animation.PlayNameA = true;
			break A;
		}
		if(e.getKeyCode() == KeyEvent.VK_8) {
			SelectedSlot = 7;
			Animation.PlayNameA = true;
			break A;
		}
		}
	SelectedID = ItemID.get(SelectedSlot);
	}
	
	public static int Search(List<Integer> list, int e) {
		if(list.contains(e)) {
			A:for(int i = 0; i < list.size(); i++) {
				if(list.get(i) == e) {
					e = i;
					break A;
				}
			}
		}else {
			e = 0;
			SelectedID = 0;
		}
		return e;
	}
	
	public static int Search(List<Double> list, double e) {
		if(list.contains(e)) {
			A:for(int i = 0; i < list.size(); i++) {
				if(list.get(i) == e) {
					s = i;
					break A;
				}
			}
		}else {
			s = 0;
			SelectedID = 0;
		}
		return s;
	}
	
	
	
	public static void DrawHotBar(Graphics g) {
		g.drawImage(HotBar, main.Main.SW/2-242, main.Main.SH - 80, 484, 64, null);
		g.setColor(new Color(0,0,0,255));
		g.setFont(F3Menu.F3Font2);
		for(int i = 0; i < 8; i++) {
			if(ItemID.get(i) > 0.0) {
				g.drawImage(Textures.BlockTex[Separate.getID1(ItemID, i)][Separate.getTAG1(ItemID, i)], main.Main.SW/2 - 233 + (60*i), main.Main.SH - 71, 46, 46, null);
				if(ItemCount.get(i) > 0) {
					g.drawString(ItemCount.get(i) + "", main.Main.SW/2 - 213 + (60*i), main.Main.SH - 21);
				}	
			}
			if(SelectedSlot == i) {
				g.setColor(new Color(255,0,0,255));
				g.drawRect(main.Main.SW/2 - 240 + (60*i), main.Main.SH - 78, 60, 60);
				g.setColor(new Color(0,0,0,255));
				}	
		}
		
		SelectedID = ItemID.get(SelectedSlot);
	}
	
	public static void DrawInventory(Graphics g) {
		g.drawImage(Inventory, main.Main.SW/2 - 306, main.Main.SH/2 - 144, 612, 252, null);
			g.setColor(new Color(0,0,0,255));
			g.setFont(F3Menu.F3Font2);
			for(int j = 0; j < 10; j++) {	//56x56 start +8
				g.drawImage(Textures.BlockTex[Separate.getID1(ItemID, 8 + j)][Separate.getTAG1(ItemID, 8 + j)], main.Main.SW/2-306 + 8 + (60*j) + 5, main.Main.SH/2 - 144 + 8 + 5, 46, 46, null);
				if(ItemCount.get(8 + j) > 0) {
				g.drawString(ItemCount.get(8+j) + "", main.Main.SW/2-273 + (60*j), main.Main.SH/2 - 81);
				}
				
				g.drawImage(Textures.BlockTex[Separate.getID1(ItemID, 18 + j)][Separate.getTAG1(ItemID, 18 + j)], main.Main.SW/2-306 + 8 + (60*j) + 5, main.Main.SH/2 - 144 + 8 + 5 + 60, 46, 46, null);
				if(ItemCount.get(18 + j) > 0) {
					g.drawString(ItemCount.get(18+j) + "", main.Main.SW/2-306 + 8 + (60*j) + 5 + 20, main.Main.SH/2 - 144 + 8 + 5 + 50 + 60);
				}
				
				g.drawImage(Textures.BlockTex[Separate.getID1(ItemID, 28 + j)][Separate.getTAG1(ItemID, 28 + j)], main.Main.SW/2-306 + 8 + (60*j) + 5, main.Main.SH/2 - 144 + 8 + 5 + 2*60, 46, 46, null);
				if(ItemCount.get(28 + j) > 0) {
					g.drawString(ItemCount.get(28+j) + "", main.Main.SW/2-306 + 8 + (60*j) + 5 + 20, main.Main.SH/2 - 144 + 8 + 5 + 50 + 120);
				}
				
				g.drawImage(Textures.BlockTex[Separate.getID1(ItemID, 38 + j)][Separate.getTAG1(ItemID, 38 + j)], main.Main.SW/2-306 + 8 + (60*j) + 5, main.Main.SH/2 - 144 + 8 + 5+ 3*60, 46, 46, null);
				if(ItemCount.get(38 + j) > 0) {
					g.drawString(ItemCount.get(38+j) + "", main.Main.SW/2-306 + 8 + (60*j) + 5 + 20, main.Main.SH/2 - 144 + 8 + 5 + 50 + 180);
				}
				
			}
			
			g.drawImage(Craft.craftButton, main.Main.SW/2+306 + 10, main.Main.SH/2 - 18 - 122, 62, 62, null);
			g.drawImage(Settings.SettingsButton, main.Main.SW/2+306 + 10, main.Main.SH/2 - 18 - 50, 62, 62, null);
			
		}
	
	
	
	public static void TakeInInv(double ID, int Count) {
		if(ItemID.contains(ID)) {
			v = Search(ItemID, ID);
			ItemCount.set(v, ItemCount.get(v)+Count);
		}else if(ItemID.contains(0.0)) {
			v = Search(ItemID, 0.0);
			ItemID.set(v, ID);
			ItemCount.set(v, Count);
		}else {
			System.out.println("full");
		}
		SelectedID = ItemID.get(SelectedSlot);
	}
	
	public static void TakeOffInv(double ID, int Count) {
		v = Search(ItemID, ID);
		if(ItemCount.get(v) == Count) {
			ItemCount.set(v, 0);
			ItemID.set(v, 0.0);
		}else {
			ItemCount.set(v, ItemCount.get(v)-Count);
		}
		SelectedID = ItemID.get(SelectedSlot);
		
	}
	
	public static void Drag() {
		A:for(int i = 0; i < 8; i++) {
			Rectangle FastSlot = new Rectangle(main.Main.SW/2 - 240 + (60*i) + Main.PosX, main.Main.SH - 78 + Main.PosY, 60, 60);//hotbar
			
			Rectangle Cursor = new Rectangle(TerrainUpdate.MouseX, TerrainUpdate.MouseY, 1, 1);
			
			if(Cursor.intersects(FastSlot)) {
				DragedID = ItemID.get(i);
				DragedCount = ItemCount.get(i);
				ItemID.set(i, 0.0);
				ItemCount.set(i, 0);
				KSlot = i;
				inCursor = true;
				break A;
			}
		}
		A:for(int i = 0; i < 10; i++) {
			
				Rectangle Slot = new Rectangle(main.Main.SW/2 - 300 + (60*i) + Main.PosX, Main.SH/2 - 141 + Main.PosY, 60, 60);
				Rectangle Slot1 = new Rectangle(main.Main.SW/2 - 300 + (60*i) + Main.PosX, Main.SH/2 - 81 + Main.PosY, 60, 60);
				Rectangle Slot2 = new Rectangle(main.Main.SW/2 - 300 + (60*i) + Main.PosX, Main.SH/2 - 21 + Main.PosY, 60, 60);
				Rectangle Slot3 = new Rectangle(main.Main.SW/2 - 300 + (60*i) + Main.PosX, Main.SH/2 + 41 + Main.PosY, 60, 60);
				
				Rectangle Cursor = new Rectangle(TerrainUpdate.MouseX, TerrainUpdate.MouseY, 1, 1);
								
				if(Cursor.intersects(Slot)) {
					DragedID = ItemID.get(8 + i);
					DragedCount = ItemCount.get(8 + i);
					ItemID.set(8 + i, 0.0);
					ItemCount.set(8 + i, 0);
					KSlot = 8 + i;
					inCursor = true;
					SelectedID = ItemID.get(SelectedSlot);
					break A;
				}else if(Cursor.intersects(Slot1)) {
					DragedID = ItemID.get(18 + i);
					DragedCount = ItemCount.get(18 + i);
					ItemID.set(18 + i, 0.0);
					ItemCount.set(18 + i, 0);
					KSlot = 18 + i;
					inCursor = true;
					SelectedID = ItemID.get(SelectedSlot);
					break A;
				}else if(Cursor.intersects(Slot2)) {
					DragedID = ItemID.get(28 + i);
					DragedCount = ItemCount.get(28 + i);
					ItemID.set(28 + i, 0.0);
					ItemCount.set(28 + i, 0);
					KSlot = 28 + i;
					inCursor = true;
					SelectedID = ItemID.get(SelectedSlot);
					break A;
				}else if(Cursor.intersects(Slot3)) {
					DragedID = ItemID.get(38 + i);
					DragedCount = ItemCount.get(38 + i);
					ItemID.set(38 + i, 0.0);
					ItemCount.set(38 + i, 0);
					KSlot = 38 + i;
					inCursor = true;
					SelectedID = ItemID.get(SelectedSlot);
					break A;
				}
				
			}
		}	
	
	public static void undo() {
		if(DragedID != null && DragedID != 0) {
		ItemID.set(KSlot, DragedID);
		ItemCount.set(KSlot, DragedCount);
		DragedID = 0.0;
		DragedCount = 0;
		SelectedID = ItemID.get(SelectedSlot);
		}
	}
	
	public static void drop() {
		A:for(int i = 0; i < 8; i++) {
		Rectangle FastSlot = new Rectangle(main.Main.SW/2 - 242 + (60*i) + Main.PosX, main.Main.SH - 80 + Main.PosY, 60, 60);//hotbar
		
		Rectangle Cursor = new Rectangle(TerrainUpdate.MouseX, TerrainUpdate.MouseY, 1, 1);
		
		if(Cursor.intersects(FastSlot)) {
			if(ItemID.get(i) != 0) {
				KID = ItemID.get(i);
				KCount = ItemCount.get(i);
				ItemID.set(i, DragedID);
				ItemCount.set(i, DragedCount);
				DragedID = KID;
				DragedCount = KCount;
				inCursor = true;
				Gameplay.draged = true;
				}else {
					ItemID.set(i, DragedID);
					ItemCount.set(i, DragedCount);
					DragedID = 0.0;
					DragedCount = 0;
					inCursor = false;
					Gameplay.draged = false;
				}
			break A;
			}else {
				inCursor = true;
			}
		}
		A:for(int i = 0; i < 10; i++) {
			Rectangle Slot = new Rectangle(main.Main.SW/2 - 300 + (60*i) + Main.PosX, Main.SH/2 - 141 + Main.PosY, 60, 60);
			Rectangle Slot1 = new Rectangle(main.Main.SW/2 - 300 + (60*i) + Main.PosX, Main.SH/2 - 81 + Main.PosY, 60, 60);
			Rectangle Slot2 = new Rectangle(main.Main.SW/2 - 300 + (60*i) + Main.PosX, Main.SH/2 - 21 + Main.PosY, 60, 60);
			Rectangle Slot3 = new Rectangle(main.Main.SW/2 - 300 + (60*i) + Main.PosX, Main.SH/2 + 41 + Main.PosY, 60, 60);
			
			Rectangle Cursor = new Rectangle(TerrainUpdate.MouseX, TerrainUpdate.MouseY, 1, 1);
			
			if(Cursor.intersects(Slot)) {
				if(ItemID.get(8 + i) != 0) {
					KID = ItemID.get(8 + i);
					KCount = ItemCount.get(8 + i);
					ItemID.set(8 + i, DragedID);
					ItemCount.set(8 + i, DragedCount);
					DragedID = KID;
					DragedCount = KCount;
					inCursor = true;
					Gameplay.draged = true;
				}else {
					ItemID.set(8 + i, DragedID);
					ItemCount.set(8 + i, DragedCount);
					DragedID = 0.0;
					DragedCount = 0;
					inCursor = false;
					Gameplay.draged = false;
				}
				break A;
			}else if(Cursor.intersects(Slot1)) {
				if(ItemID.get(18 + i) != 0) {
					KID = ItemID.get(18 + i);
					KCount = ItemCount.get(18 + i);
					ItemID.set(18 + i, DragedID);
					ItemCount.set(18 + i, DragedCount);
					DragedID = KID;
					DragedCount = KCount;
					inCursor = true;
					Gameplay.draged = true;
				}else {
					ItemID.set(18 + i, DragedID);
					ItemCount.set(18 + i, DragedCount);
					DragedID = 0.0;
					DragedCount = 0;
					inCursor = false;
					Gameplay.draged = false;
				}
				break A;
			}else if(Cursor.intersects(Slot2)) {
				if(ItemID.get(28 + i) != 0) {
					KID = ItemID.get(28 + i);
					KCount = ItemCount.get(28 + i);
					ItemID.set(28 + i, DragedID);
					ItemCount.set(28 + i, DragedCount);
					DragedID = KID;
					DragedCount = KCount;
					inCursor = true;
					Gameplay.draged = true;
				}else {
					ItemID.set(28 + i, DragedID);
					ItemCount.set(28 + i, DragedCount);
					DragedID = 0.0;
					DragedCount = 0;
					inCursor = false;
					Gameplay.draged = false;
				}
				break A;
			}else if(Cursor.intersects(Slot3)) {
				if(ItemID.get(38 + i) != 0) {
					KID = ItemID.get(38 + i);
					KCount = ItemCount.get(38 + i);
					ItemID.set(38 + i, DragedID);
					ItemCount.set(38 + i, DragedCount);
					DragedID = KID;
					DragedCount = KCount;
					inCursor = true;
					Gameplay.draged = true;
				}else {
					ItemID.set(38 + i, DragedID);
					ItemCount.set(38 + i, DragedCount);
					DragedID = 0.0;
					DragedCount = 0;
					inCursor = false;
					Gameplay.draged = false;
				}
				break A;
			}
			
		}
	}
	
	public static void DragItem(Graphics g, double ID) {
		g.drawImage(Textures.BlockTex[Separate.getID2(ID)][Separate.getTAG2(ID)], TerrainUpdate.MouseX, TerrainUpdate.MouseY - 20, 16, 16, null);
	}
	

	}
	

