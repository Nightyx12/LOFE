package main;

import java.awt.Graphics;
import java.awt.Rectangle;

import blocks.Air;
import blocks.Dirt;
import blocks.Grass;
import blocks.Leave;
import blocks.Log;
import blocks.LogWithLeave;
import blocks.Stone;
import blocks.UmbreakableBlock;

public class TerrainDraw {

	public static int BlockSize = 10;

	public static void setBlockColor(Graphics g,byte[][] var, int i, int j) {
		switch(var[i][j]) {
		case 0:
			g.setColor(Air.AirBlockColor);
			break;
		case 1:
			g.setColor(Dirt.DirtBlockColor);
			break;
		case 2:
			g.setColor(Grass.GrassBlockColor);
			break;
		case 3:
			g.setColor(Stone.StoneBlockColor);
			break;
		case 4:
			g.setColor(UmbreakableBlock.UmbreakableBlockColor);
			break;	
		case 5:
			g.setColor(Log.LogBlockColor);
			break;	
		case 6:
			g.setColor(Leave.LeaveBlockColor);
			break;	
		case 7:
			g.setColor(LogWithLeave.LogWithLeaveBlockColor);
			break;
		}
	}
	
	public static void drawchunk(Graphics g,byte[][] var, int time) {
		for(int i = 0;i < Terrain.chunkSizeH;i++) {
			for(int j = 0;j < Terrain.chunkSizeW;j++) {		
				setBlockColor(g, var, i, j);		
				if(var == Terrain.t1) {
				g.fillRect((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + (j*BlockSize) + Gui.xadd), 50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);				
				}else{
				g.fillRect((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + ((BlockSize * Terrain.chunkSizeW)*time) + (j * BlockSize) + Gui.xadd), 50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);		
				}
			}
		}
	}

	public static void showpointingblock(Graphics g,byte[][] var, int time) {
		for(int i = 0; i < Terrain.chunkSizeH; i++) {
			for(int j = 0; j < Terrain.chunkSizeW; j++) {
				Rectangle cursor = new Rectangle(Gui.Xmouse - 4, Gui.Ymouse - 25, 2, 2);
				
				Rectangle rect = new Rectangle(0,0,0,0);
				
				if(var == Terrain.t1) {
				rect = new Rectangle((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + (j*BlockSize) + Gui.xadd),  50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);
				}else{
				rect = new Rectangle((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + ((BlockSize * Terrain.chunkSizeW)*time) + (j * BlockSize) + Gui.xadd), 50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);
				}
				
				if(cursor.intersects(rect)) {
					if(var == Terrain.t1) {
					g.drawRect((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + (j*BlockSize) + Gui.xadd), 50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);
					}else{
					g.drawRect((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + ((BlockSize * Terrain.chunkSizeW)*time) + (j * BlockSize) + Gui.xadd), 50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);
					}
					
				}	
			}
			}
	}

	public static void breakBlock(byte[][] chunk, byte[][] chunkl, int time) {
		for(int i = 0; i < Terrain.chunkSizeH; i++) {
			for(int j = 0; j < Terrain.chunkSizeW; j++) {
				
				Rectangle rect = new Rectangle(0,0,0,0);
				
				Rectangle cursor = new Rectangle(Gui.Xmouse - 4, Gui.Ymouse - 25, 2, 2);
				if(chunk == Terrain.t1) {
				rect = new Rectangle((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + (j*BlockSize) + Gui.xadd),  50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);
				}else {
				rect = new Rectangle((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + ((BlockSize * chunk[1].length)*time) + (j * BlockSize) + Gui.xadd), 50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);
				}
				if(cursor.intersects(rect)) {
					
					if(Gui.selectedcube == 0) {
						if(chunkl[i][j] == 1) {
							chunk[i][j] = 0;
							chunkl[i][j] = 0;
						}else if(chunkl[i][j] == 2) {
							chunkl[i][j]--;
							if(chunk[i][j] == 2) {
								chunk[i][j] = 1;
							}
						}else if(chunkl[i][j] == 3) {
							chunkl[i][j]--;
						}	
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}				
				}					
			}
		}	
	}

	public static void placeBlock(byte[][] chunk, byte[][] chunkl, int time) {
		for(int i = 0; i < Terrain.chunkSizeH; i++) {
			for(int j = 0; j < Terrain.chunkSizeW; j++) {
				Rectangle rect = new Rectangle(0,0,0,0);
				
				Rectangle cursor = new Rectangle(Gui.Xmouse - 4, Gui.Ymouse - 25, 2, 2);
				if(chunk == Terrain.t1) {
				rect = new Rectangle((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + (j*BlockSize) + Gui.xadd),  50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);
				}else {
				rect = new Rectangle((int) ((Main.SW/2 - (BlockSize*Terrain.chunkSizeW)*2.5) + ((BlockSize * chunk[1].length)*time) + (j * BlockSize) + Gui.xadd), 50 + (i * BlockSize) + Gui.yadd, BlockSize, BlockSize);
				}
				if(cursor.intersects(rect)) {
					
					if(chunkl[i][j] == 0) {
						if(Gui.selectedcube == 0) {
							//nothing
						}else if(Gui.selectedcube == 1) {
							chunk[i][j] = 1;
							chunkl[i][j] = 1;
						}else if(Gui.selectedcube == 2) {
							chunk[i][j] = 2;
							chunkl[i][j] = 2;
						}else if(Gui.selectedcube == 3) {
							chunk[i][j] = 3;
							chunkl[i][j] = 3;
						}
					}				
				}
			}
		
		
	}
	}
}
