package linkedin;

import util.Utils;

public class CreateMirrorTree {

	public static TreeNode cloneTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode newNode = new TreeNode(root.val);
		newNode.left = cloneTree(root.right);
		newNode.right = cloneTree(root.left);
		return newNode;
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
		
		TreeNode newNode = cloneTree(root);
		
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
		
		/**
		 *      0
		 *     /  \
		 *    2    1
		 *    \    / \
		 *     5   4  3
		 *    /
		 *   6
		 * 
		 * */
		System.out.println(Utils.serialize(newNode));
		
		
	}
	
}
