
/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * */
public class BinaryTreeMaxPath {
	
	int currentMax = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int max = this.computeMax(root);
		return currentMax;
    }
	
	
	private int computeMax(TreeNode node) {
		int value = node.val;
		if(node.left != null) {
			int leftMax = this.computeMax(node.left);
			if(leftMax >= 0) {
				value = value + leftMax;
			}
		}
		if(node.right != null) {
			int rightMax = this.computeMax(node.right);
			if(rightMax >= 0) {
				value = value + rightMax;
			}
		}
		
		if(value > currentMax) {
			currentMax = value;
		}
		return value;
	}
	

	public static void main(String[] args) {
		BinaryTreeMaxPath search = new BinaryTreeMaxPath();
		TreeNode root = new TreeNode(0);
		TreeNode l = new TreeNode(1);
		TreeNode r = new TreeNode(1);
		root.left = l;
		root.right = r;
		int t = search.maxPathSum(root);
		System.out.println(t);
	}
}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}