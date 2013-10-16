/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * */
public class ReverseNodesKGroups {
	//for details, see: http://crackinterviewtoday.wordpress.com/2010/03/28/k-reverse-linked-list/
	public ListNode reverseKGroup(ListNode head, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null || k < 2) {
			return head;
		}
		ListNode tmp = new ListNode(-1);
		tmp.next = head;
		
		ListNode prev = tmp;
		ListNode curr = tmp.next; //[on the first element to be swapped]
		
		while(curr != null) {
		    int step = k;
		    //first test whether there are k steps ahead
		    ListNode forward = curr;
		    while(forward != null && step > 0) { //XXX must add step > 0, otherwise, it will keep going
		    	forward = forward.next;
		    	step--;
		    }
		    if(step != 0) {
		    	break;
		    }
		    //start to swap
		    step = k - 1; //only k-1 steps remained
		    ListNode n = curr.next;
		    while(step > 0) {
		    	curr.next = n.next;
		    	n.next = prev.next;
		    	prev.next = n;
		    	step--;
		    	n = curr.next;
		    }
		    //reset the curr
		    prev = curr; //XXX do not forget setting prev
		    curr = prev.next;
		    
		}
		
		return tmp.next;
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		ReverseNodesKGroups rnk = new ReverseNodesKGroups();
		ListNode head = rnk.reverseKGroup(n1, 2);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
