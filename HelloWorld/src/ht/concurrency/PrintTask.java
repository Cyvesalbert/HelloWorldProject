package ht.concurrency;

import java.util.Random;

//PrintTask class sleeps for a random time from 0 to 5 seconds
public class PrintTask implements Runnable {

	private final int sleepTime; // randaom sleep time for thread
	private final String taskName; // name of task
	private final static Random generator = new Random();
	
	// constructor
	public PrintTask(String name) {
		taskName = name; // set task name
		
		// pick random sleep time between 0 and 5 seconds
		sleepTime = generator.nextInt(5000); // miliseconds
	}
	
	// method run contains the code that a thread will execute
	public void run() {
		try { // put thread to aleep for sleeptime amount of time
			System.out.printf( "%s going to sleep for %d milliseconds.\n", taskName, sleepTime );
			Thread.sleep(sleepTime); // put thread to sleep
		}catch(InterruptedException exception) {
			System.out.printf( "%s %s\n", taskName, "terminated prematurely due to interruption" );
		}
		
		// print task name
		System.out.printf("%s done sleeping\n", taskName);
	}
}
