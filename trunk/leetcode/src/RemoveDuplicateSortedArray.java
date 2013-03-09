/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 * */
//some more elegant answer: http://discuss.leetcode.com/questions/207/remove-duplicates-from-sorted-array
public class RemoveDuplicateSortedArray {
	
	//XXX note this
	public int removeDuplicates_more_elegant_one(int[] A) {
		int n = A.length;
		int i = 0;
		int j;
		if (n <= 1)
			return n;

		for (j = 1; j < n; j++) {
			if (A[j] != A[i]) {
				A[++i] = A[j];
			}
		}
		return i + 1;
	}

	public int removeDuplicates(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length < 2) {
        	return a.length;
        }
        
        //use two indices
        int i = 0;
        int j = 1;
        while(j < a.length) {
        	while(a[j] == a[j-1]) {
        		j++;
        		if(j == a.length) {
        			return i+1; //reach the end
        		}
        	}
        	//now a[j] is the first non-duplicated element
        	if(j == i+1) {
        		//do nothing here
        		i++;
        		j++;
        	} else {
        		if(j < a.length) {
        			i = i+1;
        			a[i] = a[j];
        			j++; //XXX do not forget this
        		} else {
        			//do nothing
        		}
        	}
        }
        return i+1;
    }
}
