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
        if(root.left == null && root.right == null) {
            return 1;
        }
        int max = 0;
        if(root.left != null) {
            max = 1 + maxDepth(root.left);
        }
        if(root.right != null) {
            max = Math.max(max, 1 + maxDepth(root.right));
        }
        return max;
    }
	
}
