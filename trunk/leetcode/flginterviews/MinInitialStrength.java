
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
		
		//reaching the current position
		int[][] mins = new int[row][col];
		//the historical min value in the path
		int[][] historyMins = new int[row][col];
		
		//min keeps the minimal energy of ALL paths reaching
		//that point
		mins[0][0] = grid[0][0];
		historyMins[0][0] = grid[0][0];
		
		for(int i = 1 ; i < col; i++) {
			mins[0][i] = mins[0][i-1] + grid[0][i];
			historyMins[0][i] = Math.min(mins[0][i-1], mins[0][i-1] + grid[0][i]);
		}
		for(int j = 1; j < row; j++) {
			mins[j][0] = mins[j-1][0] + grid[j][0]; 
			historyMins[j][0] = Math.min(mins[j-1][0], mins[j-1][0] + grid[j][0]);
		}
		
		//then perform dynamic programming
		for(int r = 1; r < row; r++) {
			for(int c = 1; c < col; c++) {
				//a path from the top
				int minFromTop = mins[r-1][c] + grid[r][c]; //Math.min(mins[r-1][c], mins[r-1][c] + grid[r][c]);
				int historyMinFromTop = Math.min(historyMins[r-1][c], historyMins[r-1][c] + grid[r][c]);
				
				//a path from the left
				int minFromLeft = mins[r][c-1] + grid[r][c]; //Math.min(mins[r][c-1], mins[r][c-1] + grid[r][c]);
				int historyMinFromLeft = Math.min(historyMins[r][c-1], historyMins[r][c-1] + grid[r][c]);
				
				/**this use the max!*/
				if(historyMinFromLeft > historyMinFromTop) {
					historyMins[r][c] = historyMinFromLeft;
					mins[r][c] = minFromLeft;
				} else {
					historyMins[r][c] = historyMinFromTop;
					mins[r][c] = minFromTop;
				}
			}
		}
	
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(historyMins[i][j] + "    ");
			}
			System.out.println();
		}
		
		return historyMins[row-1][col-1];
	}
	
	public static void main(String[] args) {
		
		int[][] grid = new int[][] {
			new int[]{-2, -1, 5, -99, 200},
			new int[]{1,  2,  4, -60, 300},
			new int[]{2,  -3,  -1, 2,  -99},
			new int[]{-99, 200, 2, 1,  5}
		};
		System.out.println("Result: " + getMin(grid));
		System.out.println("-----------");  //should be: -2
		
		grid = new int[][] {
				new int[]{-2, -3, 5, -99, 200},
				new int[]{1,  -1,  4, -60, 300},
				new int[]{2,  -3,  -1, 2,  -99},
				new int[]{0, 200, -199, 1,  5}
			};
		System.out.println("Result: " + getMin(grid)); //should be -2
		System.out.println("-----------"); 
		grid = new int[][] {
				new int[]{1, -100},
				new int[]{1,  2},
				new int[]{-100, 3}
			};
		System.out.println("Result: " + getMin(grid)); //should be -2
	}
	
}
