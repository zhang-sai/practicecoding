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
	public TreeNode buildTree_in_post(int[] inorder, int[] postorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(inorder.length == 0) {
            return null;
        }
        return this.createBinaryTree_post(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
	 
	 TreeNode createBinaryTree_post(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend) {
	     
		 int pivot = postorder[postend];
		 TreeNode node = new TreeNode(pivot);
		 int pivotIndex = -1;
		 for(int i = 0; i < inorder.length; i++) {
		     if(inorder[i] == pivot) {
		         pivotIndex = i;
		         break;
		     }
		 }
		 
		 int leftSize = pivotIndex - instart; //1, 2, 3
		 if(leftSize > 0) {
			 //has left
			 TreeNode left
			     = this.createBinaryTree(postorder, poststart, poststart + leftSize - 1,
			    		 inorder, instart,  instart + leftSize - 1);
			 node.left = left;
		 }
		 if(pivotIndex < inend) {
			 //has right
			 TreeNode right
			     = this.createBinaryTree(postorder, poststart + leftSize, postend - 1,
			    		 inorder, pivotIndex + 1, inend);
			 node.right = right;
		 }
		 
		 return node;
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
		 //build the tree recursively
		 return this.createBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	 }
	 
	 TreeNode createBinaryTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
	     
		 int pivot = preorder[prestart];
		 TreeNode node = new TreeNode(pivot);
		 int pivotIndex = -1;
		 for(int i = 0; i < inorder.length; i++) {
		     if(inorder[i] == pivot) {
		         pivotIndex = i;
		         break;
		     }
		 }
		 
		 int leftSize = pivotIndex - instart; //1, 2, 3
		 if(leftSize > 0) {
			 //has left
			 TreeNode left
			     = this.createBinaryTree(preorder, prestart + 1, prestart + leftSize,
			    		 inorder, instart,  instart + leftSize - 1);
			 node.left = left;
		 }
		 if(pivotIndex < inend) {
			 //has right
			 TreeNode right
			     = this.createBinaryTree(preorder, prestart + leftSize + 1, preend, // p.subList(pivotIndex + 1, preorder.size()),
			    		 inorder, pivotIndex + 1, inend);
			 node.right = right;
		 }
		 
		 return node;
	 }
	 
	 public static void main(String[] args) {
		 ConstructBinaryTrees tree = new ConstructBinaryTrees();
		 tree.buildTree(new int[]{1, 2}, new int[]{1, 2});
	 }
	 
}
