package ht.networking;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//Server portion of a client/server stream-socket connection.
public class Server extends JFrame{
	private JTextField enterField; // inputs message from user
	private JTextArea displayArea; // display info to user
	private ObjectOutputStream output; // output stream to client
	private ObjectInputStream input; // input stream from client
	private ServerSocket server; // server socket
	private Socket connection; // connection to client
	private int counter = 1; // counter of number of connections
	
	//set up GUI
	public Server() {
		super("Server");
		
		enterField = new JTextField(); // create enterfield
		enterField.setEditable(false);
		enterField.addActionListener(
				new ActionListener() {
					// send message to client
					public void actionPerformed(ActionEvent event) {
						sendData(event.getActionCommand());
						enterField.setText("");
					}
				}
				);
		
		add(enterField, BorderLayout.NORTH);
		
		displayArea = new JTextArea(); // create displayArea
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		
		setSize(300, 150); // set size of window
		setVisible(true); // show window
	}
	
	// set up and run server
	public void runServer() {
		try { // set up server to receive connections ; process connections
			server = new ServerSocket(12345, 100); // create server socket
			
			while(true) {
				try {
					waitForConnection(); // wait for a connection
					getStreams(); // get input & output streams
					processConnection(); // process connection
				}catch(EOFException eofException) {
					displayMessage("\nServer terminated connection");
				}finally {
					closeConnection(); // close connection
					++counter;
				}
			}
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	// wait for connection to arrive then display connection info
	private void waitForConnection() throws IOException{
		displayMessage("Waiting for connection");
		connection = server.accept(); // allow server to accept connection
		displayMessage("Connection" + counter + "received from: " +
		connection.getInetAddress().getHostName());
	}
	
	// get streams to sent and receive data
	private void getStreams()throws IOException{
		// set up output stream for objects
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush(); // flush output buffer to send header information
		 
		// set up input stream for objects
		input = new ObjectInputStream(connection.getInputStream());
		
		displayMessage("\nGot I/O streams\n");
	}
	
	// process connection with client
	private void processConnection() throws IOException{
		String message = "Connection successful";
		sendData(message); // send connection successful message
		
		// enable enterField so server user can send messages
		setTextFieldEditable(true);
		
		do { // process messages sent from client
			try { // read message and display it
				message = (String)input.readObject(); // read new message
				displayMessage("\n" + message); // display message
			}catch(ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnknown object type received");
			}
		}while(!message.equals("CLIENT>>> TERMINATE"));
	}
	
	// close streams and socket
	private void closeConnection() {
		displayMessage("\nTerminating connection\n");
		setTextFieldEditable(false); // disable enterField
		
		try {
			output.close(); // close output stream
			input.close(); // close input stream
			connection.close(); // close socket
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	// send message to  client
	private void sendData(String message) {
		try { // send object to client
			output.writeObject("SERVER>>> " + message);
			output.flush(); // flush output to client
			displayMessage("\nSERVER>>> " + message);
		}catch(IOException ioException) {
			displayArea.append("\nError writing object");
		}
	}
	
	// manipulates displayArea in the event-dispatch thread
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() { // updates display area
						displayArea.append(messageToDisplay); // append message
					}
				}
				);
	}
	
	// manipulates enterField in the event-dispatch thread
	private void setTextFieldEditable(final boolean editable) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() { // sets enterField's editability
						enterField.setEditable(editable);
					}
				}
				);
		
	}

}
