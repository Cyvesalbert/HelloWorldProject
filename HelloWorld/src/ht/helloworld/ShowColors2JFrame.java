package ht.helloworld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

// choosing colors with JColorChooser
public class ShowColors2JFrame extends JFrame {

	private JButton changeColorJButton;
	private Color color = Color.LIGHT_GRAY;
	private JPanel colorJPanel;
	
	// set up GUI
	public ShowColors2JFrame() {
		super("using JColorChooser");
		
		// create JPanel for displaying color
		colorJPanel = new JPanel();
		colorJPanel.setBackground(color);
		
		// set up changeColorJButton and register ist event handler
		changeColorJButton = new JButton("Change Color");
		changeColorJButton.addActionListener(
				new ActionListener() {
					// display JColorChooser when user clicks button
					public void actionPerformed(ActionEvent event) {
						color = JColorChooser.showDialog(ShowColors2JFrame.this, "Choose a color", color);
						
						// set default color if no color is returned
						if(color == null) {
							color = Color.LIGHT_GRAY;
						}
						
						colorJPanel.setBackground(color);
					}
				}
				
				
				);
		
		add(colorJPanel, BorderLayout.CENTER); // add colorJPanel
		add(changeColorJButton, BorderLayout.SOUTH); // addd button
		
		setSize(400, 130);
		setVisible(true);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
