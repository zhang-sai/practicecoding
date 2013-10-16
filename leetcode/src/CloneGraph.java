import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * */
public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        // Note: The Solution object is instantiated only once and is reused by each test case.
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        //a map established from old to new
        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        nodeMap.put(node, root);
        
        //keep track of all visited nodes
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        
        List<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode next = queue.remove(0);
            if(visited.contains(next)) {
                continue;
            }
            visited.add(next);
            //the corresponding node
            UndirectedGraphNode newNode = null;
            if(nodeMap.containsKey(next)) {
                newNode = nodeMap.get(next);
            } else {
                newNode= new UndirectedGraphNode(next.label);
                nodeMap.put(next, newNode);
            }
            for(UndirectedGraphNode neighbor : next.neighbors) {
                UndirectedGraphNode newNeighbor = null;
                if(nodeMap.containsKey(neighbor)) {
                    newNeighbor = nodeMap.get(neighbor);
                } else {
                    newNeighbor = new UndirectedGraphNode(neighbor.label);
                    nodeMap.put(neighbor, newNeighbor);
                }
                newNode.neighbors.add(newNeighbor);
                queue.add(neighbor);
            }
        }
         
        return root;
    }
	
}

class UndirectedGraphNode {
	      int label;
	      ArrayList<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	  };
