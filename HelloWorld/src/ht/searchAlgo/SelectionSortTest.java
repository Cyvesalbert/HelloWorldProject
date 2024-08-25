package ht.searchAlgo;

//Testing the selection sort class
public class SelectionSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create object to perform selection sort
		SelectionSort sortArray = new SelectionSort(10);
		System.out.println("Unnsorted array:");
		System.out.println(sortArray + "\n") ; // print unsorted array
		
		sortArray.sort(); // sortArray
		
		System.out.print("Sorted array:");
		System.out.println(sortArray); // print sorted array
 	}

}
