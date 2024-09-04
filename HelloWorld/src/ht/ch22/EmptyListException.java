package ht.ch22;

//Class EmptyListException declaration
public class EmptyListException extends RuntimeException {

	// no argument constructor
	public EmptyListException() {
		this("list"); // call other EmptyListException constructor
	}
	
	// one argument constructor
	public EmptyListException(String name) {
		super(name + " is empty"); // call super class constructor
	}
	
	
	
	
	
}
