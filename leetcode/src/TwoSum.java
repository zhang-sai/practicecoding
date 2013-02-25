import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 * */
public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int[] results = new int[2];
		//XXX be aware of duplication
		HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		
		for(int i = 0; i < numbers.length; i++) {
			if(!map.containsKey(numbers[i])) {
				map.put(numbers[i], new HashSet<Integer>());
			}
			map.get(numbers[i]).add(i);
		}
		
//		System.out.println(map);
		for(int i = 0; i < numbers.length; i++) {
			int v = numbers[i];
			if(map.containsKey(target - v)) {
				int index1 = i + 1;
//				System.out.println(v + ", " + i);
				map.get(v).remove(i);
//				System.out.println(target - v);
				int index2 = map.get(target-v).iterator().next() + 1;
				results[0] = Math.min(index1, index2);
				results[1] = Math.max(index1, index2);
				break; //XXX must break out, it may exit multiple pairs [2, 25, 75] and target is 100. 
				//if it does not break out when iterating to 25,
				//then the same answer will be presented when iterating to 75
			}
		}
		
		return results;
        
    }
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		ts.twoSum(new int[]{2, 25, 75}, 100);
	}
}
