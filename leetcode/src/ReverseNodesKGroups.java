/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * */
public class ReverseNodesKGroups {
	//for details, see: http://crackinterviewtoday.wordpress.com/2010/03/28/k-reverse-linked-list/
	public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if(head == null || k < 2) {
			return head;
		}
        
		ListNode nextNode = head;
		ListNode startNode = null;
		ListNode endNode = null;
		head = null;
		
		while(nextNode != null) {
			startNode = nextNode;
			endNode = nextNode;
			
			//move
			for(int i = 1; i <=k; i++) {
				endNode = endNode.next;
				if(endNode == null) {
					break;
				}
			}
			
			//check end node
			if(endNode != null) {
				
			} else {
				nextNode = null;
			}
			
			if(head == null) {
				head = startNode;
			}
		}
    }
}
