import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * */
public class ConstructBinaryTrees {

	/**
	 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
	 * */
	//http://leetcode.com/2011/04/construct-binary-tree-from-inorder-and-preorder-postorder-traversal.html
	public TreeNode buildTree1(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return null;
    }
	
	/**
	 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

preorder = {7,10,4,3,1,2,8,11} //7 is the first element

inorder = {4,10,3,1,7,11,8,2}

	 * */
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		 if(preorder.length == 0) {
			 return null;
		 }
	        // Start typing your Java solution below
	        // DO NOT write main() function
	     List<Integer> preorderList = new ArrayList<Integer>();
	     List<Integer> inorderList = new ArrayList<Integer>();
	     for(int i = 0 ; i < preorder.length; i++) {
	    	 preorderList.add(preorder[i]);
	    	 inorderList.add(inorder[i]);
	     }
		 //build the tree recursively
		 return this.createBinaryTree(preorderList, inorderList);
	 }
	 
	 TreeNode createBinaryTree(List<Integer> preorder, List<Integer> inorder) {
		 if(preorder.size() != inorder.size() || preorder.size() == 0) {
			 throw new Error("size : " + preorder.size() + ", inorder size: " + inorder.size());
		 }
		 int pivot = preorder.get(0);
		 TreeNode node = new TreeNode(pivot);
		 int pivotIndex = inorder.indexOf(pivot);
		 
		 int leftSize = pivotIndex;
		 if(pivotIndex > 0) {
			 //has left
			 TreeNode left
			     = this.createBinaryTree(preorder.subList(1, leftSize + 1),
			    		 inorder.subList(0, pivotIndex));
			 node.left = left;
		 }
		 if(pivotIndex < inorder.size() - 1) {
			 //has right
			 TreeNode right
			     = this.createBinaryTree(preorder.subList(pivotIndex + 1, preorder.size()),
			    		 inorder.subList(pivotIndex+1, inorder.size()));
			 node.right = right;
		 }
		 
		 return node;
	 }
	 
	 public static void main(String[] args) {
		 ConstructBinaryTrees tree = new ConstructBinaryTrees();
		 tree.buildTree(new int[]{1, 2}, new int[]{1, 2});
	 }
	 
}
