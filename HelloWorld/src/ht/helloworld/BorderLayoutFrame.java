package ht.helloworld;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// demonstrating borderLayout
public class BorderLayoutFrame extends JFrame implements ActionListener {

	private JButton[] buttons; // array of buttons to hide portions
	private static final String[] names = { "Hide North", "Hide South", "Hide East", "Hide West", "Hide Center" };
	private BorderLayout layout; // borderLayout object
	
	// set up GUI and event handling
	public BorderLayoutFrame() {
		super("borderLayoutDemo");
		layout = new BorderLayout(5,5); // five pixels gaps
		setLayout(layout); // set Frame layout
		buttons = new JButton[names.length]; // set size of array
		
		// create JButtons and register listeners for them
		for(int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
		}
		
		add(buttons[0], BorderLayout.NORTH); // add button to north
		add(buttons[1], BorderLayout.SOUTH); // add button to south
		add(buttons[2], BorderLayout.EAST); // add button to east
		add(buttons[3], BorderLayout.WEST); // add button to west
		add(buttons[4], BorderLayout.CENTER); // add button to center
		
	}
	
	// handle buttons events
	public void actionPerformed(ActionEvent event) {
		// check for event source and lay out content pane correspondingly
		for(JButton button : buttons) {
			if(event.getSource() == button) {
				button.setVisible(false);
			}else {
				button.setVisible(true);
			}
		}
		layout.layoutContainer(getContentPane());
	}
	
	
	
	
}
