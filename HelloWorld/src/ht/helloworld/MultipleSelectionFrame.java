package ht.helloworld;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

// copying items from one list to another
public class MultipleSelectionFrame extends JFrame{

	private JList colorJList; // list to hold color names
	private JList copyJList; // list to copy color names into
	
	private JButton copyJButton; // button to copy selected names
	private static final String[] colorNames = { "Black", "Blue", "Cyan",
			"Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
			"Pink", "Red", "White", "Yellow" };
	
	// multipleSelectionFrame Constructor 
	public MultipleSelectionFrame() {
		super("Multiple selection Lists");
		setLayout(new FlowLayout());
		
		colorJList = new JList(colorNames); // holds names of all colors
		colorJList.setVisibleRowCount(5);
		colorJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(colorJList)); // add list with scrollpane
		
		copyJButton = new JButton("Copy >>>"); // create copy button
		copyJButton.addActionListener(
				new ActionListener() { // anonymous inner class
					// handle button event
					public void actionPerformed(ActionEvent event) {
						// place selected values in copyJList
						copyJList.setListData(colorJList.getSelectedValues());
					}
				}
				);
		add(copyJButton);
		copyJList = new JList(); // create list to hold copied color names
		copyJList.setVisibleRowCount(5);
		copyJList.setFixedCellWidth(100);
		copyJList.setFixedCellHeight(15);
		copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		add(new JScrollPane(copyJList));
	}
}
