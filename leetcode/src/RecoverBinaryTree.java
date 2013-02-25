/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
XXX
 * */

xxx
public class RecoverBinaryTree {
	public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
        	return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != null && right != null) {
        	if(right.val < left.val) {
        		//find and return
        		root.left = right;
        		root.right = left;
        		return;
        	}
        } else {
        	if(left != null) {
        		this.recoverTree(left);
        	}
        	if(right != null) {
        		this.recoverTree(right);
        	}
        }
    }
}
