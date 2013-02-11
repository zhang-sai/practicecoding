
/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 * */
public class UniquePath {

	public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		if(m == 0 || n == 0) {
			return 0;
		}
		
		//use dynamic programming
		int[][] nums = new int[m+1][n+1];
		for(int i = 0; i < m+1; i++) {
			nums[i][0] = 0;
			nums[i][1] = 1;
		}
		for(int i = 0; i < n + 1; i++) {
			nums[0][i] = 0;
			nums[1][i] = 1;
		}
		
		for(int i = 2; i < m+1; i++) {
			for(int j = 2; j < n + 1; j++) { //XXX no need this part
				nums[i][j] = nums[i-1][j] + nums[i][j-1]; // + 2*(nums[i-1][j-1] == 0 ? 1 : nums[i-1][j-1]); //XXX be careful
			}
		}
		
		return nums[m][n];
    }
	
}
