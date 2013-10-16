
/**
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 * */
public class RemoveDuplicateSortedArray2 {

	public int removeDuplicates(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = a.length;
		int i = 0;
		int j;
		if (n <= 2)
			return n;

		for (j = 1; j < n; j++) {
			if (a[j] != a[i]) {
				a[++i] = a[j];
			} else {
			    if((i > 0 && a[i] != a[i-1]) || i == 0) { //the extra condition to check
			        a[++i] = a[j];
			    }
			}
		}
		return i + 1;
    }
}
