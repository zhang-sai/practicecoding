/**
 *  Sort a linked list in O(nlogn) time with o(1) space complexity. Recursion
doesn't work here.
http://www.mitbbs.com/article_t/JobHunting/32394795.html
 * */

public class SortLinkedList {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(7);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(0);
		ListNode n7 = new ListNode(8);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
//		n6.next = n7;
//		n7.next = null;
		
		SortLinkedList s = new SortLinkedList();
		head = s.mergesort(head);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public void seeList(ListNode n) {
		System.out.print(" list: ");
		while(n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	public ListNode mergesort(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode firstNode = head;
		ListNode secondNode = getMedianNode(head);
		ListNode midNode = secondNode.next;
		secondNode.next = null; //DO NOT FORGET: must set to null
		
//		System.out.println("==> head: " + head.val + ", mid: " + midNode.val);
		
		//do recursive
		firstNode = mergesort(firstNode);
		midNode = mergesort(midNode);
		
		return merge(firstNode, midNode);
	}
	
	public ListNode getMedianNode(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		while(p2.next != null && p2.next.next != null) { //check the location of p2
			p1 = p1.next;
			p2 = p2.next.next;
		}
		return p1;
	}
	
	public ListNode merge(ListNode n1, ListNode n2) {
		ListNode newHead = new ListNode(-1);
		ListNode curr = newHead;
		while(n1 != null && n2 != null) {
			if(n1.val < n2.val) {
				curr.next = n1;
				curr = curr.next;
				n1 = n1.next;
			} else {
				curr.next = n2;
				curr = curr.next;
				n2 = n2.next;
			}
		}
		if(n1 != null) {
			curr.next = n1;
			curr = curr.next;
		}
		if(n2 != null) {
			curr.next = n2;
			curr = curr.next;
		}
		
		return newHead.next;
	}
}
