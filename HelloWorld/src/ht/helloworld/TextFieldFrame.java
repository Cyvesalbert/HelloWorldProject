package ht.helloworld;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextFieldFrame extends JFrame{

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JPasswordField passwordField;
	
	// textfieldFrame constructor adds JtextFields to Jframe
	public TextFieldFrame() {
		super("testing Jtextfield and JpasswordField");
		setLayout(new FlowLayout());
		textField1 = new JTextField(10);
		add(textField1);
		
		textField2 = new JTextField("Enter text here");
		add(textField2);
		
		textField3 = new JTextField("Uneditable text field");
		textField3.setEditable(false);
		add(textField3);
		
		passwordField = new JPasswordField("Hidden text");
		add(passwordField);
		
		// register event Handler
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
	}
	
	// private inner class for event handling
	private class TextFieldHandler implements ActionListener{
		
		// process text field event
		public void actionPerformed(ActionEvent event) {
			String string = ""; // declare string to dispaly
			
			// user pressed enter in Jtextfield textfield1
			if(event.getSource() == textField1) {
				string = String.format("textField1: %s", event.getActionCommand());
			}else if(event.getSource() == textField2) {
				string = String.format("textField2: %s", event.getActionCommand());
			}else if(event.getSource() == textField3) {
				string = String.format("textField3: %s", event.getActionCommand());
			}else if(event.getSource() == passwordField) { // user pressed enter in JtextField passwordField
				string = String.format("passwordField: %s", event.getActionCommand());
			}
			
			JOptionPane.showMessageDialog(null, string);
		}
	} // end of inner class textFieldHandler
	
	
	
}
