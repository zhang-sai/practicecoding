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
//the need for memory efficiency
//http://meigou.wordpress.com/2013/04/16/leetcode-binary-tree-level-order-traversal/
//https://gist.github.com/eclipse9614/5067681
//http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal

no queue

public class BinaryTreeLevelOrder {
	
	
	/**
	 * get the n-th level one by one
	 * */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if(root == null) {
			return ret;
		}
		int level = 1;
		while(true) {
			ArrayList<Integer> array = new ArrayList<Integer>();
			ArrayList<Integer> list = this.getNodesOfLevel(root,level, array);
			if(array.isEmpty()) {
				break;
			} else {
				ret.add(list);
			}
			level ++;
		}
		
		return ret;
	}
	
	public ArrayList<Integer> getNodesOfLevel(TreeNode node, int level, ArrayList<Integer> array) {
		if(level == 1) {
			array.add(node.val);
			return array;
		} else {
			//ArrayList<Integer> ret = new ArrayList<Integer>();
			if(node.left != null) {
				this.getNodesOfLevel(node.left, level - 1, array);
			}
			if(node.right != null) {
				this.getNodesOfLevel(node.right, level - 1, array);
			}
			return array;
		}
	}
	
	/***
	 * Another way
	 * */
	public ArrayList<ArrayList<Integer>> levelOrder_bfs(TreeNode root) {
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
