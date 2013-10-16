import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        Map<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            valueToIndex.put(numbers[i],i);
        }
        for(int i = 0; i< numbers.length; i++) {
            if(valueToIndex.containsKey(target - numbers[i])) {
                results[0] = i + 1;
                results[1] = valueToIndex.get(target - numbers[i]) + 1;
                break;
            }
        }
        
        return results;
    }
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		ts.twoSum(new int[]{2, 25, 75}, 100);
	}
}
