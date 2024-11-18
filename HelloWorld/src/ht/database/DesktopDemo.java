package ht.database;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

//Use Desktop to launch default browser, open a file in its associated
// application and an email in the default email client.
public class DesktopDemo extends javax.swing.JFrame{

	public DesktopDemo() {
		initComponents();
	}
	
	// determine selected task and perform the task
	private void doTaskJButtonActionPerformed(java.awt.event.ActionEvent evt) {
	int index = tasksJComboBox.getSelectedIndex();
	String input = inputJTextField.getText();
	
	if(Desktop.isDesktopSupported()) {
		try {
			Desktop desktop = Desktop.getDesktop();

			switch(index) {
			case 0: // open browser
				desktop.browse(new URI(input));
				break;
			case 1: // open file
				desktop.open(new File(input));
				break;
			case 2: // open eamil composition windows
				desktop.mail(new URI(input));
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

public static void main(String[] args) {
	java.awt.EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					new DesktopDemo().setVisible(true);
				}
			}
			);
}

//Variables declaration - do not modify
private javax.swing.JButton doTaskJButton;
private javax.swing.JLabel inputJLabel;
private javax.swing.JTextField inputJTextField;
private javax.swing.JLabel instructionLabel;
private javax.swing.JComboBox tasksJComboBox;
}