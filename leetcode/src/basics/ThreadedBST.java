package basics;

import util.Utils;
import linkedin.TreeNode;

/**
 * Construct a threaded BST and do traversal
 * 
 * if there is no left, make the left point to the previous vsitied ones
 * if there is no right, make the right point to the next node
 * 
 * http://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion
 * */

/**
 * difficult to achieve constant time and space.
 * */

public class ThreadedBST {

	
	public static TreeNode buildThreadedBST(TreeNode root) {
//		System.out.println("Building threaded BST");
		if(root == null) {
			return null;
		}
		TreeNode leftPrev = buildThreadedBST(root.left);
		if(leftPrev != null) {
			 TreeNode iter = leftPrev;
			 /**
			  *      0
			  *     /
			  *    1
			  *     \
			  *      2
			  *      
			  *      
			  *      0
			  *     /
			  *    1
			  * */
		     while(iter.right != null && iter.right != leftPrev) {
		            iter = iter.right;
		     }
		     iter.right = root;
		}
		
		TreeNode rightPrev = buildThreadedBST(root.right);
	    if(rightPrev != null) {
	        TreeNode iter = rightPrev;
	        while(iter.right != null && iter.right != rightPrev) {
	            iter = iter.right;
	        }
	 
	        iter.right = root;
	    }
	 
	    return root;
	}
	
	public static void resetRightmost(TreeNode root) {
		TreeNode node = root;
		while(node.right != root) {
			node = node.right;
		}
		node.right = null;
	}
	
	public static void traverse_in_order(TreeNode root) {
		System.out.println("Start traversal.");
		//go to the first node
		TreeNode node = root;
		while(node.left != null) {
		    node = node.left;
		}
		while(node != null) {
//			System.out.println(node.val);
//			node = getNextNode(node);
//			if(node.left == null) {
//				System.out.println(node.val);
//				node = node.right;
//			} else {
//				node = node.left;
//			}
		}
	}
	
	private static TreeNode getNextNode(TreeNode node) {
		return null;
	}
	
	public static void main(String[] args) {
		TreeNode n3 = new TreeNode(3);
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		TreeNode root = n3;
		
		root.left = n1;
		root.right = n6;
		
		n1.left = n0;
		n1.right = n2;
		
		n6.left = n4;
		n4.right = n5;
		
		/**
		 *        3
		 *      /   \
		 *     1     6
		 *    / \   /
		 *   0   2  4
		 *           \
		 *            5   
		 * 
		 * */
		
		System.out.println(Utils.serialize(root));
		System.out.println();
		
		buildThreadedBST(root);
		resetRightmost(root);
		
		
		System.out.println("n0: " + n0.left + ", " + n0.right);
		System.out.println("n2: " + n2.left + ", " + n2.right);
		System.out.println("n6: " + n6.left + ", " + n6.right);
		System.out.println("n4: " + n4.left + ", " + n4.right);
		System.out.println("n5: " + n5.left + ", " + n5.right);
		
		
		traverse_in_order(root);
	}
}
