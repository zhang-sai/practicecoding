import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class WordSearch {
	
	public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length == 0) {
            return false;
        }
        char[] cs = word.toCharArray();
        if(cs.length == 0) {
            return true;
        }
        int rowNum = board.length;
        int colNum = board[0].length;
        for(int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                if(exist(board, rowNum, colNum, i, j, cs, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean exist(char[][] board, int rowNum, int colNum,
        int startX, int startY, char[] cs, int charIndex) {
        if(charIndex == cs.length) {
            return true;
        }
        if(startX < 0 || startX >= rowNum) {
            return false;
        }
        if(startY < 0 || startY >= colNum) {
            return false;
        }
        char c = cs[charIndex];
        if(board[startX][startY] != c) {
            return false;
        }
        
        //we match the current one
        char tmp = board[startX][startY];
        board[startX][startY] = '#';
        boolean result = false;
        result = exist(board, rowNum, colNum, startX+1, startY, cs, charIndex+1)
            || exist(board, rowNum, colNum, startX - 1, startY, cs, charIndex+1)
            || exist(board, rowNum, colNum, startX, startY + 1, cs, charIndex+1)
            || exist(board, rowNum, colNum, startX, startY - 1, cs, charIndex+1);
        
        board[startX][startY] = tmp;
        return result;
    }
	
	public static void main(String[] args) {
		WordSearch s = new WordSearch();
		char[][] c = new char[1][1];
		c[0][0] = 'a';
		System.out.println(s.exist(c, "aaa"));
	}
}