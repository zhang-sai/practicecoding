
public class ReverseLinkedList {

	/**
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ? m ? n ? length of list.
	 * */
	//a sample answer: http://gongxuns.blogspot.com/2012/12/leetcode-reverse-linked-list-ii.html
	//a general linked list reverse
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) {
            return head;
        }
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        
        //find two points
        ListNode start = newhead;
        for(int i = 0; i < m - 1; i++) {
            start = start.next;  //go before the starting point
        }
        ListNode end = newhead;
        for(int i = 0; i < n; i++) {
            end = end.next;
        }
        end = end.next; //go after the ending point
        
        //start to
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode firstNode = curr;
        while(curr != end) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        //re-organize the linked list
        start.next = prev;
        firstNode.next = end;
        
        return newhead.next;
    }
	
	/**
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 <= m  <= n  <= length of list.
	 * */
	public ListNode reverseBetween2(ListNode head, int m, int n) {
        if(m == n) {
            return head;
        }
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        
        //find two points
        ListNode start = newhead;
        for(int i = 0; i < m - 1; i++) {
            start = start.next;  //go before the starting point
        }
        ListNode end = newhead;
        for(int i = 0; i < n; i++) {
            end = end.next;
        }
        end = end.next; //go after the ending point
        
        //start to
        ListNode curr = start.next;
        while(curr != end) {
            if(start.next == curr) {
                curr = curr.next;
                continue;
            }
            ListNode nextNode = curr.next;
            //change the pointer
            curr.next = start.next;
            start.next = curr;
            curr = nextNode;
        }
        
        while(start.next != null) {
            start = start.next;
        }
        start.next = end;
        
        return newhead.next;
    }
	
	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		rll.reverseBetween(n1, 1, 4);
	}
}
