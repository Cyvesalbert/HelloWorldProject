package ht.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Application with two threads manipulating an unsynchronized buffer.
public class SharedBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create new Thread pool with two threads
		ExecutorService application = Executors.newCachedThreadPool();
		
		// create UnsyncronizedBuffer to store ints
		Buffer sharedLocation = new UnsynchronizedBuffer();
		
		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed" );
		System.out.println("------\t\t-----\t---------------\t---------------\n" );
		
		// execute the producer and consummer, giving each of them access to sharedlocation
		application.execute( new Producer( sharedLocation ) );
		application.execute( new Consumer( sharedLocation ) );
		
		application.shutdown(); // terminate application when tasks complete
		
		
	}

}
