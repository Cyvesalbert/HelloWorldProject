package ht.networking;

import javax.swing.JFrame;

//Test the Server application.
public class ServerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server application = new Server(); // create server
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runServer(); // run server application
	}

}
