import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 * */
public class JumpGame1and2 {
	public boolean canJump(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length == 0 || a.length == 1) {
        	return true;
        }
        //construct a graph
        Map<Integer, List<Integer>> edgeMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < a.length; i++) {
        	Integer currentEle = i;
        	int maxStep = a[i];
        	for(int step = 1; step <= maxStep && currentEle + step < a.length; step++ ) {
        		if(!edgeMap.containsKey(currentEle)) {
        			edgeMap.put(currentEle, new LinkedList<Integer>());
        		}
        		edgeMap.get(currentEle).add(currentEle + step);
        	}
        }
        //then start search
        Integer start = 0;
        Integer target = a.length - 1;
        List<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        Set<Integer> visited = new HashSet<Integer>();
        
        while(!queue.isEmpty()) {
        	Integer top = queue.remove(0);
        	if(top == target) {
        		return true;
        	} else {
        		if(visited.contains(top)) {
        			continue;
        		}
        		List<Integer> nexts = edgeMap.get(top);
        		if(nexts != null) {
        		    for(Integer n : nexts) {
        			    queue.add(n);
        		    }
        		}
        	}
        }
        
        return false;
    }
	
	//return minimum number of jumps
	public int jump(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// Start typing your Java solution below
        // DO NOT write main() function
        if(a.length == 0 || a.length == 1) {
        	return 0;
        }
        //construct a graph
        Map<Integer, List<Integer>> edgeMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < a.length; i++) {
        	Integer currentEle = i;
        	int maxStep = a[i];
        	for(int step = 1; step <= maxStep && currentEle + step < a.length; step++ ) {
        		if(!edgeMap.containsKey(currentEle)) {
        			edgeMap.put(currentEle, new LinkedList<Integer>());
        		}
        		edgeMap.get(currentEle).add(currentEle + step);
        	}
        }
        //then start search
        Integer start = 0;
        Integer target = a.length - 1;
        List<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        Set<Integer> visited = new HashSet<Integer>();
        
        Map<Integer, Integer> backTracking = new HashMap<Integer, Integer>();
        
        while(!queue.isEmpty()) {
        	Integer top = queue.remove(0);
        	if(top == target) {
        		//query the backtracking
        		int count = 0;
        		while(!top.equals(start)) {
        			count++;
        			top = backTracking.get(top);
        		}
        		return count;
        	} else {
        		if(visited.contains(top)) {
        			continue;
        		}
        		List<Integer> nexts = edgeMap.get(top);
        		if(nexts != null) {
        		    for(Integer n : nexts) {
        		    	if(!backTracking.containsKey(n)) {
        		    		backTracking.put(n, top);
        		    	}
        			    queue.add(n);
        		    }
        		}
        	}
        }
        
        return -1;
    }
}
