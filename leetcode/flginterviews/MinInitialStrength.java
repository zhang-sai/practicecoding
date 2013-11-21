
/**
 * A grid of integer, you are in the top-left corner, and
 * want to move to the bottom-right corner.
 * 
 * each grid is an integer, which may be positive or negative.
 * 
 * Touching a positive number will make your strength increases
 * 1, while a negative number will make your strength descreases
 * by 1. In order to reach the bottom-right corner, which should
 * be your minimal initial strength, so that in any moment
 * your strength will not be < 0
 * */

public class MinInitialStrength {

	public static int getMin(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		
		int[][] mins = new int[row][col];
		
		mins[0][0] = grid[0][0];
		for(int i = 1 ; i < col; i++) {
			mins[0][i] = Math.min(mins[0][i-1], mins[0][i-1] + grid[0][i]);
		}
		for(int j = 1; j < row; j++) {
			mins[j][0] = Math.min(mins[j-1][0], mins[j-1][0] + grid[j][0]);
		}
		//then perform dynamic programming
		for(int r = 1; r < row; r++) {
			for(int c = 1; c < col; c++) {
				int minFromTop = Math.min(mins[r-1][c], mins[r-1][c] + grid[r][c]);
				int minFromLeft = Math.min(mins[r][c-1], mins[r][c-1] + grid[r][c]);
				//this is the max
				mins[r][c] = Math.max(minFromTop, minFromLeft);
				if(grid[r][c] > 0) {
					mins[r][c] = grid[r][c] + mins[r][c];
				}
			}
		}
	
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(mins[i][j] + "    ");
			}
			System.out.println();
		}
		
		return mins[row-1][col-1];
	}
	
	public static void main(String[] args) {
		
		xx this produces the wrong answer
		int[][] grid = new int[][] {
			new int[]{-2, -1, 5, -99, 200},
			new int[]{1,  2,  4, -60, 300},
			new int[]{2,  -3,  -1, 2,  -99},
			new int[]{-99, 200, 2, 1,  5}
		};
		System.out.println(getMin(grid));
		
	}
	
}
