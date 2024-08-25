package ht.searchAlgo;

import java.util.Arrays;
import java.util.Random;

//Class that creates an array filled with random integers.
// Provides a method to sort the array with selection sort.
public class SelectionSort {
	
	private int[] data; // array of values
	private static final Random generator = new Random();
	
	// create array of given size and fill with random integers
	public SelectionSort(int size) {
		data = new int[size]; // create space for array
		
		// fill array with random ints in range 10-99
		for(int i = 0; i < size; i++)
			data[i] = 10 + generator.nextInt(90);
		
	}
	
	// sort array using selection sort
	public void sort() {
		int smallest; // index of smallest element
		
		// loop over data.length - 1 elements
		for(int i = 0; i < data.length -1; i++) {
			smallest = i; // first index of remaining array
			
			// loop to find index of smallest element
			for(int index = i + 1; index < data.length; index++)
				if(data[index] < data[smallest])
					smallest = index;
			
			swap(i, smallest); // swap smallest element into position
			printPass(i + 1, smallest); // output pass of algorithm
		}
		
		}
	
	// helper method to swap values in two  elements
	public void swap(int first, int second) {
		int temporary = data[first]; // stores first in temporary
		data[first] = data[second]; // replace first with second
		data[second] = temporary; // put temporary in second
	}
			
	// print a pass of the algorith
	public void printPass(int pass, int index) {
		System.out.print(String.format("after pass %2d: ", pass));
		
		// output elements till selected item
		for(int i = 0; i < index; i++)
			System.out.print(data[i] + "  ");
		
		System.out.print( data[ index ] + "* " ); // indicate swap
		
		// finish outputting array
		for ( int i = index + 1; i < data.length; i++ )
			System.out.print( data[ i ] + " " );
		
		System.out.print( "\n             " ); // for alignment
		
		// indicate amount of array that is sorted
		for(int j = 0; j < pass; j++) 
			System.out.print("--  ");
		
		System.out.println("\n"); // add endline
	}
	
	// method to output values in array
	public String toString() {
		return Arrays.toString(data);
	}
}
