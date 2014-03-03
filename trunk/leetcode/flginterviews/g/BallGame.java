package g;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a board, and a ball, the ball can go four directions until the wall,
 * given a starting point, and a ending point, check whether the ending point is reachable or not.
 * */
public class BallGame {

	//do bfs
	
	/**
	 *  0 is emtpy
	 *  1 is obstacle
	 * 
	 * */
	
	//this is not complete
	
	public void rollingBall(int[][] board, int startX, int startY,
			int endX, int endY) {
		Set<Pair<Integer, Integer>> visited = new HashSet<Pair<Integer, Integer>>();
		Queue<Pair<Integer, Integer>> q = new LinkedList<Pair<Integer, Integer>>();
		
		Pair<Integer, Integer> p = new Pair<Integer, Integer>(startX, startY);
		q.add(p);
		
		while(!q.isEmpty()) {
			Pair<Integer, Integer> top = q.poll();
			if(top.t1 == endX && top.t2 == endY) {
				System.out.println("Solvable!");
				return;
			}
			//go through each four direction, and then push the last one to the queue
		}
	}
	
}
