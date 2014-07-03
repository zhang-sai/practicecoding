
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

//Related question: FindAllPathsSumToAValue
public class BinaryTreeMaxPathFromAnyNode {
	
    int currentMax = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		currentMax = Integer.MIN_VALUE;
		this.computeMax(root);
		return currentMax;
    }
    
	/**
	 * The max value of include this node:
	 * (1) node + left + right
	 * (2) node + left or right (if one is > 0)
	 * (3) node  (if both left and right is < 0)
	 * 
	 * */
    int computeMax(TreeNode root){
         
        if (root == null) {
            return 0;
        }
        int l = computeMax(root.left);
        int r = computeMax(root.right);
        int m = root.val;
        if (l>0) {
            m+=l;
        }
        if (r>0) {
            m+=r;
        }
         
        currentMax = Math.max(currentMax,m);
        
        //just include this node, and go up
        if (Math.max(l,r)>0) {
            return (Math.max(l,r)+root.val);
        }
        else {
            return root.val;
        }
         
    }
	

	public static void main(String[] args) {
		BinaryTreeMaxPathFromAnyNode search = new BinaryTreeMaxPathFromAnyNode();
		TreeNode root = new TreeNode(0);
		TreeNode l = new TreeNode(1);
		TreeNode r = new TreeNode(1);
		root.left = l;
		root.right = r;
		int t = search.maxPathSum(root);
		System.out.println(t);
	}
}