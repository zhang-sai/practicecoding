package basics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//given 1 graph with 2 nodes, find all non-cyclic paths
//from the source to dest
public class AllNonCyclicPaths {

	public static void printAllPaths(GraphNode src, GraphNode dest) {
		Set<GraphNode> visited = new HashSet<GraphNode>();
		List<GraphNode> path = new LinkedList<GraphNode>();
		path.add(src);
		visited.add(src);
		for(GraphNode n : src.nextNodes) {
			expandPaths(n, dest, path, visited);
		}
	}
	
	
	public static void expandPaths(GraphNode currNode, GraphNode dest,
			List<GraphNode> path, Set<GraphNode> visited) {
		if(currNode == dest) {
			path.add(currNode);
			System.out.println(path);
			path.remove(currNode);
			return;
		}
		if(visited.contains(currNode)) {
			return; //do nothing
		}
		path.add(currNode);
		visited.add(currNode);
		for(GraphNode n : currNode.nextNodes) {
		    expandPaths(n, dest, path, visited);	
		}
		//must do this for backtracking
		path.remove(currNode);
		visited.remove(currNode);
	}
	
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		
		/**   ---------------
		 *   |               |
		 *  \/               |
		 *   n1 ---> n2 ---> n3 <--   
		 *   |       /\      |    /\
		 *   \/       |     \ /    |
		 *   n4 ---> n5 ---> n7---->
		 *   |              /\
		 *   \/              |
		 *   n6-------------->
		 * */
		
		n1.nextNodes.add(n2);
		n1.nextNodes.add(n4);
		
		n2.nextNodes.add(n3);
		
		n3.nextNodes.add(n7);
		n3.nextNodes.add(n1);
		
		n4.nextNodes.add(n5);
		n4.nextNodes.add(n6);
		
		n5.nextNodes.add(n2);
		n5.nextNodes.add(n7);
		
		n6.nextNodes.add(n7);
		
		n7.nextNodes.add(n3);
		
		printAllPaths(n1, n7);
	}
	
}
