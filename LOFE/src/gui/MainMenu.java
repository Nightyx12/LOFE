package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Main;

public class MainMenu {
	
	public static boolean mainmenu = true;
	public static String GameName = "Floating Island";
	

	public static void MainMenu(Graphics g) {
		g.setColor(new Color(0,60,60,255));
		g.fillRect(0, 0, 5000, 5000);
		
		g.setColor(new Color(0,0,0,255));
		g.drawRect(Main.SW/2 - 300, Main.SH/2 - 150, 600, 75);
		g.drawRect(Main.SW/2 - 250, Main.SH/2 - 50, 500, 75);
		g.drawRect(Main.SW/2 - 200, Main.SH/2 + 50, 400, 75);
		g.drawRect(Main.SW/2 - 150, Main.SH/2 + 150, 300, 75);
		g.setColor(new Color(0,40,40,255));
		g.setFont(new Font("sansserif", Font.BOLD, 50));
		g.drawString("Play game", Main.SW/2 - 125, Main.SH/2 - 100);
		
		g.setColor(new Color(0,30,30,255));
		g.setFont(new Font("sansserif", Font.BOLD, 75));
		g.drawString(GameName, (int) (Main.SW/2 - (GameName.length()*(75/4.25))+3), Main.SH/2 - 225 + 3);
		g.setColor(new Color(0,40,40,255));
		g.drawString(GameName, (int) (Main.SW/2 - (GameName.length()*(75/4.25))), Main.SH/2 - 225);
	}
	
	
	public static void MainMenuClicked() {
		Rectangle cursor = new Rectangle(main.Gui.Xmouse - 4, main.Gui.Ymouse - 25, 2, 2);
		Rectangle rect = new Rectangle(Main.SW/2 - 300, Main.SH/2 - 150, 600, 75);
		
		if(cursor.intersects(rect)) {
			mainmenu = false;
		}
	}
	
	
}
