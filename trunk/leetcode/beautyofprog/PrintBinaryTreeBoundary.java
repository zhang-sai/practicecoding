
public class PrintBinaryTreeBoundary {
	
	/**
	 *       1
	 *      / \
	 *      2  3
	 *    /  \ /\
	 *   4   5 6 7
	 * */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		root.left = n2;
		root.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		printLeft(root);
		printLeaf(root);
		printRight(root);
	}

	//pre-order print
	//only deal with the left node
	public static void printLeft(TreeNode root) {
		if(root == null) {
			return;
		}
		
		//not print leaf, will duplicate
		if(root.left != null || root.right != null) {
		    System.out.println(root.val);
		}
		printLeft(root.left);
	}
	
	//in order print
	public static void printLeaf(TreeNode root) {
		if(root == null) {
			return;
		}
		printLeaf(root.left);
		if(root.left == null && root.right == null) {
			System.out.println(root.val);
		}
		printLeaf(root.right);
	}
	
	//post order print
	public static void printRight(TreeNode root) {
		if(root == null) {
			return;
		}
		//not print leaf, will duplicate
		printRight(root.right);
		if(root.left != null || root.right != null) {
		    System.out.println(root.val);
		}
		
	}
	
}
