package ht.helloworld;

import javax.swing.JFrame;

public class DrawSmileyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DrawSmiley panel = new DrawSmiley();
		
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(230, 250);
		application.setVisible(true);
	}

}
