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
	private JButton cancelButton;
	
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
		
		cancelButton = new JButton("Cancel");
		add(cancelButton);
		
		ConvertButtonHandler handler = new ConvertButtonHandler();
		convertButton.addActionListener(handler);
		cancelButton.addActionListener(handler);
		
	}
	
	public class ConvertButtonHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand() == "Convert") {
			if(celciusTextField.getText().trim().isEmpty() &&  farenheitTextField.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "You must enter a degreee farenheit or celcius");
			}else if(!celciusTextField.getText().trim().isEmpty() && farenheitTextField.getText().trim().isEmpty()) {
				float celciusDegree = Integer.parseInt(celciusTextField.getText());
				double result = (celciusDegree * 1.8) + 32;
				farenheitTextField.setText(String.valueOf(result));
			}else if(!farenheitTextField.getText().trim().isEmpty() && celciusTextField.getText().trim().isEmpty()) {
				float farenheitDegree = Integer.parseInt(farenheitTextField.getText());
				double result = (farenheitDegree - 32) * 5 / 9;
				celciusTextField.setText(Double.toString(result));
			}
		}else {
			celciusTextField.setText("");
			farenheitTextField.setText("");
		}
			
		}
		
	}
	
	
	
	
	
	
	
}
