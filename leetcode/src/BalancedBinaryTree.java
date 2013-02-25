/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * */
public class BalancedBinaryTree {
	//XXX this is a low-efficient algorithm
	//need to a non-recursive one
	public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(root == null) {
			return true;
		}
		
		//add some short cut here
		//XXX ADD such tricks works
		if(root.left == null && root.right != null) {
			if(root.right.left != null || root.right.right != null) {
				return false;
			}
		}
		if(root.left != null && root.right == null) {
			if(root.left.left != null || root.left.right != null) {
				return false;
			}
		}
		
		if(root.left != null) {
			if(!this.isBalanced(root.left)) {
				return false;
			}
		}
		if(root.right != null) {
			if(!this.isBalanced(root.right)) {
				return false;
			}
		}
		int maxLeft = this.maxDepth(root.left);
		int maxRight = this.maxDepth(root.right);
		if(Math.abs(maxRight - maxLeft) > 1) {
			return false;
		}
		return true;
    }
	
	private int maxDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int max = 1;
		if(node.left != null) {
			max = 1 + this.maxDepth(node.left);
		}
		if(node.right != null) {
			max = Math.max(max, 1 + this.maxDepth(node.right));
		}
		return max;
	}
}
