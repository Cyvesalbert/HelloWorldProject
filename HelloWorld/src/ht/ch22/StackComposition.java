package ht.ch22;

//StackComposition uses a composed List object.
public class StackComposition<T> {
	private List<T> stackList;
	
	// no argument constructor
	public StackComposition() {
		stackList = new List<T>("Stack");
	}

	// add object to stack
	public void push(T object) {
		stackList.insertAtFront(object);
	}
	
	// remove object from stack
	public T pop() throws EmptyListException{
		return stackList.removeFromFront();
	}
	
	// determine if stack is empty
	public boolean isEmpty() {
		return stackList.isEmpty();
	}
	
	// output stack contents
	public void print() {
		stackList.print();
	}
}
