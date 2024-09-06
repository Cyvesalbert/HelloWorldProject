package ht.ch22;

//Stack manipulation program.
public class StackInheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackInheritance<Integer> stack = new StackInheritance<Integer>();
		
		// use push method
		stack.push( -1 );
		stack.print();
		stack.push( 0 );
		stack.print();
		stack.push( 1 );
		stack.print();
		stack.push( 5 );
		stack.print();
		
		// remove items from stack
		try {
			int removedItem;
			
			while(true) {
				removedItem = stack.pop(); // use pop method
				System.out.printf("\n%d popped\n", removedItem);
				stack.print();
			}
		}catch(EmptyListException emptyListException) {
			emptyListException.printStackTrace();
		}
		
	}

}
