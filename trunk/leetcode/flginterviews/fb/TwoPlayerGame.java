package fb;

/**
 * Initially there is a number n written on board. 
 * Two players start playing a game turn by turn. 
 * Each player has to replace the number n written on the 
 * board by n-2^k (for some k >= 0 such that 2^k < n)? 

 Also the number n-2^k has to be as beautiful as n 
 (The beauty of a number depends on the number of one's in 
 its binary representation). The player loses the game when 
 he can't select any such k. 

 Given the initial number n, determine which player will win 
 the game if both players play optimally. n > 0 and n <= 10^9.

 http://www.careercup.com/question?id=5399897561890816
 * */

/**
 * the number of 10 --> 01
 * 
 * 11100 ==> 3*2 = 6
 * 
 * 11010 , 11001, 10101, 10011, 01011, 00111
 * 
 * => 1 + 2 + 2, summarize the number of zero before each 1
 * */
public class TwoPlayerGame {

	// odd => first, even => second
	public static int selectWinner(int n) {

		int total = 0;
		int numZeros = 0;

		while (n != 0) {
			if ((n & 1) != 0) {
				total += numZeros;
			} else {
				numZeros++;
			}
			n = n >> 1;
		}
		return (total % 2 == 0) ? 2 : 1;
	}
	
	public static void main(String[] args) {
		System.out.println(selectWinner(0x11100)); //the 1
		System.out.println(selectWinner(0x11101)); //the 2
		
		//check if the nth bit is 1
		// value & (1 << n)
		
		//set the nth bit to zero
		
		//set the nth bit to oone, use ~
		
	}
}
