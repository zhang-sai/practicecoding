import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 * */
public class SumRootToLeaf {
	public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return 0;
        }
        int[] vals = new int[]{0};
        sumNumbers(root, vals, 0);
        return vals[0];
    }
    
    public void sumNumbers(TreeNode root, int[] num, int currVal) {
        currVal = currVal * 10 + root.val;
        if(root.left == null && root.right == null) {
            num[0] = num[0] + currVal;
            return;
        } else {
            if(root.left!=null) {
                sumNumbers(root.left, num, currVal);
            }
            if(root.right!=null) {
                sumNumbers(root.right, num, currVal);
            }
        }
    }
}
