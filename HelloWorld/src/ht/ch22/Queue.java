package ht.ch22;

//Queue uses class List
public class Queue<T> {

	private List<T> queueList;
	
	// no argument constructor
	public Queue() {
		queueList = new List<T>("queue");
	}
	
	// add object to queue
	public void enqueue(T object) {
		queueList.insertAtBack(object);
	}
	
	// remove object from queue
	public T dequeue() throws EmptyListException{
		return queueList.removeFromFront();
	}
	
	// determine if queue is empty
	public boolean isEmpty() {
		return queueList.isEmpty();
	}
	
	// output queue contents
	public void print() {
		queueList.print();
	}
	
	
	
	
}
