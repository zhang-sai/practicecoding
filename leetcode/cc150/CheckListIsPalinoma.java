import java.util.Stack;


/**
 * Given a list, and check if it is a palioma
 * 1->1->2->1->1
 * 
 * or 
 * 
 * 1->2->3->3->2->1
 * 
 * at the very beginning slow = head, and fast = head.next
 * */
public class CheckListIsPalinoma {

	public static boolean checkPalinoma(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		Stack<Integer> s = new Stack<Integer>();
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null) {
			s.push(slow.val);
			slow = slow.next;
			//advance the fast
			fast = fast.next;
			if(fast == null) {
				break;
			}
			fast = fast.next;
			if(fast == null) {
				System.out.println("--");
				slow = slow.next;
			}
			
		}
		
		while(slow != null) {
			int v = s.pop();
			System.out.println(v + "  " + slow.val);
			if(v != slow.val) {
				return false;
			}
			slow = slow.next;
		}
		return s.isEmpty() ? true : false;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
//		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		head.next = n1;
		n1.next = n2;
		n2.next = n4;
//		n3.next = n4;
		n4.next = n5;
		System.out.println(checkPalinoma(head));
	}
	
}
