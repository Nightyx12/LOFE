package gameplay;

import java.awt.Color;
import java.awt.Graphics;

import main.Main;

public class Time {

	//In game time
		public static int time = 0;
		public static int day = 0;
		public static int timeForDay = 24000;	
		public static int x, y;
		public static int x1, y1;
		
		public static int a = 0;
		public static int time2;
		public static boolean add = true;
		public static Color BackGroundAdd = new Color(200,0,0,a);
		
		public static void UpdateTime() {
			if(time >= timeForDay) {
				time = 0;
				day += 1;
			}
			time++;	
			time2++;
			if(add) {
			if(time2 >= 100) {
				time2 -= 100;
				a++;
				BackGroundAdd = new Color(200,0,0,a);
				if(a >= 120) {
					add = false;
				}
			}
			}else {
				if(time2 >= 100) {
					time2 -= 100;
					a--;
					BackGroundAdd = new Color(200,0,0,a);
					if(a == 0) {
						add = true;
					}
				}
			}
			
		}
		
		public static void Sun(Graphics g) {
			x = (int) (((Main.SW/timeForDay)*time)*2.5);
			y = Main.SH/6;
			g.setColor(new Color(255,255,0,200));
			g.fillOval(x, y, 75, 75);
		}
		
		public static void Moon(Graphics g) {
			x1 = ((Main.SW/timeForDay)*time)*2 - Main.SW + 300;
			y1 = Main.SH/6;
			g.setColor(new Color(150,150,150,125));
			g.fillOval(x1, y1, 75, 75);
		}
		
	
}
