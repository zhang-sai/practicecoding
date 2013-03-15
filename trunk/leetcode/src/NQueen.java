
/**
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
» Solve this problem
 * */
public class NQueen {
	public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
	
	/**
	 * Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
	 * */
	public int totalSol = 0;
	public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] board = new int[n+1];
        
        this.placeQueue(1, board);
        
        return this.totalSol;
    }
	
	boolean safe(int row, int column, int[] board) {
		//is board[column] = row a safe configuration
		for(int j = 1; j < column; j++) {
			if(board[column - j] == row  //the same row
					|| board[column - j] == row - j  //diagnoal
					|| board[column - j] == row + j) { //diagnoal
				return false;
			}
		}
		return true;
	}
	
	void placeQueue(int column, int[] board) {
		int N = board.length - 1;
		for(int row = 1; row <= N; row ++) {
			board[column] = row;
			if(this.safe(row, column, board)) {
				if(column == N) {
					//find a solution
					totalSol++;
				} else {
					//continue to place queue
					this.placeQueue(column + 1, board);
				}
			}
			//revert the status
			board[column] = 0;
		}
	}
}
