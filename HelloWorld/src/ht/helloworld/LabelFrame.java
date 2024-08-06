package ht.helloworld;

import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic windows features
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images

public class LabelFrame  extends JFrame{

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	// LabelFrame constructor adds JLabel to JFrame
	public LabelFrame() {
		super("testing JLabel");
		setLayout(new FlowLayout()); // set frame layout
		
		// Jlabel contructor with a string argument
		label1 = new JLabel("Label with Text");
		label1.setToolTipText("this is label1");
		add(label1); // add label1 to Jframe
		
		// Jlabel constructor with String, icon, and alignments arguments
		//Icon bug = new ImageIcon(getClass().getResource("GUItip.gif"));
		label2 = new JLabel("Label with text and icon", SwingConstants.LEFT);
		label2.setToolTipText("this is label2");
		add(label2);
		
		label3 = new JLabel();
		label3.setText("Label with icon and text at bottom");
		//label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("this is label3");
		add(label3);
		
	}
	
	
}
