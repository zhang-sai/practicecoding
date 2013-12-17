package linkedin;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import basics.GraphNode;

/**
 * Given an undirected graph, find if it is bipartite or not. Return true or false.
 * http://www.careercup.com/question?id=4439680
 * */



public class CheckBiparty {

	/**
	 * We can do this by marking each node with 0 or 1.The first one
	 * we mark with 1, then a node in his list of neighbours with 0,
	 * then a neighbour of the neighbour with 1 and so until we mark
	 * all the nodes(and return true) or we arrive in a node that is 0 and we
	 * want to mark it with 1 or viceversa (and we return false).
	 * */
	
	public static boolean checkBiparty(GraphNode node) {
		
		Set<GraphNode> zeroNodes = new HashSet<GraphNode>();
		Set<GraphNode> oneNodes = new HashSet<GraphNode>();
		
		//keep the queue
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		zeroNodes.add(node);
		while(!queue.isEmpty()) {
			GraphNode top = queue.poll();
			if(!zeroNodes.contains(top) && !oneNodes.contains(top)) {
				throw new Error("error.");
			}
			List<GraphNode> nextNodes = top.nextNodes;
			boolean currNodeZero = zeroNodes.contains(top) ? true : false;
			for(GraphNode nextNode : nextNodes) {
				
				boolean nextNodeZero = !currNodeZero;
				if(nextNodeZero) {
					if(oneNodes.contains(nextNode)) {
						return false;
					} else {
						if(!zeroNodes.contains(nextNode)) {
							zeroNodes.add(nextNode);
							queue.add(nextNode);
						}
					}
				} else {
					if(zeroNodes.contains(nextNode)) {
						return false;
					} else {
						if(!oneNodes.contains(nextNode)) {
							oneNodes.add(nextNode);
							queue.add(nextNode);
						}
					}
				}
				
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		
		n1.nextNodes.add(n2);
		n2.nextNodes.add(n1);
		
		n2.nextNodes.add(n3);
		n3.nextNodes.add(n2);
		
		n3.nextNodes.add(n4);
		n4.nextNodes.add(n3);
		
		//comment out the below will become true
		n4.nextNodes.add(n5);
		n5.nextNodes.add(n4);
		
		n5.nextNodes.add(n1);
		n1.nextNodes.add(n5);
		//
		
		n4.nextNodes.add(n1);
		n1.nextNodes.add(n4);
		
		System.out.println(checkBiparty(n1));
	}
}
