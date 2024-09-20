package ht.concurrency;

import java.util.Arrays;
import java.util.Random;

//Class that manages an integer array to be shared by multiple threads.
public class SimpleArray { // CAUTION: NOT THREAD SAFE
	
	private final int[] array; // the shared integer array
	private int writeIndex = 0; // index of next element to be written
	private final static Random generator = new Random();
	
	// construct a sipleArray of a given size
	public SimpleArray(int size) {
		array = new int[size];
	}
	
	// add a value to the shared array 
	public synchronized void add(int value) {
		int position = writeIndex; // store the write index
		
		try {
			// put thread to sleep for 0-499 iliseconds
			Thread.sleep(generator.nextInt(500));
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		// put value in the appropriate element
		array[position] = value;
		System.out.printf("%s wrote %2d to element %d.\n", Thread.currentThread().getName(), value, position);
		
		++writeIndex; // increment index of element to be written next
		System.out.printf("Next write index: %d\n", writeIndex);
	}

	// used for outputting the contents of the shared integer array
	public String toString() {
		return "\nContents of SimpleArray:\n" + Arrays.toString(array);
	}
}
