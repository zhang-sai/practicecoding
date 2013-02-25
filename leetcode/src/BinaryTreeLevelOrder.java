import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * */
public class BinaryTreeLevelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
		if(root == null) {
			return retList;
		}
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while(!list.isEmpty()) {
        	ArrayList<Integer> iList = new ArrayList<Integer>();
        	for(TreeNode n : list) {
        		iList.add(n.val);
        	}
        	retList.add(iList);
        	list = this.getNextLevel(list);
        }
//        Collections.reverse(retList);
        return retList;
    }
	
	ArrayList<TreeNode> getNextLevel(ArrayList<TreeNode> currLevel) {
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		for(TreeNode node : currLevel) {
			if(node.left != null) {
				nodeList.add(node.left);
			}
			if(node.right != null) {
				nodeList.add(node.right);
			}
		}
		return nodeList;
	}
}
