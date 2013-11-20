
public class SortLinkedList {

	public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null || head.next == null) {
            return head;
        }
        //use merge sort
        ListNode slow = null;
        ListNode fast = head.next;
        while(fast != null) {
            slow = slow == null ? head: slow.next;
            fast = fast.next;
            if(fast == null) {
                break;
            }
            fast = fast.next;
        }
        //now slow points to the middle
        ListNode midNode = slow.next;
        slow.next = null;
        slow = midNode;
        //then do recursion
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(slow);
        //merge two nodes
        head = null;
        ListNode curr = head;
        while(n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                if(head == null) {
                    head = n1;
                    curr = head;
                } else {
                    curr.next = n1;
                    curr = curr.next; 
                }
                n1 = n1.next;
            } else {
                if(head == null) {
                    head = n2;
                    curr = head;
                } else {
                    curr.next = n2;
                    curr = curr.next;
                }
                n2 = n2.next;
            }
        }
        if(n1 != null) {
            curr.next = n1;
        }
        if(n2 != null) {
            curr.next = n2;
        }
        return head;
    }
}
