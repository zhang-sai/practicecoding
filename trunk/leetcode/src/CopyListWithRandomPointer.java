import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 * */
public class CopyListWithRandomPointer {

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
