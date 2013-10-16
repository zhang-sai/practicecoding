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
        if(n == 0) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode slowNode = newHead;
        ListNode fastNode = newHead;
        for(int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        
        while(fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        
        //remove the next node of slow node
        ListNode toRemove = slowNode.next;
        slowNode.next = toRemove.next;
        
        return newHead.next;
    }
	//1, 2   == 1
	
}
