package ht.helloworld;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

//Changing the look-and-feel.
public class LookAndFeelFrame extends JFrame{

	private UIManager.LookAndFeelInfo[] looks; // look and feels
	private String[] lookNames; // names of look  and feels
	private JRadioButton[] radio; // radio buttons to select look and feel
	private ButtonGroup group;// group for radio buttons
	private JButton button; // displays look of button
	private JLabel label; // displays look of label
	private JComboBox comboBox; // displays look of combobox
	
	// set up GUI
	public LookAndFeelFrame() {
		super("Look and feel Demo");
		
		// get installed look and feel information
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String[looks.length];
		
		// get names of installed look and feels
		for(int i = 0; i < looks.length; i++) {
			lookNames[i] = looks[i].getName();
		}
		
		JPanel northPanel = new JPanel(); // create north panel
		northPanel.setLayout(new GridLayout(3, 1, 0, 5));
		
		label = new JLabel( "This is a " + lookNames[0] + " look-and-feel", SwingConstants.CENTER ); // create label
		northPanel.add( label ); // add label to panel
		
		button = new JButton("JButton"); // create button
		northPanel.add(button); // add button to panel
		
		comboBox = new JComboBox(lookNames); // create comboBox
		northPanel.add(comboBox); // add combobox to panel
		
		// create array for radio buttons
		radio = new JRadioButton[looks.length];
		
		JPanel southPanel = new JPanel(); // create southPanel
		
		// user a gridLayout with 3 buttons in each row
		int rows = (int) Math.ceil(radio.length / 3.0);
		southPanel.setLayout(new GridLayout(rows, 3));
		
		group = new ButtonGroup(); // buttonGroup for look and feels
		ItemHandler handler = new ItemHandler(); // Look and feel handler
		
		for(int count = 0; count < radio.length; count++) {
			radio[count] = new JRadioButton(lookNames[count]);
			radio[count].addItemListener(handler); // add handler
			group.add(radio[count]); // add radio button to group
			southPanel.add(radio[count]); // add radio button panel
		}
		
		add(northPanel, BorderLayout.NORTH); // add north panel
		add(southPanel, BorderLayout.SOUTH); // add south panel
		
		radio[0].setSelected(true);
		
	}
	
	// Use UIManager to change look and feel
	private void changeTheLookAndFeel(int value) {
		try { // change look and feel
			// set look and feel for this application
			UIManager.setLookAndFeel(looks[value].getClassName());
			
			// update components int this application
			SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	// private inner class to handle radio button events
	private class ItemHandler implements ItemListener{
		// process users look and feel selection
		public void itemStateChanged(ItemEvent event) {
			for(int count = 0; count < radio.length; count++) {
				if(radio[count].isSelected()) {
					label.setText( String.format("This is a %s look-and-feel", lookNames[ count ] ) );
					comboBox.setSelectedIndex(count); // set comboBox index
					changeTheLookAndFeel(count); // change look and feel
				}
			}
		}
	}
	
}
