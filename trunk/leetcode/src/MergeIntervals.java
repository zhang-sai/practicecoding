import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * */
public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        //first merge redundant intervals
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Interval interval : intervals) {
			if(!map.containsKey(interval.start)) {
				map.put(interval.start, interval.end);
			} else {
				map.put(interval.start, Math.max(interval.end, map.get(interval.start)));
			}
		}
		
		//sort map keys in ascending order
		List<Integer> keys = new LinkedList<Integer>();
		keys.addAll(map.keySet());
		Collections.sort(keys);
		
		ArrayList<Interval> list = new ArrayList<Interval>();
		Stack<Interval> stack = new Stack<Interval>();
		for(Integer start : keys) {
		    if(stack.isEmpty()) {
		        stack.push(new Interval(start, map.get(start)));
		    } else {
		        Interval top = stack.peek();
		        if(top.end < start) {
		            stack.push(new Interval(start, map.get(start)));
		        } else {
		            top.end = Math.max(map.get(start), top.end);
		        }
		    }
		}
		
		while(!stack.isEmpty()) {
		    Interval interval = stack.pop();
		    list.add(0, interval);
		}
		
		return list;
		
// 		//create a return interval list
// 		ArrayList<Interval> list = new ArrayList<Interval>();
// 		//a list of interval that should not be inserted
// 		Set<Integer> skipIndex = new HashSet<Integer>();
// 		for(Integer start :keys) {
// 			if(skipIndex.contains(start)) {
// 				continue;
// 			}
// 			//get the end
// 			//the current interval [start, end]
// 			int end = map.get(start);
// 			for(int i = start + 1; i <=end ; i++) {
// 				if(map.containsKey(i)) {
// 					end = Math.max(end, map.get(i));
// 					skipIndex.add(i); //skip the the current start index
// 				}
// 			}
			
// 			//add a new interval
// 			list.add(new Interval(start, end));
// 		}
		
// 		return list;
    }
	
	//[2,3],[5,5],[2,2],[3,4],[3,4]
	public static void main(String[] args) {
		Interval i1 = new Interval(2, 3);
		Interval i2 = new Interval(5, 5);
		Interval i3 = new Interval(2, 2);
		Interval i4 = new Interval(3, 4);
		Interval i5 = new Interval(3, 4);
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		list.add(i5);
		MergeIntervals mi = new MergeIntervals();
		System.out.println(mi.merge(list));
	}
}

class Interval {
	     int start;
	     int end;
	     int cost;
	     
	     Interval() { start = 0; end = 0; cost = 0;}
	     Interval(int s, int e) { start = s; end = e; cost = 0;}
	     Interval(int s, int e, int c) { start = s; end = e; cost = c; }
	     public int hashCode() {
	    	 return start + 99*end + 101*cost;
	     }
	     public String toString() {
	    	 return "(" + start + ", " + end + 
	    	     (cost != 0 ? ", (cost: " + cost + ")" : "") + ")";
	     }
}
