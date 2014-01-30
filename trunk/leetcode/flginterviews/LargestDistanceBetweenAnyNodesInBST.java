
/**
 * Any two arbitrary nodes in BST
 * */
//recursive
//3.8beauty of programming
public class LargestDistanceBetweenAnyNodesInBST {
//omit
	
	//give two nodes, the distance: DistanceBetweenTwoNodesinBST
	//the max one:
	
	public static int computeMax(TreeNode root) {
		if(root == null) {
			return 0;
		}
		//get the depth of left and get depth of the right
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
//		System.out.println(root.val + " left: " + leftDepth + ", rightDepth: " + rightDepth);
		
		int maxDistance = leftDepth + rightDepth;
		
		maxDistance = Math.max(maxDistance, computeMax(root.left));
		maxDistance = Math.max(maxDistance, computeMax(root.right));
		
		return maxDistance;
	}
	
	private static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftDepth = maxDepth(root.left);
		int maxDepth = leftDepth + 1;
		
		int rightDepth = maxDepth(root.right);
		maxDepth = Math.max(maxDepth, rightDepth + 1);
		
		return maxDepth;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		
		root.left = n1;
		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		
		//root -- n1 -- n2 -- n3 -- n4 
		
		System.out.println(computeMax(root));
		
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n1.right = n5;
		n5.right = n6;
		n6.right = n7;
		n7.right = n8;
		
		System.out.println(computeMax(root));
		
	}
}
