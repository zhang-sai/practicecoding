
/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carrier = 0;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(l1 != null || l2 != null) {
            
            int v1 = l1 != null ? l1.val: 0;
            int v2 = l2 != null ? l2.val : 0;
            
            int digit = (v1 + v2 + carrier)%10;
            ListNode newNode = new ListNode(digit);
            curr.next = newNode;
            curr = curr.next;
            
            carrier = (v1 + v2 + carrier)/10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            
            
        }
        if(carrier != 0) {
            curr.next = new ListNode(carrier);
        }
        return head.next;
    }
}
