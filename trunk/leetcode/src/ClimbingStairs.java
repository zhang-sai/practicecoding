
/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
public class ClimbingStairs {
	public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int num = 0;
        int prevprev = 1;
        int prev = 2;
        for(int i = 2; i < n; i++) {
            num = prevprev + prev;
            prevprev = prev;
            prev = num;
        }
        return num;
    }
}
