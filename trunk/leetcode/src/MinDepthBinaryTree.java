
/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * */
public class MinDepthBinaryTree {

	public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
        	return 0;
        }
        //XXX NOTE that the a leaf means the following condition, do not confuse
        if(root.left == null && root.right == null) {
        	return 1;
        }
        int min = Integer.MAX_VALUE;
        if(root.left != null) {
        	min  = Math.min(min, 1 + this.minDepth(root.left));
        }
        if(root.right != null) {
        	min = Math.min(min, 1 + this.minDepth(root.right));
        }
        return min;
    }
	
}
