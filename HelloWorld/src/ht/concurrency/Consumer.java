package ht.concurrency;

import java.util.Random;

//Consumer with a run method that loops, reading 10 values from buffer.
public class Consumer implements Runnable {

	private final static Random generator = new Random();
	private final Buffer sharedLocation; // reference to shared object
	
	// constructor
	public Consumer(Buffer shared) {
		sharedLocation = shared;
	}
	

	// store values from 1 to 10 in sharedLocation
	public void run() {
		int sum  = 0;
		
		for(int count = 1; count <= 10; count++) {
			try { // sleep 0 to 3 seconds then place value in Buffer
				Thread.sleep(generator.nextInt(3000)); // random sleep
				sum += sharedLocation.get(); // increment sum of values
				System.out.printf( "\t\t\t%2d\n", sum );
			}catch(InterruptedException exception) { // if lines 25 0r 26 get interrupted 
				exception.printStackTrace();
			}
		}
		
		System.out.println("consumer done producing\nTerminating consumer");
	}
}
