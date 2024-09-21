package ht.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Two threads correctly manipulating a synchronized buffer.
public class SharedBufferTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create a newCachedThreadPool
		ExecutorService application = Executors.newCachedThreadPool();
		
		// create synchronizedBuffer to store ints
		Buffer sharedLocation = new SynchronizedBuffer();
		
		System.out.printf( "%-40s%s\t\t%s\n%-40s%s\n\n", "Operation",
			"Buffer", "Occupied", "---------", "------\t\t--------" );
		
		// execute the producer adn consummer tasks
		application.execute(new Producer(sharedLocation));
		application.execute(new Consumer(sharedLocation));
		
		application.shutdown();
	}

}
