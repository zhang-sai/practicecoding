/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
 * 
 * */
public class SymmetryTree {
	public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if((left==null && right!=null) || (left!=null && right == null)) {
            return false;
        }
        if(left != null) {
            return left.val == right.val && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
        }
        
        return true;
    }
}
