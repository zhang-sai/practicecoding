import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * */
public class MergeKSortedList {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists == null || lists.isEmpty()) {
        	return null;
        }
        
        //define a comparator
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val >= o2.val ? 1 : -1;
			}
        };
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
        ListNode head = null;
        ListNode curr = null;
        for(ListNode n : lists) {
        	if(n != null) { //XXX do not forget this check
        	heap.add(n);
        	}
        }
        
        //start to get from the heap
        while(!heap.isEmpty()) {
        	ListNode next = heap.poll();
        	ListNode newNode = new ListNode(next.val);
        	if(head == null) {
        		head = newNode;
        		curr = head;
        	} else {
        		curr.next = newNode;
        		curr = curr.next;
        	}
        	if(next.next != null) {
        		heap.add(next.next);
        	}
        }
        
        return head;
    }
	
	public static void main(String[] args) {
		MergeKSortedList ks = new MergeKSortedList();
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(new ListNode(1));
		ks.mergeKLists(lists);
	}
}
