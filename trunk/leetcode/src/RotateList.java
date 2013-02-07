
/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		if(head == null || n == 0) {
			return head;
		}
		
		//compute the actually retated one
		int size = 0;
		ListNode node = head;
		while(node != null) {
			size++;
			node = node.next;
			
		}
		
		int num = n % size;
		if(num == 0) {
			return head;
		}
		

	    ListNode finalNode = head;
	    while(finalNode.next != null) {
	    	finalNode = finalNode.next;
	    }
		
	    int step = size - num;
	    ListNode lastNode = head;
	    for(int i = 1; i < step; i++) {
	    	lastNode = lastNode.next;
	    }
	    
	    
	    //set last node point to null
	    ListNode newHead = lastNode.next;
	    lastNode.next = null;
	    finalNode.next = head;
	    
	    return newHead;
	}
}

class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}
