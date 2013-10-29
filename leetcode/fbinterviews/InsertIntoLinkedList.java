
//http://leetcode.com/2011/08/insert-into-a-cyclic-sorted-list.html
public class InsertIntoLinkedList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n1;
		
		insertValue(n3, 4);
		printList(n3);
		insertValue(n3, 4);
		printList(n3);
		
		n1.next = n1;
		insertValue(n1, 4);
		printList(n1);
	}
	
	public static void printList(ListNode node) {
		ListNode originalNode = node;
		System.out.print(node.val + "  ");
		while(node.next != originalNode) {
			node = node.next;
			System.out.print(node.val + "  ");
		}
		System.out.println();
	}
	
	//http://leetcode.com/2011/08/insert-into-a-cyclic-sorted-list.html
	//see here
	void insert(ListNode aNode, int x) {
		if (aNode == null) {
			aNode = new ListNode(x);
			aNode.next = aNode;
			return;
		}

		ListNode p = aNode;
		ListNode prev = null;
		do {
			prev = p;
			p = p.next;
			if (x <= p.val && x >= prev.val)
				break; // For case 1)
			if ((prev.val > p.val) && (x < p.val || x > prev.val))
				break; // For case 2)
		} while (p != aNode); // when back to starting point, then stop. For
								// case 3)

		ListNode newNode = new ListNode(x);
		newNode.next = p;
		prev.next = newNode;
	}
	
	public static ListNode insertValue(ListNode aNode, int val) {
		ListNode newNode = new ListNode(val);
		if(aNode == null) {
			return newNode;
		}
		ListNode curr = aNode;
		while(true) {
			ListNode nextNode = curr.next;
			
			if((curr.val <= val && val <= nextNode.val) ) {
				curr.next = newNode;
				newNode.next = nextNode;
				break;
			}
			
			//should be >= rather than , consider insert 4 into [1]
			if(curr.val >= nextNode.val && (val < nextNode.val || val > curr.val)) {
				curr.next = newNode;
				newNode.next = nextNode;
				break;
			}
			
			if(nextNode == aNode) {
				break;
			}
			
			curr = nextNode;
		}
		return newNode;
	}
	
}