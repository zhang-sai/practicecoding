/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * */

public class FlattenBinaryTreeToList {
	public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return;
        }
        if(root.left == null) {
        	this.flatten(root.right);
        } else {
        	this.flatten(root.left);
        	this.flatten(root.right); //XXX must flatten both
        	//move the left to right
        	TreeNode tmp = root.right;
        	root.right = root.left;
        	root.left = null;
        	//append to the most right
        	TreeNode right = root.right;
        	while(right.right != null) {
        		right = right.right;
        	}
        	right.right = tmp;
        }
    }
}
