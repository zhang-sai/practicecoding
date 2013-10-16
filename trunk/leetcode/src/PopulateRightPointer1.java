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

	public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return;
        }
        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next =  (root.next ==  null)
                    ? null
                    : (root.next.left != null ? root.next.left : root.next.right);
            }
        }
        if(root.right != null) {
            if(root.next == null) {
                root.right.next = null;
            } else {
                root.right.next = root.next.left != null ? root.next.left : root.next.right;
            }
        }
        
        connect(root.left);
        connect(root.right);
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
