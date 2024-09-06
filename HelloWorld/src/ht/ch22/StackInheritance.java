package ht.ch22;

//StackInheritance extends class List.
public class StackInheritance<T> extends List<T> {

	// no arguments constructors
	public StackInheritance() {
		super("Stack");
	}
	
	// add object to stack
	public void push(T object) {
		insertAtFront(object);
	}
	
	// remove object from stack
	public T pop() throws EmptyListException{
		return removeFromFront();
	}
	
	
	
}
