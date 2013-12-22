package basics;

import util.Utils;
import linkedin.TreeNode;

//http://www.algolist.net/Data_structures/Binary_search_tree/Removal

xx
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
			return root;
		}
		//find the value and need to delete it
		if(node.left == null && node.right == null) {
			if(parent == null) {
				//delete the root
				root = null;
				return root;
			} else if(parent.left == node) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (node.left == null || node.right == null) {	
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
			//has two children
			//find the min value in the right tree
			TreeNode rightSub = node.right;
			TreeNode rightParent = node;
			int min = rightSub.val;
			while(rightSub != null) {
				if(rightSub.left != null) {
					rightParent = rightSub;
					rightSub = rightSub.left;
					min = rightSub.val;
				}
			}
			//get the min
			node.val = min;
			//disconnect the min from the rightSub
			if(rightSub.right != null) {
				if(rightParent.right == rightSub) {
					rightParent.right = rightSub.right;
				} else {
					rightParent.right = rightSub.left;
				}
			} else {
				if(rightParent.right == rightSub) {
					rightParent.right = null;
				} else {
					rightParent.left = null;
				}
			}
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		root.left = n1;
		root.right = n2;
		
		n1.left = n3;
		n1.right = n4;
		
		n2.left = n5;
		n5.right = n6;
		
		/**
		 *        0
		 *      /   \
		 *     1     2
		 *    / \   /
		 *   3   4  5
		 *           \
		 *            6   
		 * 
		 * */
		
		System.out.println(Utils.serialize(root));
		
		System.out.println("delete: " + 20);
		
		root = delete(root, 20);
		System.out.println(Utils.serialize(root));
		
		System.out.println("delete: " + 4);
		
		root = delete(root, 4);
		System.out.println(Utils.serialize(root));
		
		System.out.println("delete: " + 0);
		
		root = delete(root, 0);
		System.out.println(Utils.serialize(root));
		
		System.out.println("delete: " + 5);
		
		root = delete(root, 5);
		System.out.println(Utils.serialize(root));
		
		System.out.println("delete: " + 1);
		
		root = delete(root, 1);
		System.out.println(Utils.serialize(root));
	}
	
}
