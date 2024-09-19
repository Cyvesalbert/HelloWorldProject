package ht.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Executes two Runnables to add elements to a shared SimpleArray.
public class SharedArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// construct the shared object
		SimpleArray sharedSimpleArray = new SimpleArray(6);
		
		// create two tasks to write to the shared simpleArray
		ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);
		
		// execute the tasks with an ExecutorService
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(writer1);
		executor.execute(writer2);
		
		executor.shutdown();
		
		try {
			// wait 1 minute for both writers to finish executing
			boolean taksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
			
			if(taksEnded)
				System.out.println(sharedSimpleArray); // print contents
			else
				System.out.println("Timed out while waiting for tasks to finish");
			
		}catch(InterruptedException ex) {
			System.out.println("Interrupted while waiting for tasks to finish");
		}
	}

}
