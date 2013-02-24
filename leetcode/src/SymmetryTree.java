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
        TreeNode left = root.left;
        TreeNode right = root.right;
        return this.isSymmetric(left, right);
    }
	
	public boolean isSymmetric(TreeNode node1, TreeNode node2) {
		if(node1== null) {
			return node2 == null;
		}
		if(node2 == null) {
			return node1 == null;
		}
		if(node1.val != node2.val) {
			return false;
		}
		if(node1.left != null) {
			if(node2.right == null) {
				return false;
			}
			if(!this.isSymmetric(node1.left, node2.right)) {
				return false;
			}
		} else {
			//XXX do not forget
			if(node2.right != null) {
				return false;
			}
		}
		if(node1.right != null) {
			if(node2.left == null) {
				return false;
			}
			if(!this.isSymmetric(node1.right, node2.left)) {
				return false;
			}
		} else {
			//DO not forget this
			if(node2.left != null) {
				return false;
			}
		}
		return true;
	}
}
