package ht.helloworld;

import javax.swing.JFrame;

public class ShowColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create frame for colrJPanel
		JFrame frame = new JFrame("Using colors");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ColorJPanel colorJPanel = new ColorJPanel(); // create colorJPanel
		frame.add(colorJPanel); // add colorJPanel to frame
		frame.setSize(400, 180);
		frame.setVisible(true);
	}

}
