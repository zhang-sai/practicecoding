
public class InsertionSortLinkedList {

	static ListNode sort(ListNode head) {
		ListNode newHead = new ListNode(-1);
		newHead.next = head;
		
		ListNode prev = newHead;
		ListNode curr = newHead.next;
		
		while(curr != null) {
			int v = curr.val;
//			System.out.println(" + " + v);
			ListNode nextNode = curr.next; //get the next node
			
			ListNode n = newHead;
			boolean isInserted = false;
			while( n.next !=  curr) {
//				System.out.println(n.next + "   " + curr);
//				System.out.println("  - " + n.val + ", curr: " + curr.val + ",  next: " + n.next.val);
				if(n.next.val >= v ) {
					
					prev.next = curr.next;
					curr.next = n.next;
					n.next = curr;
					
					isInserted = true;
					break;
				}
				n = n.next;
			}
			
			if(!isInserted) {
				prev = curr;
				curr = curr.next;
			} else {
				curr = nextNode;
			}
			
		}
		
		return newHead.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(0);
		ListNode n7 = new ListNode(12);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		ListNode node = sort(n1);
		
		System.out.println("--");
		
		while(node != null) {
			System.out.print(node.val + "  ");
			node = node.next;
		}
	}
	
}
