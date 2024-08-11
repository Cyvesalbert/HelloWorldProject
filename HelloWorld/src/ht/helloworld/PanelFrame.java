package ht.helloworld;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelFrame extends JFrame{

	private JPanel buttonJPanel; // panel to hold buttons
	private JButton[] buttons; // array of buttons
	
	public PanelFrame() {
		super("Panel Demo");
		
		buttons = new JButton[5]; // create buttons array
		buttonJPanel = new JPanel(); // set up panel
		buttonJPanel.setLayout(new GridLayout(1, buttons.length));
		
		// create and add buttons
		for(int count = 0; count < buttons.length; count++) {
			buttons[count] = new JButton("Button" + (count + 1));
			buttonJPanel.add(buttons[count]); // add button to panel
		}
		
		add(buttonJPanel, BorderLayout.SOUTH); // add panel to JFrame
	}
	
		
	
	
	
	
	
	
}
