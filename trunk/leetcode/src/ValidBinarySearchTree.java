/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

» Solve this problem
 * */
public class ValidBinarySearchTree {
	 public boolean isValidBST(TreeNode root, int min, int max) {
	        if(root == null) {
	            return true;
	        }
	        if(root.val <= min || root.val >= max) {
	            return false;
	        }
	        boolean isLeftBST = isValidBST(root.left, min, Math.min(max, root.val));
	        if(!isLeftBST) {
	            return false;
	        }
	        boolean isRightBST = isValidBST(root.right, Math.max(min, root.val), max);
	        return isRightBST;
	    }
	    
	    public boolean isValidBST(TreeNode root) {
	        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }
	
	public static void main(String[] args) {
		ValidBinarySearchTree v = new ValidBinarySearchTree();
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(1);
		TreeNode n0 = new TreeNode(0);
		TreeNode n2 = new TreeNode(2);
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		n1.left = n0;
		n1.right = n2;
		
		n5.left = n4;
		n5.right = n6;
		
		root.left = n1;
		root.right = n5;
		System.out.println(v.isValidBST(root));
	}
}
