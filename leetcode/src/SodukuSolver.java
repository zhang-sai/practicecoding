/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * */
public class SodukuSolver {
	public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //check no duplication
		for(int i = 0; i < board.length; i++) {
			if(!noDuplication(board[i])) {
				return false;
			}
		}
		//then check the row
		for(int i = 0; i < board.length; i++) {
			char[] cs = new char[board.length];
			for(int j = 0; j < board.length; j++) {
				cs[j] = board[j][i];
			}
			if(!noDuplication(cs)) {
				return false;
			}
		}
		//check the square
		for(int i = 0; i < 9; i = i + 3) {
			for(int j = 0; j < 9; j = j + 3) {
				char[] cs = new char[board.length];
				cs[0] = board[i][j];
				cs[1] = board[i][j + 1];
				cs[2] = board[i][j + 2];
				cs[3] = board[i + 1][j];
				cs[4] = board[i + 1][j + 1];
				cs[5] = board[i + 1][j + 2];
				cs[6] = board[i + 2][j];
				cs[7] = board[i + 2][j + 1];
				cs[8] = board[i + 2][j + 2];
				if(!noDuplication(cs)) {
					return false;
				}
			}
		}
		return true;
    }
	
	private boolean noDuplication(char[] cs) {
		int[] counts = new int[]{0,0,0,0,0,0,0,0,0};
		for(int i = 0; i < cs.length; i++) {
			if(cs[i] == '.') {
				continue;
			}
			int index = cs[i] - '1';
			if(counts[index] != 0) {
				return false;
			} else {
				counts[index] = 1;
			}
		}
		return true;
	}
	
	/**
	 * A solver for sudoku
	 * */
	public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.solve(0, 0, board);
    }
	
	//the next cell to solve
	private boolean solve(int i , int j, char[][] board) {
	    //move to the end of the column
		if(i == 9) {
			i = 0;
			j = j + 1;
			if( j == 9) {
				return true;
			}
		}
		//skip
		if(board[i][j] != '.') {
			//skip
			return this.solve(i + 1, j, board);
		}
		
		for(char c = '1'; c <= '9'; c++) {
			if(legal(i, j, c, board)) {
				board[i][j] = c;
				if(this.solve(i + 1, j, board)) {
					return true;
				}
			}
		}
		
		//backtracking
		board[i][j] = '.';
		return false;
	}
	
    private boolean legal(int i, int j, char c, char[][] board) {
        for (int k = 0; k < 9; ++k)  // row
            if (c == board[k][j])
                return false;

        for (int k = 0; k < 9; ++k) // col
            if (c == board[i][k])
                return false;

        //XXX get the index
        int boxRowOffset = (i / 3)*3;
        int boxColOffset = (j / 3)*3;
        for (int k = 0; k < 3; ++k) // box
            for (int m = 0; m < 3; ++m)
                if (c == board[boxRowOffset+k][boxColOffset+m])
                    return false;

        return true; // no violations, so it's legal
    }
    
    //","83.6.....","..29..6.8","6....49.7",".9.....5.","3.75....4","2.3..91..",".....2.43",".4..8...9
    public static void main(String[] args) {
    	SodukuSolver s = new SodukuSolver();
    	char[][] board = new char[][] {
    			{'.', '.', '.', '9', '.', '3', '.', '4', '5'},
    			{'.', '.', '.', '4', '.', '.', '7', '9', '.'},
    			{'.', '.', '.', '7', '8', '.', '.', '1', '.'},
    			{'8', '.', '.', '.', '.', '5', '.', '3', '.'},
    			{'.', '.', '2', '.', '.', '.', '6', '.', '.'},
    			{'.', '4', '.', '6', '.', '.', '.', '.', '2'},
    			{'.', '9', '.', '.', '6', '2', '.', '.', '.'},
    			{'.', '1', '5', '.', '.', '4', '.', '.', '.'},
    			{'6', '8', '.', '3', '.', '7', '.', '.', '.'},
    	};
    	board = new char[][] {
    			{'.', '.', '6', '.', '.', '.', '.', '3', '2'},
    			{'.', '.', '.', '.', '.', '.', '9', '.', '.'},
    			{'.', '5', '7', '.', '.', '9', '.', '4', '.'},
    			{'.', '6', '.', '7', '9', '.', '.', '.', '3'},
    			{'7', '.', '.', '4', '.', '6', '.', '.', '1'},
    			{'8', '.', '.', '.', '3', '5', '.', '6', '.'},
    			{'.', '9', '.', '3', '.', '.', '5', '1', '.'},
    			{'.', '.', '5', '.', '.', '.', '.', '.', '.'},
    			{'4', '8', '.', '.', '.', '.', '2', '.', '.'},
    	};
    	s.solveSudoku(board);
    	
    	for(int i = 0; i < board.length; i++) {
    		for(int j= 0; j < board[i].length; j++) {
    			System.out.print(board[i][j] + "  ");
    		}
    		System.out.println();
    	}
    }

}
