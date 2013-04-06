
public class RemoveDuplicatesSortedList {

	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
	 * */
	public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) {
        	return head;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        while(next != null) {
            while(next != null && next.val == curr.val) {
        	    next = next.next;
            }
            //link next to curr
            curr.next = next;
            curr = next;
            if(next != null) { //XXX must add this check
                next = next.next;
            }
        }
        
        return head;
    }
	
	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
	 * */
	public ListNode deleteDuplicates_all_code(ListNode head) {
        xxx
    }
}
