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
	
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		a++;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		a++;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		a++;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		
		/**
		 * 0000 0111=7 two's complement is 1111 1001= -7
		 * 
		 * */
		a = 0;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		a--;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
	}
	
}
