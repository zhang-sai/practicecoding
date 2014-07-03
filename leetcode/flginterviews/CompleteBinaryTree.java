import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Write a function to validate a complete binary tree. That is, the function
 * will take a binary tree as an input argument and return true if the given
 * binary tree is a complete binary tree.
 * 
 * A binary tree is complete if all levels except possibly the last are
 * completely full, and the last level has all its node to the left side.
 * 
 * For example, the following is a complete binary tree:
 * 
 * 
 * a
 * 
 * / \
 * 
 * b c
 * 
 * /
 * 
 * d
 * 
 * The followings are not complete binary trees:
 * 
 * 
 * a
 * 
 * / \
 * 
 * b c
 * 
 * / \
 * 
 * d e
 * 
 * 
 * a
 * 
 * / \
 * 
 * b c
 * 
 * / / \
 * 
 * f d e
 * */
public class CompleteBinaryTree {

	
	// level by leve traverse, and check the next level
	// a flag indicate noMoreRight Node

	public static boolean isCompleteBinaryTree(TreeNode node) {
		if (node == null) {
			return true;
		}

		// a queue
		List<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);

		boolean noMoreNodeInNextLevel = false;
		while (!queue.isEmpty()) {
			List<TreeNode> nextLevel = new LinkedList<TreeNode>();

			for (TreeNode firstNode : queue) {
				if (firstNode.left != null && firstNode.right != null) {
					if (noMoreNodeInNextLevel) {
						return false;
					} else {
						nextLevel.add(firstNode.left);
						nextLevel.add(firstNode.right);
					}
				} else if (firstNode.left == null && firstNode.right == null) {
					noMoreNodeInNextLevel = true;
				} else if (firstNode.left != null) {
					if (noMoreNodeInNextLevel) {
						return false;
					} else {
						noMoreNodeInNextLevel = true;
						nextLevel.add(firstNode.left);
					}
				} else {
					// firstNode.right != null but firstNode.left == null
					return false;
				}
			}
			queue.clear();
			queue.addAll(nextLevel);
		}

		return true;
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
		n2.left = n4;
		System.out.println(isCompleteBinaryTree(n1));
		// clear all pointers
		n2.left = null;

		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		System.out.println(isCompleteBinaryTree(n1));

		n2.left = n6;
		System.out.println(isCompleteBinaryTree(n1));

	}

}
