import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class WordSearch {

	public boolean exist(char[][] board, String word) {
        if(word.isEmpty()) {
        	return false;
        }
        
        //get all the starting point
		List<Pair> queue = new LinkedList<Pair>();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(word.charAt(0) == board[i][j]) {
					queue.add(new Pair(i, j));
				}
			}
		}
		
		if(word.length() == 1 && !queue.isEmpty()) { //XXX critical condition
			return true;
		}
		
		//a helper queue
		for(Pair startPoint : queue) {
			Set<Pair> visited = new HashSet<Pair>();
			visited.add(startPoint);
			boolean contained = this.search(board, visited, startPoint, word, 1);
			if(contained) {
				return true;
			}
		}
		
        return false;
    }
	
	/**
	 * current point is included in visited
	 * */
	public boolean search(char[][] board, Set<Pair> visited, Pair currPoint, String s, int index) {
		boolean contained = false;
		
		char c = s.charAt(index);
		int currX = currPoint.x;
	    int currY = currPoint.y;
	    //return four possible next points
	    //currX - 1, currY, currX, currY - 1
	    //currX + 1, currY, currX, currY + 1
	    if(currX - 1 > -1) {
	    	if(board[currX - 1][currY] == c) {
	    		Pair nextPoint = new Pair(currX - 1, currY);
	    		if(!visited.contains(nextPoint)) {
	    		    Set<Pair> copyNewVisited = new HashSet<Pair>();
	    		    copyNewVisited.addAll(visited);
	    		    copyNewVisited.add(nextPoint);
	    		    if(index == s.length() - 1) {
	    		    	return true;
	    		    }
	    		    contained = this.search(board, copyNewVisited, nextPoint, s, index+1);
	    		    copyNewVisited.clear();
	    		}
	    	}
	    }
	    if(contained) {
	    	return true;
	    }
	    
	    if(currY - 1 > -1) {
	    	if(board[currX][currY - 1] == c) {
	    		Pair nextPoint = new Pair(currX, currY - 1);
	    		if(!visited.contains(nextPoint)) {
	    			Set<Pair> copyNewVisited = new HashSet<Pair>();
	    		    copyNewVisited.addAll(visited);
	    		    copyNewVisited.add(nextPoint);
	    		    if(index == s.length() - 1) {
	    		    	return true;
	    		    }
	    		    contained = this.search(board, copyNewVisited, nextPoint, s, index+1);
	    		}
	    	}
	    }
	    
	    if(contained) {
	    	return true;
	    }
	    
	    if(currX + 1 < board.length) {
	    	if(board[currX + 1][currY] == c) {
	    		Pair nextPoint = new Pair(currX + 1, currY);
	    		if(!visited.contains(nextPoint)) {
	    			Set<Pair> copyNewVisited = new HashSet<Pair>();
	    		    copyNewVisited.addAll(visited);
	    		    copyNewVisited.add(nextPoint);
	    		    if(index == s.length() - 1) {
	    		    	return true;
	    		    }
	    		    contained = this.search(board, copyNewVisited, nextPoint, s, index+1);
	    		}
	    	}
	    }
	    
	    if(contained) {
	    	return true;
	    }
	    
	    if(currY + 1 < board[0].length) {
	    	if(board[currX][currY + 1] == c) {
	    		Pair nextPoint = new Pair(currX, currY + 1);
	    		if(!visited.contains(nextPoint)) {
	    			Set<Pair> copyNewVisited = new HashSet<Pair>();
	    		    copyNewVisited.addAll(visited);
	    		    copyNewVisited.add(nextPoint);
	    		    if(index == s.length() - 1) {
	    		    	return true;
	    		    }
	    		    contained = this.search(board, copyNewVisited, nextPoint, s, index+1);
	    		}
	    	}
	    }
		
		return contained;
	}
	
	class Pair{
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public boolean equals(Object p) {
			if(p instanceof Pair) {
				return ((Pair) p).x == this.x && ((Pair)p).y == this.y;
			}
			return false;
		}
		
		//XXX never forget hashcode
		public int hashCode() {
			return 7*x + 999*y;
		}
	}
	
	public static void main(String[] args) {
		WordSearch s = new WordSearch();
		char[][] c = new char[1][1];
		c[0][0] = 'a';
		System.out.println(s.exist(c, "aaa"));
	}
}