
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
	//a sample answer:
	//http://fenghaolw.blogspot.com/2013/03/remove-duplicates-from-sorted-list-ii.html
	public ListNode deleteDuplicates_all_code(ListNode head) {
		//XXX use a tmp node is much convenient
        ListNode tmpNode = new ListNode(-1);
        tmpNode.next = head;
        
        ListNode prev = tmpNode;
        ListNode curr = head;
        
        while(curr != null) {
        	boolean dup = false;
        	while(curr.next != null && curr.next.val == curr.val) {
        		dup = true;
        		curr = curr.next;
        	}
        	if(dup) {
        		prev.next = curr.next;
        	} else {
        		//no duplicate
        		prev = curr;  //XXX no dup means only 1 step
        	}
        	curr = curr.next;
        }
        
        return tmpNode.next;
    }
}
