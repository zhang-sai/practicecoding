/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        
        if(l1 == null) {
            curr.next = l2;
        }
        if(l2 == null) {
            curr.next = l1;
        }
        
        return head.next;
    }
}
