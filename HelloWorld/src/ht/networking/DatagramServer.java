package ht.networking;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

//Server side of connectionless client/server computing with datagrams
public class DatagramServer extends JFrame{

	private JTextArea displayArea; // displays packects received
	private DatagramSocket socket; // socket to connect to client
	
	// set up Gui and datragramSocket
	public DatagramServer() {
		super("Server");
		
		displayArea = new JTextArea(); // create displayArea
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		setSize(400, 300); // set size of window
		setVisible(true);// show window
		
		try { // create datagramSocket for sending and receiving packets
			socket = new DatagramSocket(5000);
		}catch(SocketException socketException) {
			socketException.printStackTrace();
			System.exit(1);
		}
	}
	
	// wait for packets to arrive, display data and echo packet to client
	public void waitForPackets() {
		while(true) {
			try { // receive packet, isplay contents return copy to client
				byte[] data = new byte[100]; // set up packet
				DatagramPacket receivepacket = new DatagramPacket(data, data.length);
				
				socket.receive(receivepacket); // wait to receive packet
				
				// display info from received packet
				displayMessage( "\nPacket received:" +
						"\nFrom host: " + receivepacket.getAddress() +
						"\nHost port: " + receivepacket.getPort() +
						"\nLength: " + receivepacket.getLength() +
						"\nContaining:\n\t" + new String(receivepacket.getData() ,
						0, receivepacket.getLength()) );
				
				sendPacketToClient(receivepacket); // send packet to client
				
			}catch(IOException ioException) {
				displayMessage(ioException + "\n");
				ioException.printStackTrace();
			}
		}
	}
	
	// echo packet to client
	private void sendPacketToClient(DatagramPacket receivePacket) throws IOException{
		displayMessage("\n\nEcho data to client ...");
		
		// create packet to send
		DatagramPacket sendPacket = new DatagramPacket(
				receivePacket.getData(), receivePacket.getLength(),
				receivePacket.getAddress(), receivePacket.getPort() );
		
		socket.send( sendPacket ); // send packet to client
		displayMessage("Packet sent\n");
	}
	
	// manipulates displayArea in the event- dispatch thread
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(
				new Runnable() { // updates display area
					displayArea.append(messageToDisplay); // display message
				}
				);
	}
}
