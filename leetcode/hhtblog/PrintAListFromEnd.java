
//http://zhedahht.blog.163.com/blog/static/2541117420079237185699/
public class PrintAListFromEnd {
	
	//use recursion
	
	public static void print(ListNode n) {
		if(n == null) {
			return;
		}
		print(n.next);
		System.out.println(n.val);
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		print(n1);
	}

}