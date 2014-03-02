
public class AllNodesAlongDeepestBSTPath {

	
	public static void print(TreeNode root) {
		int depth = maxDepth(root);
		printNode(root, depth);
	}
	
	private static boolean printNode(TreeNode node, int depth) {
		if(node == null) {
			return false;
		}
		if(depth == 1) {
			System.out.println(node.val);
			return true;
		}
		
		if(printNode(node.left, depth - 1)) {
			System.out.println(node.val);
			return true;
		}
		
		if(printNode(node.right, depth-1)) {
			System.out.println(node.val);
			return true;
		}
		
		return false;
	}
	
	private static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	/**
	 *     1
	 *    / \
	 *   2   3
	 *      / \
	 *      4  5
	 *     /
	 *     6
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
		n3.left = n4;
		n3.right = n5;
		n4.left = n6;
		
//		n4.right = n7;
		
		print(root);
		
	}
	
}
