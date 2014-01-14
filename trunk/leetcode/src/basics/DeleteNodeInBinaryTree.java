package basics;

import util.Utils;
import linkedin.TreeNode;

//http://www.algolist.net/Data_structures/Binary_search_tree/Removal


public class DeleteNodeInBinaryTree {

//	static class TreeNode {
//	     int val;
//	     TreeNode left;
//	     TreeNode right;
//	     TreeNode(int x) { val = x; }
//	     public String toString() {return val + ""; }
//	     
//	     int elem = 0;
//	     TreeNode parent;
//	     TreeNode succ;
//	}
	
	
	/**
	 * if the tree has only 1 subtree, lift that subtree
	 * 
	 *           root
	 *          /
	 *         left
	 *         
	 *  if the node has right subtree, then get the smallest one in the right tree
	 *  as the node
	 *  
	 *  three possibilities:
	 *  1. has no children
	 *  2. has 1 child
	 *  3. has two children
	 *  
	 * 
	 * */
	public static TreeNode delete(TreeNode root, int val) {
		TreeNode parent = null;
		TreeNode node = root;
		while(node != null) {
			if(node.val == val) {
				break;
			} else if(node.val > val) {
				parent = node;
				node = node.left;
			} else {
				parent = node;
				node = node.right;
			}
		}
		//did not find it
		if(node == null) {
			System.out.println("Canot find the node with value: " + val);
			return root;
		}
		//find the value and need to delete it
		if(node.left == null && node.right == null) {
			if(parent == null) {
				//delete the root
				return null;
			} else if(parent.left == node) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (node.left == null || node.right == null) {	
			//if the node has 1 child
			if(parent == null) {
				//delete the root
				root = node.left == null ? node.right : node.left;
				return root;
			} else if (parent.left == node) {
				parent.left = node.left == null ? node.right : node.left;
			} else {
				parent.right = node.left == null ? node.right : node.left;
			}
		} else {
			//if the node has two children
			int min = findMin(node.right);
			delete(root, min);
			node.val = min;
		}
		
		return root;
	}
	
	private static int findMin(TreeNode node) {
		if(node.left == null) {
			return node.val;
		} else {
			return findMin(node.left);
		}
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
		
		System.out.println("delete: " + 20);
		root = delete(root, 20);
		System.out.println(Utils.serialize(root));
		System.out.println();
		
		System.out.println("delete: " + 4);
		root = delete(root, 4);
		System.out.println(Utils.serialize(root));
		System.out.println();
		
		System.out.println("delete: " + 3);
		root = delete(root, 3);
		System.out.println(Utils.serialize(root));
		
		System.out.println("delete: " + 5);
		root = delete(root, 5);
		System.out.println(Utils.serialize(root));
		System.out.println();
		
		System.out.println("delete: " + 6);
		root = delete(root, 6);
		System.out.println(Utils.serialize(root));
	}
	
}
