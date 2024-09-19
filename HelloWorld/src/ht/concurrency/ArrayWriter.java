package ht.concurrency;

//Adds integers to an array shared with other Runnables

public class ArrayWriter implements Runnable {

	private final SimpleArray sharedSimpleArray;
	private final int startValue;
	
	public ArrayWriter(int value, SimpleArray array) {
		startValue = value;
		sharedSimpleArray = array;
	}
	
	public void run() {
		for(int i = startValue; i < startValue + 3; i++) {
			sharedSimpleArray.add(i); // add an element to the shared array
		}
	}
}
