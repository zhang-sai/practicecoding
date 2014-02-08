import java.util.HashMap;
import java.util.Map;


/**
 * BT(binary tree), want to find the LIS(largest independent set) of the BT
LIS: if the current node is in the set, then its children should not be in 
the set. So that the set has the largest number of nodes.

http://www.mitbbs.com/article_t/JobHunting/32620157.html

see:

http://mypathtothe4.blogspot.com/2013/03/dynamic-programming-company-party.html

 * */


public class BinaryTreeLIS {

	/**
	 * Naive approach
	 * 
	 *    getMax(TreeNode root)
	 *    if(root == null) {
	 *       return 0;
	 *    } else 
	 * 
	 * */
	
	static Map<TreeNode, Integer> cache = new HashMap<TreeNode, Integer>();
	
	public int getMaxSet(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(cache.containsKey(root)) {
			return cache.get(root);
		}
		if(root.left == null && root.right == null) {
			cache.put(root, 1);
			return 1;
		}
		int excludeRoot = getMaxSet(root.left) + getMaxSet(root.left);
		int includeRoot = 1
		    + (root.left != null ? getMaxSet(root.left.left) + getMaxSet(root.left.right) : 0)
		    + (root.right != null ? getMaxSet(root.right.left) + getMaxSet(root.right.right) : 0);
		int max = Math.max(excludeRoot, includeRoot);
		
		//store in the cache
		cache.put(root, max);
		
		return max;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(0);
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		
		
		System.out.println(new BinaryTreeLIS().getMaxSet(root));
		
	}
}
