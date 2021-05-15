package io.practise.algo;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
	}
	
	public void traversePreOrder(Node tree) {
		if(tree == null) {
			return;
		}
		System.out.print(tree.data + " ");
		traversePreOrder(tree.left);
		traversePreOrder(tree.right);
	}

	public Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		/*
		 * Scanner sc=new Scanner(System.in); int T=sc.nextInt();
		 */
		Node root = null;
		int t[] = { 3, 5, 4, 7, 2, 1 };
		LevelOrderTraversal sol = new LevelOrderTraversal();
		for (int i = 0; i < t.length; i++) {
			// int data=sc.nextInt();
			root = sol.insert(root, t[i]);
		}

		sol.levelOrder(root);
		
		System.out.println();
		sol.traversePreOrder(root);

	}
}