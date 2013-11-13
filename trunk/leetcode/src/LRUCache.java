import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//http://blog.csdn.net/violet_program/article/details/15335673
//use a double linked list



public class LRUCache {
	
	class CacheNode {
		CacheNode prev = null;
		CacheNode next = null;
		int key = -1;
		int value = -1;
		CacheNode(int k, int v) {
			key = k;
			value = v;
		}
	}

    int capacity = -1;
    
    Map<Integer, CacheNode> map = new HashMap<Integer, CacheNode>();
    
    CacheNode head = new CacheNode(-1, -1);
    CacheNode tail = new CacheNode(-1, -1);
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	CacheNode n =  map.get(key);
        	//break the link
        	n.prev.next = n.next;
        	n.next.prev = n.prev;
        	//attach to the head
        	this.attach(n);
        	
        	return n.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            //update the time stamp
            CacheNode n = map.get(key);
            n.value = value;
            //delete the original node
            n.prev.next = n.next;
            n.next.prev = n.prev;
            this.attach(n);
        } else {
            if(map.size() < capacity) {
//            	System.out.println(map.size() + "   " + capacity);
            	CacheNode newNode = new CacheNode(key, value);
                //put to the map
                map.put(key, newNode);
                //attach the node to the head
                this.attach(newNode);
                
                
            } else {
                //need to invalidate some
                //remove the last one
            	CacheNode lastNode = tail.prev;
            	map.remove(lastNode.key);
            	this.detach(lastNode);
            	//create a new one
            	CacheNode newNode = new CacheNode(key, value);
                map.put(key, newNode);
                this.attach(newNode);
                
                
            }
        }
    }
    
    //to the head
    private void attach(CacheNode n) {
    	n.next = head.next;
    	head.next.prev = n;
    	
    	head.next = n;
    	n.prev = head;
    }
    
    //from the tail
    private void detach(CacheNode n) {
    	n.prev.next = n.next;
    	n.next.prev = n.prev;
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache(2);
//    	cache.set(2, 1);
//    	cache.get(2);
//    	cache.set(3, 2);
    	System.out.println(cache.map);
    	cache.set(2,1);
    	System.out.println(cache.map);
    	cache.set(1,1);
    	System.out.println(cache.map);
    	cache.set(2,3);
    	System.out.println(cache.map);
    	cache.set(4,1);
    	System.out.println(cache.map);
    	System.out.println(cache.get(1));
    }
}
