
public class SwapNodePairs {

	public ListNode swapPairs(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        //use three pointers
        ListNode prev = newHead;
        ListNode curr = head;
        ListNode next = curr.next;
        
        while(next != null) {
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            //adjust the pointer
            prev = curr;
            curr = curr.next;
            next = curr != null ? curr.next : null;
        }
        return newHead.next;
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

 