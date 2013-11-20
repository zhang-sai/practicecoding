
import java.util.LinkedList;
import java.util.Queue;

//or sometimes, you can use a combination of two order traversal
public class TreeSerialization {
	
	public static void main(String[] args) {
       TreeNode root = new TreeNode(9);
		
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
		
		String s = serialize(root);
		System.out.println(s);
		
		root = deserialize(s);
		s = serialize(root);
		System.out.println(s);
	}

	public static String serialize(TreeNode node) {
		
		if(node == null) {
			return "#";
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
//		queue.
		queue.add(node);
		
		String s = "";
		while(!queue.isEmpty()) {
			TreeNode n = queue.poll();
			if(n == null) {
				s = s + "#";
			} else {
				s = s + n.val;
				queue.add(n.left);
				queue.add(n.right);
			}
		}
		
		return s;
	}
	
	public static TreeNode deserialize(String str) {
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(str.charAt(0) - '0');
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			count++;
			char c = str.charAt(count);
			if(c == '#') {
				node.left = null;
			} else {
				TreeNode newLeft = new TreeNode(c - '0');
				node.left = newLeft;
				queue.add(newLeft);
			}
			count++;
			c = str.charAt(count);
			if(c == '#') {
				node.right = null;
			} else {
				TreeNode newRight = new TreeNode(c - '0');
				node.right = newRight;
				queue.add(newRight);
			}
		}
		
		return root;
	}
	
}
