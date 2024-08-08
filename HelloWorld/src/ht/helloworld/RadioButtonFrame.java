package ht.helloworld;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// creating tion buttons using ButtonsGroup and JRadioButtons
public class RadioButtonFrame extends JFrame {
	
	private JTextField textField; // used to display font changes
	private Font plainFont; // font for plain text
	private Font boldFont; // font for bold text
	private Font italicFont; // font for italic text
	private Font boldItalicFont; // font for bold and italic text
	private JRadioButton plainJRadioButton; // selects plain text
	private JRadioButton boldJRadioButton; // selects bold text
	private JRadioButton italicJRadioButton; // selects italic text
	private JRadioButton boldItalicJRadioButton; // bold and italic 
	private ButtonGroup radioGroup; // buttonGroup to hold radio buttons
	
	

	// radioButtonFrame constructor and JRadioButttons to JFrame
	public RadioButtonFrame() {
		super("Radio Button test");
		setLayout(new FlowLayout()); // set frame Layout
		
		textField = new JTextField("Watch the font style change", 25);
		add(textField);
		
		// create radio buttons
		plainJRadioButton = new JRadioButton("Plain", true);
		boldJRadioButton = new JRadioButton("Bold", false);
		italicJRadioButton = new JRadioButton("Italic", false);
		boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
		add(plainJRadioButton); // add plain button to JFrame
		add(boldJRadioButton); // add bold button to JFrame
		add(italicJRadioButton); // add italic button to JFrame
		add(boldItalicJRadioButton); // add bold and italic button
		
		// create logical relationship between JRadioButtons
		radioGroup = new ButtonGroup(); // create button group
		radioGroup.add(plainJRadioButton);
		radioGroup.add(boldJRadioButton);
		radioGroup.add(italicJRadioButton);
		radioGroup.add(boldItalicJRadioButton);
		
		// create font objects
		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		textField.setFont(plainFont); // set initial font to plain
		
		// register events for JRadioButtons
		plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
		
		
	}
	
	private class RadioButtonHandler implements ItemListener{
		
		private Font font; // font associated with listener
		
		public RadioButtonHandler(Font f) {
			font = f;
	
		}
		
		// handle radio button event
		public void itemStateChanged(ItemEvent event) {
			textField.setFont(font);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
