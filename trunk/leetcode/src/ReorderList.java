import util.Files;


/**
 * 
 * Given a singly linked list L: L0->L1 .. -> ..Ln-1 -> Ln,
reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * */
public class ReorderList {

	//first reverse the list in place
	static ListNode  reverseList(ListNode head)  
    {  
        if(head == null || head.next == null)  
            return head;
        ListNode tmphead = reverseList(head.next);  
        //now it looks like:  head --> tmphead <--- n1 <-- n2 <-- n
        head.next.next = head;  
        head.next = null;  
        return tmphead;  
    }  
    
	//first go to the middle point, and then weave together
	static void  reorderList(ListNode head) {  
        // IMPORTANT: Please reset any member data you declared, as  
        // the same Solution instance will be reused for each test case.  
        if(head == null || head.next == null) {
            return;  
        }
        //keep two pointers: a slow one and a fast
        ListNode pslow = head;  
        ListNode pfast = head;  
        //advance fast nodes two steps, the slow node once
        //in each iteration
        while(pfast != null) {  
            if(pfast != null) { 
                pfast = pfast.next;  
            }
            if(pfast != null) {
                pfast = pfast.next;  
            }
            if(pfast==null)  {
                break;  
            }
            pslow = pslow.next;  
        }  
        //start to take some action
        //1, 2, 3, 4
        //now pslow = 1, pfast = null;
        ListNode head2 = pslow.next;
        //head2 = 2
        pslow.next = null;  
        //reverse the remaining
        //1,  2<-3<-4  (head2 = 4)
        head2 = reverseList(head2); 
        //p1 = 1
        //p2 = 4
        ListNode p1 = head;  
        ListNode p2 = head2;  
        ListNode tmp = null; 
        while(p1!=null && p2 != null){  
            tmp = p1.next;  
            p1.next = p2;  
            p1 = tmp;
            
            //weave together
            tmp = p2.next;  
            p2.next = p1;  
            p2 = tmp;  
        }  
    }
	
	public static ListNode readList(String fileName) {
		String src = Files.readWholeAsString(fileName);
		String[] splits = src.split(",");
		System.out.println("size: " + splits.length);
		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy;
		int count= 0;
		for(String str : splits) {
			str = str.trim();
			count++;
//            if(str.startsWith("\"")) {
//            	System.out.println(count);
//			}
			int v = Integer.parseInt(str);
			
//			System.out.println(count);
			ListNode node = new ListNode(v);
			curr.next = node;
			curr = node;
		}
		
		return dummy.next;
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
    	reorderList(n1);
    	
    	
    	
    	while(n1 != null) {
    		System.out.println(n1.val);
    		n1 = n1.next;
    	}
    	
    	ListNode head = readList("C:\\Users\\szhang\\Desktop\\testdata.txt");
    	reorderList(head);
    	n1 = head;
    	while(n1 != null) {
    		System.out.println(n1.val);
    		n1 = n1.next;
    	}
    }
}
