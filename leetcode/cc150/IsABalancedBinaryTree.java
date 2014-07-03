/**
 * Given a tree, check whether it is a balanced binary tree
 * */
public class IsABalancedBinaryTree {

	/**
	 * In the worst case, it is O(n^2), for a skewed tree
	 * 
	 * */
	
	/**
	 * An O(n) solution, by precompute heights for all nodes
	 * */
	//http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
	public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right != null) {
            if(root.right.left != null || root.right.right != null) {
                return false;
            }
        }
        if(root.right == null && root.left != null) {
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
