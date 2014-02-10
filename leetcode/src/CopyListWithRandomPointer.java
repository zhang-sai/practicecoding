import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 * */

public class CopyListWithRandomPointer {	
	
	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		n1.random = n3;
		n2.random = n4;
		
		RandomListNode copied = copyRandomListWithConstantSpace(n1);
		
//		System.out.println(copied.label);
//		System.out.println(copied.next.label);
//		System.out.println(copied.next.next.label);
//		System.out.println(copied.next.next.next.label);
		
		while(copied != null) {
			System.out.println(copied.label + " " + (copied.random != null ? copied.random.label : "null"));
//			+ ", random: "
//					+ copied.random != null ? copied.random.label : "null");
			copied = copied.next;
		}
		
	}
	
	/**
	 * With constant space
	 * page 128
	 * */
	public static RandomListNode copyRandomListWithConstantSpace(RandomListNode head) {
		
		if(head == null) {
			return null;
		}
		RandomListNode newBeforeHead = new RandomListNode(-1);
		
		//copy the old node to a new node, fill in the data, copy the newnode.next
		//make oldnode.next = new node, make the newnode.random un-set
		RandomListNode oldCurr = head;
//		RandomListNode newPrev = newBeforeHead;
		while(oldCurr != null) {
			RandomListNode newCurr = new RandomListNode(oldCurr.label);
			newCurr.next = oldCurr.next;
			
			//RandomListNode next = oldCurr.next;
			oldCurr.next = newCurr;
			
			//set the new node
			if(newBeforeHead.next == null) {
				System.out.println("set: " + newCurr.label);
				newBeforeHead.next = newCurr;
			}
			
			//set the old curr
			oldCurr = newCurr.next;
		}
		
		
		//make newnode.random to the right place
		oldCurr = head;
		while(oldCurr != null) {
			//oldCurr.next is the new
			oldCurr.next.random = oldCurr.random != null ? oldCurr.random.next : null;
			oldCurr = oldCurr.next.next; //must be two next
		}
		
		//reset the old.next
		oldCurr = head;
		while(oldCurr != null) {
			oldCurr.next = oldCurr.next.next;
			oldCurr = oldCurr.next;
		}
		
		
		System.out.println("return: " + newBeforeHead.next.label);
		return newBeforeHead.next;
	}
	

	/**
	 * With O(n) space
	 * */
	public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(head == null) {
            return head;
        }
        
        Map<RandomListNode, RandomListNode> oldToNewNodes = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode newPrevHead  =  new RandomListNode(-1);
        
        RandomListNode curr = newPrevHead;
        RandomListNode oldCurr = head;
        while(oldCurr != null) {
            RandomListNode newNode = null;
            if(oldToNewNodes.containsKey(oldCurr)) {
                newNode = oldToNewNodes.get(oldCurr);
            } else {
                newNode = new RandomListNode(oldCurr.label);
                oldToNewNodes.put(oldCurr, newNode);
            }
            curr.next = newNode;
            
            RandomListNode randomNode = oldCurr.random;
            if(randomNode != null) {
                RandomListNode newRandomNode = null;
                if(oldToNewNodes.containsKey(randomNode)) {
                    newRandomNode = oldToNewNodes.get(randomNode);
                } else {
                    newRandomNode = new RandomListNode(randomNode.label);
                    oldToNewNodes.put(randomNode, newRandomNode);
                }
                newNode.random = newRandomNode;
            }
            
            curr = newNode;
            oldCurr = oldCurr.next;
        }
        
        return newPrevHead.next;
        
    }
	
}

class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };
	  
	  //use constant space
	  
	  
