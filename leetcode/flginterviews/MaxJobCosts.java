import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a set of n jobs with [start time, end time, cost] find a subset so that
 * no 2 jobs overlap and the cost is maximum
 * */
public class MaxJobCosts {

	//use interval to mimic a job
	public static void  main(String[] args) {
		Interval[] intervals = new Interval[]{
				new Interval(1, 2, 1),
				new Interval(2, 4, 3),
				new Interval(3, 5, 10), //11
				new Interval(6, 10, 5), 
				new Interval(8, 11, 6), //17
				new Interval(11, 12, 1), 
				new Interval(11, 13, 3) //20
				//max = 20
		};
		System.out.println(maxJobCosts(intervals));
	}
	
	public static int maxJobCosts(Interval[] intervals) {
		
		Map<Integer, List<Interval>> startTimes = new HashMap<Integer, List<Interval>>();
		Map<Integer, List<Interval>> endTimes = new HashMap<Integer, List<Interval>>();
		
		for(Interval interval : intervals) {
			int start = interval.start;
			int end = interval.end;
			//the start
			if(!startTimes.containsKey(start)) {
				startTimes.put(start, new LinkedList<Interval>());
			} 
			startTimes.get(start).add(interval);
			//the end
			if(!endTimes.containsKey(end)) {
				endTimes.put(end, new LinkedList<Interval>());
			}
			endTimes.get(end).add(interval);
		}
		
		//all times
		//sort both starting and ending time
		ArrayList<Integer> times = new ArrayList<Integer>();
		times.addAll(endTimes.keySet());
		Collections.sort(times);
		
		
		//using an arrange to keep track of the end time
		
		int[] maxCost = new int[endTimes.size()];
		for(int i = 0; i < times.size(); i++) {
			int endTime = times.get(i);
			List<Interval> endIntervals = endTimes.get(endTime);
			//only check for the end time
			for(Interval interval : endIntervals) {
			    if( i == 0) {
				    maxCost[i] = Math.max(maxCost[i], interval.cost);
			    } else {
			    	int startTime = interval.start;
			    	//find the number of the first interval, whose endtime is < startTime
			    	int lastIndex = -1;
			    	for(int j = i - 1; j >= 0; j--) {
			    		int prevEndTime = times.get(j);
			    		if(prevEndTime <= startTime) {
			    			lastIndex = j;
			    			break;
			    		}
			    	}
			    	int prevCost = lastIndex == -1 ? 0 : maxCost[lastIndex];
				    maxCost[i] = Math.max(maxCost[i - 1], interval.cost + prevCost);
			    }
			}
		}
		
		return maxCost[times.size() - 1];
	}

}
