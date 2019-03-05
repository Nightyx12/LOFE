package gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import blocks.Blocks;
import main.Main;
import main.Separate;
import player.Mouvement;
import player.Player;
import terrain.Terrain;
import terrain.TerrainDraw;

public class Growth {

	public static Random r = new Random();
	public static int r1;
	
	public static int r1max = 45;
	public static int r2max = 10;
	
	public static List<Integer> TreeX = new ArrayList<Integer>();
	public static List<Integer> TreeY = new ArrayList<Integer>();
	public static int numberOfTree = 0;
	
	public static int x1, y1;
	
	public static int Search(List<Integer> x, List<Integer> y, int x1, int y1) {
		for(int i = 0; i < numberOfTree; i++) {
			if(x.get(i) == x1 && y.get(i) == y1) {
				return i;
			}
		}
		return 0;
	}
	
	public static void TreeGrowth() {
		for(int i = 0; i < numberOfTree; i++) {
			r1 = 0 + r.nextInt(r1max - 0);
			if(r1 == 1) {
				Terrain.TreeGen(Terrain.chunk, TreeY.get(i), TreeX.get(i));
				TreeX.remove(i);
				TreeY.remove(i);
				numberOfTree--;
			}else {
				
			}
		}
	}
	
	public static void GrassSpread() {
		for(int i = 0; i < (Main.SH/TerrainDraw.blockSize); i++) {
			for(int j = 0; j < (Main.SW/TerrainDraw.blockSize); j++) {
				x1 = (Player.playerCoordX + Mouvement.Xshard) - ((Main.SW/2)/TerrainDraw.blockSize) + j;
				y1 = (Player.playerCoordY + Mouvement.Xshard) - ((Main.SH/2)/TerrainDraw.blockSize) + i -2;
				
				if(Terrain.chunk[y1][x1] == 2) {
					if(Terrain.chunk[y1][x1+1] == 1 && Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, y1-1, x1+1)][Separate.getTAG(Terrain.chunk, y1-1, x1+1)] == 1) {
						r1 = 0 + r.nextInt(r2max - 0);
						if(r1 == 2) {
							Terrain.chunk[y1][x1+1] = 2;
						}
					}
					if(Terrain.chunk[y1+1][x1+1] == 1 && Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, y1, x1+1)][Separate.getTAG(Terrain.chunk, y1, x1+1)] == 1) {
						r1 = 0 + r.nextInt(r2max - 0);
						if(r1 == 2) {
							Terrain.chunk[y1+1][x1+1] = 2;
						}
					}
					if(Terrain.chunk[y1-1][x1+1] == 1 && Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, y1-2, x1+1)][Separate.getTAG(Terrain.chunk, y1-2, x1+1)] == 1) {
						r1 = 0 + r.nextInt(r2max - 0);
						if(r1 == 2) {
							Terrain.chunk[y1-1][x1+1] = 2;
						}
					}
					if(Terrain.chunk[y1][x1-1] == 1 && Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, y1-1, x1-1)][Separate.getTAG(Terrain.chunk, y1-1, x1-1)] == 1) {
						r1 = 0 + r.nextInt(r2max - 0);
						if(r1 == 2) {
							Terrain.chunk[y1][x1-1] = 2;
						}
					}
					if(Terrain.chunk[y1+1][x1-1] == 1 && Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, y1, x1-1)][Separate.getTAG(Terrain.chunk, y1, x1-1)] == 1) {
						r1 = 0 + r.nextInt(r2max - 0);
						if(r1 == 2) {
							Terrain.chunk[y1+1][x1-1] = 2;
						}
					}
					if(Terrain.chunk[y1-1][x1-1] == 1 && Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, y1-2, x1-1)][Separate.getTAG(Terrain.chunk, y1-2, x1-1)] == 1) {
						r1 = 0 + r.nextInt(r2max - 0);
						if(r1 == 2) {
							Terrain.chunk[y1-1][x1-1] = 2;
						}
					}
				}
				
				}
			}
	}
	
}
