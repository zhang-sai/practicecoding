package basics;

import java.util.Arrays;

/**
 * given an unsorted integer array, find three integers can form a triangle
 * 
 * http://www.geeksforgeeks.org/find-number-of-triangles-possible/
 * */
public class CheckTriangle {

	/**
	 * a + b > c
       a + c > b
       b + c > a
	 * */
	
	public static int countTriangles(int[] values) {
		if(values.length < 3) {
			return 0;
		}
		/**
		 * First sort all the values
		 * */
		Arrays.sort(values);
		int count = 0;
		 
	    // Fix the first element.  We need to run till n-3 as the other two elements are
	    // selected from arr[i+1...n-1]
	    for (int i = 0; i < values.length - 2; ++i)
	    {
	        // Initialize index of the rightmost third element
	        int k = i+2;
	 
	        // Fix the second element
	        for (int j = i+1; j < values.length; ++j)
	        {
	            // Find the rightmost element which is smaller than the sum
	            while (k < values.length && values[i] + values[j] > values[k])
	               k++;
	 
	            //ke can be just values.length
	            //so that count is still correct
	            count += k - j - 1;
	        }
	    }
		
		return count;
		
	}
	
	private static boolean isTriangle(int a, int b, int c) {
		return a + b > c && b + c > a && a + c > b;
	}
	
	public static void main(String[] args) {
		int[] values = new int[]{10, 21, 22, 100, 101, 200, 300};
		System.out.println("The number of triangles: " + countTriangles(values));
	}
}
