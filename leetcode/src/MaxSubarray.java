
/**
 * Find the contiguous subarray within an array 

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another
solution using the divide and conquer approach, which is more subtle.

http://en.wikipedia.org/wiki/Maximum_subarray_problem
 * */
public class MaxSubarray {
	public int maxSubArray(int[] numbers) {
		int max_so_far  = numbers[0], max_ending_here = numbers[0];
        for(int i = 1; i < numbers.length; i++)
        {
                // calculate max_ending_here
                max_ending_here += numbers[i];
                if(numbers[i] > max_ending_here) //XXX this part is critical
                {
                        max_ending_here = numbers[i];
                }
                // calculate max_so_far
                if(max_ending_here > max_so_far )
                {
                        max_so_far  = max_ending_here;
                }
        }
        // return max_so_far 
        return max_so_far ;
    }
	
	public static void main(String[] args) {
		MaxSubarray maxSub = new MaxSubarray();
		System.out.println(maxSub.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(maxSub.maxSubArray(new int[]{-2,-1, -2}));
	}
	
	
	
	public int maxSubArray_v2(int[] numbers) {
		int  max_so_far = numbers[0];
		int maxSum = max_so_far;
		for(int i = 1; i < numbers.length; i++) {
			int v = numbers[i];
			if(max_so_far + v < v) {
				max_so_far = v;
			} else {
				max_so_far = max_so_far + v;
			}
			if(max_so_far > maxSum) {
				maxSum = max_so_far;
			}
		}
		
		return maxSum;
	}
}
