package basics;

public class DatabaseJoins {

	/**
	 * 1. simple solutions
	 *    Nested loops
	 *    (use a memory buffer)
	 *    (read every chuck into the memory)
	 *    (or read multiple pages)
	 *    
	 * 2.  build index and then join
	 * 
	 * 3. sort merge join: or first do external sorting, and then join
	 *    the cost will be O(size of T1 + size of T2)
	 * 
	 * 4. hash join
	 *    Define a hash function h that can be used to partition R and S 
          – Each S partition should be small enough to fit into main memory
          – Apply h to R and S and store each resulting partition in a file
          – Do the simple case (index nested loop join) on each pair of matching partitions (files)
          
          sort merge join is less sensitive to skew, but hash join can be highly parallized
	 * */
	
}
