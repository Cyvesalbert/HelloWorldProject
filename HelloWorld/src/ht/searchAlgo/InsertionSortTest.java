package ht.searchAlgo;

//Testing the insertion sort class.
public class InsertionSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create object to perform insertion sort
		InsertionSort sortArray = new InsertionSort(10);
		
		System.out.println("Unsorted array:");
		System.out.println(sortArray + "\n"); // print unsorted array
		
		sortArray.sort(); // sort array
		
		System.out.println("Sorted array");
		System.out.println(sortArray); // print sorted array

	}

}
