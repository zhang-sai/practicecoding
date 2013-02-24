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
	public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(root == null) {
			return true;
		}
		if(root.left != null) {
			if(!this.validateBound(root.left, Integer.MIN_VALUE, root.val)) {
				return false;
			}
		}
		if(root.right != null) {
			if(!this.validateBound(root.right, root.val, Integer.MAX_VALUE)) {
				return false;
			}
		}
		return true;
    }
	
	private boolean validateBound(TreeNode node, int lower, int upper) {
//		System.out.println("checking: " + node + ", lower: " + lower + ", upper: " + upper);
		if(node.val <= lower || node.val >= upper) {
//			System.out.println("    invalidate: " + node + ", lower: " + lower + ", upper: " + upper);
			return false;
		}
		if(node.left != null) {
			if(!this.validateBound(node.left, lower, node.val)) { //XXX the change of bound is critical
				return false;
			}
		}
		if(node.right != null) {
			if(!this.validateBound(node.right, node.val, upper)) {
				return false;
			}
		}
		return true;
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
