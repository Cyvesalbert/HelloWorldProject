package ht.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Two threads manipulating a blocking buffer that properly
// implements the producer/consumer relationship.
public class BlockingBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create new thread pool with two threads
		ExecutorService application = Executors.newCachedThreadPool();
		
		// create BlockingBuffer to store ints
		Buffer sharedLocation = new BlockingBuffer();
		
		application.execute(new Producer(sharedLocation));
		application.execute(new Consumer(sharedLocation));
		
		application.shutdown();
	}

}
