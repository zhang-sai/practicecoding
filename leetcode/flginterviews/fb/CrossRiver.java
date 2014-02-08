package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * http://www.mitbbs.com/article_t/JobHunting/32617501.html
 * 
 * R=[1,1,1,0,1,1,0,0]
 * 
 * At beginning, we are at the 0-th index, each time we
 * can keep the current speed, or add + 1 speed
 * */
public class CrossRiver {

	public static void crossRiver(int[] array) {		
		//check the possible speed for each cell, and if the speed is greater than
		//the distance to the end of the array
		// that is:  speed >= array.length - index
		
		//index and its corresponding speed
		//keeps speed and the previous node
		List<Map<Integer, Integer>> speed = new ArrayList<Map<Integer, Integer>>();
		for(int i = 0; i < array.length; i++) {
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			speed.add(m);
		}
		//the initial value of index zero
		speed.get(0).put(1, -1); //coming from nowhere
		
		for(int i = 0; i < array.length; i++) {
			//skip the island
			if(array[i] == 0) {
				//do nothing
				continue;
			}
			//we have see a 1
			for(int spd : speed.get(i).keySet()) {
				if(spd >= array.length - i) {
					//we find a solution, then backtrack to find the path
					System.out.println("We get a solution. speed: " + spd + ", at: " + i);
					int currPos = i;
					int prevPos = speed.get(i).get(spd);
					int currSpd = spd;
					while(prevPos != -1) {
						System.out.println("From node: " + prevPos);
						int posDelta = currPos - prevPos;
						if(currSpd == posDelta) {
							//no speed up
							System.out.println("  keep the current speed");
						} else {
							System.out.println("  speed up");
							currSpd --;
						}
						currPos = prevPos;
						System.out.println(speed.get(currPos));
						prevPos = speed.get(currPos).get(currSpd);
						
					}
					return;
				}
				//either keep the current spd
				if(!speed.get(i + spd).containsKey(spd)) {
					speed.get(i + spd).put(spd, i);
				}
				if(!speed.get(i + spd + 1).containsKey(spd + 1)) {
					speed.get(i + spd + 1).put(spd + 1, i);
				}
			}
		}
		
		System.out.println("No solution exists.");
	}
	
	//we can also use graph reachability
	public static void crossRiver_graph(int[] array) {
		
		Pos first = new Pos(0, 1);
		Set<Pos> visited = new HashSet<Pos>();
		Queue<Pos> queue = new LinkedList<Pos>();
		
		queue.add(first);
		
		while(!queue.isEmpty()) {
			Pos top = queue.poll();
			if(top.speed >= array.length - top.pos) {
				System.out.println("We found one: " + top.pos + " with speed: " + top.speed);
				return;
			}
			if(visited.contains(top)) {
				continue;				
			}
			visited.add(top);
			//the next
			queue.add(new Pos(top.pos + top.speed, top.speed));
			queue.add(new Pos(top.pos + top.speed + 1, top.speed + 1));
		}
		
	}
	
	static class Pos {
		final int pos;
		final int speed;
		public Pos(int pos, int speed) {
			this.pos = pos;
			this.speed = speed;
		}
		
		public boolean equals(Object obj) {
			if(obj instanceof Pos) {
				return ((Pos)obj).pos == this.pos &&  ((Pos)obj).speed == this.speed;
			}
			return false;
		}
		
		public int hashCode() {
			return 13*pos + 97*speed;
		}
	}
	
	public static void main(String[] args) {
		//crossRiver(new int[]{1, 1, 1, 0, 1, 1, 0, 0});
		crossRiver_graph(new int[]{1, 1, 1, 0, 1, 1, 0, 0});
	}
}
