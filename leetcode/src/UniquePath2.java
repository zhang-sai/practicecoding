/**
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 * */
public class UniquePath2 {


	public int uniquePathsWithObstacles(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] nums = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				nums[i][j] = 0;
			}
		}
		//for all first cells rows
		for(int i = 0; i < m; i++) {
			if(grid[i][0] != 1) {
				nums[i][0] = 1;
				
			} else {
				break; //XXX do not forget break here
			}
		}
		//for all first cells columns
		for(int i = 0; i < n; i++) {
			if(grid[0][i] != 1) {
				nums[0][i] = 1;
				
			} else {
				break;
				//XXX do not forget break here, never set all 0 below
			}
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(grid[i][j] == 1) {
					nums[i][j] = 0;
				} else {
					//check three places
					int pathNum = 0;
					if(grid[i][j-1] != 1) {
						pathNum += nums[i][j-1];
					}
					if(grid[i-1][j] != 1) {
						pathNum += nums[i-1][j];
					}
					nums[i][j] = pathNum;
				}
			}
		}
		
		return nums[m-1][n-1];
    }
	
	public static void main(String[] args) {
		UniquePath2 p = new UniquePath2();
		System.out.println(p.uniquePathsWithObstacles(new int[][]{new int[]{1, 0}}));
	}
}
