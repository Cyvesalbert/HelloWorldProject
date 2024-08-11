package ht.helloworld;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// demonstrating flowlayout alignments
public class FlowLayoutManager extends JFrame {

	private JButton leftJButton; // button to set alignment left
	private JButton centerJButton; // button to set alignment center
	private JButton rightJButton; // button to set alignment right
	private FlowLayout layout; // layout object
	private Container container; // container to set layout
	
	// set GUI and register button listener 
	public FlowLayoutManager() {
		super("flowLayout Demo");
		
		layout = new FlowLayout(); // create flowLayout
		container = getContentPane(); // get container to layout
		setLayout(layout); // set frame layout
		
		// set up leftJButton and register listener
		leftJButton = new JButton("Left"); // create left button
		add(leftJButton); // add leftButton to frame
		leftJButton.addActionListener(
				new ActionListener () { // anonymous inner class
					// process  leftJButton event
					public void actionPerformed(ActionEvent event) {
						layout.setAlignment(FlowLayout.LEFT);
						
						// realigned attach component 
						layout.layoutContainer(container);
					}
					
					
				}
				 
				
				);
		
		// set up centrerJButton and register listener
		centerJButton = new JButton("Center"); // create center button
		add(centerJButton); // add center button to frame
		centerJButton.addActionListener(
				new ActionListener() { // anonymous inner class
					
					// process centerJButton event
					public void actionPerformed(ActionEvent event) {
						layout.setAlignment(FlowLayout.CENTER);
						
						// realign attached components
						layout.layoutContainer(container);
					}
					
				}
				);
		rightJButton = new JButton("Right"); // create right button
		add(rightJButton); // add right button to frame
		rightJButton.addActionListener(
				new ActionListener() { // anonymous inner class
					public void actionPerformed(ActionEvent event) {
						layout.setAlignment(FlowLayout.RIGHT);
						
						// realign attached components
						layout.layoutContainer(container);
					}
					
				}
				
		);
		
	}
	
	
	
	
	
}
