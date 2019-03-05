package craft;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import blocks.Textures;
import main.Main;
import terrain.TerrainUpdate;

public class DrawCraft {

	public static Font f = new Font("Calibri", 1, 15);
	
	public static int[] crafts = new int[14];
	
	public static int ID1, ID2, ID3, ID4;
	public static int TAG1, TAG2, TAG3, TAG4;
	
	public static int craft = 0;
	public static int maxcrafts = 2;	
	public static boolean reload = true;
	public static int choice = 0;
	
	public static void Quickset(int ID, int TAG) {
		ID1 = ID2;
		TAG1 = TAG2;
			ID2 = ID3;
			TAG2 = TAG3;
				ID3 = ID4;
				TAG3 = TAG4;
					ID4 = ID;
					TAG4 = TAG;
					reload = false;
	}
	
	public static void Quickset2(int ID, int TAG) {
		ID4 = ID3;
		TAG4 = TAG3;
			ID3 = ID2;
			TAG3 = TAG2;
				ID2 = ID1;
				TAG2 = TAG1;
					ID1 = ID;
					TAG1 = TAG;
					reload = false;
	}
	
	public static void SetID() {
		if(craft == 0) {
			ID1 = 6;	//Plank
			TAG1 = 0;
				ID2 = 300;	//Stick
				TAG2 = 0;
					ID3 = 302;	//Axe
					TAG3 = 0;
						ID4 = 301;	//Pickaxe
						TAG4 = 0;
		}else if(craft == 1) {
			Quickset(304,0);
		}else if(craft == 2) {
			Quickset(16,0);
		}
	}
	
	public static void SetID2() {
		if(craft == 0) {
			ID1 = 6;	//Plank
			TAG1 = 0;
				ID2 = 300;	//Stick
				TAG2 = 0;
					ID3 = 302;	//Axe
					TAG3 = 0;
						ID4 = 301;	//Pickaxe
						TAG4 = 0;
		}else if(craft == 1) {
			Quickset2(300,0);
		}else if(craft == 2) {
			Quickset2(302,0);
		}
	}
	
	public static void drawCraft(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(405, 220, 50, 50);
		g.drawRect(405, 280, 50, 50);
		g.drawRect(405, 340, 50, 50);
		g.drawRect(405, 400, 50, 50);
		
		if(reload) {
			if(choice == 0) {
				SetID();
			}else {
				SetID2();
			}
		}
		
		g.drawImage(Textures.BlockTex[ID1][TAG1], 410, 225, 40, 40, null);
		g.drawImage(Textures.BlockTex[ID2][TAG2], 410, 285, 40, 40, null);
		g.drawImage(Textures.BlockTex[ID3][TAG3], 410, 345, 40, 40, null);
		g.drawImage(Textures.BlockTex[ID4][TAG4], 410, 405, 40, 40, null);	
		
		g.setColor(new Color(25,25,25,255));
		g.setFont(f);
		
		g.drawString(Crafts.Crafts[craft], 475, 265);
		g.drawString(Crafts.Crafts[craft+1], 475, 325);
		g.drawString(Crafts.Crafts[craft+2], 475, 385);
		g.drawString(Crafts.Crafts[craft+3], 475, 445);
		
		
	}
	
	public static void OnClick() {
		for(int i = 0; i < 4; i++) {
			Rectangle Craft = new Rectangle(405 + Main.PosX, 220 + (60*i) + Main.PosY, 50, 50);
			Rectangle Cursor = new Rectangle(TerrainUpdate.MouseX, TerrainUpdate.MouseY, 1, 1);
			
			if(Cursor.intersects(Craft)) {
				
				if(craft == 0) {
					switch(i) {
					case 0:
						Crafts.planks();
						break;
					case 1:
						Crafts.sticks();
						break;
					case 2:
						Crafts.WoodenAxe();
						break;
					case 3:
						Crafts.WoodenPickaxe();
						break;
					}
				}else if(craft == 1) {
					switch(i) {
					case 0:
						Crafts.sticks();
						break;
					case 1:
						Crafts.WoodenAxe();
						break;
					case 2:
						Crafts.WoodenPickaxe();
						break;
					case 3:
						Crafts.WoodenShovel();
						break;
					}
				}else if(craft == 2) {
					switch(i) {
					case 0:
						Crafts.WoodenAxe();
						break;
					case 1:
						Crafts.WoodenPickaxe();
						break;
					case 2:
						Crafts.WoodenShovel();
						break;
					case 3:
						Crafts.CraftingBench();
						break;
					}
				}
				
			}
			
		}
	}
	
}
