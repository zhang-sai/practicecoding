package linkedin;


/**
 * 
 * translate:
 * 
 *                                head4 -> 6 -> tail4
 *                                 |
 *          head2 ->tail2   head5 --> 4 -> 5 -> tail5
 *          |             |
 * head1 --> 1  -->  2 --> 3 --> tail1
 *          |             |
 *       head3 ->9->tail3  head6 -> 7 --> 8 -> tail6
 *                               |
 *                               head7 -> tail7
 *                               
 *                               
 *  into:
 *  
 *  head -> 1 -> 9 -> 2 -> 3 -> 4 -> 6 -> 5 - > 7 ->8 -> tail
 *  
 * */


//xx should be double linked list
public class FlattenLinkedList {
	static class ListNode {
	     int val;
	     ListNode next;
	     ListNode prev;
	     
	     
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	     
	     ListNode parent;
	     ListNode child;
	     
	     boolean isHead() {
	    	 return val == -1;
	     }
	     
	     boolean isTail() {
	    	 return val == -2;
	     }
	     
	     public String toString() {
	    	 return val + "";
	     }
	}
	
	
	public static ListNode flatten(ListNode head) {
		
		assert head.isHead();
		
		ListNode prevNode = head;
		ListNode currNode = head.next;
		
		while(!currNode.isTail()) {
			
			//first check if there is any parent or child node
			if(currNode.parent != null) {
				ListNode parentHead = flatten(currNode.parent);
				currNode.parent = null; //assign to zero
				//connect the linked list to the current linked list
				ListNode parentCurrNode = parentHead.next;
				if(!parentCurrNode.isTail()) {
					//move the point
					prevNode.next = parentCurrNode;
					parentCurrNode.prev = prevNode;
					
					//move parentCurrNode pointers to the end
					while(!parentCurrNode.next.isTail()) {
						parentCurrNode = parentCurrNode.next;
					}

					//reconnect it
					parentCurrNode.next = currNode;
					currNode.prev = parentCurrNode;
					
					//reset the prev and currNode, no change to the currNode
					prevNode = parentCurrNode;
				}
				
			}
			
			if(currNode.child != null) {
				ListNode childHead = flatten(currNode.child);
				currNode.child = null; //assign to null
				//connect the linked list to the current linked list
				ListNode childCurrNode = childHead.next;
				if(!childCurrNode.isTail()) {
					//move the point
					prevNode.next = childCurrNode;
					childCurrNode.prev = prevNode;
					
					//move parentCurrNode pointers to the end
					while(!childCurrNode.next.isTail()) {
						childCurrNode = childCurrNode.next;
					}

					//reconnect it
					childCurrNode.next = currNode;
					currNode.prev = childCurrNode;
					
					//reset the prev and currNode, no change to the currNode
					prevNode = childCurrNode;
				}
			}
			
			prevNode = currNode;
			currNode = currNode.next;
			
		}
		
		return head;
	}
	
	
	public static void print(ListNode head) {
		ListNode curr = head;
		while(curr != null) {
//			System.out.println("curr: " + curr.val);
			if(curr.isHead() || curr.isTail()) {
				//do nothinig
			} else {
			    System.out.println(curr.val);
			    if(curr.parent != null) {
				    print(curr.parent);
			    }
			    if(curr.child != null) {
				    print(curr.child);
			    }
			 }
			curr = curr.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		
		ListNode h1 = new ListNode(-1);
		ListNode h2 = new ListNode(-1);
		ListNode h3 = new ListNode(-1);
		ListNode h4 = new ListNode(-1);
		ListNode h5 = new ListNode(-1);
		ListNode h6 = new ListNode(-1);
		ListNode h7 = new ListNode(-1);
		
		ListNode t1 = new ListNode(-2);
		ListNode t2 = new ListNode(-2);
		ListNode t3 = new ListNode(-2);
		ListNode t4 = new ListNode(-2);
		ListNode t5 = new ListNode(-2);
		ListNode t6 = new ListNode(-2);
		ListNode t7 = new ListNode(-2);
		
		
		h1.next = n1;  n1.prev = h1;
		n1.next = n2;  n2.prev = n1;
		n2.next = n3;  n3.prev = n2;
		n3.next = t1;  t1.prev = n3;
		
		h2.next = t2;  t2.prev = h2;
		
		h3.next = n9;  n9.prev = h3;
		n9.next = t3;  t3.prev = n9;
		
		h4.next = n6;  n6.prev = h4;
		n6.next = t4;  t4.prev = n6;
		
		h5.next = n4;  n4.prev = h5;
		n4.next = n5;  n5.prev = n4;
		n5.next = t5;  t5.prev = n5;
		
		h6.next = n7;  n7.prev = h6;
		n7.next = n8;  n8.prev = n7;
		n8.next = t6;  t6.prev = n8;
		
		h7.next = t7;  t7.prev = h7;
		
		n1.parent = h2;
		n1.child = h3;
		
		n3.parent = h5;
		n3.child = h6;
		
		n4.parent = h4;
		
		n7.child = h7;
		
//		ListNode flatNode = flatten(h1);
//		while(flatNode != null) {
//			System.out.print(flatNode.val + "  ");
//			flatNode = flatNode.next;
//		}
		print(n1);
		
		ListNode flattenNode = flatten(h1);
		while(flattenNode != null) {
			System.out.println(flattenNode.val
					+ ", prev: " + flattenNode.prev
					+ ", next: " + flattenNode.next
					+ ", parent: " + flattenNode.parent
					+ ", child: " + flattenNode.child);
			flattenNode = flattenNode.next;
		}
	}
}
