package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import basics.GraphNode;

/**
 * http://n00tc0d3r.blogspot.com/2013/09/topological-sort.html
 * 
 * Sandro is a well organised person. Every day he makes a list of things which
 * need to be done and enumerates them from 1 to n. However, some things need to
 * be done before others. In this task you have to find out whether Sandro can
 * solve all his duties and if so, print the correct order.
 * 
 * Input In the first line you are given an integer n and m (1<=n<=10000,
 * 1<=m<=1000000). On the next m lines there are two distinct integers x and y,
 * (1<=x,y<=10000) describing that job x needs to be done before job y.
 * 
 * Output Print "Sandro fails." if Sandro cannot complete all his duties on the
 * list. If there is a solution print the correct ordering, the jobs to be done
 * separated by a whitespace. If there are multiple solutions print the one,
 * whose first number is smallest, if there are still multiple solutions, print
 * the one whose second number is smallest, and so on.
 * 
 * Example 1 Input: 8 9 1 4 1 2 4 2 4 3 3 2 5 2 3 5 8 2 8 6 Output: 1 4 3 5 7 8
 * 2 6
 * 
 * Example 2 Input: 2 2 1 2 2 1 Output: Sandro fails.
 * */
public class TopologicalSort {
	
	public static void toposort_graph(Collection<GraphNode> nodes) {
		xx
	}

	//the next nodes of each node
	//the number of incoming edges for each node
	public static void toposort(ArrayList<ArrayList<Integer>> graph,
			int[] indegs) {
		int n = indegs.length;
		boolean[] visited = new boolean[n];
		//use priority queue, so get the smallest number first
		Queue<Integer> queue = new PriorityQueue<Integer>();
		//the return list
		ArrayList<Integer> res = new ArrayList<Integer>(n);

		// enque 0-in-degree nodes
		for (int i = 0; i < n; ++i) {
			if (indegs[i] == 0) {
				queue.offer(i);
			}
		}

		// do BFS
		while (!queue.isEmpty()) {
			int node = queue.poll();
			res.add(node);
			// mark as visited
			visited[node] = true;
			// update its neighbors and enqueue 0-in-degree ones
			for (int nb : graph.get(node)) {
				if (visited[nb]) { // a cycle detected
					break;
				}
				//XXX only enqueue the number when it has no incoming edges
				if (--indegs[nb] == 0) {
					queue.offer(nb);
				}
			}
		}

		// print
		if (res.size() < n) {
			System.out.println("Sandro fails.");
			System.out.println(res);
		} else {
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		
		int n = 8;
		// initial graph
		ArrayList<ArrayList<Integer>> graph
		    = new ArrayList<ArrayList<Integer>>(n);
		int[] indegs = new int[n];
		
		/**
		 *     7   5    3
		 *     \ \/    / |
		 *      \/ \  /  |
		 *       1    2  |
		 *      / \ \/   |
		 *     /   \/ \  |
		 *     4     6   0
		 * 
		 * 
		 * */
		graph.add(new ArrayList<Integer>());
		graph.add(new ArrayList<Integer>(Arrays.asList(0, 4, 6)));
		graph.add(new ArrayList<Integer>(Arrays.asList(6)));
		graph.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
		graph.add(new ArrayList<Integer>());
		graph.add(new ArrayList<Integer>(Arrays.asList(1)));
		graph.add(new ArrayList<Integer>());
		graph.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
		
		indegs[0] = 2;
		indegs[1] = 2;
		indegs[2] = 2;
		indegs[3] = 0;
		indegs[4] = 1;
		indegs[5] = 0;
		indegs[6] = 2;
		indegs[7] = 0;
		

		toposort(graph, indegs);
	}

}
