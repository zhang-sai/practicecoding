
public class MostCommonAncesterNodes {
	
	public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		root.left = node3;
		root.right = node6;
		
		node3.left = node2;
		node3.right = node4;
		
		node2.left = node1;
		
		node6.left = node5;
		node6.right = node7;
		
		System.out.println(findMostCommonNodes(root, node5, node7).val);
	}

	//for BST, this is easy, just check the value
	//for an arbitrary tree, 
	public static TreeNode findMostCommonNodes(TreeNode root, TreeNode n1, TreeNode n2) {
		if(root == null) {
			return null;
		}
		if(root == n1 || root == n2) {
			return root;
		}
		TreeNode leftNode = findMostCommonNodes(root.left, n1, n2);
		TreeNode rightNode = findMostCommonNodes(root.right, n1, n2);
		
		if(leftNode != null && rightNode != null) {
			return root;
		} else if (leftNode != null) {
			return leftNode;
		} else {
			return rightNode;
		}
	}
	
}