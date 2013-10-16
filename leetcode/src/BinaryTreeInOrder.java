import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // stack.push(root);
        //first left than right
        TreeNode current = root;
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                list.add(current.val);
                TreeNode currentRight = current.right;
                current = currentRight;
                // if(currentRight != null) {
                //     stack.push(currentRight);
                // }
            }
        }
        
        return list;
    }
}
