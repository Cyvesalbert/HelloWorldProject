package ht.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Using an ExecutorService to execute Runnables.
public class TaskExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		// create and name each runnable
		PrintTask task1 = new PrintTask("task1");
		PrintTask task2 = new PrintTask("task2");
		PrintTask task3 = new PrintTask("task3");
		
		System.out.println("Starting executor");
		
		// create executorservice  to manage threads
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		
		// start threads and place in runnable state
		threadExecutor.execute(task1); // start task1
		threadExecutor.execute(task2); // start task2
		threadExecutor.execute(task3); // start task3
		
		// shut down worker threads when their tasks complete
		threadExecutor.shutdown();
		
		System.out.println("Tasks started, main ends.\n"	);
	}

}
