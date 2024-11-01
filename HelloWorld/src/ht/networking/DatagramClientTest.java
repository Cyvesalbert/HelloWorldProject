package ht.networking;

import javax.swing.JFrame;

//Tests the Client class.
public class DatagramClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramClient application = new DatagramClient(); // create client
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.waitForPackets();
	}

}
