package mapConversion;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import blocks.Textures;
import main.Main;
import player.Animation;
import player.Food;
import player.Life;
import player.Player;
import terrain.Terrain;

public class Load {

	public static double[] temp;
	public static String s;
	public static String[] s1;
	static Random r = new Random();
	static int k, k1, k2;
	
	//create a temporary file
	  public static String FolderName = "Skyblock";
	  public static String dataFolder = System.getenv("APPDATA") + "\\." + FolderName; 
	  public static File GameFile = new File(dataFolder);
	    
	  public static File WorldFolder = new File(dataFolder + "\\Saves");
	  public static String WorldName = "New_World";
	  public static File World = new File(dataFolder + "\\Saves\\" + WorldName);
    
    static int time1 = 0;
	static int maxtime1 = 50;
	public static boolean loaded = false;
    
    public static void LoadMap() {
    	k = 0;
    	k1 = 0;
    	k2 = 0;
    	File logFile = new File(World + "World.txt");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(logFile));
            String line;
            while((line = reader.readLine())!=null){
            	if(line.startsWith("B.")) {
            		s1 = line.split(" ");
            		for(int i = 0; i < s1.length-1; i++) {
            			Terrain.chunk[k][i] = Double.parseDouble(s1[i+1]);
            		}
            		k++;
            	}else if(line.startsWith("HP.")) {
            		s1 = line.split(" ");
            		for(int i = 0; i < s1.length-1; i++) {
            			Terrain.chunkhp[k1][i] = Integer.parseInt(s1[i+1]);
            		}
            		k1++;
            	}else if(line.startsWith("C.")) {
            		s1 = line.split(" ");
            		for(int i = 0; i < s1.length-1; i++) {
            			Terrain.chunkColour[k2][i] = Integer.parseInt(s1[i+1]);
            		}
            		k2++;
            	}
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        k = 0;
        System.out.println("Loaded");
        }
    
    public static void LoadPLayerStats() {
    	k = 0;
    	k1 = 0;
    	File logFile = new File(World + "Inventory.txt");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(logFile));
            String line;
            while((line = reader.readLine())!=null){
            	if(line.startsWith("ID ")) {
            		s1 = line.split(" ");
            		gui.Inventory.ItemID.set(k, Double.parseDouble(s1[1]));
            		k++;
            	}else if(line.startsWith("C ")) {
            		s1 = line.split(" ");
            		gui.Inventory.ItemCount.set(k1, Integer.parseInt(s1[1]));
            		k1++;
            	}else if(line.startsWith("X ")) {
            		s1 = line.split(" ");
            		Player.playerCoordX = Integer.parseInt(s1[1]);
            		k++;
            	}else if(line.startsWith("Y ")) {
            		s1 = line.split(" ");
            		Player.playerCoordY = Integer.parseInt(s1[1]);
            		k++;
            	}else if(line.startsWith("HP ")) {
            		s1 = line.split(" ");
            		player.Life.hp = Integer.parseInt(s1[1]);
            		k++;
            	}else if(line.startsWith("D ")) {
            		s1 = line.split(" ");
            		Life.death = Integer.parseInt(s1[1]);
            		k++;
            	}else if(line.startsWith("FP ")) {
            		s1 = line.split(" ");
            		Food.fp = Integer.parseInt(s1[1]);
            		k++;
            	}else if(line.startsWith("S ")) {
            		s1 = line.split(" ");
            		Food.saturation = Integer.parseInt(s1[1]);
            		k++;
            	}
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        loaded = true;
    }
    
    public static void LoadFinish(Graphics g) {
		g.setColor(new Color(0,0,0,255));
		g.setFont(Animation.AFont);
		g.drawString("Loaded", Main.SW/2-100, Main.SH/2);
		time1++;
		if(time1 == maxtime1) {
			loaded = false;
			time1 = 0;
		}
	}
    
	
}
