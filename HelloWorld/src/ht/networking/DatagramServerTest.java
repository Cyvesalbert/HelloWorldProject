package ht.networking;

import javax.swing.JFrame;

//Class that tests the Server.
public class DatagramServerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatagramServer application = new DatagramServer(); // create server
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.waitForPackets();;
	}

}
