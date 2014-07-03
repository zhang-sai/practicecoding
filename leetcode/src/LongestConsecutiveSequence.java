import java.util.HashMap;
import java.util.Map;


/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

XXX only update the lowest and highest index
 * */

public class LongestConsecutiveSequence {
	//here is an example solution:
	//http://discuss.leetcode.com/questions/1070/longest-consecutive-sequence
	public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0) {
        	return 0;
        }
        //here is the running example:
        //100, 4, 3, 2, 1
        //100, 1
        //4, 1
        //3, 1
        //merge: 3,4
        //4, 2
        //3, 2
        
        HashMap<Integer, Integer> clusters = new HashMap<Integer, Integer>();
        int max = 1;
        for(int i : num) {
        	if(!clusters.containsKey(i)) {
        		clusters.put(i, 1);
        		//check i - 1;
        		//XXX only need to update the highest and lowest boundary
        		if(clusters.containsKey(i - 1)) {
        			//merge i and i-1
        			max = Math.max(max, this.merge(clusters, i - 1, i));
        		}
        		if(clusters.containsKey(i+1)) {
        			//merge i and i + 1
        			max = Math.max(max, this.merge(clusters, i, i + 1));
        		}
        	}
        }
        
        return max;
    }
	
	private int merge(Map<Integer, Integer> map, int left, int right) {
		int upperBound = right + map.get(right) - 1;
		int lowerBound = left - map.get(left) + 1;
		int length = upperBound - lowerBound + 1;
		map.put(upperBound, length);
		map.put(lowerBound, length);
		return length;
	}
}
