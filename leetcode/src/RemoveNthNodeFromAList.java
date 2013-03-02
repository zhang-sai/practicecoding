/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 * */
public class RemoveNthNodeFromAList {
	//http://www.cnblogs.com/remlostime/archive/2012/11/14/2770033.html
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0 || head == null) {
        	return head;
        }
        ListNode prev = null; //XXX note this
        ListNode next = head;
        for(int i = 0; i < n - 1; i++) {
        	next = next.next;
        }
        while(next.next != null) {
        	if(prev == null) {   //XXX attention this condition
        		prev = head;
        	} else {
        	    prev = prev.next;
        	}
        	next = next.next;
        }
        if(prev == null) {
        	return head.next;
        } else {
            //delete the next node of prev
            prev.next = prev.next.next;
        }
        
        return head;
    }
	//1, 2   == 1
	
}
