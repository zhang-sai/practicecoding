import java.util.LinkedList;
import java.util.List;

//given a preorder traversal result
//return all possible postorder traversal

public class BinaryTreePreorderToPostorder {

	public static void main(String[] args) {
		int[] vals = new int[]{1, 2, 3};
		for(TreeNode n : constructTrees(vals, 0, vals.length - 1)) {
			posttraverse(n);
			System.out.println();
		}
	}
	
	public static List<TreeNode> constructTrees(int[] nums, int start, int end) {
		List<TreeNode> nodes = new LinkedList<TreeNode>();
		if(start == end) {
			nodes.add(new TreeNode(nums[start]));
			return nodes;
		}
		List<TreeNode> restNodes = constructTrees(nums, start + 1, nums.length - 1);
		
		System.out.println("rest: " + restNodes);
		
		for(TreeNode n : restNodes) {
			TreeNode newNode1 = new TreeNode(nums[start]);
			newNode1.left = n;
			nodes.add(newNode1);
			
			TreeNode newNode2 = new TreeNode(nums[start]);
			newNode2.right = n;
			nodes.add(newNode2);
		}
		
		for(int mid = start + 1; mid < end; mid++) {
			List<TreeNode> leftNodes = constructTrees(nums, start + 1, mid);
			List<TreeNode> rightNodes = constructTrees(nums, mid + 1, end);
			
			System.out.println("left: " + leftNodes);
			System.out.println("right: " + rightNodes);
			
			for(TreeNode left : leftNodes) {
				for(TreeNode right : rightNodes) {
					TreeNode newNode1 = new TreeNode(nums[start]);
					newNode1.left = left;
					newNode1.right = right;
					nodes.add(newNode1);
				}
			}
		}
		
		
		return nodes;
	}
	
	public static void posttraverse(TreeNode n) {
		if(n == null) {
			return;
		}
		posttraverse(n.left);
		posttraverse(n.right);
		System.out.print(n.val + " ");
		
	}
}
