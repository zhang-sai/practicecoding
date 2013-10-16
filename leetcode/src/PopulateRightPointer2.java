

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
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) {
            return;
        }
        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            } else {
                TreeLinkNode nextNode = root.next;
                while(nextNode != null) {
                    if((nextNode.left != null ||  nextNode.right != null)) {
                        break;
                    } else {
                        nextNode = nextNode.next;
                    }
                }
                root.left.next =  (nextNode ==  null)
                    ? null
                    : (nextNode.left != null ? nextNode.left : nextNode.right);
            }
        }
        if(root.right != null) {
            if(root.next == null) {
                root.right.next = null;
            } else {
                TreeLinkNode nextNode = root.next;
                while(nextNode != null) {
                    if((nextNode.left != null || nextNode.right != null)) {
                        break;
                    } else {
                        nextNode = nextNode.next;
                    }
                }
                if(nextNode == null) {
                    root.right.next = null;
                } else {
                    root.right.next = nextNode.left != null ? nextNode.left : nextNode.right;
                }
            }
        }
        
        //the recursive order may make some right side pointer 
        //initialized after the left side
        connect(root.right);
        connect(root.left);
        //must connect right before connecting left
    }
}
