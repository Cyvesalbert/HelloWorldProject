package ht.helloworld;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

//Demonstrating JPopupMenus
public class PopupFrame extends JFrame{

	private JRadioButtonMenuItem[] items; // holds items for colors
	private final Color[] colorValues = { Color.BLUE, Color.YELLOW, Color.RED }; // colors to be used
	private JPopupMenu popupMenu; // allows user to select color
	
	// no argument constructor sets up gui
	public PopupFrame() {
		super("using JPopupsMenus");

		ItemHandler handler = new ItemHandler(); // handler for menu items
		String[] colors = { "Blue", "Yellow", "Red" }; // array of colors
		
		ButtonGroup colorGroup = new ButtonGroup();// manages color items
		popupMenu = new JPopupMenu(); // create popupp menu
		items = new JRadioButtonMenuItem[colors.length]; // color items
		
		//construct menu item, add to popup menu, enable event handling
		for(int count = 0; count < items.length; count++) {
			items[count] = new JRadioButtonMenuItem(colors[count]);
			popupMenu.add(items[count]); // add item to popup menu
			colorGroup.add(items[count]); // add item to buttongroup
			items[count].addActionListener(handler); // add handler
		}
		
		setBackground(Color.WHITE); // set background to white
		
		// declare a MouseListener for the window to display popup menu
		addMouseListener(
				new MouseAdapter() { // anonymous inner class
					//handle mouse press event
					public void mousePressed(MouseEvent event) {
						checkForTriggerEvent(event); // check for trigger
					}
					
					// handle mouse release event
					public void mouseReleased(MouseEvent event) {
						checkForTriggerEvent(event); //  check for trigger
					}
					
					// determine whether event should trigger popup menu
					private void checkForTriggerEvent(MouseEvent event) {
						if(event.isPopupTrigger())
							popupMenu.show(event.getComponent(), event.getX(), event.getY());
					}
				}
				
				);
	}
	
	
	private class ItemHandler implements ActionListener{
		// process menu item selections
		public void actionPerformed(ActionEvent event) {
			// determine which menu item was selected
			for(int i = 0; i < items.length; i++) {
				getContentPane().setBackground(colorValues[i]);
				return;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
