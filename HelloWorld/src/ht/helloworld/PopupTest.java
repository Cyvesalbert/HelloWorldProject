package ht.helloworld;

import javax.swing.JFrame;

//Testing PopupFrame.
public class PopupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PopupFrame popupFrame = new PopupFrame(); // create popup frame
		popupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popupFrame.setSize(300, 200); // set frame size
		popupFrame.setVisible(true); // display frame
	}

}
