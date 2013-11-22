import java.util.ArrayList;


public class BinaryTreeAllPathFromRootToLeaf {

	public static ArrayList<ArrayList<Integer>> getAllPaths(TreeNode node) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		accumulateAllPaths(node, paths, new ArrayList<Integer>());
		return paths;
	}
	
	static void accumulateAllPaths(TreeNode currNode, ArrayList<ArrayList<Integer>> paths,
			ArrayList<Integer> currPath) {
		if(currNode == null) {
			return;
		} else if (currNode.left == null && currNode.right == null) {
			currPath.add(currNode.val);
			paths.add(currPath);
//			System.out.println(currPath);
			
		}else {
			ArrayList<Integer> leftPath = new ArrayList<Integer>(currPath);
			leftPath.add(currNode.val);
			
			ArrayList<Integer> rightPath = new ArrayList<Integer>(currPath);
			rightPath.add(currNode.val);
			
			currPath.clear();
			
			accumulateAllPaths(currNode.left, paths, leftPath);
			accumulateAllPaths(currNode.right, paths, rightPath);
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);

		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		n2.left = n6;
		
		System.out.println(getAllPaths(n1));
	}
	
}
