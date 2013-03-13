
XXX

public class PopulateRightPointer2 {	/**
	 * Follow up for problem "Populating Next Right Pointers in Each Node".

	What if the given tree could be any binary tree? Would your previous solution still work?

	Note:

	You may only use constant extra space.
	For example,
	Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
	» Solve this problem
		 * */
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
			this.createLinks(root.left);
			this.createLinks(root.right);
		} else if(root.left != null) {
			root.left.next = null;
			this.createLinks(root.left);
		} else if (root.right != null) {
			root.right.next = null;
			this.createLinks(root.right);
		}
	}
	
	public void createLinkdsBetweenSubtrees(TreeLinkNode node) {
		if(node == null) {
			return;
		}
		if(node.next != null) {
			TreeLinkNode node1 = node.right != null ? node.right : node.left;
			if(node1 != null && node1.next == null) {
				//XXX this tricky point you need to follow the next to the most left one
				TreeLinkNode nextNode = node.next;
				while(nextNode!= null) {
					if(nextNode.left != null || nextNode.right != null) {
						break;
					}
					nextNode = nextNode.next;
				}
				TreeLinkNode node2 = nextNode == null ? null
						: (nextNode.left != null ? nextNode.left : nextNode.right);
				node1.next = node2;
			}
		}
		this.createLinkdsBetweenSubtrees(node.left);
		this.createLinkdsBetweenSubtrees(node.right);
	}
}
