package ht.helloworld;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShapesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shapes panel = new Shapes();
		JFrame app = new JFrame();
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(panel);
		app.setSize(300, 300);
		app.setVisible(true);
		
		
		
	}

}
