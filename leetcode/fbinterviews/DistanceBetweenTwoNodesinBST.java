/**
 * Given two nodes in BST, caculate the distance
 * */

//what about not BST, but an arbitrary tree
public class DistanceBetweenTwoNodesinBST {

	public int getDistance(TreeNode root, TreeNode n1, TreeNode n2) {
		TreeNode n = root;
		
		while(((n.val > n1.val && n.val > n2.val) || (n.val < n1.val && n.val < n2.val))) {
			if(n.val > n1.val && n.val > n2.val) {
				n = n.left;
			} else {
				n = n.right;
			}
		}
		
		int d1 = this.getDistance(n, n1);
		int d2 = this.getDistance(n, n2);
		
		return d1 + d2;
	}
	
	public int getDistance(TreeNode upNode, TreeNode downNode) {
		TreeNode n = upNode;
		int d = 0;
		while(n.val != downNode.val) {
			if(downNode.val > n.val) {
				n = n.right;
			} else {
				n = n.left;
			}
			d++;
		}
		return d;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(8);
		
		root.left = node3;
		root.right = node6;
		
		node3.left = node2;
		node3.right = node4;
		
		node2.left = node1;
		
		node6.left = node5;
		node6.right = node7;
		
		TreeNode n1 = node5;
		TreeNode n2 = node7;
		
		DistanceBetweenTwoNodesinBST d = new DistanceBetweenTwoNodesinBST();
		System.out.println(d.getDistance(root, n1, n2));
	}
	
}
