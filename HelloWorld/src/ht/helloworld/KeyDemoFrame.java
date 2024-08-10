package ht.helloworld;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener{

	private String line1 = ""; // first line of textarea
	private String line2 = ""; // second line textarea
	private String line3 = ""; // third line of textarea
	private JTextArea textArea; // textarea to display output
	
	public KeyDemoFrame() {
		super("demostrating keystroke events");	
		
		textArea = new JTextArea(10, 15); // set up JTextArea
		textArea.setText("Press any key on the keyboard");
		textArea.setEnabled(false); // disable textArea
		textArea.setDisabledTextColor(Color.BLACK); // set text color
		add(textArea); // add textArea to JFrame
		
		addKeyListener(this); // allow frame to process key events
	}
	
	// handle press of any key
	public void keyPressed(KeyEvent event) {
		line1 = String.format("Key Presses: %s", KeyEvent.getKeyText(event.getKeyCode())); // show released key
		setLines2and3(event); // set output lines two and three
	}
	
	// handle release of any key
	public void keyReleased(KeyEvent event) {
		line1 = String.format("Key released: %s", KeyEvent.getKeyText(event.getKeyCode()));
		setLines2and3(event);
	}
	
	// handle press of an action key
	public void keyTyped(KeyEvent event) {
		line1 = String.format("Key Typed: %s", event.getKeyChar());
		setLines2and3(event); // set output lines two and three
		
	}
	
	// set second and third lines of output 
	private void setLines2and3(KeyEvent event) {
		line2 = String.format("this key is %san action key", (event.isActionKey() ? "" : "not"));
		
		String temp = KeyEvent.getKeyModifiersText(event.getModifiers());
		
		line3 = String.format("Modifiers key pressed: %s", (temp.equals("") ? "none" : temp));
		
		textArea.setText(String.format("%s\n%s\n%s\n", line1, line2, line3));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
