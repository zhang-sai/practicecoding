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
	
//	public static void main(String[] args) {
//		TreeNode n1 = new TreeNode(1);
//		TreeNode n2 = new TreeNode(2);
//		TreeNode n3 = new TreeNode(3);
//		TreeNode n4 = new TreeNode(4);
//		TreeNode n5 = new TreeNode(5);
//		
//		n1.right = n2;
//		n2.left = n3;
//		n2.right = n4;
//		n4.left = n5;
//	
//		System.out.println(inorderTraversal_1(n1));
//	}
//	
//	public static ArrayList<Integer> inorderTraversal_1(TreeNode root) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//        if(root == null) {
//            return list;
//        }
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//         stack.push(root);
//        //first left than right
//        while(!stack.isEmpty()) {
//        	System.out.println(stack);
//        	TreeNode curr = stack.peek();
//        	System.out.println("top: " + curr.val);
//        	if(curr.left == null && curr.right == null) {
//        		list.add(curr.val);
//        		stack.pop();
//        		continue;
//        	}
//        	
//        	if(curr.left != null) {
//        		System.out.println("push left: " + curr.left.val);
//        		stack.push(curr.left);
//        	} else {
//        		list.add(curr.val);
//        		stack.pop();
//        		if(curr.right != null) {
//        			System.out.println("push right: " + curr.right.val);
//        			stack.push(curr.right);
//        		}
//        	}
//        }
//        
//        return list;
//	}
	
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
