package ht.helloworld;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PaintPanelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 JFrame application = new JFrame("A simple paint program");
		 
		 PaintPanel paintPanel = new PaintPanel();  // create paint Panel
		 application.add(paintPanel, BorderLayout.CENTER); // in center
		 
		 // create a label and place it in south or borderlayout
		 application.add(new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);
		 application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 application.setSize(400, 200);
		 application.setVisible(true);
	}

}
