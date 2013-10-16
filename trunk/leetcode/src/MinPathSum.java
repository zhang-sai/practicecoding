/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * */
public class MinPathSum {

	public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] paths = new int[rows][cols];
        
        paths[0][0] = grid[0][0];
        for(int i = 1; i < rows; i++) {
            paths[i][0] = paths[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < cols; i++) {
            paths[0][i] = paths[0][i-1] + grid[0][i];
        }
        
        //use dp
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                paths[i][j] = Math.min(paths[i-1][j], paths[i][j-1]) + grid[i][j];
            }
        }
        
        
        return paths[rows-1][cols-1];
    }
	
	public static void main(String[] args) {
		MinPathSum mps = new MinPathSum();
//		System.out.println(mps.minPathSum(new int[][]{new int[]{0}}));
		System.out.println(mps.minPathSum(new int[][]{new int[]{1, 2, 5}, new int[]{3, 2, 1}}));
	}
}
