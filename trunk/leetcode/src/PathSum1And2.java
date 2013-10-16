import java.util.ArrayList;


public class PathSum1And2 {

	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 * */
	public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return false;
        }
        return hasPathSumInternal(root, sum);
    }
    
    public boolean hasPathSumInternal(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root.left == null && root.right == null) {
            if(sum == root.val) {
                return true;
            } else {
                return false;
            }
        }
        //this is wrong
        // return hasPathSumInternal(root.left, sum - root.val) || hasPathSumInternal(root.right, sum - root.val);
        boolean left = false;
        if(root.left != null) {
            left = hasPathSumInternal(root.left, sum - root.val);
        }
        if(left) {
            return true;
        }
        boolean right = false;
        if(root.right != null) {
            right = hasPathSumInternal(root.right, sum - root.val);
        }
        return right;
    }
	
	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
	 * */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return results;
        }
        ArrayList<Integer> currList = new ArrayList<Integer>();
        findPathSum(results, currList, root, sum);
         return results;
    }
    
    public void findPathSum(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> currentList, TreeNode node, int sum) {
        if(node.left == null && node.right == null) {
            if(sum == node.val) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.addAll(currentList);
                list.add(node.val);
                results.add(list);
            }
            return;
        }
        if(node.left != null) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(currentList);
            list.add(node.val);
            findPathSum(results, list, node.left, sum - node.val);
        }
        if(node.right != null) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(currentList);
            list.add(node.val);
            findPathSum(results, list, node.right, sum - node.val);
        }
    }
}
