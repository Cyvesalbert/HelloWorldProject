package ht.helloworld;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

// JCombobox that displays a list of image names
public class ComboBoxFrame extends JFrame{

	private JComboBox imagesJComboBox; // combobox to hold names of icons
	private JLabel label; // label to display selected icon
	
	private static final String[] names = {"bug1.gif", "bug2.gif", "travelbug.gif", "buganim.gif"};
	
	private Icon[] icons = {
			new ImageIcon( getClass().getResource( names[ 0 ] ) ),
			new ImageIcon( getClass().getResource( names[ 0 ] ) ),
			new ImageIcon( getClass().getResource( names[ 0 ] ) ),
			new ImageIcon( getClass().getResource( names[ 0 ] ) ) };
	
	public ComboBoxFrame() {
		super("testing JComboBox");
		setLayout(new FlowLayout());
		
		imagesJComboBox = new JComboBox(names); // setup JComboBox
		imagesJComboBox.setMaximumRowCount(3); // display 3 rows
		
		imagesJComboBox.addItemListener(
					new ItemListener() { // anonymous inner class
						// handle JComboBox event
						public void itemStateChanged(ItemEvent event) {
							if(event.getStateChange() == ItemEvent.SELECTED) {
								label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
							}
						}
						
					}
				);
		add(imagesJComboBox);
		label = new JLabel(icons[0]);
		add(label);
	}
	
}
