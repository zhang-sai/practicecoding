import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 
a b c d
x o a t
b x b x

 bob, cat, bat, cob ...
 * */

public class AllLegalWordsInDict {
	
	

	Set<String> findAllWords(char[][] board, Set<String> dict) {
		int rows = board.length;
		int cols = board[0].length;
		
		Set<String> set = new HashSet<String>();
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				this.findWords(board, i, j, new ArrayList<Character>(), dict, set);
			}
		}
		
		return set;
	}
	
	void findWords(char[][] board, int i, int j, ArrayList<Character> curr, Set<String> dict, Set<String> result) {
		char[] cs = new char[curr.size()];
		for(int index = 0; index < curr.size(); index++) {
			cs[index] = curr.get(index);
		}
		String s = new String(cs);
		if(dict.contains(s)) {
//			System.out.println("Find: " + s);
			result.add(s);
		}
//		return;
		if(i < 0 || i >= board.length ) {
			return;
		}
		if(j < 0 || j >= board[0].length) {
			return;
		}
		char tmp = '#';
		if(board[i][j] == tmp) {
			return;
		}
		
		curr.add(board[i][j]);
		char backup = board[i][j];
		board[i][j] = tmp;
		this.findWords(board, i + 1, j, curr, dict, result);
		this.findWords(board, i, j + 1, curr, dict, result);
		this.findWords(board, i - 1, j, curr, dict, result);
		this.findWords(board, i, j - 1, curr, dict, result);
		board[i][j] = backup;
		curr.remove(curr.size() - 1);
	}
	
	/**
	 * a b c d
x o a t
b x b x
	 * */
	public static void main(String[] args) {
		char[][] board = new char[][] {
				new char[]{'a', 'b', 'c', 'd'},
				new char[]{'x', 'o', 'a', 't'},
				new char[]{'b', 'x', 'b', 'x'},
		};
		Set<String> dict = new HashSet<String>();
		dict.add("boa");
		dict.add("cat");
		dict.add("cab");
		dict.add("tab");
		
		
		AllLegalWordsInDict all = new AllLegalWordsInDict();
		
		System.out.println(all.findAllWords(board, dict));
	}
	
}
