import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * */
public class InsertIntervals {

	//a sample solution: http://blog.theliuy.com/2012/insert-interval/
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		ArrayList<Interval> retList = new ArrayList<Interval>();
		boolean flag =  false;
		for(Interval interval : intervals) {
			//[start, end] [new.start, new.end]  , did not reach the newInterval yet
			if(interval.end < newInterval.start) {
				retList.add(interval);
				continue;
			}
			//[newStart, newEnd] [start end] 
			if(interval.start > newInterval.end) {
				if(!flag) {
					retList.add(newInterval);
					flag = true;
				}
				retList.add(interval);
				continue;
			}
			//other cases, there must be some intersection
			newInterval.start = Math.min(newInterval.start, interval.start);
			newInterval.end = Math.max(newInterval.end, interval.end);
		}
		
		//XXX do not forget this
		if(!flag) {
			retList.add(newInterval);
		}
        
		return retList;
    }
	
	public static void main(String[] args) {
		InsertIntervals ii = new InsertIntervals();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 5));
		Interval newInterval =  new Interval(1, 5);
		System.out.println(ii.insert(intervals, newInterval));
	}
}


