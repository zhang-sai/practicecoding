import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 * */
public class BinaryTreeInOrder {
	
	//XXX a non-recursive version
	//http://leetcode.com/2010/04/binary-search-tree-in-order-traversal.html
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		List<TreeNode> stack = new LinkedList<TreeNode>();
		if(root == null) {
			return ret;
		}
		TreeNode node = root;
		while(true) {
			while(node != null) {
				stack.add(0, node);
				node = node.left;
			}
			//check
			if(stack.isEmpty()) {
				break;
			} else {
				TreeNode n = stack.remove(0);
				ret.add(n.val);
				node = n.right; //XXX go to the next
			}
		}
		return ret;
	}
	
	//XXX a recursive version
	public ArrayList<Integer> inorderTraversal_recursive(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if(root == null) {
			return ret;
		}
        this.traverseInOrder(root, ret);
        return ret;
    }
	
	public void traverseInOrder(TreeNode node, ArrayList<Integer> list) {
		if(node.left != null) {
			this.traverseInOrder(node.left, list);
		}
		list.add(node.val);
		if(node.right != null) {
			this.traverseInOrder(node.right, list);
		}
	}
}
