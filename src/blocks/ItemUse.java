package blocks;

import gui.Inventory;
import player.Food;

public class ItemUse {
	
	public static int temp = 0;
	
	public static void EatFruit(int foodregen, int saturation, Double ID) {
		if(Food.fp < 100) {
			if(Food.maxfp - Food.fp < foodregen) {
				temp = foodregen - (Food.maxfp - Food.fp);
				Food.fp = 100;
				Food.saturation += temp + saturation;
			}else {
				Food.fp += foodregen;
				Food.saturation += saturation;
			}
			Inventory.TakeOffInv(ID, 1);
		}
	}
	
	
	
}
