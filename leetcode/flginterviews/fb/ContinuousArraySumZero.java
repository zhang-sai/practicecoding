package fb;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an array write a function to print all continuous subsequences in the array which sum of 0. 
e.g: 
Input: 
Array = [-1, -3, 4, 5, 4] 
output: 
-1, -3, 4


http://www.careercup.com/question?id=5172027535130624

 * */
public class ContinuousArraySumZero {

	public static void printAllContinuousArray(int[] array) {
		/**
		 * Then, just find the same values in sum[].
For example,
[-1, -3, 4, 5, -2, -7]
[0, -1, -4, 0, 5, 3, -4]
There is a pair 0, that mean the range from 0 to 2.
Another pair -4, that means the range form 2 to 5.
		 * */
		
		int[] sums = new int[array.length + 1];
		sums[0] = 0;
		for(int i = 0; i < array.length; i++) {
			sums[i+1] = sums[i] + array[i];
		}
		//now find the same pairs
		Map<Integer, List<Integer>> valueIndex = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0; i < sums.length; i++) {
			if(valueIndex.containsKey(sums[i])) {
				//find it
				System.out.println("current index: " + i);
				//
//				System.out.println("   startiing: " + valueIndex.get(sums[i]));
				for(int sIndex : valueIndex.get(sums[i])) {
					for(int startIndex = sIndex; startIndex < i; startIndex++) {
						System.out.print(array[startIndex] + " ");
					}
					System.out.println();
				}
			} else {
				valueIndex.put(sums[i], new LinkedList<Integer>());
			}
			valueIndex.get(sums[i]).add(i); //add new index
		}
	}
	
	public static void main(String[] args) {
		printAllContinuousArray(new int[]{-1, -3, 4, 5, 4});
		System.out.println("---------------------");
		printAllContinuousArray(new int[]{-1, -3, 4, 5, 4, -9});
		System.out.println("---------------------");
		printAllContinuousArray(new int[]{-1, -3, 4, 0, -3, -2, 5, 4, -9});
	}
	
}
