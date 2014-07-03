package basics;


//
public class ReverseLinkedList {
	
	static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		
		ListNode n = reverse_no_recursive(n1);
		
		while(n != null) {
			System.out.print(n.val + "  ");
			n = n.next;
		}
		
	}
	
	public static ListNode reverse_no_recursive(ListNode node) {
		if(node == null || node.next == null) {
			return node;
		}
		
		ListNode prev = null;
		ListNode curr = node;
		
		while(curr != null) {
			//relink
			ListNode nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			//move to the next
			curr = nextNode;
		}
		
		return prev;
	}

	public ListNode Reverse(ListNode list) {
	    if (list == null) return null; // first question

	    if (list.next == null) return list; // second question

	    // third question - in Lisp this is easy, but we don't have cons
	    // so we grab the second element (which will be the last after we reverse it)

	    ListNode secondElem = list.next;

	    // bug fix - need to unlink list from the rest or you will get a cycle
	    list.next = null;

	    // then we reverse everything from the second element on
	    ListNode reverseRest = Reverse(secondElem);

	    // then we join the two lists
	    secondElem.next = list;

	    return reverseRest;
	}
}
