
/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 * */
public class RemoveDuplicateSortedList2 {

	public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        ListNode prev = newHead;
        
        ListNode curr = newHead.next;
        ListNode forward = curr.next;
        
        while(forward != null) {
            if(forward.val != curr.val) {
                prev = curr;
                curr = curr.next;
                forward = forward.next;
            } else {
                int v = curr.val;
                while(forward != null && forward.val == v) {
                    forward = forward.next;
                }
                prev.next = forward;
                curr = forward;
                if(curr != null) {
                    forward = curr.next;
                }
            }
        }
        
        return newHead.next;
    }
	
}
