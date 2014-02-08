package linkedin;

//http://www.mitbbs.com/article_t/JobHunting/32619691.html
public class CommonWords {

	/**
	 * This is a good day
       This is a bad day
       That was good day
       
       return the first / second sentences, since they share the
       most number of common words
	 * */
	
			
			/**
			 * 1. use reverse index to keep track of the word and sentence
			 *    e.g.,
			 *    This --> {sentence1, sentence2}
			 *    
			 *    use an array to store all intersections array[][]
			 *    that is: array[sentence1][sentence]++;
			 *    
			 *    finally figure out the largest value
			 *    
			 * 2. bit vector, in Java, it is BitSet
			 * 
			 *   for brute force comparison
			 *   
			 *   implement BitSet:
			 *   
			 *   http://stackoverflow.com/questions/7861778/how-to-implement-a-bit-vector-bitset-in-java
			 * 
			 * */
}
