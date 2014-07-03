package basics;

/**
 * reservoir sampling for infinite stream,
 * */

/**
 * Just like shuffling a card:
 * 
 * It can be solved in O(n) time. The solution also suits well for input in the form of stream. The idea is similar to this post. Following are the steps.

1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
2) Now one by one consider all items from (k+1)th item to nth item.
…a) Generate a random number from 0 to i where i is index of current item in stream[]. Let the generated random number is j.
…b) If j is in range 0 to k-1, replace reservoir[j] with arr[i]
 * 
 * see here:
 * http://www.geeksforgeeks.org/reservoir-sampling/
 * */

//explanation: http://code-slim-jim.blogspot.com/2010/06/reservoir-sampling.html
public class SamplingForInfinite {

	//see ShuffleCards
	
	//any O(k) algorithm
	//by destroying the array, first select random
	/**
	 * 
	 * while(1 ..k) {
	 *    num = random(N - K)
	 *    swap num with the last one, and then continue
	 * }
	 * 
	 * 
	 * */
}
