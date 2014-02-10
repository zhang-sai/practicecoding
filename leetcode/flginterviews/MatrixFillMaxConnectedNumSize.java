/**
 * Find the largest clusters
 * The large number of '1'
 * 
 * the number of connected component
 * */
public class MatrixFillMaxConnectedNumSize {
	
	public static void main(String[] args) {
		MatrixFillMaxConnectedNumSize mf = new MatrixFillMaxConnectedNumSize();
		int[][] board = new int[][] {
			new int[]{0, 1, 1, 0},
			new int[]{1, 0, 0, 1},
			new int[]{0, 1, 1, 1},
			new int[]{1, 0, 0, 1}
		};
//		System.out.println(mf.getNumberOfConnected(board));
		System.out.println(mf.getLargestSize(board));
	}

	//mark and sweep
	public int getLargestSize(int[][] board) {
		int max = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 1) {
					int[] currMax = new int[]{0};
					mark(board, i, j, currMax);
					max = Math.max(max, currMax[0]);
				}
			}
		}
		return max;
	}
	
	
	//'1'
	public int getNumberOfConnected(int[][] board) {
		int count = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 1) {
					mark(board, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	public void mark(int[][] board, int row, int col, int[] currMax) {
		if(row < 0 || row >= board.length) {
			return;
		}
		if(col < 0 || col >= board[row].length) {
			return;
		}
		if(board[row][col] == 2 || board[row][col] == 0) {
			return;
		}
		board[row][col] = 2;
		currMax[0]++;
		if(row + 1 < board.length) {
			mark(board, row + 1, col, currMax);
		}
		if(row - 1 >= 0) {
			mark(board, row - 1, col, currMax);
		}
		if(col - 1 >= 0) {
			mark(board, row, col - 1, currMax);
		}
		if(col + 1 < board[row].length) {
			mark(board, row, col + 1, currMax);
		}
		
		System.out.println("currmax: " + currMax[0]);
	}
	
	public void mark(int[][] board, int row, int col) {
		if(row < 0 || row >= board.length) {
			return;
		}
		if(col < 0 || col >= board[row].length) {
			return;
		}
		if(board[row][col] == 2 || board[row][col] == 0) {
			return;
		}
		board[row][col] = 2;
		mark(board, row + 1, col);
		mark(board, row - 1, col);
		mark(board, row, col + 1);
		mark(board, row, col - 1);
	}
	
}
