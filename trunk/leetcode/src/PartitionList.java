/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 * */
//refer to: http://www.tsechung.com/wordpress/2012/07/15/partition-list/
//XXX
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null) {
			return null;
		}
        // Start typing your Java solution below
        // DO NOT write main() function
		ListNode start = null;
		ListNode less = null;
		
		ListNode middle = null;
		ListNode more = null;
		
		ListNode node = head;
		while(node != null) {
			if(node.val < x) {
				if(less == null) {
					less = node;
					start = less;
				} else {
					less.next = node;
					less = less.next;
				}
			} else {
				if(more == null) {
					more = node;
					middle = more;
				} else {
					more.next = node;
					more = more.next;
				}
			}
			node = node.next;
		}
		
		//check possibility
		if(start != null) {
			less.next = middle;
		} else {
			start = middle;
		}
		
		if(middle != null) {
			more.next = null;
		}
		return start;
    }
}
