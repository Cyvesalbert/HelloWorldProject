package ht.ch22;

import java.util.Random;

//Binary tree test program.
public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree<Integer> tree = new Tree<Integer>();
		int value;
		Random randomNumber = new Random();
		
		System.out.println("Inserting the following values: ");
		
		// insert 10 random integers from 0-99 in tree
		for(int i = 1; i <= 10; i++) {
			value = randomNumber.nextInt(100);
			System.out.printf("%d ", value);
			tree.insertNode(value);
		}
		
		System.out.println("\n\nPreorder traversal");
		tree.preorderTraversal(); // perform preorder traversal of tree
		
		System.out.println("\n\nInorder traversal");
		tree.inorderTraversal();; // perform Inorder traversal of tree
		
		System.out.println("\n\nPostorder traversal");
		tree.postorderTraversal();; // perform Postorder traversal of tree
		System.out.println();
	}

}
