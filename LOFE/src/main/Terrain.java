package main;

import java.util.Random;

public class Terrain {

	static Random r = new Random();
	
	public static int max = 1;
	public static int min = 0;
	
	public static int chunkSizeH = 128;
	public static int chunkSizeW = 9;
	
	public static byte[][] t1 = new byte[chunkSizeH][chunkSizeW];
	public static byte[][] t2 = new byte[chunkSizeH][chunkSizeW];
	public static byte[][] t3 = new byte[chunkSizeH][chunkSizeW];
	public static byte[][] t4 = new byte[chunkSizeH][chunkSizeW];
	public static byte[][] t5 = new byte[chunkSizeH][chunkSizeW];
	
	public static byte[][] t1l = new byte[chunkSizeH][chunkSizeW];
	public static byte[][] t2l = new byte[chunkSizeH][chunkSizeW];
	public static byte[][] t3l = new byte[chunkSizeH][chunkSizeW];
	public static byte[][] t4l = new byte[chunkSizeH][chunkSizeW];
	public static byte[][] t5l = new byte[chunkSizeH][chunkSizeW];

	
	public static void TerrainUpdate(byte[][] chunk, byte[][] chunkl) {
		for(int i = 0;i< chunkSizeH;i++) {
			for(int j = 0;j < chunkSizeW;j++){
				chunk[i][j] = 0;
				chunkl[i][j] = 0;
			}
		}
	}
	
	public static void IslandGen(byte[][] chunk, byte[][] chunkl) {
		for(int i = 0;i < 7; i++) {
			chunk[33][1+i] = 2;
			chunkl[33][1+i] = 2;
			}
		for(int i = 0;i < 5; i++) {
			chunk[34][2+i] = 1;
			chunk[35][2+i] = 1;
			chunkl[34][2+i] = 1;
			chunkl[35][2+i] = 1;
		}
		for(int i = 0;i < 3; i++) {
			chunk[36][3+i] = 1;
			chunk[37][3+i] = 1;
			chunkl[36][3+i] = 1;
			chunkl[37][3+i] = 1;
			}
		chunk[38][4] = 1;
		chunk[39][4] = 1;
		chunkl[38][4] = 1;
		chunkl[39][4] = 1;
		chunk[36][4] = 4;
		chunkl[36][4] = -1;
	}
	
	public static void TreeGen(byte[][] chunk, byte[][] chunkl) {
		chunk[32][4] = 5;
		chunk[31][4] = 5;
		chunk[30][4] = 5;
		chunk[29][4] = 5;
		chunk[28][4] = 5;
		
		chunk[27][4] = 7;
		chunk[27][3] = 6;
		chunk[27][5] = 6;
		chunk[27][2] = 6;
		chunk[27][6] = 6;
		chunk[26][3] = 6;
		chunk[26][4] = 6;
		chunk[26][5] = 6;
		
	}
	
}

