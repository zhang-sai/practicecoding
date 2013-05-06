/**
 * http://zhedahht.blog.163.com/blog/static/254111742007127104759245/
 * */
public class BSTToDoubleLinkedList {

	public TreeNode bstToList(TreeNode root) {
		if(root == null) {
			return root;
		}
		if(root.left == null && root.right == null) {
			return root;
		}
		
		TreeNode leftListHead = root.left == null ? null : bstToList(root.left);
		TreeNode rightListHead = root.right == null ? null : bstToList(root.right);
		
		TreeNode head = leftListHead != null ? leftListHead : root;
		if(leftListHead != null) {
		    TreeNode leftTail = leftListHead;
		    while(leftListHead != null && leftListHead.right != null) {
			    leftTail = leftListHead.right;
			    leftListHead = leftListHead.right;
		    }
		    leftTail.right = root;
		    root.left = leftTail;
		}
		
		root.right = rightListHead;
		if(rightListHead != null) {
		    rightListHead.left = root;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		
		t2.left = t1;
		t2.right = t3;
		t4.left = t2;
		t4.right = t5;
		t5.right = t6;
		
		TreeNode root = new TreeNode(7);
//		root.left = t4;
		
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		
		t8.right = t9;
		root.right = t8;
		
		BSTToDoubleLinkedList bstList = new BSTToDoubleLinkedList();
		TreeNode node = bstList.bstToList(root);
		print(node);
	}
	
	static void print(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		sb.append("--> ");
		while(t != null) {
			sb.append(t.val);
			sb.append(" ");
			if(t.right == null) {
				break;
			}
			t = t.right;
		}
		System.out.println(sb.toString());
		
		sb = new StringBuilder();
		sb.append(" <-- ");
		while(t != null) {
			sb.append(t.val);
			sb.append(" ");
			if(t.left == null) {
				break;
			}
			t = t.left;
		}
		System.out.println(sb.toString());
	}
}
