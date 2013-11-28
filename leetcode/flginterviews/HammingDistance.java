/**
 * a) first, write a function to calculate the hamming distance between two 
binary numbers
(b) write a function that takes a list of binary numbers and returns the sum
of the hamming distances for each pair

O(n) solution is recore each position how many 1 and how many 0, and 
multiply them for each position and add together
 * */


public class HammingDistance {

	//(1) is trivial
	public int distance(int a, int b) {
		return 0;
	}
	
	public int distance(int[] nums) {
		//1 1 1  1   --- (1)
		//1 0 0  1   --- (2)
		//1 1 1  0   --- (3)
		//
		//distance = d(1, 2) + d(1, 3) + d(2, 3)
		//         = 2 + 2 + 
		
		//for each position, record the number of 1s and the number of 0s
		//and multiple them
		/**
		 * For the above example, from left to write:
		 * 1-st:  2*1 = 2
		 * 2nd and 3rd  2*1 = 2
		 * 4th: 3*0 = 0
		 * so in total: 6
		 * */
		return 1;
	}
	
}
