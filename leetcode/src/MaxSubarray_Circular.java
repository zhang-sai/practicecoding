
/**
 * circular array, elements are +/-, find subsequence of max sum
 * */


//http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
public class MaxSubarray_Circular {

	public static int findMaxSubarrayCircular(int[] array) {
		if(array.length == 0) {
			return 0;
		}
		//keep the max
		int max = Integer.MIN_VALUE;
		
		int startingIndex = 0;
		
		//the max sum so far
		int max_so_far = array[0];
		
		//array.length + startingIndex controls the number of iterations
		for(int i = 1; i < array.length + startingIndex; i++) {
			//compute the actual index
			int index = i % array.length;
			if(array[index] > max_so_far + array[index]) {
				max_so_far = array[index];
				startingIndex = index;  //reset the starting index
			} else {
				max_so_far = max_so_far + array[index];
			}
			max = Math.max(max, max_so_far);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1, 3, -100, 4, 5};
		System.out.println(findMaxSubarrayCircular(array));
		
		array = new int[]{1, 3, 6, 4, 5};
		System.out.println(findMaxSubarrayCircular(array));
	}
}
