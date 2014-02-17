package twitter;

/**
 * Given four points, check whether they can form a square. no particular order
 * */
public class FourPointsSquare {

	/**
	 * tricky part is the overflow handling:
	 * 
	 * x = MAX_INT  = 2^31  - 1
	 * 
	 * y = MIN_INT  = 2^31
	 * 
	 * so, x - y = 2^31 - 1  + 2^31 = 2^32 - 1
	 * 
	 * ==> (x-y)^2 = 
	 * 
	 * */
	
}
