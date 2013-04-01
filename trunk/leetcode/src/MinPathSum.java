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
        if(grid[0].length == 0) {
        	return 0;
        }
        int[][] costs = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid[0].length; i++) { //XXX be aware of grid[0], not grid
        	costs[0][i] = i==0 ? grid[0][i] : costs[0][i-1] + grid[0][i];
        }
        for(int i = 0; i < grid.length; i++) {
        	costs[i][0] = i == 0? grid[i][0] : costs[i-1][0] + grid[i][0];
        }
        //compute each cost
        for(int i = 1; i < grid.length; i++) {
        	for(int j = 1; j < grid[0].length; j++) {
        		costs[i][j] = Math.min(costs[i-1][j], costs[i][j-1]) + grid[i][j];
        	}
        }
        
        return costs[grid.length - 1][grid[0].length - 1];
    }
	
	public static void main(String[] args) {
		MinPathSum mps = new MinPathSum();
//		System.out.println(mps.minPathSum(new int[][]{new int[]{0}}));
		System.out.println(mps.minPathSum(new int[][]{new int[]{1, 2, 5}, new int[]{3, 2, 1}}));
	}
}
