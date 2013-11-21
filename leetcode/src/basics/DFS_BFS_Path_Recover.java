package basics;
import java.util.ArrayList;


/**
 * recover paths for dfs and bfs
 * */
public class DFS_BFS_Path_Recover {

	//should consider the edge weight to find the shortest path
//	public ArrayList<GraphNode> dfsPath(GraphNode startNode, GraphNode targetNode) {
//		
//	}
//	
//	public ArrayList<GraphNode> bfsPath(GraphNode startNode, GraphNode targetNode) {
//		
//	}
//	
//	public ArrayList<GraphNode> allNonCyclicPaths(GraphNode startNode, GraphNode targetNode) {
//		
//	}
//	
//	//the a star search
//	public int getWeight(GraphNode startNode, GraphNode targetNode) {
//		
//	}
}

class GraphNode {
	static int count = 0;
	public final int nodeId;
	int val;
	GraphNode[] nextNodes;
	GraphNode(int v, GraphNode[] nodes) {
		nodeId = count;
		count = count+ 1;
		val = v;
		nextNodes = nodes;
	}
}
