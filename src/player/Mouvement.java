package player;

import blocks.Blocks;
import main.Separate;
import terrain.Terrain;

public class Mouvement {
	
	public static boolean VoidDied = false;
	
	public static int Yshard = 0;
	public static int Xshard = 0;
	
	public static boolean falling = false;
	public static int BlockFall = 0;
	
	public static void Qpressed() {
		Player.Tex = 1;
		if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-3, Player.playerCoordX-1)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-3, Player.playerCoordX-1)] == 1 ||
				Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-3, Player.playerCoordX-1)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-3, Player.playerCoordX-1)] == 2) {			
			Player.playerCoordX -= 1;
		}	
		Food.action = true;
	}
	
	public static void Dpressed() {
		Player.Tex = 0;
		if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-3, Player.playerCoordX+1)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-3, Player.playerCoordX+1)] == 1 ||
				Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-3, Player.playerCoordX+1)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-3, Player.playerCoordX+1)] == 2) {
			Player.playerCoordX += 1;
		}
		Food.action = true;
	}

	public static void Spressed() {
		if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-2, Player.playerCoordX)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-2, Player.playerCoordX)] == 2) {
		Player.playerCoordY += 1;
		}
	}

	public static void Jump() {
		if(Player.Tex == 0) {
			Player.Tex = 2;
		}else if(Player.Tex == 1){
			Player.Tex = 3;
		}
		if(!falling) {
		if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-4, Player.playerCoordX)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-4, Player.playerCoordX)] == 0) {
			Player.playerCoordY -= 0;
		}else if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-5, Player.playerCoordX)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-5, Player.playerCoordX)] == 0) {
			Player.playerCoordY -= 2;
		}else if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-6, Player.playerCoordX)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-6, Player.playerCoordX)] == 0) {
			Player.playerCoordY -= 3;
		}else if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-7, Player.playerCoordX)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-7, Player.playerCoordX)] == 0) {
			Player.playerCoordY -= 4;
		}else if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-8, Player.playerCoordX)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-8, Player.playerCoordX)] == 0) {
			Player.playerCoordY -= 5;
		}else if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-9, Player.playerCoordX)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-9, Player.playerCoordX)] == 0) {
			Player.playerCoordY -= 6;
		}else {
			Player.playerCoordY -= 6;
		}
		}
		Food.action = true;
	}
	
	public static void Gravity(double chunk[][]) {
		
		if(Blocks.TRAVERSABLE[Separate.getID(Terrain.chunk, Player.playerCoordY-2, Player.playerCoordX)][Separate.getTAG(Terrain.chunk, Player.playerCoordY-2, Player.playerCoordX)] == 1 && !VoidDied) {
			if(!falling) {
			falling = true;
			}
			Yshard += 5;
			if(Yshard >= 10) {
				Player.playerCoordY += 1;
				Yshard = 0;
				BlockFall++;
			}
		}else {
			if(falling) {
				if(Player.Tex == 2) {
					Player.Tex = 0;
				}else if(Player.Tex == 3){
					Player.Tex = 1;
				}
			falling = false;
			Life.FallingDamage();
			BlockFall = 0;
			}
		}
	}
	
	public static void VoidDied() {
		if(VoidDied) {
			Player.playerCoordY = Player.InitPlayerCoordY;
			Player.playerCoordX = Player.InitPlayerCoordX;
			VoidDied = false;
			Animation.PlayDiedA = true;
		}
		
		if(BlockFall >= 100) {
			VoidDied = true;
			Animation.PlayDamageA = true;
		}
		
		if(Player.playerCoordY >= 650) {
			VoidDied = true;
		}
	}

}
