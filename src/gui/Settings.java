package gui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gameplay.Gameplay;
import mapConversion.Load;
import mapConversion.Save;

public class Settings {

	public static BufferedImage SettingsButton;
	public static BufferedImage SettingsWindow;
	
	public static boolean Opened = false;
	
	public static void DrawSettingsWindow(Graphics g) {
		g.drawImage(SettingsWindow, main.Main.SW/2-306, main.Main.SH/2 - 18 - 126, 612, 252, null);
	}
	
	public static void Onclick() {
		Rectangle save = new Rectangle(main.Main.SW/2 - 294, main.Main.SH/2 - 109, 68, 68);
		Rectangle load = new Rectangle(main.Main.SW/2 - 294, main.Main.SH/2 - 29, 68, 68);
		Rectangle Controls = new Rectangle(main.Main.SW/2 - 294, main.Main.SH/2 + 51, 68, 68);
		
		if(Gameplay.Cursor.intersects(save)){
			System.out.println("Saving...");
			Save.SaveMap();
			Save.SavePlayerSats();
		}else if(Gameplay.Cursor.intersects(load)){
			System.out.println("Loading...");
			Load.LoadMap();
			Load.LoadPLayerStats();
		}else if(Gameplay.Cursor.intersects(Controls)) {
			System.out.println("Controls");
		}

	}
	
}
