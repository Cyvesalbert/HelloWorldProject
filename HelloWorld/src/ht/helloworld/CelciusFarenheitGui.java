package ht.helloworld;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CelciusFarenheitGui extends JFrame{

	private JTextField celciusTextField;
	private JTextField farenheitTextField;
	private JLabel farenheitLabel;
	private JLabel celciusLabel;
	private JButton convertButton;

	
	public CelciusFarenheitGui() {
		super("Celcius to Farenheit");
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
		
		celciusLabel = new JLabel("Celcius: ");
		add(celciusLabel);
		
		celciusTextField = new JTextField(10);
		add(celciusTextField);
		
		farenheitLabel = new JLabel("Farenheit: ");
		add(farenheitLabel);
		
		farenheitTextField = new JTextField(10);
		add(farenheitTextField);
		
		convertButton = new JButton("Convert");
		add(convertButton);
		
		ConvertButtonHandler handler = new ConvertButtonHandler();
		convertButton.addActionListener(handler);
		
	}
	
	public class ConvertButtonHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(celciusTextField.getText() == null &&  farenheitTextField.getText() == null ) {
				JOptionPane.showMessageDialog(null, "You must enter a degreee farenheit or celcius");
			}
		}
		
	}
	
	
	
	
	
	
	
}
