package gui;

import javax.swing.JFrame;

public class Breakout extends JFrame {
	public Breakout() {
		setTitle("ブロック崩し作ってみた");
		setResizable(false);

		MainPanel panel = new MainPanel();
		getContentPane().add(panel);

		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Breakout();
	}

}
