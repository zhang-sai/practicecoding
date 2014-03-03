package basics;

public class RDTree {

	//http://en.wikipedia.org/wiki/R-tree
	
	//or use KD-tree
	
	//http://en.wikipedia.org/wiki/K-d_tree
	
	/*
	 
	 function kdtree (list of points pointList, int depth)
{
    // Select axis based on depth so that axis cycles through all valid values
    var int axis := depth mod k;
    
    //divide tree repeatedly
        
    // Sort point list and choose median as pivot element
    select median by axis from pointList;
        
    // Create node and construct subtrees
    var tree_node node;
    node.location := median;
    node.leftChild := kdtree(points in pointList before median, depth+1);
    node.rightChild := kdtree(points in pointList after median, depth+1);
    return node;
}
	 
	  
	 * */
}
