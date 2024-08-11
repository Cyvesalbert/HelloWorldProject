package ht.helloworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// copying selected text from one textArea to another
public class TextAreaFrame extends JFrame{

	private JTextArea textArea1; // displays demo string
	private JTextArea textArea2; // highlighted text is copied here 
	private JButton copyJButton; // initiates copying of text
	
	
	public TextAreaFrame() {
		super("textArea Demo");
		Box box = Box.createHorizontalBox()	; // create box
		String demo = "This is a demo string to\n" + "illustrate copying text\nfrom one textarea to \n" + "another textarea using an\nexternal event\n";
		
		textArea1 = new JTextArea(demo, 10, 15); // create textArea1
		box.add(new JScrollPane(textArea1)); // add scroll pane
		
		copyJButton = new JButton("Copy>>>"); // create copy button
		box.add(copyJButton);
		copyJButton.addActionListener(
				new ActionListener() {
					
					// set text in textArea2 to selected text from textArea1
					public void actionPerformed(ActionEvent event) {
						textArea2.setText(textArea1.getSelectedText());
					}
					
					
				}
				
				);
		
		textArea2 = new JTextArea(10,15); // create second textArea
		textArea2.setEditable(false); // disable editing
		box.add(new JScrollPane(textArea2)); // add scroll pane
		add(box); // add box to frame
		
	}
	
	
	
	
	
	
}
