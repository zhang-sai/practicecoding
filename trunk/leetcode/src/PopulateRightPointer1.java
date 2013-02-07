import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * */
public class PopulateRightPointer1 {

	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root == null) {
			return;
		}
		List<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		List<TreeLinkNode> orderedByLevels = new LinkedList<TreeLinkNode>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			System.out.println("length of queue: " + queue.size());
			TreeLinkNode node = queue.remove(0);
			orderedByLevels.add(node);
			if(node != null) {
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			} else {
				if(queue.isEmpty()) {
					break; //XXX must break out
				}
				queue.add(null);
			}
		}
		//make the link
		for(int i = 0; i < orderedByLevels.size(); i++) {
			TreeLinkNode currNode = orderedByLevels.get(i);
			TreeLinkNode nextNode = i == orderedByLevels.size() - 1? null : orderedByLevels.get(i + 1);
			if(currNode == null) {
				continue;
			} else {
				if(nextNode != null) {
					currNode.next = nextNode;
				} else {
					currNode.next = null;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		PopulateRightPointer1 p = new PopulateRightPointer1();
		TreeLinkNode n = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		
		TreeLinkNode n21 = new TreeLinkNode(4);
		TreeLinkNode n22 = new TreeLinkNode(5);
		n2.left = n21;
		n2.right = n22;
		
		TreeLinkNode n31 = new TreeLinkNode(6);
		TreeLinkNode n32 = new TreeLinkNode(7);
		n3.left = n31;
		n3.right = n32;
		
		
		n.left = n2;
		n.right = n3;
		p.connect(n);
		
		System.out.println(n);
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) {
		val = x;
	}
	
	public String toString() {
		return this.printNode(this, 0);
	}
	
	private String printNode(TreeLinkNode node, int indent) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < indent; i++) {
			sb.append(" ");
		}
		if(node == null) {
			sb.append("null");
			return sb.toString();
		}
		sb.append("val: " + node.val + ", left: " + (node.left == null ? "null" : node.left.val)
				+ ", right: " + (node.right == null ? "null" : node.right.val)
				+ ", next: " + (node.next == null ? "null" : node.next.val));
		sb.append("\n");
		String left = printNode(node.left, indent + 4);
		sb.append(left);
		sb.append("\n");
		String right = printNode(node.right, indent + 4);
		sb.append(right);
		sb.append("\n");
		
		return sb.toString();
	}
}
