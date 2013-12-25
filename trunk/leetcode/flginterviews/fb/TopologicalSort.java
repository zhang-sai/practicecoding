package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

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
		Map<GraphNode, Integer> inedges = new HashMap<GraphNode, Integer>();
		
		//or use a priority queue to always fetch the smaller task
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		Set<GraphNode> visited = new HashSet<GraphNode>();
		
		List<GraphNode> res = new LinkedList<GraphNode>();
		
		//count the incoming edges
		for(GraphNode node : nodes) {
			if(!inedges.containsKey(node)) {
				inedges.put(node, 0);
			}
			//increase the incoming
			for(GraphNode nextNode : node.nextNodes) {
				if(!inedges.containsKey(nextNode)) {
					inedges.put(nextNode, 1);
				} else {
					inedges.put(nextNode, inedges.get(nextNode) + 1);
				}
			}
		}
		
		//push to the queue
		for(GraphNode n : inedges.keySet()) {
			if(inedges.get(n) == 0) {
				queue.add(n);
			}
		}
		
		while(!queue.isEmpty()) {
			GraphNode node = queue.poll();
			//add to the result
			res.add(node);
			visited.add(node);
			//check its neighboring nodes
			for(GraphNode nextNode : node.nextNodes) {
				if(visited.contains(nextNode)) {
					break;
				}
				inedges.put(nextNode, inedges.get(nextNode) - 1);
				if(inedges.get(nextNode) == 0) {
					queue.add(nextNode);
				}
			}
		}
		
		if(res.size() == nodes.size()) {
			System.out.println(res);
		} else {
			System.out.println("size: " + res.size());
			System.out.println("fail");
		}
	}

	//the next nodes of each node
	//the number of incoming edges for each node
	@Deprecated
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
	
	public static void testGraph() {
		GraphNode n0 = new GraphNode(0);
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		
		n7.nextNodes.add(n1);
		n7.nextNodes.add(n2);
		n5.nextNodes.add(n1);
		n3.nextNodes.add(n2);
		n3.nextNodes.add(n0);
		n1.nextNodes.add(n4);
		n1.nextNodes.add(n6);
		n1.nextNodes.add(n0);
		n2.nextNodes.add(n6);
		
		toposort_graph(Arrays.asList(n0, n1, n2, n3, n4, n5, n6, n7));
	}

	public static void main(String[] args) {
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
		testGraph();
		
		int n = 8;
		// initial graph
		ArrayList<ArrayList<Integer>> graph
		    = new ArrayList<ArrayList<Integer>>(n);
		int[] indegs = new int[n];
		
		
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
