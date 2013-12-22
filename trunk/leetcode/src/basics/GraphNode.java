package basics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphNode {
	static int count = 0;
	public final int nodeId;
	int val;
	public List<GraphNode> nextNodes = new LinkedList<GraphNode>();
	public GraphNode(int v) {
		val = v;
		nodeId = count++;
	}
	public GraphNode(int v, GraphNode[] nodes) {
		nodeId = count;
		count = count+ 1;
		val = v;
		nextNodes.addAll(Arrays.asList(nodes));
	}
	
	public String toString() {
		return " " + val + " ";
	}
}
