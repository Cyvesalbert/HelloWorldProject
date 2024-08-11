package ht.helloworld;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// demostrating gridLayout
public class GridLayoutFrame extends JFrame implements ActionListener {

	private JButton[] buttons; // array of buttons
	private final String[] names = { "one", "two", "three", "four", "five", "six" };
	private boolean toggle = true; // toggle between two layouts
	private Container container; // frame container
	private GridLayout gridLayout1;  // first gridLayout
	private GridLayout gridLayout2; // second gridLayout
	
	public GridLayoutFrame() {
		super("gridLayout Demo");
		gridLayout1 = new GridLayout(2, 3, 5, 5); // 2 by 3; gaps of 5
		gridLayout2 = new GridLayout(3, 2); // 3 by 2; no gaps
		container  = getContentPane(); // get content pane
		setLayout(gridLayout1); // set JFrame layout
		buttons = new JButton[names.length]; // create array of JButtons
		
		for(int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this); // register listener
			add(buttons[count]);
		}
	}
	
	// handle button events by toggling between layouts
	public void actionPerformed(ActionEvent event) {
		if(toggle) {
			container.setLayout(gridLayout2); // set layout to second
		}else {
			container.setLayout(gridLayout1);
		}
		
		toggle = !toggle; // set togggle to opposite  value
		container.validate(); // relay out container
	}
	

	
	
	
}
