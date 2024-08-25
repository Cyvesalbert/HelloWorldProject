package ht.searchAlgo;

import java.util.Arrays;
import java.util.Random;

//Class that creates an array filled with random integers.
// Provides a method to sort the array with insertion sort.
public class InsertionSort {

	
	private int[] data; // array of values
	private static final Random generator = new Random();
	
	// create array of given size and fill with random integers
	public InsertionSort(int size) {
		data = new int[size];// create space for array
		
		// fill array with random ints in range 10-99
		for(int i = 0; i < size; i++)
			data[i] = 10 + generator.nextInt(90);
	}
	
	// sort array using insertion sort
	public void sort() {
		int insert; // temporary variable to  hold element to insert
		
		// loop over data.length - 1 elements
		for(int next = 1; next < data.length; next++) {
			insert = data[next]; // store value in current element
			
			int moveItem = next; // initialize location to place element
			
			// search for place to put current element
			while(moveItem > 0  && data[moveItem - 1] > insert) {
				// shift element right one slot
				data[moveItem] = data[moveItem - 1];
				moveItem--;
			}
			
			data[moveItem] = insert; // place inserted element
			printPass(next, moveItem); // output pass of algorithm
		}
	}
	
	// print a pass of the algoriht
	public void printPass(int pass, int index) {
		System.out.print(String.format("after pass %2d: ", pass));
		
		// output elements till swap item
		for(int i = 0; i < index; i++)
			System.out.print(data[i] + "   ");
		
		System.out.print(data[index] + "* "); // indicate swap
		
		//finish outputting array
		for(int i = index + 1; i < data.length; i++)
			System.out.print(data[i] + "   ");
		
		System.out.print("\n               "); // for alignment
		
		// indicate amount of aaray that is sorted
		for(int i = 0; i <= pass; i++)
			System.out.print("--  ");
		
		System.out.println("\n");
	}
	
	// method to output values in array
	public String toString() {
		return Arrays.toString(data);
	}
}


