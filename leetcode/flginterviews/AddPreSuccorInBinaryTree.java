import java.util.Stack;

/**
 * Add a successor point to a node in binary tree in order traversal
 * */
//xx
public class AddPreSuccorInBinaryTree {

	public static void addPreSuccessor(TreeNode root) {
		if(root == null) {
			return;
		}
		TreeNode dummy = new TreeNode(-1);
		
		TreeNode prev = dummy;
//		TreeNode now = null;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		while(!stack.isEmpty() || curr != null) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left; //go to the next
			} else {
				curr = stack.pop();
				
				//add the succ ponter
				prev.succ = curr;
				prev = curr;
				
				System.out.println(curr.val);
				//visit this
				curr = curr.right;
			}
		}
		
		//add the news
		while(dummy != null) {
			System.out.println(dummy.val);
			dummy = dummy.succ;
		}
		
	}
	
	static void addSucc(TreeNode pre, TreeNode next) {
		
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
		
		n4.right = n6;
		
		addPreSuccessor(root);
	}
}
