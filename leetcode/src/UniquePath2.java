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
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] paths = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            if(grid[i][0] == 1) {
                break;
            }
            paths[i][0] = 1;
        }
        for(int i = 0; i < cols; i++) {
            if(grid[0][i] == 1) {
                break;
            }
            paths[0][i] = 1;
        }
        //compute the rest
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                paths[i][j] = (grid[i][j] == 1) ? 0 : (paths[i-1][j] + paths[i][j-1]); 
            }
        }
        
        return paths[rows-1][cols-1];
    }
	
	public static void main(String[] args) {
		UniquePath2 p = new UniquePath2();
		System.out.println(p.uniquePathsWithObstacles(new int[][]{new int[]{1, 0}}));
	}
}
