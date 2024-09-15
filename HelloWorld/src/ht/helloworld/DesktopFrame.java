package ht.helloworld;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//Demonstrating JDesktopPane.
public class DesktopFrame extends JFrame {

	private JDesktopPane theDesktop;
	
	// set up gui
	public DesktopFrame() {
		super("using a JDesktopPane");
		JMenuBar bar = new JMenuBar(); // create menu bar
		JMenu addMenu = new JMenu("Add"); // create add menu
		JMenuItem newFrame = new JMenuItem( "Internal Frame" );
		
		addMenu.add(newFrame); // add new frame item to add menu
		bar.add(addMenu); // add menu to menu bar
		setJMenuBar(bar); // set menu bar for this application
		
		theDesktop = new JDesktopPane(); // create desktop pane
		add(theDesktop); // add desktop pane to frame
		
		// set up listener for newFrame menu item
		newFrame.addActionListener(
				new ActionListener() { // anonymous inner class
					// display new internal window
					public void actionPerformed(ActionEvent event) {
						// create internal frame
						JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true );
						
						MyJPanel panel = new MyJPanel(); // create new panel
						frame.add(panel, BorderLayout.CENTER); // add panel
						frame.pack(); // set internal frame to size of contents
						
						theDesktop.add(frame); // attach internal frame
						frame.setVisible(true); // show internal frame
					}
				}
				);
	}
	
	// class to display an ImageIcon on a panel
	class MyJPanel extends JPanel{
		private static Random generator = new Random();
		private ImageIcon picture; // image to be displayed
		private final static String[] images = { "yellowflowers.png", "purpleflowers.png", "redflowers.png", "redflowers2.png", "lavenderflowers.png" };
		
		//load image
		public MyJPanel() {
			int randomNumber = generator.nextInt(images.length);
			picture = new ImageIcon(images[randomNumber]); // set icon
		}
		
		// display ImageIcon on panel
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // display icon
		}
		
		// return image dimensions
		public Dimension getPreferredSize() {
			return new Dimension(picture.getIconWidth(), picture.getIconHeight());
		}
		
	}
	
	
	
	
	
}
