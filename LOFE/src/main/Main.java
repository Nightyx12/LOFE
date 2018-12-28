package main;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public static int SW;
	public static int SH;
	
	public Main() {
		super("Game");
		setSize(1382, 744);	//1366 705
		add(new Gui());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);	
		setExtendedState(MAXIMIZED_BOTH);
		SW = this.getWidth();
		SH = this.getHeight();
	}
	
	public static void main(String[] args) {
		new Main();

	}

}
