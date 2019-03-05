package blocks;

import java.util.Random;

import blocks.functionalBlocks.Barrel;
import blocks.functionalBlocks.CraftingBench;
import blocks.functionalBlocks.Furnace;
import gameplay.Gameplay;
import gameplay.Growth;
import gui.Inventory;
import main.Separate;
import terrain.Terrain;

public class Break_Build {
	
	public static Random r = new Random();
	public static int r1;
	public static int v;
	public static int x1, y1, x2, y2;
	
	public static void placePlatform() {
		
		if(Terrain.chunk[y1][x1-1] == 24.0) {
			Terrain.chunk[y1][x1-1] = 24.2;
		}else if(Terrain.chunk[y1][x1-1] == 24.1) {
			Terrain.chunk[y1][x1-1] = 24.3;
		}		
		
		if(Terrain.chunk[y1][x1+1] == 24.0) {
			Terrain.chunk[y1][x1+1] = 24.1;
		}else if(Terrain.chunk[y1][x1+1] == 24.2) {
			Terrain.chunk[y1][x1+1] = 24.3;
		}	
		
		if((Terrain.chunk[y1][x1-1] == 24.0 || Terrain.chunk[y1][x1-1] == 24.1 || Terrain.chunk[y1][x1-1] == 24.2 || Terrain.chunk[y1][x1-1] == 24.3)
			&& (Terrain.chunk[y1][x1+1] == 24.0 || Terrain.chunk[y1][x1+1] == 24.1 || Terrain.chunk[y1][x1+1] == 24.2 || Terrain.chunk[y1][x1+1] == 24.3)) {					
			Terrain.chunk[y1][x1] = 24.3;			
		}else if(Terrain.chunk[y1][x1+1] == 24.0 || Terrain.chunk[y1][x1+1] == 24.1 || Terrain.chunk[y1][x1+1] == 24.2 || Terrain.chunk[y1][x1+1] == 24.3) {
			Terrain.chunk[y1][x1] = 24.2;
		}else if(Terrain.chunk[y1][x1-1] == 24.0 || Terrain.chunk[y1][x1-1] == 24.1 || Terrain.chunk[y1][x1-1] == 24.2 || Terrain.chunk[y1][x1-1] == 24.3){
			Terrain.chunk[y1][x1] = 24.1;
		}else {
			Terrain.chunk[y1][x1] = 24.0;
		}
		
		Inventory.TakeOffInv(24.0, 1);
		
	}
	
	public static void BreakPlatform() {
		
		if(Terrain.chunk[y1][x1-1] == 24.2) {
			Terrain.chunk[y1][x1-1] = 24.0;
		}else if(Terrain.chunk[y1][x1-1] == 24.3) {
			Terrain.chunk[y1][x1-1] = 24.1;
		}
		
		if(Terrain.chunk[y1][x1+1] == 24.1) {
			Terrain.chunk[y1][x1+1] = 24.0;
		}else if(Terrain.chunk[y1][x1+1] == 24.3) {
			Terrain.chunk[y1][x1+1] = 24.2;
		}
		
		Terrain.chunk[y1][x1] = 0;
		Inventory.TakeInInv(24.0, 1);
	}
	
	public static void breakLeave() {
		//Step 1: randomizer
		r1 = r.nextInt(50);
		//Step 2:
		if(r1 <= 10) {
			Inventory.TakeInInv(11.0,1);
		if(r1 <= 3) {
			r1 = 0 + r.nextInt(4 - 0);
			if(r1 == 1) {
				Inventory.TakeInInv(310.0,1);
			}else if(r1 == 2) {
				Inventory.TakeInInv(310.1,1);
			}else if(r1 == 3) {
				Inventory.TakeInInv(310.2,1);
			}
		}
		}
		
		r1 = r.nextInt(100);
		if(r1 == 2) {
			Inventory.TakeInInv(313, 1);
		}
		
		r1 = r.nextInt(150);
		if(r1 == 12) {
			Inventory.TakeInInv(314, 1);
		}else if(r1 == 13) {
			Inventory.TakeInInv(315, 1);
		}
		
	}
	
	public static void breakTorch(int playerX, int playerY) {
		Lights.ResetEmit(y1, x1, playerX, playerY);
		Terrain.chunk[y1][x1] = 0;
		Terrain.chunkhp[y1][x1] = 0;
		Inventory.TakeInInv(8.0,1);
	}
	
	public static void breakSapling(double[][] chunk, int[][] chunkhp, int y1, int x1) {
		v = Growth.Search(Growth.TreeX, Growth.TreeY, x1, (y1));
		Growth.TreeX.remove(v);
		Growth.TreeY.remove(v);
		Growth.numberOfTree--;
		chunk[y1][x1] = 0.0;
		chunkhp[y1][x1] = 0;
		Inventory.TakeInInv(11.0,1);
	}
	
	public static void placeSapling(double[][] chunk, int[][] chunkhp, int y1, int x1) {
		if(chunk[y1+1][x1] == 1 || chunk[y1+1][x1] == 2) {
		Growth.TreeX.add(x1);
		Growth.TreeY.add((y1));
		Growth.numberOfTree++;
		chunk[y1][x1] = 11;
		chunkhp[y1][x1] = Blocks.BLOCKHP[11][0];
		Inventory.TakeOffInv(11.0,1);
		}
	}
	
	public static void placeBarrel(double[][] chunk, int[][] chunkhp, int y1, int x1) {
		Barrel.BarrelX.add(x1);
		Barrel.BarrelY.add(y1);
		Barrel.Finished.add(false);
		Barrel.Progress.add(0);
		Barrel.Process.add(false);
		Barrel.numberOfBarrel++;
		chunk[y1][x1] = 19.0;
		chunkhp[y1][x1] = Blocks.BLOCKHP[19][0];
		Inventory.TakeOffInv(19.0,1);
	}
	
	public static void breakBarrel(double[][] chunk, int[][] chunkhp, int y1, int x1) {
		if(chunk[y1][x1] == 19.6) {
			Inventory.TakeInInv(1, 1);
		}
		v = Barrel.Search(Barrel.BarrelX, Barrel.BarrelY, x1, (y1));
		Barrel.BarrelX.remove(v);
		Barrel.BarrelY.remove(v);
		Barrel.Finished.remove(v);
		Barrel.Progress.remove(v);
		Barrel.Process.remove(v);
		Barrel.numberOfBarrel--;
		chunk[y1][x1] = 0.0;
		chunkhp[y1][1] = 0;
		Inventory.TakeInInv(19.0,1);
	}
	
	public static void placeDoor(double[][] chunk, int[][] chunkhp, int x, int y) {
		if(chunk[y-1][x] == 0) {
			chunk[y][x] = 10.1;
			chunk[y-1][x] = 10;
			Inventory.TakeOffInv(10.5,1);
		}else {
			//Impossible
		}
	}
	
	public static void breakDoor(double[][] chunk, int[][] chunkhp, int x, int y) {
		if(chunk[y][x] == 10.0 || chunk[y][x] == 10.2) {
			chunk[y][x] = 0;
			chunk[y+1][x] = 0;
		}else if(chunk[y][x] == 10.1 || chunk[y][x] == 10.3) {
			chunk[y][x] = 0;
			chunk[y-1][x] = 0;
		}
		Inventory.TakeInInv(10.5,1);
		
	}
	
	public static void openDoor(double[][] chunk, int[][] chunkhp, int x, int y) {
		if(chunk[y][x] == 10.0) {
			chunk[y][x] = 10.2;
			chunk[y+1][x] = 10.3;
		}else if(chunk[y][x] == 10.1) {
			chunk[y][x] = 10.3;
			chunk[y-1][x] = 10.2;
		}else if(chunk[y][x] == 10.2) {
			chunk[y][x] = 10.0;
			chunk[y+1][x] = 10.1;
		}else if(chunk[y][x] == 10.3) {
			chunk[y][x] = 10.1;
			chunk[y-1][x] = 10.0;
		}
		
		Gameplay.Rclicked = false;
		
	}
	

	public static void breakBlock(int[][] chunkhp, double[][] chunk, int playerX, int playerY) {
		if(chunk[y1][x1] > 0.0 && chunkhp[y1][x1] >= 0) {
			
			if((chunk[y1][x1] == 1 || chunk[y1][x1] == 2) && chunk[y1-1][x1] == 11.0) {
				breakSapling(chunk, chunkhp, y1-1, x1);
				Inventory.TakeInInv(1.0,1);
				Terrain.chunk[y1][x1] = 0.0;
				Terrain.chunkhp[y1][x1] = 0;
			}else if(chunk[y1][x1] == 24.0 || chunk[y1][x1] == 24.1 || chunk[y1][x1] == 24.2 || chunk[y1][x1] == 24.3) {
				BreakPlatform();
			}else if(chunk[y1][x1] == 2.0) {
				Inventory.TakeInInv(1, 1);
				Terrain.chunk[y1][x1] = 0.0;
				Terrain.chunkhp[y1][x1] = 0;
			}else if(chunk[y1][x1] == 7.0) {
				//leaves
				breakLeave();
				Terrain.chunk[y1][x1] = 0.0;
				Terrain.chunkhp[y1][x1] = 0;
			}else if(chunk[y1][x1] == 5.1) {
				//Log with leaves
				breakLeave();
				Terrain.chunk[y1][x1] = 5.0;
				Terrain.chunkhp[y1][x1] = Blocks.BLOCKHP[5][0];
			}else if(chunk[y1][x1] == 8.0) {
				//Torch
				breakTorch(playerX, playerY);
			}else if(chunk[y1][x1] == 11.0) {
				//Sapling
				breakSapling(chunk, chunkhp, y1, x1);
			}else if(chunk[y1][x1] == 19.0 || chunk[y1][x1] == 19.1 || chunk[y1][x1] == 19.2 || chunk[y1][x1] == 19.3 || chunk[y1][x1] == 19.4
					|| chunk[y1][x1] == 19.5|| chunk[y1][x1] == 19.6) {
				breakBarrel(chunk, chunkhp, y1, x1);
			}else if(chunk[y1][x1] == 10.0 || chunk[y1][x1] == 10.1 || chunk[y1][x1] == 10.2 || chunk[y1][x1] == 10.3) {
				breakDoor(chunk, chunkhp, x1, y1);
			}
			else {	
				Inventory.TakeInInv(chunk[y1][x1],1);
				Terrain.chunk[y1][x1] = 0.0;
				Terrain.chunkhp[y1][x1] = 0;
			}
			
			if(v == Inventory.SelectedSlot) {
				Inventory.SelectedID = Inventory.ItemID.get(v);
			}
			
		}
		
	}
	
	public static void placeBlock(int[][] chunkhp, double[][] chunk) {
		if(chunk[y1][x1] == 0.0 && Blocks.BLOCKHP[Separate.getID2(Inventory.SelectedID)][Separate.getTAG2(Inventory.SelectedID)] != -2 
				&& Inventory.SelectedID != 0 && Blocks.BLOCKHP[Separate.getID2(Inventory.SelectedID)][Separate.getTAG2(Inventory.SelectedID)] > 0) {
			if(Inventory.SelectedID == 24.0) {
				//Platform
				placePlatform();
			}else if(Inventory.SelectedID == 8.0) {
				//Torch
				Lights.Emit(y1, x1);
				chunk[y1][x1] = 8;
				chunkhp[y1][x1] = Blocks.BLOCKHP[8][0];
				Inventory.TakeOffInv(8.0,1);
			}else if(Inventory.SelectedID == 11.0) {
				//Sapling
				placeSapling(chunk, chunkhp, y1, x1);
			}else if(Inventory.SelectedID == 19.0) {
				//Barrel
				placeBarrel(chunk, chunkhp, y1, x1);
			}else {
			
				chunk[y1][x1] = Inventory.SelectedID;
				chunkhp[y1][x1] = Blocks.BLOCKHP[Separate.getID2(Inventory.SelectedID)][Separate.getTAG2(Inventory.SelectedID)];
				Inventory.TakeOffInv(Inventory.SelectedID,1);
			}
			
			if(v == Inventory.SelectedSlot) {
				Inventory.SelectedID = Inventory.ItemID.get(v);
				if(Inventory.ItemCount.get(v) == 0) {
					Inventory.SelectedID = 0;
				}
			}
			
		}else if(chunk[y1][x1] == 17.0) {
			Furnace.Opened = true;
		}else if(chunk[y1][x1] == 0 && Inventory.SelectedID == 10.5) {
			placeDoor(chunk, chunkhp, x1, y1);
		}else if(chunk[y1][x1] == 16.0) {
			//craftingBench
			CraftingBench.Opened = true;
		}else if(chunk[y1][x1] == 17.0) {
			//Furnace
						
		}else if(chunk[y1][x1] == 19.0 || chunk[y1][x1] == 19.1 || chunk[y1][x1] == 19.2 || chunk[y1][x1] == 19.3 || chunk[y1][x1] == 19.4 
				|| chunk[y1][x1] == 19.5 || chunk[y1][x1] == 19.6) {
			//Barrel
			Barrel.ClickOnBarrel(x1, y1, chunk);
		}else if(chunk[y1][x1] == 10.0 || chunk[y1][x1] == 10.1 || chunk[y1][x1] == 10.2 || chunk[y1][x1] == 10.3) {
			openDoor(chunk, chunkhp, x1, y1);
		}else if(Inventory.SelectedID == 310.0 || Inventory.SelectedID == 310.1 || Inventory.SelectedID == 310.2) {
			//Apple
			ItemUse.EatFruit(20, 20, Inventory.SelectedID);
		}else if(Inventory.SelectedID == 314.0) {
			//Orange
			ItemUse.EatFruit(40, 30, 314.0);
		}else if(Inventory.SelectedID == 315.0) {
			//Orange
			ItemUse.EatFruit(50, 15, 315.0);
		}
	}
	
}
