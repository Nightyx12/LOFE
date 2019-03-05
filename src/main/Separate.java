package main;

import java.util.List;

public class Separate {

	public static String[] s = new String[2];
	public static double d1;
	public static String s1;

	public static int getID(double[][] d, int y, int x) {
		d1 = d[y][x];
		s1 = Double.toString(d1);
		s = s1.split("\\.");
		return Integer.parseInt(s[0]);	
	}
	
	public static int getTAG(double[][] d, int y, int x) {
		d1 = d[y][x];
		s1 = Double.toString(d1);
		s = s1.split("\\.");
		return Integer.parseInt(s[1]);			
	}
	
	public static int getID1(List<Double> d, int slot) {
		d1 = d.get(slot);
		s1 = Double.toString(d1);
		s = s1.split("\\.");
		return Integer.parseInt(s[0]);
	}
	
	public static int getTAG1(List<Double> d, int slot) {
		d1 = d.get(slot);
		s1 = Double.toString(d1);
		s = s1.split("\\.");
		return Integer.parseInt(s[1]);
		
	}
	
	public static int getID2(double d) {
		s1 = Double.toString(d);
		s = s1.split("\\.");
		return Integer.parseInt(s[0]);
	}
	
	public static int getTAG2(double d) {
		s1 = Double.toString(d);
		s = s1.split("\\.");
		return Integer.parseInt(s[1]);
	}
	
}
