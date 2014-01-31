package basics;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1. Dijkstra's algorithm can be used to find the shortest route between
 * one city and all other cities
 * 
 * 2. Bellman–Ford algorithm is an algorithm that computes shortest paths
 * from a single source vertex to all of the other vertices in a weighted digraph.[1] It is slower than Dijkstra's algorithm for the same problem, but more versatile, as it is capable of handling graphs in which some of the edge weights are negative 
 * */
public class GraphShortestPaths {

	/**
	 *  a directed graph
	 * 
	 *  A1  --1--> B2 --3--> C3 --10---> D4
	 *  |        /1                  /1 
	 *  4       /                   /
	 *  |--> E5 - 2 -> F6 --1--> G7 
	 * 
	 * */
	
	//use uniform search to find the shortest path
	/**
	 * expand lowest path cost
	 * 
	 * Explores options in every “direction”
	 * No information about goal location
	 * */
	
	/**
	 * 
	 * Best-first heuristic
	 * 
	 * Strategy: expand a node that you think is closest to a goal state
      Heuristic: estimate of distance to nearest goal for each state
	 * */
	
	static int[][] edges = new int[8][8];
	static {
		edges[1][2] = 1;
		edges[2][3] = 3;
		edges[3][4] = 10;
		edges[1][5] = 4;
		edges[5][6] = 2;
		edges[5][2] = 1;
		edges[6][7] = 1;
		edges[7][4] = 1;
	}
	
	public static void findShortestPath(GraphNode start, GraphNode end) {
		
		PriorityQueue<GraphPath> queue = new PriorityQueue<GraphPath>(
		  10, new Comparator<GraphPath> () {
			@Override
			public int compare(GraphPath o1, GraphPath o2) {
				if(o1.sum < o2.sum) {
					return -1;
				} else if (o1.sum == o2.sum) {
					return 0;
				} else {
					return 1;
				}
			}
		 }
		);
		
		Set<GraphNode> visited = new HashSet<GraphNode>();
		GraphPath p = new GraphPath();
		p.addGraphNode(start);
		queue.add(p);
		
		while(!queue.isEmpty()) {
			
			GraphPath top = queue.poll();
			if(top.getLastNode().val == end.val) {
				//done
				System.out.println(top.toString());
				return;
			}
			if(visited.contains(top.getLastNode())) {
				continue;
			}
			visited.add(top.getLastNode());
			//expand the path
			for(GraphNode nextNode : top.getLastNode().nextNodes) {
				GraphPath newPath = top.copy();
				newPath.addGraphNode(nextNode);
				queue.add(newPath);
			}
		}
		
		
	}
	
	static class GraphPath {
		List<GraphNode> nodeList = new LinkedList<GraphNode>();
		int sum = 0;
		void addGraphNode(GraphNode n1) {
			if(!nodeList.isEmpty()) {
				GraphNode lastNode = getLastNode();
				if(edges[lastNode.val][n1.val] == 0) {
					throw new Error(lastNode.val + ", " + n1.val);
				}
				sum += edges[lastNode.val][n1.val];
			}
			nodeList.add(n1);
		}
		
		GraphNode getLastNode() {
			return nodeList.get(nodeList.size() - 1);
		}
		
		GraphPath copy() {
			GraphPath newpath = new GraphPath();
			newpath.nodeList.addAll(nodeList);
			newpath.sum = sum;
			return newpath;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for(GraphNode n : nodeList) {
				sb.append(n.val + " -> ");
			}
			sb.append(": cost:  " + sum);
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		
		n1.nextNodes.add(n2);
		n2.nextNodes.add(n3);
		n3.nextNodes.add(n4);
		n1.nextNodes.add(n5);
		n5.nextNodes.add(n6);
		n5.nextNodes.add(n2);
		n6.nextNodes.add(n7);
		n7.nextNodes.add(n4);
		
		findShortestPath(n1, n4);
	}
	
}
