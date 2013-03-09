/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//two extreme cases
		if(l1 == null) {
			return l2;
		};
		if(l2 == null) {
			return l1;
		}
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode retNode = null;
        ListNode node1 = l1;
        ListNode node2 = l2;
        
        ListNode currNode = null;
        if(node1.val < node2.val) {
        	currNode = node1;
        	node1 = node1.next;
        } else {
        	currNode = node2;
        	node2 = node2.next;
        }
        retNode = currNode;
        
        while(true) {
        	if(node1 != null && node2 != null) {
        		if(node1.val < node2.val) {
        			currNode.next = node1;
        			currNode = currNode.next;
        			//move node1 to next
        			node1 = node1.next;
        		} else {
        			currNode.next = node2;
        			currNode = currNode.next;
        			//move node2
        			node2 = node2.next;
        		}
        	} else if (node1 != null) {
        		currNode.next = node1;
        		break;
        	} else if (node2 != null) {
        		currNode.next = node2;
        		break;
        	} else {
        		break;
        	}
        }
        
        return retNode;
    }
}
