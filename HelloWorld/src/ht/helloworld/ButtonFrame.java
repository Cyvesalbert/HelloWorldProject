package ht.helloworld;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

//creatings butttons
public class ButtonFrame extends JFrame{

	private JButton plainJButton; // button with just text
	private JButton fancyJButton; // button with icons
	
	public ButtonFrame() {
		super("Testing buttons");
		setLayout(new FlowLayout());
		
		plainJButton = new JButton("Plain button");
		add(plainJButton);
		
//		Icon bug1 = new ImageIcon(getClass().getResource("GUItip.gif"));
//		Icon bug2 = new ImageIcon(getClass().getResource("GUItip.gif"));
		fancyJButton = new JButton("Fancy Button");
		//fancyJButton.setRolloverIcon(bug2);
		add(fancyJButton);
		
		ButtonHandler handler = new ButtonHandler();
		fancyJButton.addActionListener(handler);
		plainJButton.addActionListener(handler);
		
	
		
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(ButtonFrame.this, String.format("you pressed: %s ", e.getActionCommand()));
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
