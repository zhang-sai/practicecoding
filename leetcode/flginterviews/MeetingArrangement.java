import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a vector of Nodes, each of which contain the start and end time of a 
meeting, find the maximum number of rooms one would have to book for the day
. 

Just count at the same time, how many meetings are running.


this is different than coloring, for instance, the following graph is not possible:

     A
    / \
   B   C
    \ /
     D
     
  both A, D are intersected with B and C, but A, D are not intersected, which is impossible

 * */

public class MeetingArrangement {

	//use interevals to represent a meeting
	public static void main(String[] args) {
		Interval[] intervals = new Interval[]{
				new Interval(1, 2),
				new Interval(2, 5),
				new Interval(3, 4),
				new Interval(4, 8),
				new Interval(4, 5),
				new Interval(5, 7),
				new Interval(5, 7),
				new Interval(6, 12),
				new Interval(11, 15),
				new Interval(11, 12)
				
		};
		System.out.println(maxArrangement(intervals));
	}
	
	//additional features, assign room
	public static int maxArrangement(Interval[] intervals) {
		
		
		boolean[] rooms = new boolean[intervals.length];
		
		Map<Interval, Integer> assignment = new HashMap<Interval, Integer>();
		
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
		
		ArrayList<Integer> times = new ArrayList<Integer>();
		times.addAll(startTimes.keySet());
		times.addAll(endTimes.keySet());
		times = new ArrayList<Integer>(new HashSet<Integer>(times));
		Collections.sort(times);
		
		int maxNumber = 0;
		int currNum = 0;
		for(Integer t : times) {
			//DO END before start
			if(endTimes.containsKey(t)) {
				currNum -= endTimes.get(t).size();
				//release the rooms
				List<Interval> currMeetings = endTimes.get(t);
				for(Interval m : currMeetings) {
//					System.out.println(m + ", " + assignment.get(m));
					rooms[assignment.get(m)] = false; //release the room
				}
				
			}
			
			if(startTimes.containsKey(t)) {
				currNum += startTimes.get(t).size();
				List<Interval> currMeetings = startTimes.get(t);
				for(Interval m : currMeetings) {
					//find the available ones
					for(int i = 0; i < rooms.length; i++) {
						if(!rooms[i]) {
							rooms[i] = true;
							assignment.put(m, i);
							System.out.println("  assign: " + m + " with: " + i);
							break;
						}
					}
				}
			}
			
			
			maxNumber = Math.max(currNum, maxNumber);
//			System.out.println("time: " + t + ", curr: " + currNum + " max: "+ maxNumber);
		}
		
		
		return maxNumber;
	}
	
}
