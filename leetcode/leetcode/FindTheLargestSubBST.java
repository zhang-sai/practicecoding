
/**
 * 
 * http://leetcode.com/2010/11/largest-binary-search-tree-bst-in.html
 * for a node, it must contain all its decendant
 * */
public class FindTheLargestSubBST {

	int min = Integer.MIN_VALUE;
	int max = Integer.MAX_VALUE;
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
	
	/***
	 * Find the largest BST, NOT necessarily containing all the decendants.
	 * */
	TreeNode child = null;
	
	public int findLargestBST(TreeNode p, int min, int max) {
        if (p != null) {
        	return 0;
        }
        if (min < p.val && p.val < max) {
              int leftNodes = findLargestBST(p.left, min, p.val);
              TreeNode leftChild = (leftNodes == 0) ? null : child;
              int rightNodes = findLargestBST(p.right, p.val, max);
              TreeNode rightChild = (rightNodes == 0) ? null : child;
              
              // create a copy of the current node and 
              // assign its left and right child.
              TreeNode parent = new TreeNode(p.val);
              parent.left = leftChild;
              parent.right = rightChild;
              
              // pass the parent as the child to the above tree.
              /**
               * The largest child tree so far
               * */
              child = parent;
              
              int totalNodes = leftNodes + rightNodes + 1;
              if (totalNodes > maxNodes) {
                  maxNodes = totalNodes;
                  largestBST = parent;
              }
              return totalNodes;
       } else {
         // include this node breaks the BST constraint,
         // so treat this node as an entirely new tree and 
         // check if a larger BST exist in this tree
    	 min = Integer.MIN_VALUE;
    	 max = Integer.MAX_VALUE;
    	 //XXX the most important part!!!
         findLargestBST(p, min, max);
         //must return 0 to exclude this node
         return 0;
       }
    }
}
