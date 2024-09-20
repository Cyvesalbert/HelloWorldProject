package ht.concurrency;

import java.util.Random;

//Producer with a run method that inserts the values 1 to 10 in buffer.
public class Producer implements Runnable {

	private final static Random generator = new Random();
	private final Buffer sharedLocation; // reference to shared object
	
	// constructor
	public Producer(Buffer shared) {
		sharedLocation = shared;
	}
	
	// store values from 1 to 10 in sharedLocation
	public void run() {
		int sum  = 0;
		
		for(int count = 1; count <= 10; count++) {
			try { // sleep 0 to 3 seconds then place value in Buffer
				Thread.sleep(generator.nextInt(3000)); // random sleep
				sharedLocation.set(count); // set value in buffer
				sum += count; // increment sum of values
				System.out.printf("\t%2d\n", sum);
			}catch(InterruptedException exception) { // if lines 25 0r 26 get interrupted 
				exception.printStackTrace();
			}
		}
		
		System.out.println("Producer done producing\nTerminating Producer");
	}
}
