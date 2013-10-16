
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
		currentMax = Integer.MIN_VALUE;
		this.computeMax(root);
		return currentMax;
    }
    
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
        
        if (Math.max(l,r)>0) {
            return (Math.max(l,r)+root.val);
        }
        else {
            return root.val;
        }
         
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