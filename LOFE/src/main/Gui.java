package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

import blocks.Air;
import blocks.Dirt;
import blocks.Grass;
import blocks.Stone;

import javax.swing.JPanel;

public class Gui extends JPanel implements ActionListener, KeyListener, MouseListener{
	
	private Timer timer;
	private int delay = 20;
	
	public static boolean clicked = false;
	
	public static int BlockSize = 10;
	
	public static int chunkn = 3;
	
	public static int xadd = 0;
	public static int yadd = 0;
	
	public static int Xmouse = MouseInfo.getPointerInfo().getLocation().x;
	public static int Ymouse = MouseInfo.getPointerInfo().getLocation().y;
	
	public static int Xcoord = 22;
	public static int Ycoord = 16;
	public static int Yshard = 0;
	
	public static int selectedcube = 0;
	
	public static boolean falling = false;
		
	public Gui() {
		Terrain.TerrainUpdate(Terrain.t1, Terrain.t1l);
		Terrain.TerrainUpdate(Terrain.t2, Terrain.t2l);
		Terrain.TerrainUpdate(Terrain.t3, Terrain.t3l);
		Terrain.TerrainUpdate(Terrain.t4, Terrain.t4l);
		Terrain.TerrainUpdate(Terrain.t5, Terrain.t5);
		Terrain.IslandGen(Terrain.t3, Terrain.t3l);
		Terrain.TreeGen(Terrain.t3, Terrain.t3l);
		addKeyListener(this);
		addMouseListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		//background
		g.setColor(new Color(200,200,255));
		g.fillRect(0, 0, 5000, 5000);
		
		//draw Chunk
		TerrainDraw.drawchunk(g, Terrain.t1,0);
		TerrainDraw.drawchunk(g, Terrain.t2,1);
		TerrainDraw.drawchunk(g, Terrain.t3,2);
		TerrainDraw.drawchunk(g, Terrain.t4,3);
		TerrainDraw.drawchunk(g, Terrain.t5,4);
		
		//draw Player
			Player.DrawPlayer(g);
		
		//Pointing Block
		g.setColor(new Color(255,255,255));
			TerrainDraw.showpointingblock(g,Terrain.t1, 0);
			TerrainDraw.showpointingblock(g,Terrain.t2,1);
			TerrainDraw.showpointingblock(g,Terrain.t3,2);
			TerrainDraw.showpointingblock(g,Terrain.t4,3);
			TerrainDraw.showpointingblock(g,Terrain.t5,4);
		
		//draw InventoryBar
			gui.Inventory.drawInventoryBar(g);
		
		if(gui.Inventory.Inventory && !gui.MainMenu.mainmenu) {
			gui.Inventory.Inventory(g);
		}
						
						
		//Main menu
		if(gui.MainMenu.mainmenu) {
			gui.MainMenu.MainMenu(g);
		}			
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(clicked && !gui.MainMenu.mainmenu) {

			TerrainDraw.breakBlock(Terrain.t1, Terrain.t1l, 1);
			TerrainDraw.breakBlock(Terrain.t2, Terrain.t2l, 1);
			TerrainDraw.breakBlock(Terrain.t3, Terrain.t3l, 2);
			TerrainDraw.breakBlock(Terrain.t4, Terrain.t4l, 3);
			TerrainDraw.breakBlock(Terrain.t5, Terrain.t5l, 4);
			
			TerrainDraw.placeBlock(Terrain.t1,Terrain.t1l, 1);
			TerrainDraw.placeBlock(Terrain.t2,Terrain.t2l, 1);
			TerrainDraw.placeBlock(Terrain.t3,Terrain.t3l, 2);
			TerrainDraw.placeBlock(Terrain.t4,Terrain.t4l, 3);
			TerrainDraw.placeBlock(Terrain.t5,Terrain.t5l, 4);
		}
		
		Xmouse = MouseInfo.getPointerInfo().getLocation().x;
		Ymouse = MouseInfo.getPointerInfo().getLocation().y;
		
		if(!gui.MainMenu.mainmenu) {
			Mouvement.getPlayerChunk();
			
		Mouvement.Gravity(-1, 9, Terrain.t1, 0);
		Mouvement.Gravity(8, 18, Terrain.t2, 9);
		Mouvement.Gravity(17, 27, Terrain.t3, 18);
		Mouvement.Gravity(26, 36, Terrain.t4, 27);
		Mouvement.Gravity(35, 45, Terrain.t5, 36);
		
	//Void died
		if(Ycoord >= 100) {
			Ycoord = 16;
			Xcoord = 22;
			xadd = 0;
			yadd = 0;
		}
		}
		
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_D && !gui.MainMenu.mainmenu) {
			Mouvement.DPressed(e);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Q && !gui.MainMenu.mainmenu) {
			Mouvement.QPressed(e);
		}
		
		
		//Jump	
			if(e.getKeyCode() == KeyEvent.VK_SPACE && !falling && !gui.MainMenu.mainmenu) {
				if(chunkn == 1) {
				Mouvement.jump(Terrain.t1, 0);
				}else if(chunkn == 2) {
				Mouvement.jump(Terrain.t2, 9);
				}else if(chunkn == 3) {
				Mouvement.jump(Terrain.t3, 18);
				}else if(chunkn == 4) {
				Mouvement.jump(Terrain.t4, 27);
				}else if(chunkn == 5) {
				Mouvement.jump(Terrain.t5, 36);
				}
			}
		
		if(e.getKeyCode() == KeyEvent.VK_NUMPAD1 && !gui.MainMenu.mainmenu) {
			Terrain.TerrainUpdate(Terrain.t1, Terrain.t1l);
			Terrain.TerrainUpdate(Terrain.t2, Terrain.t2l);
			Terrain.TerrainUpdate(Terrain.t3, Terrain.t3l);
			Terrain.TerrainUpdate(Terrain.t4, Terrain.t4l);
			Terrain.TerrainUpdate(Terrain.t5, Terrain.t5l);
			repaint();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_1 && !gui.MainMenu.mainmenu) {
			selectedcube = 1;
			System.out.println(Dirt.DirtBlock + " is selected");
			gui.Inventory.drawSelectedSlot(new Color(255, 0, 0), Grass.GrassBlockColor, Stone.StoneBlockColor, Air.AirBlockColor);
		}
		if(e.getKeyCode() == KeyEvent.VK_2 && !gui.MainMenu.mainmenu) {
			selectedcube = 2;
			System.out.println(Grass.GrassBlock + " is selected");
			gui.Inventory.drawSelectedSlot(Dirt.DirtBlockColor, new Color(255,0,0), Stone.StoneBlockColor, Air.AirBlockColor);
		}
		if(e.getKeyCode() == KeyEvent.VK_3 && !gui.MainMenu.mainmenu) {
			selectedcube = 3;
			System.out.println(Stone.StoneBlock + " is selected");
			gui.Inventory.drawSelectedSlot(Dirt.DirtBlockColor, Grass.GrassBlockColor, new Color(255,0,0), Air.AirBlockColor);
		}
		if(e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_4 && !gui.MainMenu.mainmenu) {
			selectedcube = 0;
			System.out.println(Air.AirBlock + " is selected");
			gui.Inventory.drawSelectedSlot(Dirt.DirtBlockColor, Grass.GrassBlockColor, Stone.StoneBlockColor, new Color(255,0,0));
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE && !gui.MainMenu.mainmenu) {
			if(!gui.Inventory.Inventory) {
				gui.Inventory.Inventory = true;
			}else {
				gui.Inventory.Inventory = false;
			}
		}
		
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1 && !gui.MainMenu.mainmenu) {
			clicked = true;
			}
		
		if(e.getButton() == MouseEvent.BUTTON1 && gui.MainMenu.mainmenu) {
			gui.MainMenu.MainMenuClicked();
		}
		
			
		}
			
			
		
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
		
	
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent e) {
		 if (e.getButton() == MouseEvent.BUTTON1 && !gui.MainMenu.mainmenu) {
		        clicked = false;
		    }
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
