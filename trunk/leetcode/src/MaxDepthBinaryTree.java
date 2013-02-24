/**
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * */
public class MaxDepthBinaryTree {
	public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
        	return 0;
        }
        int maxDepth = 1;
        if(root.left != null) {
        	maxDepth += this.maxDepth(root.left);
        }
        if(root.right != null) {
        	maxDepth = Math.max(maxDepth, 1 + this.maxDepth(root.right));
        }
        
        return maxDepth;
    }
	
}
