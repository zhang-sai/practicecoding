
/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(l1 == null || l2 == null) {
			return null;
		}
        ListNode retNode = null;
        ListNode prevNode = null; 
        
        int carrier = 0;
        while(l1 != null || l2 != null) {
        	int v1 = l1 != null ? l1.val : 0;
        	int v2 = l2 != null ? l2.val : 0;
        	int value = v1 + v2 + carrier;
        	int rValue = value >= 10 ? value % 10 : value; //XXX note this
        	carrier = value >= 10 ? value / 10 : 0;
        	
        	ListNode newNode = new ListNode(rValue);
        	if(retNode == null) {
        		retNode = newNode;
        		prevNode = newNode;
        	} else {
        		prevNode.next = newNode;
        		prevNode = prevNode.next; //XXX do not forget this
        	}
        	//reset l1 and l2
        	l1 = l1 == null ? null : l1.next;
        	l2 = l2 == null ? null : l2.next;
        }
        
        //XXX donot forget this
        if(carrier > 0) {
        	prevNode.next = new ListNode(carrier);
        }
        
        return retNode;
    }
}
