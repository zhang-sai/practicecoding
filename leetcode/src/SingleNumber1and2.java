
public class SingleNumber1and2 {

	/**
	 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	 * */
	public int singleNumber(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(a.length == 1) {
            return a[0];
        }
        int curr = a[0];
        for(int i = 1; i < a.length; i++) {
            curr = curr^a[i];
        }
        return curr;
    }
	
}
