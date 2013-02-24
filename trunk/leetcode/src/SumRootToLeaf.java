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
		if(root == null) {
			return 0;
		}
        return this.computeValue(root, 0);
		
    }
	
	public int computeValue(TreeNode node, int currValue) {
		int v = currValue*10;
		v+=node.val;
		
		if(node.left == null && node.right == null) {
			return v;
		}
		
		int retValue = 0;
		if(node.left != null) {
			retValue += this.computeValue(node.left, v);
		}
		if(node.right != null) {
			retValue += this.computeValue(node.right, v);
		}
		
		return retValue;
	}
}
