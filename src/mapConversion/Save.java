package mapConversion;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import blocks.Textures;
import main.Main;
import player.Animation;
import terrain.Terrain;

public class Save {

	public static double[] temp;
	public static int[] temp1;
	public static String s;
	public static String[] s1;
	static Random r = new Random();
	static int k = 0;
	static int i, j;
	
	static int time1 = 0;
	static int maxtime1 = 50;
	public static boolean saved = false;
	
	//create a temporary file
    
    public static String FolderName = "Skyblock";
    public static String dataFolder = System.getenv("APPDATA") + "\\." + FolderName; 
    public static File GameFile = new File(dataFolder);
    
    public static File WorldFolder = new File(dataFolder + "\\Saves");
    public static String WorldName = "New_World";
    public static File World = new File(dataFolder + "\\Saves\\" + WorldName);
	
	public static void SaveMap() {	
		System.out.println(dataFolder);
		GameFile.mkdir();
		if(!WorldFolder.exists()) {
			WorldFolder.mkdir();
		}
		World.mkdir();
		File logFile = new File(World + "World.txt");
		
		BufferedWriter writer = null;
        try {
            

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            for(int i = 0; i < Terrain.worldSizeY; i++) {
            	writer.write("B. ");
            for(int j = 0; j < Terrain.worldSizeX; j++) {
            	temp = Terrain.chunk[i];
            	s = Double.toString(temp[j]);
            	writer.write(s + " ");
            }
            writer.newLine();
            }
            
            for(int i = 0; i < Terrain.worldSizeY; i++) {
            	writer.write("HP. ");
            for(int j = 0; j < Terrain.worldSizeX; j++) {
            	temp1 = Terrain.chunkhp[i];
            	s = Integer.toString(temp1[j]);
            	writer.write(s + " ");
            }
            writer.newLine();
            }
            
            for(int i = 0; i < Terrain.worldSizeY; i++) {
            	writer.write("C. ");
            for(int j = 0; j < Terrain.worldSizeX; j++) {
            	temp1 = Terrain.chunkColour[i];
            	s = Integer.toString(temp1[j]);
            	writer.write(s + " ");
            }
            writer.newLine();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
	}
	
	
	
	public static void SavePlayerSats() {
		File logFile = new File(World + "Inventory.txt");
		
		BufferedWriter writer = null;
        try {
            

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            
            //Inventory
            for(double ID:gui.Inventory.ItemID) {
            	writer.write("ID " + Double.toString(ID));
            	i++;
            	writer.newLine();
            }
            for(int Count:gui.Inventory.ItemCount) {
            	writer.write("C " + Integer.toString(Count));
            	writer.newLine();
            }
            
            //Coord
            	writer.write("X " + player.Player.playerCoordX);
            	writer.newLine();
            	writer.write("Y " + player.Player.playerCoordY);
            	writer.newLine();
            	
            //HP, Death, FP & Saturation
            	//HP & Death
            	writer.write("HP " + player.Life.hp);
            	writer.newLine();
            	writer.write("D " + player.Life.death);
            	writer.newLine();
            	//FP & Saturation
            	writer.write("FP " + player.Food.fp);
            	writer.newLine();
            	writer.write("S " + player.Food.saturation);
            	writer.newLine();
            	
            	
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
        saved = true;
	}
	
	public static void SaveFinish(Graphics g) {
		g.setColor(new Color(0,0,0,255));
		g.setFont(Animation.AFont);
		g.drawString("Saved", Main.SW/2-100, Main.SH/2);
		time1++;
		if(time1 == maxtime1) {
			saved = false;
			time1 = 0;
		}
	}
	
}
