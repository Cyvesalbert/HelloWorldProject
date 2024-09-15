package ht.helloworld;

import javax.swing.JFrame;

//Demonstrating JDesktopPane.
public class DesktopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DesktopFrame desktopFrame = new DesktopFrame();
		desktopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktopFrame.setSize(600, 480);
		desktopFrame.setVisible(true);
	}

}
