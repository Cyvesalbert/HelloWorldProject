package ht.networking;

import javax.swing.JFrame;

//Class that tests the Client.
public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client application; // declare client application
		
		// if no command line args
		if ( args.length == 0 )
			application = new Client( "192.168.1.9" ); // connect to localhost
		else
			application = new Client( args[ 0 ] ); // use args to connect
		
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		application.runClient(); // run client application
	}

}
