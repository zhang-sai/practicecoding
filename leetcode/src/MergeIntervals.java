import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * */
public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Interval interval : intervals) {
			if(!map.containsKey(interval.start)) {
				map.put(interval.start, interval.end);
			} else {
				map.put(interval.start, Math.max(interval.end, map.get(interval.start)));
			}
		}
		
//		System.out.println(map);
		
		//iterate the key in  ascending order
		List<Integer> keys = new LinkedList<Integer>();
		keys.addAll(map.keySet());
		Collections.sort(keys);
		
//		System.out.println(keys);
		
		ArrayList<Interval> list = new ArrayList<Interval>();
		Set<Integer> skipIndex = new HashSet<Integer>();
		for(Integer start :keys) {
//			System.out.println(map);
//			System.out.println(start);
			if(skipIndex.contains(start)) {
				continue;
			}
			int end = map.get(start);
			
			for(int i = start + 1; i <=end ; i++) {
				if(map.containsKey(i)) {
					end = Math.max(end, map.get(i));
//					map.remove(i); //XXX cannot remove it
//					keys.remove((Integer)i); //XXX cannot remove keys, lead to concurrentmodification error
					skipIndex.add(i);
				}
			}
			
			list.add(new Interval(start, end));
			
		}
		
		return list;
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
	     Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	     public String toString() {
	    	 return "(" + start + ", " + end + ")";
	     }
}