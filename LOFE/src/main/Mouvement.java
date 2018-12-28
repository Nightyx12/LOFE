package main;

import java.awt.event.KeyEvent;

public class Mouvement {

	public static void Gravity(int x1, int x2, byte[][] var, int m1) {
		if(Gui.Xcoord > x1 &&  Gui.Xcoord < x2) {
			if(var[Gui.Ycoord][Gui.Xcoord - m1] == 0 || var[Gui.Ycoord][Gui.Xcoord - m1] == 5 || var[Gui.Ycoord][Gui.Xcoord - m1] == 6 || var[Gui.Ycoord][Gui.Xcoord - m1] == 7) {
				Gui.yadd -= 5;
				Gui.Yshard += 5;
				Gui.falling = true;
				if(Gui.Yshard >= 10) {
					Gui.Yshard -= 10;
					Gui.Ycoord++;
				}
			}else if(var[Gui.Ycoord][Gui.Xcoord - m1] == 1 || var[Gui.Ycoord][Gui.Xcoord - m1] == 2 || var[Gui.Ycoord][Gui.Xcoord - m1] == 3 || var[Gui.Ycoord][Gui.Xcoord - m1] == 4) {
				Gui.falling = false;
			}
		}
	}
	
	public static void jump(byte[][] chunk, int m1) {
			if(chunk[Gui.Ycoord - 2][Gui.Xcoord - m1] == 0 || chunk[Gui.Ycoord - 2][Gui.Xcoord - m1] == 5 || chunk[Gui.Ycoord - 2][Gui.Xcoord - m1] == 6 || chunk[Gui.Ycoord - 2][Gui.Xcoord - m1] == 7) {
				Gui.yadd +=100;
				Gui.Ycoord -= 10;
			}
	}
	
	public static void moveRight(int x1, int x2, int m, byte[][] var) {
		if(Gui.Xcoord > x1 && Gui.Xcoord < x2) {
			if(var[Gui.Ycoord - 1][Gui.Xcoord - m + 1] == 0 || var[Gui.Ycoord - 1][Gui.Xcoord - m + 1] == 5 || var[Gui.Ycoord - 1][Gui.Xcoord - m + 1] == 6 || var[Gui.Ycoord - 1][Gui.Xcoord - m + 1] == 7) {
				Gui.xadd-=10;
				Gui.Xcoord+=1;
			}
		}
	}
	
	public static void moveLeft(int x1, int x2, int m, byte[][] var) {
		if(Gui.Xcoord > x1 && Gui.Xcoord < x2) {
			if(var[Gui.Ycoord - 1][Gui.Xcoord - m - 1] == 0 || var[Gui.Ycoord - 1][Gui.Xcoord - m - 1] == 5 || var[Gui.Ycoord - 1][Gui.Xcoord - m - 1] == 6 || var[Gui.Ycoord - 1][Gui.Xcoord - m - 1] == 7) {
				Gui.xadd+=10;
				Gui.Xcoord-=1;
			}
		}
	}
	
	public static void DPressed(KeyEvent e) {
		
			moveRight(35, 44, 36, Terrain.t5); //36-43
			moveRight(34, 36, 36, Terrain.t5); //35
			moveRight(26, 35, 27, Terrain.t4); //27-34
			moveRight(25, 27, 27, Terrain.t4); //26
			moveRight(17, 26, 18, Terrain.t3); //18-25
			moveRight(16, 18, 18, Terrain.t3); //17
			moveRight(8, 17, 9, Terrain.t2); //9-16
			moveRight(7, 9, 9, Terrain.t2); //8
			moveRight(-1, 8, 0, Terrain.t1); //0-7 
		
		
		
		
		
		
	}

	public static void QPressed(KeyEvent e) {
		moveLeft(-1, 10, 0, Terrain.t1); //0-9
		moveLeft(9, 19, 9, Terrain.t2); //10-18
		moveLeft(18, 28, 18, Terrain.t3); //19-27
		moveLeft(27, 37, 27, Terrain.t4); //28-36
		moveLeft(36, 45, 36, Terrain.t4); //37-44
		
	}

	public static void getPlayerChunk() {
		if(Gui.Xcoord >= 0 && Gui.Xcoord <= 8) {
			Gui.chunkn = 1;
		}else if(Gui.Xcoord >= 9 && Gui.Xcoord <= 17) {
			Gui.chunkn = 2;
		}else if(Gui.Xcoord >= 18 && Gui.Xcoord <= 26) {
			Gui.chunkn = 3;
		}else if(Gui.Xcoord >= 27 && Gui.Xcoord <= 35) {
			Gui.chunkn = 4;
		}else if(Gui.Xcoord >= 36 && Gui.Xcoord <= 44) {
			Gui.chunkn = 5;
		}
	}
}
