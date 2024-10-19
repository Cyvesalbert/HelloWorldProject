package ht.networking;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//Client portion of a stream-socket connection between client and server.
public class Client extends JFrame{
	private JTextField enterField; // enters info from user
	private JTextArea displayArea; // display information to user
	private ObjectOutputStream output; // output stream to server
	private ObjectInputStream input; // input stream from server
	private String message = ""; // message from server
	private String chatServer; // host server for this application
	private Socket client; // socket to communicate with server
	
	// initialize chat server and set up
	public Client(String host) {
		super("Client");
		
		chatServer = host; // set server to which this client connects
		
		enterField = new JTextField(); // create enterField
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
	
	// connect to server and process messages from server
	public void runClient() {
		try { // onnect to server get streams process connection
			connectToServer(); // create a socket to make connection
			getStreams(); // get the input and output streams
			processConnection(); // process connection
		}catch(EOFException eofException) {
			displayMessage( "\nClient terminated connection" );
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}finally {
			closeConnection(); // close connection
		}
	}
	
	// connect to server
	private void connectToServer() throws IOException{
		displayMessage("Attempting connection\n");
		
		// create socket to make connection to server
		client = new Socket(InetAddress.getByName(chatServer), 12345);
		
		// display connection information
		displayMessage("Connected to: " + client.getInetAddress().getHostName());
	}
	
	// get Streams to send and receive data
	private void getStreams() throws IOException{
		// set up output stream for objects
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush(); // flush output buffer to send header info
		
		// set up input stream for objects
		input = new ObjectInputStream(client.getInputStream());
		
		displayMessage("\nGot I/O streams\n");
	}
	
	// process connection with server
	private void processConnection() throws IOException{
		// enable enterField so client user can send messages
		setTextFieldEditable(true);
		
		do { // process messages sent from server
			try { // read message and display it
				message = (String) input.readObject(); // read new message
				displayMessage("\n" + message); // display message
			}catch(ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnknown object type received");
			}
		}while(!message.equals("SERVER>>> TERMINATE"));
	}
	
	// close streams and socket
	private void closeConnection() {
		displayMessage("\nclosing connection");
		setTextFieldEditable(false);
		
		try {
			output.close(); // close output stream
			input.close(); // close input stream
			client.close(); // cose socket
			}catch(IOException ioException) {
				ioException.printStackTrace();
			}
	}
	
	// send message to server
	private void sendData(String message) {
		try { // send object to server
			output.writeObject("CLIENT>>> " + message) ;
			output.flush(); // flush data to output
			displayMessage("\nCLIENT>>> " + message);
		} catch(IOException ioException) {
			displayArea.append("\nError writing object");
		}
	}
	
	// manipulates display area in the event dispatch thread
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() { // updates displayArea
						displayArea.append(messageToDisplay);					}
				}
				);
	}
	
	// manipulates enter field in the event dispatch thread
		private void setTextFieldEditable(final boolean editable) {
			SwingUtilities.invokeLater(
					new Runnable() {
						public void run() { // sets enterfields editability
							enterField.setEditable(editable);					}
					}
					);
		}
	
	

}
