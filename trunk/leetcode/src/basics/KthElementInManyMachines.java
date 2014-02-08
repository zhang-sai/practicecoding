package basics;

/**
 * kth element in many n machines(
distributed quickselect)
 * */


public class KthElementInManyMachines {

	/**
	 * Solutions:
	 * from: http://stackoverflow.com/questions/9872099/find-the-largest-k-numbers-in-k-arrays-stored-across-k-machines
	 * 
	 *   0. do external sort
	 *   
	 *   1. Find the k largest numbers on each machine. O(n*log(k))
	 *   
         2. Combine the results (on a centralized server, if k is not huge,
         otherwise you can merge them in a tree-hierarchy accross the server cluster).
         
        
         
         //use a heap. nk-logk + 
	 * 
	 * */
	
}
