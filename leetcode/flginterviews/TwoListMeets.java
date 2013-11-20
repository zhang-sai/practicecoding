
/**
 * Decide if two lists meet
 * loop two list then if the last element is the same then it will meet.
 * */
public class TwoListMeets {

	//just check whether the last statements are the same or not
	public boolean checkMeet(ListNode n1, ListNode n2) {
		return false;
	}
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n6;
		
		System.out.println(findTheLoopHead(head).val);
	}
	
	
	public static ListNode findTheLoopHead(ListNode head) {
		//using floyd cycle detection
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//meet at some point
		ListNode start = head;
		slow = slow.next;
		
		//this is the key point,
		//the distance of the slow point to the cycle head
		//equals to the distance from head to the cycle head
		while(slow != start) {
			slow = slow.next;
			start = start.next;
		}
		
		return slow;
	}
	
}