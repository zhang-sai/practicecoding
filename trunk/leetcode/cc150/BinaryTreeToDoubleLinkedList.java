
//a binary tree to a double linked list

//duplicate to hht
class BiNode {
	BiNode left, right;
	public int data;
	BiNode(int v) {
		data = v;
	}
}
public class BinaryTreeToDoubleLinkedList {

	public static BiNode treeToDoublyList(BiNode root) {
		  BiNode prev = null;
		  BiNode head = null;
		  BiNode[] headArray = new BiNode[]{head};
		  treeToDoublyList(root, new BiNode[] {prev}, headArray);
		  System.out.println(headArray[0].data);
		  return head; //the head of the linked list
	}
	
	//BiNode[] is simulating a reference
	static void treeToDoublyList(BiNode p, BiNode[] prev, BiNode[] head) {
		  if (p == null) {
			  return;
		  }
		  treeToDoublyList(p.left, prev, head);
		  
		  // current node's left points to previous node
		  p.left = prev[0];
		  if (prev[0] != null)
		    prev[0].right = p;  // previous node's right points to current node
		  else
		    head[0] = p; // current node (smallest element) is head of
		              // the list if previous node is not available
		  
		  // as soon as the recursion ends, the head's left pointer 
		  // points to the last node, and the last node's right pointer
		  // points to the head pointer.
		  BiNode right = p.right;
		  
		  //the temp pointer to p
		  head[0].left = p;
		  p.right = head[0];
		  
		  // updates previous node
		  prev[0] = p;  //ASSIGN THE PREVIOUS NODE HERE
		  treeToDoublyList(right, prev, head);
		}
	
	public static void main(String[] args) {
		/**
		 * A tree:
		 *          1
		 *         / \
		 *        2   3
		 *       / \   \
		 *      4   5   6
		 *      
		 * will be transformed to:
		 * 
		 * 4  <-> 2 <-> 5 <-> 1 <-> 3 <-> 6
		 * */
		BiNode n1 = new BiNode(1);
		BiNode n2 = new BiNode(2);
		BiNode n3 = new BiNode(3);
		BiNode n4 = new BiNode(4);
		BiNode n5 = new BiNode(5);
		BiNode n6 = new BiNode(6);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		
		treeToDoublyList(n1);
		
		BiNode start = n1;
		while(true) {
			System.out.print(n1.data + " ");
			n1 = n1.right;
			if(n1 == start) {
				break;
			}
		}
		//print the results
	}
	
}

