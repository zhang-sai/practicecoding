
/**
 * a board with black or white dot, find the largest X in it
 * 
 * using dynamic programming to compute the largest dot extension in each four
 * direction, and then check the results.
 * 
 * it has O(n2) complexity
 * */

public class FindTheLargestX {
	
	public static int getMaxX(int[][] board) {
		
		int rowNum = board.length;
		int colNum = board[0].length;
		
		int[][][] values = new int[rowNum][colNum][4];
		
		//do counting
		/**
		 *  1              2
		 * 
		 * 
		 * 
		 *  3              4
		 * 
		 * */
		
		//from 1 -> 4
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				
			}
		}
		
		
		
		//from 4 -> 1
		
		//from 3 -> 2
		
		//from 2 -> 3
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				int m = Math.max(values[i][j][0], Math.max(values[i][j][1], Math.max(values[i][j][2], values[i][j][3])));
				max = Math.max(max, m);
			}
		}
		
		return max;
	}

	
	public static void main(String[] args) {
		int[][] board = new int[][] {
			new int[]{1, 0, 0, 1, 1},
			new int[]{0, 1, 0, 1, 1},
			new int[]{0, 0, 1, 0, 0},
			new int[]{0, 1, 0, 1, 0},
			new int[]{1, 0, 1, 1, 1}
		};
		
		System.out.println(getMaxX(board));
	}
	
}
