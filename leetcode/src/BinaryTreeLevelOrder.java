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


public class BinaryTreeLevelOrder {
	
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
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return retList;
        }
        ArrayList<TreeNode> currList = new ArrayList<TreeNode>();
        //add the root to the currList
        currList.add(root);
        ArrayList<TreeNode> nextList = new ArrayList<TreeNode>();
        //iterate through the currList
        while(!currList.isEmpty()) {
            ArrayList<Integer> values = new ArrayList<Integer>();
            for(TreeNode node : currList) {
                values.add(node.val);
                if(node.left!=null) {
                    nextList.add(node.left);
                }
                if(node.right != null) {
                    nextList.add(node.right);
                }
            }
            currList.clear();
            currList.addAll(nextList);
            nextList.clear();
            retList.add(values);
        }
        return retList;
    }
	
	
	/**
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
	 * */
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return retList;
        }
        int maxHeight = maxHeight(root);
        for(int i = maxHeight; i >=1; i--) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            //get the level
            getLevel(i, root, list);
            retList.add(list);
        }
        return retList;
    }
    
	
	/***
	 * Proof, it is still O(n)
	 * 
	 * Although the DFS solution traverse the same node multiple times, it is not another order slower than the BFS solution. Here is the proof that the DFS solution above runs in O(N) time, where N is the number of nodes in the binary tree and we assume that the binary tree is balanced.

We first compute the complexity of printLevel for the kth level:

T(k) = 2T(k-1) + c
     = 2k-1 T(1) + c
     = 2k-1 + c
Assuming it’s a balanced binary tree, then it would have a total of lg N levels.

Therefore, the complexity of printing all levels is:

T(1) + T(2) + ... + T(lg N)
= 1 + 2 + 22 + ... + 2lg N-1 + c
= O(N)
	 * 
	 * */
    public void getLevel(int level, TreeNode node, ArrayList<Integer> list) {
        if(node == null) {
            return;
        }
        if(level != 1) {
            getLevel(level - 1, node.left, list);
            getLevel(level - 1, node.right, list);
        } else {
            list.add(node.val);
        }
    }
    
    public int maxHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int max = 0;
        if(root.left != null) {
            max = 1 + maxHeight(root.left);
        }
        if(root.right != null) {
            max = Math.max(max, 1 + maxHeight(root.right));
        }
        return max;
    }
}
