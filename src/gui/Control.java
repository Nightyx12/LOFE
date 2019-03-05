package gui;

import player.Player;
import terrain.TerrainDraw;

public class Control {

	public static int BlockSizeMultitplier = 1;
	public static int minusY = 0;
	
	public static void UpdateControls() {
		if(BlockSizeMultitplier == 1) {
			minusY = 0;
		}else if(BlockSizeMultitplier == 2) {
			minusY = 70;
		}
		
		TerrainDraw.blockSize *= BlockSizeMultitplier;
		Player.playerSize *= BlockSizeMultitplier;
	}
	
}
