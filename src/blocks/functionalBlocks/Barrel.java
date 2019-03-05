package blocks.functionalBlocks;

import java.util.ArrayList;
import java.util.List;

import gui.Inventory;
import terrain.Terrain;

public class Barrel {	
	
	public static List<Integer> BarrelY = new ArrayList<Integer>();
	public static List<Integer> BarrelX = new ArrayList<Integer>();
	public static List<Boolean> Process = new ArrayList<Boolean>();
	public static List<Integer> Progress = new ArrayList<Integer>();
	public static List<Boolean> Finished = new ArrayList<Boolean>();
	public static List<Boolean> Process2 = new ArrayList<Boolean>();
	public static int TimeforFinish = 10;
	public static int numberOfBarrel = 0;
	public static int x, y;
	public static int v;
	public static int r;
	
	public static int Search(List<Integer> x, List<Integer> y, int x1, int y1) {
		for(int i = 0; i < numberOfBarrel; i++) {
			if(x.get(i) == x1 && y.get(i) == y1) {
				return i;
			}
		}
		return 0;
	}
	
	public static int Search(List<Boolean> list, boolean e) {
		if(list.contains(e)) {
			A:for(int i = 0; i < list.size(); i++) {
				if(list.get(i) == e) {
					r = i;
					break A;
				}
			}
		}else {
			r = 0;
		}
		return r;
	}
	
	public static void ClickOnBarrel(int x, int y, double chunk[][]) {
		v = Search(BarrelX, BarrelY, x, y);
		if(Finished.get(v) == true) {
			//Full and Finished
			System.out.println("pick");
			Progress.set(v, 0);
			Finished.set(v, false);
			Process.set(v, false);
			Inventory.TakeInInv(1,1);
			chunk[y][x] = 19;			
		}else {
		if(Inventory.SelectedID == 11.0) {
			if(chunk[y][x] == 19.5) {
				//Nothing
			}else if(chunk[y][x] == 19.4){
				chunk[y][x] = 19.5;
				Process.set(v, true);
				Inventory.TakeOffInv(11,1);
			}else if(chunk[y][x] == 19.3) {
				chunk[y][x] = 19.4;
				Inventory.TakeOffInv(11,1);
			}else if(chunk[y][x] == 19.2) {
				chunk[y][x] = 19.3;
				Inventory.TakeOffInv(11,1);
			}else if(chunk[y][x] == 19.1) {
				chunk[y][x] = 19.2;
				Inventory.TakeOffInv(11,1);
			}else if(chunk[y][x] == 19.0) {
				chunk[y][x] = 19.1;
				Inventory.TakeOffInv(11,1);
			}
		}
		}		
	}
	
	public static void ProcessBarrel() {
		if(Process.contains(true)) {
			//Init
			Process2.clear();
			Process2.addAll(Process);
		while(Process2.contains(true)) {
			v = Search(Process2, true);
			
			if(Progress.get(v) < TimeforFinish) {
				Progress.set(v, Progress.get(v)+1);
				Process2.set(v, false);
			}
			if(Progress.get(v) == TimeforFinish) {
				Process2.set(v, false);
				Finished.set(v, true);
				Terrain.chunk[BarrelY.get(v)][BarrelX.get(v)] = 19.6;
				Process2.set(v, false);
			}
		}		
		}
	}
	
	
}
