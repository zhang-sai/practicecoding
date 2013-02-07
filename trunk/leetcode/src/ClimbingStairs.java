
/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
public class ClimbingStairs {
	public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(n <= 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		int[] nums = new int[n+1];
		nums[0] = 0;
		nums[1] = 1;
		nums[2] = 2;
		
		for(int i = 3; i < nums.length; i++) {
			nums[i] = nums[i-1] + nums[i-2];
		}
		
		return nums[n];
        
    }
}
