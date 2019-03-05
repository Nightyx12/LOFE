package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Main;

public class LoadingMenu {

	public static BufferedImage Logo;
	public static BufferedImage[] Loading = new BufferedImage[16];
	
	public static int time = 0;
	public static int LoadingTime = 1;	//160
	public static int time2 = 0;
	public static int LoadingTime2 = 160;
	
	public static boolean loadingMenu = true;
	
	public static void DrawLoadingMenu(Graphics g) {
		g.drawImage(Logo, Main.SW/2 - 200, Main.SH/2 - 200, 400, 400, null);
	}
	
	public static void DrawLoadingBar(Graphics g) {
		if(time2 < 10) {
			g.drawImage(Loading[0], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 20) {
			g.drawImage(Loading[1], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 30) {
			g.drawImage(Loading[2], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 40) {
			g.drawImage(Loading[3], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 50) {
			g.drawImage(Loading[4], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 60) {
			g.drawImage(Loading[5], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 70) {
			g.drawImage(Loading[6], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 80) {
			g.drawImage(Loading[7], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 90) {
			g.drawImage(Loading[8], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 100) {
			g.drawImage(Loading[9], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 110) {
			g.drawImage(Loading[10], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 120) {
			g.drawImage(Loading[11], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 130) {
			g.drawImage(Loading[12], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 140) {
			g.drawImage(Loading[13], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 < 150) {
			g.drawImage(Loading[14], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}else if(time2 <= 160) {
			g.drawImage(Loading[15], Main.SW/2 - 50, Main.SH - 150, 100, 100, null);	
		}
	}
	
}
