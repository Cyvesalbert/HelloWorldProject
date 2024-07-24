package ht.helloworld;

import javax.swing.JOptionPane;

public class NameDialog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name =
				JOptionPane.showInputDialog("What is your name?");
		String message =
				String.format("Welcome, %s, to java programmming!", name);
		
		JOptionPane.showMessageDialog(null, message);
		
		
		
		
	}

}
