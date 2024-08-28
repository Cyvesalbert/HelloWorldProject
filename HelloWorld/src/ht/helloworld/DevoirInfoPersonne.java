package ht.helloworld;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ht.ch17.AccountRecordSerializable;
import ht.ch17.CreateSequentialFile;
import ht.ch17.CreateTextFile;
import ht.helloworld.CelciusFarenheitGui.ConvertButtonHandler;

public class DevoirInfoPersonne extends JFrame{

	
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAge;
	private JTextField txtRue;
	private JTextField txtVille;
	private JTextField txtPays;
	private JTextField txtTelephone;
	private JTextField txtNif;
	
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblAge;
	private JLabel lblRue;
	private JLabel lblVille;
	private JLabel lblPays;
	private JLabel lblTelephone;
	private JLabel lblNif;
	
	private JButton btnAddInList;
	private JButton btnAddInFile;
	
	private static int index = 0;
	List<Personne> personnes = new ArrayList<Personne>();

	
	public DevoirInfoPersonne() {
		super("Person Info");
		setLayout(new GridLayout(9, 2, 10, 10));  // GridLayout for better alignment
		
		lblNom = new JLabel("Nom:  ");
		add(lblNom);
		
		txtNom = new JTextField(10);
		add(txtNom);
		
		lblPrenom = new JLabel("Prenom:  ");
		add(lblPrenom);
		
		txtPrenom = new JTextField(10);
		add(txtPrenom);
		
		lblAge = new JLabel("Age:  ");
		add(lblAge);
		
		txtAge = new JTextField(10);
		add(txtAge);
		
		lblRue = new JLabel("Rue:  ");
		add(lblRue);
		
		txtRue = new JTextField(10);
		add(txtRue);
		
		lblVille = new JLabel("Ville:  ");
		add(lblVille);
		
		txtVille = new JTextField(10);
		add(txtVille);
		
		lblPays = new JLabel("Pays:  ");
		add(lblPays);
		
		txtPays = new JTextField(10);
		add(txtPays);
		
		lblTelephone = new JLabel("Telephone:  ");
		add(lblTelephone);
		
		txtTelephone = new JTextField(10);
		add(txtTelephone);
		
		lblNif = new JLabel("Nif:  ");
		add(lblNif);
		
		txtNif = new JTextField(10);
		add(txtNif);
		
		btnAddInList = new JButton("Add in list");
		add(btnAddInList);
		
		btnAddInFile = new JButton("Add in File");
		add(btnAddInFile);
		
		ButtonHandler handler = new ButtonHandler();
		btnAddInList.addActionListener(handler);
		btnAddInFile.addActionListener(handler);
	}
	
public class ButtonHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand() == "Add in list") {
			Personne personne = new Personne(txtNom.getText(), txtPrenom.getText(), Integer.parseInt(txtAge.getText()),
					txtRue.getText(), txtVille.getText(), txtPays.getText(), txtTelephone.getText(), txtNif.getText());
			personnes.add(personne);
			
			if(index < personnes.size()) {
                System.out.println(personnes.get(index));
                index++; // Increment index
            } else {
                System.out.println("End of list.");
            }
				
			}else if(e.getActionCommand() == "Add in File") {
				CreateSequentialFile.openFile("demos.txt");
				
				for(Personne p : personnes) {
					try { // output personne to file
						
						CreateSequentialFile.output.writeObject(p);
						
					}catch(IOException ioException) {
						System.err.println("error writing to file");
						return;
					}catch(NoSuchElementException elementException) {
						System.err.println("Invalid input. please try again");
						
					}
				}
			}
		}
	}
	
	
		
}
