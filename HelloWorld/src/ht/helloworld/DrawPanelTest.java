package ht.helloworld;

import javax.swing.JFrame;

public class DrawPanelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DrawPanel panel = new DrawPanel();
		
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		application.add(panel);
		application.setSize(250, 250);
		application.setVisible(true);
		
		
	}

}
