
public class CyclesInLinkedList1And2 {

	public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            slow = slow.next;
            //beaware of this condition
            if(fast == null || fast.next == null || fast.next.next == null) {
                return false;
            } 
            fast = fast.next.next;
        }
        return true;
    }
	
	public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null || head.next == null) {
            return null;
        }
        
        //use floyd cycle detection
        ListNode slow = head;
		ListNode fast = head.next;
		
		while(slow != fast) {
		    if(slow == null) {
		        return null;
		    }
		    if(fast == null || fast.next == null || fast.next.next == null) {
		        return null;
		    }
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//now we find a cycle, and two ndoes
		//meet at some point
		ListNode start = head;
		slow = slow.next;
		
		//THIS is the key point,
		//the distance of the slow point to the cycle head
		//equals to the distance from head to the cycle head
		while(slow != start) {
			slow = slow.next;
			start = start.next;
		}
		
		return slow;
    }
}
