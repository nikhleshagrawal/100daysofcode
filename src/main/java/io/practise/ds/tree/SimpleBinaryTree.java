package io.practise.ds.tree;

/**
 * A binary tree is a tree data structure in which each parent node can have at
 * most two children
 * 
 * Binary Tree Applications
 * 
 * For easy and quick access to data
 * In router algorithms
 * To implement heap data structure
 * Syntax tree
 *
 */
public class SimpleBinaryTree {

	class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
		}

	}
	
	Node root;

	public void traversePreOrder(Node tree) {
		if(tree == null) {
			return;
		}
		System.out.print(tree.data + "->");
		traversePreOrder(tree.left);
		traversePreOrder(tree.right);
	}

	public void traversePostOrder(Node tree) {
		if(tree == null) {
			return;
		}
		traversePostOrder(tree.left);
		traversePostOrder(tree.right);
		
		System.out.print(tree.data+ "->");
	}

	public void traverseInOrder(Node tree) {
		if(tree == null) {
			return;
		}
		
		traverseInOrder(tree.left);
		System.out.print(tree.data+ "->");
		traverseInOrder(tree.right);
	}
	
	public void create(SimpleBinaryTree tree) {

		  tree.root = new Node(1) ;
		  tree.root.left = new Node(12);
		  tree.root.right = new Node(9);
		  tree.root.left.left = new Node(5);
		  tree.root.left.right = new Node(6);
		 
	}

	public static void main(String[] args) {
		
		SimpleBinaryTree tree = new SimpleBinaryTree();
		tree.create(tree);
		
		tree.traversePreOrder(tree.root);
		System.out.println();
		tree.traverseInOrder(tree.root);
		System.out.println();
		tree.traversePostOrder(tree.root);
	}

}
