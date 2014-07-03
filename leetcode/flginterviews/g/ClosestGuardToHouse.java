package g;

import java.util.LinkedList;
import java.util.Queue;

public class ClosestGuardToHouse {

	/**
	 *  0 --> house
	 *  B --> block
	 *  G -- > guard
	 *  
	 *  fill in the map and compute the closest distance of each house to guard
	 * */
	
	static class Pair {
		
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Object o) {
			if(!(o instanceof Pair)) {
				return false;
			}
			return ((Pair)o).x == this.x && ((Pair)o).y == this.y; 
		}
		
		public int hashCode() {
			return 13*x + 97*y;
		}
		
	}
	
	//start flooding at all guard
	public static void fillClosestDistance(char[][] board) {
		int row = board.length;
		int col = board[0].length;
		
		//start to do bfs from all nodes
		Queue<Pair> queue = new LinkedList<Pair>();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j] == 'G') {
					queue.add(new Pair(i, j));
				}
			}
		}
	
		while(!queue.isEmpty()) {
			Pair top = queue.poll();
			int x = top.x;
			int y = top.y;
			//ignore the block and guard
			char c = board[x][y];
			if(c == 'B') {
				continue;
			}
			int currDistance = c == 'G' ? 0 : c - '0';
			//check all the next four
			if(x + 1 < row) {
				if(board[x+1][y] == '0') {
					board[x+1][y] = (char)((int)'0' + currDistance + 1);
					queue.add(new Pair(x + 1, y));
				}
			}
			if(x - 1 >= 0) {
				if(board[x-1][y] == '0') {
					board[x-1][y] = (char)((int)'0' + currDistance + 1);
					queue.add(new Pair(x - 1, y));
				}
			}
			if(y + 1 < col) {
				if(board[x][y + 1] == '0') {
					board[x][y + 1] = (char)((int)'0' + currDistance + 1);
					queue.add(new Pair(x, y + 1));
				}
			}
			if(y - 1 >= 0) {
				if(board[x][y - 1] == '0') {
					board[x][y - 1] = (char)((int)'0' + currDistance + 1);
					queue.add(new Pair(x, y - 1));
				}
			}
		}
		
		
		//print result
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		char[][] board = new char[][] {
				new char[]{'0', '0', '0'},
				new char[]{'B', 'G', 'G'},
				new char[]{'B', 'G', 'G'},
				new char[]{'0', 'B', '0'},
				new char[]{'0', 'B', '0'},
				new char[]{'0', '0', '0'}
		};
		
		fillClosestDistance(board);
		
	}
	
}
