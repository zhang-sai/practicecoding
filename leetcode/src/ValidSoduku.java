
public class ValidSoduku {

	public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length != 9) {
            return false;
        } 
        if(board[0].length != 9) {
            return false;
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !isNum(board[i][j])) {
                    return false;
                }
            }
        }
        //check each row
        for(int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[9];
            for(char c : board[i]) {
                if(c == '.') {
                    continue;
                }
                if(flags[c - '1']) {
                    return false;
                } else {
                    flags[c - '1'] = true;
                }
            }
        }
        
        //check each column
        for(int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[9];
            for(int j = 0; j < 9; j++) {
                char c = board[j][i];
                if(c == '.') {
                    continue;
                }
                if(flags[c - '1']) {
                    return false;
                } else {
                    flags[c - '1'] = true;
                }
            }
        }  
        //check each cell
        for(int row = 0; row < 9; row = row + 3) {
            for(int col = 0; col < 9; col = col + 3) {
                boolean[] flags = new boolean[9];
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        char c = board[row + i][col + j];
                        if(c == '.') {
                            continue;
                        }
                        if(flags[c - '1']) {
                            return false;
                        } else {
                            flags[c - '1'] = true;
                        }
                    }
                }
            }
        }
        
        return true;
        }
        
        private boolean isNum(char c) {
            return c >= '1' && c <= '9';
       } 
}
