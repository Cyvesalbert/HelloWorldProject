package ht.searchAlgo;

//Testing the merge sort class
public class MergeSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create object to perform merge sort
		MergeSort sortArray = new MergeSort(10);
		
		// print unsorted array
		System.out.println("unsorted:" + sortArray + "\n");
		
		sortArray.sort(); // sort array
		
		// print sorted array
		System.out.println("sorted:	" + sortArray);
	}

}
