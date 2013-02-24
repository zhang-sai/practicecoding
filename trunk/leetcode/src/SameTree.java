/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p == null) {
        	return q == null;
        }
        if(q == null) {
        	return p == null;
        }
        //now p and q are not null
        if(p.val != q.val) {
        	return false;
        }
        if(p.left != null) {
        	if(q.left == null) {
        		return false;
        	}
        	if(!this.isSameTree(p.left, q.left)) {
        		return false;
        	}
        }
        if(p.right != null) {
        	if(q.right == null) {
        		return false;
        	}
        	if(!this.isSameTree(p.right, q.right)) {
        		return false;
        	}
        }
        return true;
    }
}
