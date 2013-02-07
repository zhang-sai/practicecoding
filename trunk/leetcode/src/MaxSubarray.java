
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
//        int begin = 0;
//        int begin_temp = 0;
//        int end = 0;
        // Find sequence by looping through
        for(int i = 1; i < numbers.length; i++)
        {
                // calculate max_ending_here
                max_ending_here += numbers[i];
                if(numbers[i] > max_ending_here) //XXX this part is critical
                {
                        max_ending_here = numbers[i];
//                        begin_temp = i;
                }
                // calculate max_so_far
                if(max_ending_here > max_so_far )
                {
                        max_so_far  = max_ending_here;
//                        begin = begin_temp;
//                        end = i;
                }
        }
        // return max_so_far 
        return max_so_far ;
    }
	
	private int returnMax(int[] a) {
		if(a.length == 0) {
			return 0;
		}
		if(a.length == 1) {
			return a[0];
		}
        // Start typing your Java solution below
        // DO NOT write main() function
		int max = Integer.MIN_VALUE;
        int[] sum = new int[a.length];
        int index = -1;
        for(int i = 0; i < a.length; i++) {
        	if(i == 0) {
        		sum[i] = a[i];
        	} else {
        		sum[i] = sum[i-1] + a[i];
        	}
        	if(sum[i] >= max) {  //expand it, including 0 XXX must be >=
        		max = sum[i];
        		index = i;
        	}
        }
        //pick up the biggest value
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < index; i++) {
        	if(sum[i] < min) {
        		min = sum[i];
        	}
        }
        if(index == 0) {
        	min = 0;
        }
        
        //re-duct
        //XXX
        if(min > 0) {
        	min = 0;
        }
        
        return max - min;
	}
	
	public static void main(String[] args) {
		MaxSubarray maxSub = new MaxSubarray();
		System.out.println(maxSub.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(maxSub.maxSubArray(new int[]{-2,-1, -2}));
	}
}
