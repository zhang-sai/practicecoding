
/**
 * 
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 * */
//XXX may have duplication
public class FirstMissingPositive {
	/**
	 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
	 * */
	//XXX a fairly smart solution
	//a sample solution here: http://yewenxing.wordpress.com/2012/03/13/first-missing-positive/
	public int firstMissingPositive(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int length = a.length;
        //put every element in A such that A[i]=i
        for(int i = 0; i < length; i++) {
        	while(a[i] != i+1) { //XXX note this is a while loop until a[i] == i + 1
        		int value = a[i];
        		/**This condition is critical */
        	    if(value <= 0 || value > length || value == a[value -1]) {
        	    	break;
        	    }
        	    int tmp = value;
        	    a[i] = a[value -1];
        	    a[value -1] = tmp;
        	}
        }
        for(int i=0;i<length;i++){
            if(a[i]!=i+1)   return i+1;
        }
        return length+1;
    }
}