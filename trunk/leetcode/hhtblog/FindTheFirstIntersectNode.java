//http://zhedahht.blog.163.com/blog/static/254111742008053169567/
public class FindTheFirstIntersectNode {

	//first get the length of each linked list
	//then a longer node goes a few steps first, then check whether they can meet
	public static ListNode findIntersection(ListNode n1, ListNode n2) {
		int l1 = getlength(n1);
		int l2 = getlength(n2);
		if(l1 < l2) {
			ListNode tmp = n1;
			n1 = n2;
			n2 = tmp;
		}
		int delta = Math.abs(l2 - l1);
		for(int i = 0; i < delta; i++) {
			n1 = n1.next;
		}
		
		//iterate
		while(n1 != null && n2 != null) {
			if(n1 == n2) {
				System.out.println(n1.val);
				return n1;
			} else {
				n1 = n1.next;
				n2 = n2.next;
			}
		}
		
		return null;
	}
	
	public static int getlength(ListNode n) {
		int l = 0;
		while(n != null) {
			l++;
			n = n.next;
		}
		return l;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode n6 = new ListNode(1);
		ListNode n7 = new ListNode(1);
		n6.next = n7;
		n7.next = n4;
		
		System.out.println(findIntersection(n1, n6));
	}
}
