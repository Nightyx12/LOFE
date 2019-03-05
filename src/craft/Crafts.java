package craft;

import gui.Craft;
import gui.Inventory;

public class Crafts {
	
	public static int v;
	
	public static String[] Crafts = {"1 log  =  1 plank", "1 plank  =  8 sticks", "2 planks  +  1 stick  +  2 strings  =  1 WoodenAxe", 
			"2 planks  +  2 stick  +  2 strings  =  1 WoodenPickaxe", "1 planks  +  2 stick  +  2 strings  =  1 WoodenShovel",
			"1 Axe  +  2 planks  =  1 CraftingBench"};
	
	public static String[] Crafts2 = {"1 axe  +  1 plank  =  1 Barrel"};

	public static void planks() {
		//1 log --> 1 plank
		Craft.craft(5, 1, 6, 1);
	}
	
	public static void sticks() {
		//1 plank --> 8 sticks
		Craft.craft(6, 1, 300, 8);
	}
	
	public static void CraftingBench() {
		//2 planks + 4 sticks + axe --> 1 CraftingBench
		if(Inventory.ItemID.contains(302.0)) {
			Craft.craft(6,2,16,1);
			}
		}	
	
	public static void WoodenPickaxe() {
		Double[] WoodenPickaxe = {6.0, 300.0, 313.0};
		int[] count = {2, 2, 2};
		Craft.craft4(WoodenPickaxe, count, 301, 1);
	}
	
	public static void WoodenAxe() {
		Double[] WoodenAxe = {6.0, 300.0, 313.0};
		int[] count = {2, 1, 2};
		Craft.craft4(WoodenAxe, count, 302, 1);
	}
	
	public static void WoodenShovel() {
		Double[] WoodenShovel = {6.0, 300.0, 313.0};
		int[] count = {1, 2, 2};
		Craft.craft4(WoodenShovel, count, 302, 1);
	}
	
	public static void Torch() {
		//4 stick + 1 coal --> 4 Torch
		
	}
	
	public static void Barrel() {
		//2 planks + 4 sticks --> 1 Barrel
		if(Inventory.ItemID.contains(302.0)) {
			Craft.craft(6.0,1,19.0,1);
		}
	}
	
	public static void Door() {
		//4 planks + 4 sticks --> Door
		Craft.craft2(6, 300, 4, 4, 10.5, 1);
	}
	
	
}
