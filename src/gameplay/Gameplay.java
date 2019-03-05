package gameplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import blocks.Blocks;
import blocks.functionalBlocks.Barrel;
import blocks.functionalBlocks.CraftingBench;
import blocks.functionalBlocks.Furnace;
import craft.Crafts;
import craft.DrawCraft;
import gui.Control;
import gui.Craft;
import gui.F3Menu;
import gui.Inventory;
import gui.LoadingMenu;
import gui.Settings;
import main.Main;
import mapConversion.Load;
import mapConversion.Save;
import player.Animation;
import player.Food;
import player.Life;
import player.Mouvement;
import player.Player;
import terrain.Terrain;
import terrain.TerrainDraw;
import terrain.TerrainUpdate;


public class Gameplay extends JPanel implements ActionListener, KeyListener, MouseListener, MouseWheelListener{
	
	private static final long serialVersionUID = 1L;
	
	//timer
	private Timer timer;
	private int delay = 20;
	
	public static Rectangle Cursor = new Rectangle(TerrainUpdate.MouseX, TerrainUpdate.MouseY, 1, 1);
	
	public static int loop = 0;
	
	//Mouse
	public static boolean Lclicked = false;
	public static boolean Rclicked = false;
	public static boolean draged = false;
	public static boolean TerrainAction = false;
	
	public static boolean ControlDown = false;
	
	public static int v;
	
	public Gameplay() {
		Control.UpdateControls();
		Main.PosX = 0;
		Main.PosX = 0;
		//Set Textures
		Blocks.InitAll();
		//Initialize
		Terrain.Init(Terrain.chunk, Terrain.chunkhp, Terrain.worldSizeX, Terrain.worldSizeY);
		Inventory.Init();
		//Generate
		Terrain.IslandGen(Terrain.chunk, Terrain.worldSizeX, Terrain.worldSizeY);
		Terrain.TreeGen(Terrain.chunk, (Terrain.worldSizeY/2-3), (Terrain.worldSizeX/2));
		//Listener
		addKeyListener(this);
		addMouseListener(this);
		addMouseWheelListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//Initialize the Timer
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		if(LoadingMenu.loadingMenu) {
			g.setColor(new Color(200,200,255,255));
			g.fillRect(0, 0, 5000, 5000);
			LoadingMenu.DrawLoadingMenu(g);
			LoadingMenu.DrawLoadingBar(g);
		}else {
		//background
			g.setColor(new Color(200,200,255));
			g.fillRect(0, 0, Main.SW, Main.SH);
			g.setColor(Time.BackGroundAdd);
			g.fillRect(0, 0, Main.SW, Main.SH);		
			
//			Time.Sun(g);
//			Time.Moon(g);
			
			//Terrain
			TerrainDraw.drawTerrain(g, Terrain.chunk, Player.playerCoordX, Player.playerCoordY, Mouvement.Yshard, Mouvement.Xshard);
			
			//Light
			TerrainDraw.drawLight(g, Terrain.chunkColour, Player.playerCoordX, Player.playerCoordY, Mouvement.Yshard, Mouvement.Xshard);
			
			//Player
			Player.drawPlayer(g);
			
			//Pointer Detection
			if(!Inventory.Opened && !Craft.Opened && !Settings.Opened) {
			TerrainUpdate.PointerDetection(g, Player.playerCoordX, Player.playerCoordY);
			}
			
			//F3 Menu
			if(F3Menu.F3Pressed) {
				F3Menu.F3Draw(g);
			}
			
			//HotBar
			Inventory.DrawHotBar(g);
			
			//Inventory
			if(Inventory.Opened && !Craft.Opened && !CraftingBench.Opened && !Settings.Opened) {
				Inventory.DrawInventory(g);
			}
			
			//craftWindow
			if(Craft.Opened && !Inventory.Opened && !CraftingBench.Opened && !Settings.Opened) {
				Craft.DrawcraftWindow(g);
				DrawCraft.drawCraft(g);
			}

			if(CraftingBench.Opened) {
				CraftingBench.DrawWindow(g);
			}
			
			if(Settings.Opened) {
				Settings.DrawSettingsWindow(g);
			}
			
			if(Furnace.Opened) {
				Furnace.DrawWindow(g);
			}
			
			if(Inventory.inCursor) {
				Inventory.DragItem(g, Inventory.DragedID);
			}
			
			//Animation
			if(Animation.PlayDamageA) {
				Animation.DrawDamageA(g);
			}
			if(Animation.PlayDiedA) {
				Animation.DrawDiedA(g);
			}
			if(Animation.PlayNameA) {
				Animation.DrawNameA(g);
			}
			if(Save.saved) {
				Save.SaveFinish(g);
			}
			if(Load.loaded) {
				Load.LoadFinish(g);
			}
			
			//Bar
			Life.DrawLifeBar(g);
			Food.DrawFoodBar(g);
			
		g.dispose();
		}
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();		
		
		Main.SW = this.getWidth();
		Main.SH = this.getHeight();
		if(this.isShowing()) {
		Main.PosX = this.getLocationOnScreen().x;
		Main.PosY = this.getLocationOnScreen().y; 
		}
		
		if(LoadingMenu.loadingMenu) {
			
			LoadingMenu.time++;
			LoadingMenu.time2++;
			if(LoadingMenu.time == LoadingMenu.LoadingTime) {
				LoadingMenu.loadingMenu = false;
				LoadingMenu.time = 0;
				LoadingMenu.LoadingTime2 = 0;
			}
			
		}else {
		
			Cursor = new Rectangle(TerrainUpdate.MouseX, TerrainUpdate.MouseY, 1, 1);
			
		loop++;
		if(loop >= 50) {
			//1 Second
			loop = 0;
			Barrel.ProcessBarrel();
			Growth.TreeGrowth();
			Growth.GrassSpread();
			Life.NaturalRegen();
			Food.NaturalFoodLoose();
		}
		
		//Mouse Position
		TerrainUpdate.MouseX = MouseInfo.getPointerInfo().getLocation().x;
		TerrainUpdate.MouseY = MouseInfo.getPointerInfo().getLocation().y;
		
		if(Lclicked && !Animation.PlayDiedA) {
			TerrainUpdate.updateBlock(Terrain.chunk, Terrain.chunkhp, Player.playerCoordX, Player.playerCoordY, 0);
		}
		if(Rclicked && !Animation.PlayDiedA) {
			TerrainUpdate.updateBlock(Terrain.chunk, Terrain.chunkhp, Player.playerCoordX, Player.playerCoordY, 1);
		}
		
		//Gravity
		Mouvement.Gravity(Terrain.chunk);
		Mouvement.VoidDied();
		
		Time.UpdateTime();	
		
		}
		
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(!LoadingMenu.loadingMenu && !Animation.PlayDiedA) {
		if(Craft.Opened) {			
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_E) {
				Craft.Opened = false;
				DrawCraft.craft = 0;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
				ControlDown = true;
			}
			
		}else if(CraftingBench.Opened) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_E) {
				CraftingBench.Opened = false;
			}
		}else if(Furnace.Opened) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_E) {
				Furnace.Opened = false;
			}			
		}else if(Inventory.Opened) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_E) {
					Inventory.Opened = false;
					Inventory.undo();
				}
		}else if(Settings.Opened) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_C) {
				Settings.Opened = false;
			}
		}else {
			Inventory.SetSlot(e);
			if(e.getKeyCode() == KeyEvent.VK_Q && !Inventory.Opened ) {
				Mouvement.Qpressed();
			}
			if(e.getKeyCode() == KeyEvent.VK_D && !Inventory.Opened ) {
				Mouvement.Dpressed();
			}
			if(e.getKeyCode() == KeyEvent.VK_S && !Inventory.Opened ) {
				Mouvement.Spressed();
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE && !Inventory.Opened ) {
				Mouvement.Jump();
			}
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_E) {
					Inventory.Opened = true;				
			}
			if(e.getKeyCode() == KeyEvent.VK_H) {
				Life.Damage(5);				
			}
			if(e.getKeyCode() == KeyEvent.VK_C) {
					Craft.Opened = true;				
		}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_F3) {
			if(F3Menu.F3Pressed) {
				F3Menu.F3Pressed = false;
			}else {
			F3Menu.F3Pressed = true;
			}
		}

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!LoadingMenu.loadingMenu && !Animation.PlayDiedA) {
		if(Inventory.Opened) {
			
			if(e.getButton() == MouseEvent.BUTTON1) {
				Craft.OpenCraftWindow();
				if(draged) {
					Inventory.drop();
				}else {
				draged = true;
				Inventory.Drag();
				}
			}
			
			
			
		}else if(Craft.Opened) {
			
			if(ControlDown) {
				for(int i = 0; i < 8; i++) {
					DrawCraft.OnClick();
				}
			}else {
				DrawCraft.OnClick();
			}
			
		}else if(CraftingBench.Opened) {
			
			if(ControlDown) {
				for(int i = 0; i < 8; i++) {
					CraftingBench.OnClick();
				}
			}else {
				CraftingBench.OnClick();
			}
			
		}else if(Settings.Opened) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				Settings.Onclick();
			}
		}else {
			
			if(e.getButton() == MouseEvent.BUTTON1) {
				Inventory.SetSlotclick();
				if(TerrainAction) {
				TerrainUpdate.updateBlock(Terrain.chunk, Terrain.chunkhp, Player.playerCoordX, Player.playerCoordY, 0);
				Lclicked = true;
				TerrainAction = false;
				}
				
			}
			if(e.getButton() == MouseEvent.BUTTON3) {
				Inventory.SetSlotclick();
				if(TerrainAction) {
					TerrainUpdate.updateBlock(Terrain.chunk, Terrain.chunkhp, Player.playerCoordX, Player.playerCoordY, 1);
					Rclicked = true;
					TerrainAction = false;
				}
			}
			
			
			
		}
		
	}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(!LoadingMenu.loadingMenu && !Animation.PlayDiedA) {
		if(Inventory.Opened) {			
			
			}else if(Craft.Opened) {
				
			}else {
				
		if(e.getButton() == MouseEvent.BUTTON1) {
			TerrainUpdate.updateBlock(Terrain.chunk, Terrain.chunkhp, Player.playerCoordX, Player.playerCoordY, 0);
			Lclicked = false;
		}
		if(e.getButton() == MouseEvent.BUTTON3) {
			TerrainUpdate.updateBlock(Terrain.chunk, Terrain.chunkhp, Player.playerCoordX, Player.playerCoordY, 1);
			Rclicked = false;
		}
		
		}
		}
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(!LoadingMenu.loadingMenu && !Animation.PlayDiedA) {
		if(Craft.Opened) {
			if(e.getWheelRotation() > 0) {
				//down
					if(DrawCraft.craft == 0)	{
						
					}else {
						DrawCraft.craft--;
						DrawCraft.reload = true;
						DrawCraft.choice = 1;
					}
				}else {
					//up
					if(DrawCraft.maxcrafts == DrawCraft.craft)	{
						
					}else {
						DrawCraft.craft++;
						DrawCraft.reload = true;
						DrawCraft.choice = 0;
					}		
				}
		}else if(Inventory.Opened) {
			
		}else if(CraftingBench.Opened) {
			
		}else {
			if(e.getWheelRotation() > 0) {
				//down
					if(Inventory.SelectedSlot == 7) {
						Inventory.SelectedSlot = 0;
						Inventory.SelectedID = Inventory.ItemID.get(Inventory.SelectedSlot);
						Animation.PlayNameA = true;
					}else {
						Inventory.SelectedSlot++;
						Inventory.SelectedID = Inventory.ItemID.get(Inventory.SelectedSlot);
						Animation.PlayNameA = true;
					}						
				}else {
					//up
					if(Inventory.SelectedSlot == 0) {
						Inventory.SelectedSlot = 7;
						Inventory.SelectedID = Inventory.ItemID.get(Inventory.SelectedSlot);
						Animation.PlayNameA = true;
					}else {
						Inventory.SelectedSlot--;
						Inventory.SelectedID = Inventory.ItemID.get(Inventory.SelectedSlot);
						Animation.PlayNameA = true;
					}			
				}
		}
		}
	
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			ControlDown = false;
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}

}
