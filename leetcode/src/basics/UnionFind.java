package basics;


/**
 * Its application of path recovery
 * 
 * given, 1-2, 2-3 4-5 3-4, figure out: 1-2-3-4-5
 * 
 * this may not be a great application
 * 
 * http://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
 * */
public class UnionFind {

	//suppose we have a set of element 0 -- N, each element
	//is associate with an id   id[num]
	private int[] id;
	
	public UnionFind(int N) {
	      id = new int[N];
	      for (int i = 0; i < N; i++) {
	    	  id[i] = i;  
	      }
	}
	
	private int getRoot(int i) {
		while(id[i] != i) {
			i = id[i];
		}
		return i;
	}
	
	private boolean find(int i, int j) {
		return getRoot(i) == getRoot(j);
	}
	
	//a smart way is to merge, the shorter tree to a larger tree
	private void union(int i, int j) {
		int rootI = getRoot(i); //time proportial to the depth,
		int rootJ = getRoot(j);
		id[rootI] = rootJ;
	}
}
