package basics;

/**
 * MST of a all connected graph. Need to use Fibo heap to reduce complexity
 * 
 * Kruskall
 * 
 *  KRUSKAL(G):
    1    A = empty_set
    2 foreach vertex v in G.V:
    3   MAKE-SET(v)
    4    foreach (u, v) ordered by weight(u, v), increasing:
    5    if FIND-SET(u) != FIND-SET(v):
    6       A = A union {(u, v)}
    7       UNION(u, v)
    8 return A
 * 
 *  Complexity: O(E log E) = O(E log V).
 * 
 * 
 * 
 * Prim's algorithm
 * http://en.wikipedia.org/wiki/Prim%27s_algorithm
 *   1. Initialize a tree with a single vertex, chosen arbitrarily from the graph.
 *   2. Grow the tree by one edge: Of the edges that connect the tree to vertices not
 *       yet in the tree, find the minimum-weight edge, and transfer it to the tree.
 *   3. Repeat step 2 (until all vertices are in the tree).
 * 
 * uisng adjacent matrix: O(|V|2)
 * 
 * using binary heap: O((|V| + |E|) log |V|) = O(|E| log |V|)
 *   
 * using fibonaci heap: O(|E| + |V| log |V|)
 * 
 * 
 * 
 * */
public class MinSpanningTree {

}
