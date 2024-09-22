package ht.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Producer and Consumer threads manipulating a circular buffer.
public class CircularBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create new thread pool with two threads
		ExecutorService application = Executors.newCachedThreadPool();
		
		// create CircularBufffer to store ints
		CircularBuffer sharedLocation  = new CircularBuffer();
		
		// display the initial state of the circularBuffer
		sharedLocation.displayState("Intitial State");
		
		// execute the producer and consumer tasks
		application.execute( new Producer( sharedLocation ) );
		application.execute( new Consumer( sharedLocation ) );
		
		application.shutdown();
	}

}
