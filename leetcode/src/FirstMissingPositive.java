
/**
 * 
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 * */
XXXX may have duplication
public class FirstMissingPositive {
	public int firstMissingPositive(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(a.length == 0) {
			return 1;
		}
		
		int sum = 0;
		for(int i : a) {
			if(i <= 0) {
				continue;
			}
			int pow = (int)Math.pow(2.0, (double)i);
			sum = sum + pow;
		}
		
		//decide which positive is missing
		if(sum == 0) {
			return 1;
		}
        sum = sum/2; //remove the last c
        int missing = 1;
        while(sum != 0) {
        	int mod = sum%2;
        	if(mod == 0) {
        		return missing;
        	}
        	sum = sum/2;
        	missing++;
        }
        return missing;
    }
}