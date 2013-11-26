import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * you are given 2 arrays sorted in increasing order of size m and n respectively. 
Input: a number k <= n*n and >= 1 
Output: the kth smalles sum(a+b) possible. where 
a (any element from array 1) 
b (any element from array 2)

Given a N*N Matrix. 
All rows are sorted, and all columns are sorted. 
Find the Kth Largest element of the matrix.
//http://www.dsalgo.com/2013/02/find-kth-largest-element-in-sorted.html
 * */

//two ways,
//or use a priority queue, if k is small enough
//or just sort to find the k
class Node {
	int x;
	int y;
	int val;
	public Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
	
	public int hashCode() {
		return 13*x + 99*y;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Node) {
			return ((Node)o).x == this.x && this.y == ((Node)o).y;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "(" + x + ", " + y + "): " + val;
	}
}

public class KthSmallestNumberInAMatrix {
	

	public int findKthSmallest(int[][] m, int k) {
		int count = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(k, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.val == o2.val) {
					return 0;
				}
				if(o1.val > o2.val) {
					return 1;
				} else {
					return -1;
				}
			}
			
		});
		queue.add(new Node(0, 0, m[0][0]));
		
		Set<Node> visited = new HashSet<Node>();
		
		while(!queue.isEmpty()) {
			count++; //increase the count here
			Node n = queue.poll();
//			System.out.println("Now: " + n);
			if(count == k) {
				return n.val;
			} else {
				if(n.x + 1 < m.length) {
					Node nextNode = new Node(n.x + 1, n.y, m[n.x + 1][n.y]);
					if(!visited.contains(nextNode)) {
					    queue.add(nextNode);
					    visited.add(nextNode);
//					    System.out.println("  add: " + nextNode);
					}
				}
				if(n.y + 1 < m[n.x].length) {
					Node nextNode = new Node(n.x, n.y + 1, m[n.x][n.y + 1]);
					if(!visited.contains(nextNode)) {
					    queue.add(nextNode);
					    visited.add(nextNode);
//					    System.out.println("  add: " + nextNode);
					}
				}
			}
		}
		
		throw new Error("k is: " + k);
	}
	
	public static void main(String[] args) {
		KthSmallestNumberInAMatrix k = new KthSmallestNumberInAMatrix();
		int[][] m = new int[][]{
				new int[]{1, 3, 4, 5},
				new int[]{2, 4, 7, 8},
				new int[]{3, 5, 10, 11},
				new int[]{9, 12, 14, 16}
		};
//		System.out.println(k.findKthSmallest(m, 7));
		for(int i = 1; i <= 16; i++) {
			System.out.println(k.findKthSmallest(m, i));
		}
	}
}
