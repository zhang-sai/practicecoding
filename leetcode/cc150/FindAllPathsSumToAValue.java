import util.Utils;


/**
 * The find all paths from any node to any node in a tree
 * that sum to a certain value
 * 
 * here the path is only from parent -> child
 *
 *     5
 *    / \
 *   4   3
 *  / \    \
 * 1   2    3
 * \    
 *  1
 * /
 * 4
 * */
//4.9

//check for every level
public class FindAllPathsSumToAValue {

	public static void printAllPaths(TreeNode node, int sum) {
		int depth = depth(node);
		Integer[] path = new Integer[depth];
		printAllPaths(node, path, sum, 0);
	}
	
	static void printAllPaths(TreeNode node, Integer[] path, int sum, int level) {
		if(node == null) {
			return;
		}
		path[level] = node.val;
		
//		System.out.println(Utils.dumpArray(path));
		
		int t = 0;
		for(int i = level; i >= 0; i--) {
			t += path[i];
			if(t == sum) {
				print(path, i, level);
			}
		}
		
		//search
		printAllPaths(node.left, path, sum, level + 1);
		printAllPaths(node.right, path, sum, level + 1);
		
		path[level] = Integer.MAX_VALUE;
	}
	
	static void print(Integer[] a, int start, int end) {
		for(int i = start; i <= end; i++) {
			System.out.print(a[i] + "   ");
		}
		System.out.println();
	}
	
	public static int depth(TreeNode node) {
		if(node == null) {
			return 0; 
		} else {
			return 1 + Math.max(depth(node.left), depth(node.right));
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(2);
		
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(1);
		TreeNode n8 = new TreeNode(4);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		n3.right = n6;
		
		n4.right = n7;
		n7.left = n8;
		
		printAllPaths(n1, 6);
	}
	
}
