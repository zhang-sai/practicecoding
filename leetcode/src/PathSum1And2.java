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
        if(root.left == null && root.right == null && root.val == sum) {
        	return true;
        }
        if(root.left != null) {
        	if(this.hasPathSum(root.left, sum - root.val)) {
        		return true;
        	}
        }
        if(root.right != null) {
        	return this.hasPathSum(root.right, sum - root.val);
        }
        return false;
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
        if(root == null) {
        	return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<ArrayList<Integer>>();
        this.pathSum(root, sum, new ArrayList<Integer>(), allPaths);
        return allPaths;
    }
	
	public void pathSum(TreeNode root, int sum, ArrayList<Integer> currPath,
			ArrayList<ArrayList<Integer>> allPaths) {
		if(root.left == null && root.right == null && root.val == sum) {
			ArrayList<Integer> list = (ArrayList<Integer>) currPath.clone();
			list.add(root.val);
			allPaths.add(list);
		} else {
			if(root.left != null) {
				ArrayList<Integer> list = (ArrayList<Integer>) currPath.clone();
				list.add(root.val);
				this.pathSum(root.left, sum - root.val, list, allPaths);
			}
			if(root.right != null) {
				ArrayList<Integer> list = (ArrayList<Integer>) currPath.clone();
				list.add(root.val);
				this.pathSum(root.right, sum - root.val, list, allPaths);
			}
		}
	}
}
