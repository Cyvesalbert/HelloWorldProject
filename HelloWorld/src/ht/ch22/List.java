//ListNode and List class declarations.
package ht.ch22;


//class to represent one node in a list
class ListNode<T>{
	// package access members; list can access these directly
	T data; // data for this node
	ListNode<T> nextNode; // reference to the next node in the list
	
	// constructor creates ListNode that refers to object
	ListNode(T object){
		this(object, null);
	}
	
	// constructor creates ListNode that refers to the specified object and to the next ListNode
	ListNode(T object, ListNode<T> node){
		data = object;
		nextNode = node;
	}
	
	// return reference to data in node
	T getData() {
		return data; // return item in this node
	}
	
	//return reference to next Node in list
	ListNode<T> getNext(){
		return nextNode; //get Next node
	}
}

public class List<T> {
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name; // String like list used in printing
	
	// constructor creates empty list with list as the name
	public List() {
		this("List");
	}
	
	// constructor creates an empty list with a name
	public List(String listName) {
		name = listName;
		firstNode = lastNode = null;
	}
	
	// insert item at front of list
	public void insertAtFront(T insertItem) {
		if(isEmpty()) // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<T>(insertItem);
		else // firstNode refers to new node
			firstNode = new ListNode<T>(insertItem, firstNode);
	}
	
	// insert item at the end of List
	public void insertAtBack(T insertItem) {
		if(isEmpty()) // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<T>(insertItem);
		else // lastNode's nextNode refers to new node
			lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
	}
	
	// remove first node from List
	public T removeFromFront( ) throws EmptyListException {
		if(isEmpty()) // throw exception if list is empty
			throw new EmptyListException(name);
		
		T removedItem = firstNode.data; // retrieve data being removed
		
		// update references firstNode and lastNode
		if(firstNode == lastNode)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;
		
		return removedItem; // return removed node data
		}
	
	// remove last node from list
	public T removeFromBack() throws EmptyListException{
		if(isEmpty()) // throw exception if list is empty
			throw new EmptyListException(name);
		
		T removedItem = lastNode.data; // retrieve data being removed 
		
		// update references firstNode and lastNode
		if(firstNode == lastNode)
			firstNode = lastNode = null;
		else {// locate new last node
			ListNode<T> current = firstNode;
			
			// loop while current node does not refer to lastNode
			while(current.nextNode != lastNode)
				current = current.nextNode;
			
			lastNode = current; // current is new lastNode
			current.nextNode = null;
		}
		
		return removedItem; // return removed node data
		}
	
	// determine whether list is empty
	public boolean isEmpty() {
		return firstNode == null; // return true if list is empty
	}
	
	// output list contents
	public void print() {
		if(isEmpty()) {
			System.out.printf("Empty %s\n", name);
			return;
		}
		
		System.out.printf("The %s is: ", name);
		ListNode<T> current = firstNode;
		
		// while not at end of list, output current node's data
		while(current != null) {
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}
		
		System.out.println("\n");
	}
}

