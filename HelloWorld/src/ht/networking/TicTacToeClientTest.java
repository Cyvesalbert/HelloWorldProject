package ht.networking;

import javax.swing.JFrame;

//Test class for Tic-Tac-Toe client.
public class TicTacToeClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TicTacToeClient application; // declare client app
		
		// if no client args
		if(args.length == 0) {
			application = new TicTacToeClient("127.0.0.1"); // localHost
		}else {
			application = new TicTacToeClient(args[0]); // use args
			
		}
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}

}
