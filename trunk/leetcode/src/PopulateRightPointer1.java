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

//XXX another solution: http://leetcode.com/2010/03/first-on-site-technical-interview.html
public class PopulateRightPointer1 {

	//XXX PASS the test set
	public void connect(TreeLinkNode root) {
		this.createLinks(root);
		this.createLinkdsBetweenSubtrees(root);
	}
	
	//create the next link between siblings
	public void createLinks(TreeLinkNode root) {
		if(root == null) {
			return;
		}
		if(root.left != null && root.right != null) {
			root.left.next = root.right;
			root.right.next = null;
			this.connect(root.left);
			this.connect(root.right);
		}
	}
	
	public void createLinkdsBetweenSubtrees(TreeLinkNode node) {
		if(node == null) {
			return;
		}
		if(node.next != null) {
			if(node.right != null) {
				node.right.next = node.next.left;
			}
		}
		this.createLinkdsBetweenSubtrees(node.left);
		this.createLinkdsBetweenSubtrees(node.right);
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
