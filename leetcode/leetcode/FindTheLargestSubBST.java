
/**
 * 
 * http://leetcode.com/2010/11/largest-binary-search-tree-bst-in.html
 * for a node, it must contain all its decendant
 * */
public class FindTheLargestSubBST {

	int min = 0;
	int max = 0;
	int maxNodes = Integer.MIN_VALUE;
	TreeNode largestBST;
	
	public int findLargestBSTSubtree(TreeNode p) {
        if (p == null) {
    	    return 0;
        }
        boolean isBST = true;
        //take a look at the left part
        int leftNodes = findLargestBSTSubtree(p.left); //this will update the min and max
        int currMin = (leftNodes == 0) ? p.val : min;
        if (leftNodes == -1 || (leftNodes != 0 && p.val <= max)) {
                isBST = false;
        }
        //take a look at the right part
        int rightNodes = findLargestBSTSubtree(p.right); //it will update the max
        int currMax = (rightNodes == 0) ? p.val : max;
        if (rightNodes == -1 || (rightNodes != 0 && p.val >= min)) {
               isBST = false;
        }
        //if it is a bst when combining the current node
        if (isBST) {
             min = currMin;
             max = currMax;
             int totalNodes = leftNodes + rightNodes + 1;
             if (totalNodes > maxNodes) {
                  maxNodes = totalNodes;
                  largestBST = p;
            }
            return totalNodes;
        } else {
            return -1;   // This subtree is not a BST
        }
    }
}
