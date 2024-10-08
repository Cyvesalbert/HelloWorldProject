package ht.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Two threads manipulating a synchronized buffer.
public class SharedBufferTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create new thread pool with two threads
		ExecutorService application = Executors.newCachedThreadPool();
		
		// create SynchronizedBuffer to store ints
		Buffer sharedLocation = new SynchronizedBuffer();
		
		System.out.printf( "%-40s%s\t\t%s\n%-40s%s\n\n", "Operation",
				"Buffer", "Occupied", "---------", "------\t\t--------" );
	
		// execute the producer and consumer tasks
		application.execute(new Producer(sharedLocation));
		application.execute(new Consumer(sharedLocation));
		
		application.shutdown();
	
	
	}
	
	
	

}
