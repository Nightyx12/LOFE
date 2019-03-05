package main;

import javax.swing.JFrame;

import gameplay.Gameplay;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static int SW, SH;
	public static int PosX, PosY;
	
	public Main() {
		super("Skyblock ...");
		setSize(1382, 744);	//1366 705
		add(new Gameplay());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setUndecorated(true);
		setVisible(true);	
		setExtendedState(MAXIMIZED_BOTH);
		SW = this.getWidth();
		SH = this.getHeight();
		PosX = this.getLocationOnScreen().x;
		PosY = this.getLocationOnScreen().y;		
	}
	
	public static void main(String[] args) {
		new Main();

	}

}