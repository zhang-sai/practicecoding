import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * */
//XXX some tricks in 
public class BinaryTreeZigZagTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
		if(root == null) {
			return retList;
		}
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        boolean leftToRight = false;
        while(!list.isEmpty()) {
        	ArrayList<Integer> iList = new ArrayList<Integer>();
        	for(TreeNode n : list) {
        		iList.add(n.val);
        	}
        	retList.add(iList);
        	list = this.getNextLevel(list, leftToRight);
        	leftToRight = !leftToRight;
        }
        return retList;
        
    }
	
	ArrayList<TreeNode> getNextLevel(ArrayList<TreeNode> currLevel, boolean leftToRight) {
		System.out.println("leftoright? " + leftToRight +  ", current list: " + currLevel);
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
//		if(leftToRight) {
		//XXX note that no matter in which order, you must reverse the list
		//since the next traversal order is ALWAYS different than the previous one
			Collections.reverse(currLevel);
//			System.out.println("   -- reversed current list: " + currLevel);
//		}
		for(TreeNode node : currLevel) {
			if(leftToRight) {
			    if(node.left != null) {
				    nodeList.add(node.left);
			    }
			    if(node.right != null) {
				    nodeList.add(node.right);
			    }
			} else {
			    if(node.right != null) {
				    nodeList.add(node.right);
			    }
			    if(node.left != null) {
				    nodeList.add(node.left);
			    }
			}
		}
		return nodeList;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n2.left = n4;
		n3.right = n5;
		root.left = n2;
		root.right = n3;
		BinaryTreeZigZagTraversal t = new BinaryTreeZigZagTraversal();
		System.out.println(t.zigzagLevelOrder(root));
	}
}
