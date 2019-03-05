package blocks;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import blocks.functionalBlocks.CraftingBench;
import blocks.functionalBlocks.Furnace;
import gui.Craft;
import gui.Inventory;
import gui.LoadingMenu;
import gui.Settings;
import main.Main;
import player.Animation;
import player.Food;
import player.Life;
import player.Player;

public class Textures {	

	public static BufferedImage BlockTex[][] = new BufferedImage[Blocks.IDmax][Blocks.MaxIDTag];
	public static ClassLoader loader = Main.class.getClassLoader();
	public static String path = (loader.getResource("")).toString().replace("file:/", "");
	
	public static void InitAllTex() {
		
		try {

			//Code
				//Blocks
			System.out.println(path.replaceAll("/", "\\\\") + "res\\Blocks\\Air.png");
			path = path.replaceAll("/", "\\\\");
				BlockTex[0][0] = ImageIO.read(new File(path + "res\\Blocks\\Air.png"));
				BlockTex[1][0] = ImageIO.read(new File(path + "res\\Blocks\\Dirt.png"));
				BlockTex[2][0] = ImageIO.read(new File(path + "res\\Blocks\\Grass.png"));
				BlockTex[3][0] = ImageIO.read(new File(path + "res\\Blocks\\Stone2.png"));
				BlockTex[4][0] = ImageIO.read(new File(path + "res\\Blocks\\UmbreakableBlock.png"));
				BlockTex[5][0] = ImageIO.read(new File(path + "res\\Blocks\\Log.png"));
				BlockTex[5][1] = ImageIO.read(new File(path + "res\\Blocks\\LogWithLeaves.png"));
				BlockTex[6][0] = ImageIO.read(new File(path + "res\\Blocks\\Planks.png"));
				BlockTex[7][0] = ImageIO.read(new File(path + "res\\Blocks\\Leaves.png"));
				BlockTex[8][0] = ImageIO.read(new File(path + "res\\Blocks\\Torch.png"));
				BlockTex[9][0] = ImageIO.read(new File(path + "res\\Blocks\\Sign.png"));
				BlockTex[10][0] = ImageIO.read(new File(path + "res\\Blocks\\LockedDoorU.png"));
				BlockTex[10][1] = ImageIO.read(new File(path + "res\\Blocks\\LockedDoorD.png"));
				BlockTex[10][2] = ImageIO.read(new File(path + "res\\Blocks\\OpenedDoorU.png"));
				BlockTex[10][3] = ImageIO.read(new File(path + "res\\Blocks\\OpenedDoorD.png"));
				BlockTex[10][4] = ImageIO.read(new File(path + "res\\Blocks\\LockedDoor.png"));
				BlockTex[10][5] = ImageIO.read(new File(path + "res\\Blocks\\OpenedDoor.png"));
				BlockTex[11][0] = ImageIO.read(new File(path + "res\\Blocks\\Sapling.png"));
				BlockTex[12][0] = ImageIO.read(new File(path + "res\\Blocks\\Clay.png"));
				BlockTex[13][0] = ImageIO.read(new File(path + "res\\Blocks\\Polished_Clay.png"));
				BlockTex[14][0] = ImageIO.read(new File(path + "res\\Blocks\\Sand.png"));
				BlockTex[16][0] = ImageIO.read(new File(path + "res\\Blocks\\CraftingBench.png"));
				BlockTex[17][0] = ImageIO.read(new File(path + "res\\Blocks\\Furnace.png"));
				BlockTex[19][0] = ImageIO.read(new File(path + "res\\Blocks\\Barrel.png"));
				BlockTex[19][1] = ImageIO.read(new File(path + "res\\Blocks\\Barrel1.png"));
				BlockTex[19][2] = ImageIO.read(new File(path + "res\\Blocks\\Barrel2.png"));
				BlockTex[19][3] = ImageIO.read(new File(path + "res\\Blocks\\Barrel3.png"));
				BlockTex[19][4] = ImageIO.read(new File(path + "res\\Blocks\\Barrel4.png"));
				BlockTex[19][5] = ImageIO.read(new File(path + "res\\Blocks\\Barrel5.png"));
				BlockTex[19][6] = ImageIO.read(new File(path + "res\\Blocks\\Barrel6.png"));
				BlockTex[24][0] = ImageIO.read(new File(path + "res\\Blocks\\Plateform.png"));
				BlockTex[24][1] = ImageIO.read(new File(path + "res\\Blocks\\Platform2.png"));
				BlockTex[24][2] = ImageIO.read(new File(path + "res\\Blocks\\Platform3.png"));
				BlockTex[24][3] = ImageIO.read(new File(path + "res\\Blocks\\Platform4.png"));
				
				//Item
				BlockTex[300][0] = ImageIO.read(new File(path + "res\\Item\\Stick.png"));
				BlockTex[301][0] = ImageIO.read(new File(path + "res\\T&W\\Wooden_Pickaxe.png"));
				BlockTex[302][0] = ImageIO.read(new File(path + "res\\T&W\\Wooden_Axe.png"));
				BlockTex[304][0] = ImageIO.read(new File(path + "res\\T&W\\Wooden_Shovel.png"));
				BlockTex[306][0] = ImageIO.read(new File(path + "res\\Item\\Coal.png"));
				BlockTex[306][0] = ImageIO.read(new File(path + "res\\Item\\Coal.png"));
				BlockTex[310][0] = ImageIO.read(new File(path + "res\\Item\\Red_Apple.png"));
				BlockTex[310][1] = ImageIO.read(new File(path + "res\\Item\\Green_Apple.png"));
				BlockTex[310][2] = ImageIO.read(new File(path + "res\\Item\\Yellow_Apple.png"));
				BlockTex[313][0] = ImageIO.read(new File(path + "res\\Item\\String.png"));
				BlockTex[314][0] = ImageIO.read(new File(path + "res\\Item\\Orange.png"));
				BlockTex[315][0] = ImageIO.read(new File(path + "res\\Item\\Lemon.png"));
				
				//Player
				Player.PlayerTexs[0] = ImageIO.read(new File(path + "res\\Player\\PlayerR.png"));
				Player.PlayerTexs[1] = ImageIO.read(new File(path + "res\\Player\\PlayerL.png"));
				Player.PlayerTexs[2] = ImageIO.read(new File(path + "res\\Player\\PlayerJR.png"));
				Player.PlayerTexs[3] = ImageIO.read(new File(path + "res\\Player\\PlayerJL.png"));
				
				//Life
				Life.Bar = ImageIO.read(new File(path + "res\\Gui\\LifeBar.png"));
				Life.Heart1 = ImageIO.read(new File(path + "res\\Gui\\Heart_I.png"));
				Life.Heart2 = ImageIO.read(new File(path + "res\\Gui\\Heart_II.png"));
				Life.Heart3 = ImageIO.read(new File(path + "res\\Gui\\Heart_III.png"));
				Food.Food = ImageIO.read(new File(path + "res\\Gui\\Food.png"));
				
				//Gui
				Inventory.HotBar = ImageIO.read(new File(path + "res\\Gui\\HotBar.png"));
				Inventory.Inventory = ImageIO.read(new File(path + "res\\Gui\\Inventory.png"));
				Craft.craftButton = ImageIO.read(new File(path + "res\\Gui\\CraftingButton.png"));
				Craft.craftWindow = ImageIO.read(new File(path + "res\\Gui\\CraftWindow.png"));
				CraftingBench.CraftingBenchWindow = ImageIO.read(new File(path + "res\\Gui\\CraftingBenchWindow.png"));
				Settings.SettingsButton = ImageIO.read(new File(path + "res\\Gui\\SettingsButton.png"));
				Settings.SettingsWindow = ImageIO.read(new File(path + "res\\Gui\\SettingWindow.png"));
				LoadingMenu.Logo = ImageIO.read(new File(path + "res\\Gui\\Logo.png"));
				Furnace.FurnaceWindow = ImageIO.read(new File(path + "res\\Gui\\FurnaceWindow.png"));
				
				//Loading animation
				LoadingMenu.Loading[0] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_1.png"));
				LoadingMenu.Loading[1] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_2.png"));
				LoadingMenu.Loading[2] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_3.png"));
				LoadingMenu.Loading[3] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_4.png"));
				LoadingMenu.Loading[4] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_5.png"));
				LoadingMenu.Loading[5] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_6.png"));
				LoadingMenu.Loading[6] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_7.png"));
				LoadingMenu.Loading[7] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_8.png"));
				LoadingMenu.Loading[8] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_9.png"));
				LoadingMenu.Loading[9] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_10.png"));
				LoadingMenu.Loading[10] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_11.png"));
				LoadingMenu.Loading[11] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_12.png"));
				LoadingMenu.Loading[12] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_13.png"));
				LoadingMenu.Loading[13] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_14.png"));
				LoadingMenu.Loading[14] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_15.png"));
				LoadingMenu.Loading[15] = ImageIO.read(new File(path + "res\\Gui\\Loading\\Loading_16.png"));
				
				Animation.DamageA = ImageIO.read(new File(path + "res\\\\Gui\\\\Heart_I.png"));
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
