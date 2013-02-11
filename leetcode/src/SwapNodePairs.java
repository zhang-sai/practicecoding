
public class SwapNodePairs {

	public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) {
        	return head;
        }
        if(head.next == null) {
        	return head;
        }
        ListNode newHead = null;
        
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;
        while(current != null && next != null) {
        	current.next = next.next; //XXX this is error-prone
        	next.next = current;
        	if(prev != null) {
        		prev.next = next;
        	} else {
        		newHead = next;
        	}
        	//go to the next
        	prev = current;
        	current = current.next;
        	if(current != null) {
        		next = current.next;
        	}
        }
        
        return newHead;
    }
	
	class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}
}

 