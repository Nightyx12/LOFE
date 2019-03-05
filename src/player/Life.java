package player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Main;

public class Life {

	public static int maxhp = 100;
	public static int hp = 100;
	public static int death = 0;
	public static int hpPerSecond = 1;
	
	public static BufferedImage Bar;
	public static BufferedImage Heart1;
	public static BufferedImage Heart2;
	public static BufferedImage Heart3;
	
	public static void NaturalRegen() {
		if(hp < maxhp && Food.fp >= 50) {
			if(hp > maxhp-hpPerSecond) {
				hp = maxhp;
			}else {
				hp += hpPerSecond;
			}
		}
	}
	
	public static void Death() {
		Player.playerCoordX = Player.InitPlayerCoordX;
		Player.playerCoordY = Player.InitPlayerCoordY;
		death++;
		hp = 50;
		Food.fp = 50;
		Animation.PlayDiedA = true;
	}
	
	public static void Damage(int damage) {
		if(hp <= damage) {
			Death();
		}else {
			hp -= damage;
			Animation.PlayDamageA = true;
		}
	}
	
	public static void FallingDamage() {
		if(Mouvement.BlockFall >= 8) {
		if(Mouvement.BlockFall == 8) {
			Damage(5);
		}else {
			Damage(5 + ((Mouvement.BlockFall-8)*5));
		}
		}
	}
	
	public static void DrawLifeBar(Graphics g) {
		g.drawImage(Bar, Main.SW - 424, 5, 404, 44, null);
		DrawHeart(g);
	}
	
	public static void DrawHeart(Graphics g) {
		if(hp == maxhp) {
			g.drawImage(Heart1, Main.SW - 62, 7, 40, 40, null);
		}
		if(hp >= maxhp - (maxhp/10)) {
			g.drawImage(Heart1, Main.SW - 102, 7, 40, 40, null);
		}
		if(hp >= maxhp - ((maxhp/10)*2)) {
			g.drawImage(Heart1, Main.SW - 142, 7, 40, 40, null);
		}	
		if(hp >= maxhp - ((maxhp/10)*3)) {
			g.drawImage(Heart1, Main.SW - 182, 7, 40, 40, null);
		}
		if(hp >= maxhp - ((maxhp/10)*4)) {
			g.drawImage(Heart1, Main.SW - 222, 7, 40, 40, null);
		}
		if(hp >= maxhp - ((maxhp/10)*5)) {
			g.drawImage(Heart1, Main.SW - 262, 7, 40, 40, null);
		}
		if(hp >= maxhp - ((maxhp/10)*6)) {
			g.drawImage(Heart1, Main.SW - 302, 7, 40, 40, null);
		}
		if(hp >= maxhp - ((maxhp/10)*7)) {
			g.drawImage(Heart1, Main.SW - 342, 7, 40, 40, null);
		}
		if(hp >= maxhp - ((maxhp/10)*8)) {
			g.drawImage(Heart1, Main.SW - 382, 7, 40, 40, null);
		}
		if(hp >= maxhp - ((maxhp/10)*9)) {
			g.drawImage(Heart1, Main.SW - 422, 7, 40, 40, null);
		}		
	}
	
}
