package ht.helloworld;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
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
import ht.ch17.ReadSequentialFile;
import ht.helloworld.CelciusFarenheitGui.ConvertButtonHandler;

public class DevoirInfoPersonne extends JFrame{

	
	private static JTextField txtNom;
	private static JTextField txtPrenom;
	private static JTextField txtAge;
	private static JTextField txtRue;
	private static JTextField txtVille;
	private static JTextField txtPays;
	private static JTextField txtTelephone;
	private static JTextField txtNif;
	
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
	
	private JButton btnPrecedent;
	private JButton btnSuivant;
	
	private static int index = 0;
	private static int currentIndex = 0;
	
	List<Personne> personnes = new ArrayList<Personne>();
	static List<Personne> personnesNav = new ArrayList<Personne>();

	
	public DevoirInfoPersonne() {
		super("Person Info");
        setLayout(new GridLayout(9, 2, 10, 10));  // GridLayout for better alignment

        // Initialize UI components
        lblNom = new JLabel("Nom:  ");
        txtNom = new JTextField(10);
        lblPrenom = new JLabel("Prenom:  ");
        txtPrenom = new JTextField(10);
        lblAge = new JLabel("Age:  ");
        txtAge = new JTextField(10);
        lblRue = new JLabel("Rue:  ");
        txtRue = new JTextField(10);
        lblVille = new JLabel("Ville:  ");
        txtVille = new JTextField(10);
        lblPays = new JLabel("Pays:  ");
        txtPays = new JTextField(10);
        lblTelephone = new JLabel("Telephone:  ");
        txtTelephone = new JTextField(10);
        lblNif = new JLabel("Nif:  ");
        txtNif = new JTextField(10);

        // Add UI components to frame
        add(lblNom);
        add(txtNom);
        add(lblPrenom);
        add(txtPrenom);
        add(lblAge);
        add(txtAge);
        add(lblRue);
        add(txtRue);
        add(lblVille);
        add(txtVille);
        add(lblPays);
        add(txtPays);
        add(lblTelephone);
        add(txtTelephone);
        add(lblNif);
        add(txtNif);

        // Initialize buttons
        btnAddInList = new JButton("Add in list");
        btnAddInFile = new JButton("Add in File");
        btnPrecedent = new JButton("Precedent");
        btnSuivant = new JButton("Suivant");

        // Add buttons to frame
        add(btnAddInList);
        add(btnAddInFile);
        add(btnPrecedent);
        add(btnSuivant);

        // Set up button actions
        ButtonHandler handler = new ButtonHandler();
        btnAddInList.addActionListener(handler);
        btnAddInFile.addActionListener(handler);
        btnPrecedent.addActionListener(handler);
        btnSuivant.addActionListener(handler);

	}
	
	// hadnler class
	public class ButtonHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
            if (command.equals("Add in list")) {
                addPersonToList();
            } else if (command.equals("Add in File")) {
                addPersonsToFile();
                JOptionPane.showMessageDialog(null, "List content added to file successfully");
            } else if (command.equals("Precedent")) {
            	// Load records from file on initialization
             
                showPreviousRecord();
            } else if (command.equals("Suivant")) {
                showNextRecord();
            }
	}	
	
		// Add personne object to a list 
        private void addPersonToList() {
            try {
                // Create a new Personne object and add it to the list
                Personne personne = new Personne(txtNom.getText(), txtPrenom.getText(), Integer.parseInt(txtAge.getText()),
                        txtRue.getText(), txtVille.getText(), txtPays.getText(), txtTelephone.getText(), txtNif.getText());
                personnes.add(personne);
                System.out.println("Person added to list: " + personne);
                
                clearFields();
            } catch (NumberFormatException ex) {
                System.err.println("Invalid age format.");
            }
        }

        // add personne object to file
        private void addPersonsToFile() {
            CreateSequentialFile.openFile("demos.txt");

            for (Personne p : personnes) {
                try {
                    CreateSequentialFile.output.writeObject(p);
                    
                } catch (IOException ioException) {
                    System.err.println("Error writing to file");
                    return;
                } catch (NoSuchElementException elementException) {
                    System.err.println("Invalid input. Please try again.");
                }
            }

            CreateSequentialFile.closeFile();
            loadRecords();  // Reload records after adding new ones
        }
    }
	
	// load records from file to list personnesNav
	private static void loadRecords() {
		ReadSequentialFile.openFile("demos.txt"); // Open the file
	    Personne record;
	    
	    try {
	        while (true) {
	            record = (Personne) ReadSequentialFile.getInput().readObject();
	            personnesNav.add(record); // Add record to the list
	        }
	    } catch (EOFException endOfFileException) {
	        // End of file reached
	    } catch (ClassNotFoundException | IOException ex) {
	        ex.printStackTrace();
	    }
	    
	    CreateSequentialFile.closeFile();
	}

	// show previous record
	private static void showPreviousRecord() {
	    if (currentIndex > 0) {
	        currentIndex--; // Decrement the index
	        displayRecord(personnesNav.get(currentIndex)); // Display the previous record
	    } else {
	        System.out.println("No previous record.");
	    }
	}

	// show next record
	private static void showNextRecord() {
	    if (currentIndex < personnesNav.size() - 1) {
	        currentIndex++; // Increment the index
	        displayRecord(personnesNav.get(currentIndex)); // Display the next record
	    } else {
	        System.out.println("No next record.");
	    }
	}

	// dislplay a record
	private static void displayRecord(Personne record) {
	    txtNom.setText(record.getNom());
	    txtPrenom.setText(record.getPrenom());
	    txtAge.setText(String.valueOf(record.getAge()));
	    txtRue.setText(record.getRue());
	    txtVille.setText(record.getVille());
	    txtPays.setText(record.getPays());
	    txtTelephone.setText(record.getTelephone());
	    txtNif.setText(record.getNif());
	}
	
	// clear fields
	private static void clearFields() {
	    txtNom.setText("");
	    txtPrenom.setText("");
	    txtAge.setText("");
	    txtRue.setText("");
	    txtVille.setText("");
	    txtPays.setText("");
	    txtTelephone.setText("");
	    txtNif.setText("");
	}


}
