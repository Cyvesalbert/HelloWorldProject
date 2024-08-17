package ht.helloworld;

import javax.swing.JFrame;

public class Fonts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Using fonts");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FontPanel fontPanel = new FontPanel();
		frame.add(fontPanel);
		frame.setSize(420, 150);
		frame.setVisible(true);
		
	}

}
