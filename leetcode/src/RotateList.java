
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
        if(n == 0 || head == null) {
            return head;
        } 
        ListNode curr = head;
        int length = 0;
        while(curr!=null) {
            length++;
            curr = curr.next;
        }
        n = n % length;
        //skip the zero
        if(n == 0) {
            return head;
        }
        //do the rotating
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        int step = length - n;
        curr = newHead;
        for(int i = 0; i < step; i++) {
            curr = curr.next;
        }
        
        //be aware need to break the loop
        ListNode tmp = curr.next;
        curr.next = null;
        curr = tmp;
        
        newHead.next = curr;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        
        return newHead.next;
    }
}


