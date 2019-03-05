package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Main;

public class Food {

	public static BufferedImage Food;
	
	public static int fp = 100;
	public static int maxfp = 100;
	public static int saturation = 50;
	public static int maxsaturation = 100;
	public static boolean action = false;
	
	public static void NaturalFoodLoose() {
		if(saturation > 0) {
			if(fp != maxfp) {
				if(action) {
					saturation -= 3;
					fp++;
				}else {
					saturation -= 2;
					fp++;
				}
			}else {
				if(action) {
					saturation -= 2;
				}
				saturation -= 1;
			}
		}else if(fp > 0) {
			if(action) {
				fp -= 2;
			}else {
				fp--;
			}
			
		}else {
			fp = 0;
			Life.Damage(5);
		}
		action = false;
		
		if(saturation < 0) {
			saturation = 0;
		}
		
	}
	
	public static void DrawFoodBar(Graphics g) {
		g.drawImage(Life.Bar, Main.SW - 424, 59, 404, 44, null);
		DrawFood(g);
		DrawSaturation(g);
	}
	
	public static void DrawFood(Graphics g) {
		if(fp == maxfp) {
			g.drawImage(Food, Main.SW - 62, 61, 40, 40, null);
		}
		if(fp >= maxfp - (maxfp/10)) {
			g.drawImage(Food, Main.SW - 102, 61, 40, 40, null);
		}
		if(fp >= maxfp - ((maxfp/10)*2)) {
			g.drawImage(Food, Main.SW - 142, 61, 40, 40, null);
		}	
		if(fp >= maxfp - ((maxfp/10)*3)) {
			g.drawImage(Food, Main.SW - 182, 61, 40, 40, null);
		}
		if(fp >= maxfp - ((maxfp/10)*4)) {
			g.drawImage(Food, Main.SW - 222, 61, 40, 40, null);
		}
		if(fp >= maxfp - ((maxfp/10)*5)) {
			g.drawImage(Food, Main.SW - 262, 61, 40, 40, null);
		}
		if(fp >= maxfp - ((maxfp/10)*6)) {
			g.drawImage(Food, Main.SW - 302, 61, 40, 40, null);
		}
		if(fp >= maxfp - ((maxfp/10)*7)) {
			g.drawImage(Food, Main.SW - 342, 61, 40, 40, null);
		}
		if(fp >= maxfp - ((maxfp/10)*8)) {
			g.drawImage(Food, Main.SW - 382, 61, 40, 40, null);
		}
		if(fp >= maxfp - ((maxfp/10)*9)) {
			g.drawImage(Food, Main.SW - 422, 61, 40, 40, null);
		}		
	}
	
	public static void DrawSaturation(Graphics g) {
		g.setColor(new Color(200,125,0,125));
		if(saturation == maxsaturation) {
			g.fillRect(Main.SW - 62, 61, 40, 40);
		}
		if(saturation >= maxsaturation - (maxsaturation/10)) {
			g.fillRect(Main.SW - 102, 61, 40, 40);
		}
		if(saturation >= maxsaturation - (maxsaturation/10)*2) {
			g.fillRect(Main.SW - 142, 61, 40, 40);
		}	
		if(saturation >= maxsaturation - (maxsaturation/10)*3) {
			g.fillRect(Main.SW - 182, 61, 40, 40);
		}
		if(saturation >= maxsaturation - (maxsaturation/10)*4) {
			g.fillRect(Main.SW - 222, 61, 40, 40);
		}
		if(saturation >= maxsaturation - (maxsaturation/10)*5) {
			g.fillRect(Main.SW - 262, 61, 40, 40);
		}
		if(saturation >= maxsaturation - (maxsaturation/10)*6) {
			g.fillRect(Main.SW - 302, 61, 40, 40);
		}
		if(saturation >= maxsaturation - (maxsaturation/10)*7) {
			g.fillRect(Main.SW - 342, 61, 40, 40);
		}
		if(saturation >= maxsaturation - (maxsaturation/10)*8) {
			g.fillRect(Main.SW - 382, 61, 40, 40);
		}
		if(saturation >= maxsaturation - (maxsaturation/10)*9) {
			g.fillRect(Main.SW - 422, 61, 40, 40);
		}	
	}
	
}
