/**
 * Given an integer array, count the number of inversions.

Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

For example, given [22, 48, 12, 35, 57], return 3 since there are three inversions, (22, 12), (48, 12), (48, 35).

http://n00tc0d3r.blogspot.com/search?q=inversions
 * */

/**
 * two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 * */
xx
public class CountingInversions {

	public static long countInversion_bruteforce(int[] a) {
		long count = 0;

		for (int i = 0; i < a.length - 1; ++i) {
			for (int j = i + 1; j < a.length; ++j) {
				if (a[i] > a[j])
					++count;
			}
		}

		return count;
	}

	//
	/* merge two sorted subarrays A[l..mid) and A[mid..r) into one sorted array  
	   and count inversions during the process. B is a temporary array for merging. */  
	 private static long mergeAndCount(int[] A, int l, int mid, int r, int[] B) {  
	   long count = 0;  

	   // copy from A to B  
	   System.arraycopy(A, l, B, l, r-l);  
	   // merge
	   for (
	      int i=l, h1=l, h2=mid; 
	      i<r; 
	      ++i) {
	     if (h1 >= mid || (h2 < r && B[h2] < B[h1])) {
	      /**
	       * If an element x has an inversion, what does it tells us? That said,
	       * among k elements that are behind x, (k-1) of them are no less than
	       * x and 1 of them are less than x. Thus, in the sorted array, x need
	       * to move 1 step to get the subarray starting from x to the end be sorted.
	       * That's essentially the sorting process.
	       * 
	       * */
	      //XXX this step is critical: why h2 - i?
	      // suppose  1 3 9  mid-point  2 4 6
	      // when h2 = 3 with value 2  h1 = 1 with value 3
	      //   now i = 2, so h2 - i = 1 
	    	 
	       count += (h2 - i);
	       A[i] = B[h2++];
	     } else {
	       A[i] = B[h1++];
	     }
	   }  
	   
	   return count;  
	 }  
	   
	 /* count inversions in A[l..r) */  
	 public static long countInversion(int[] A, int l, int r, int[] B) {  
	   if (l >= r) return 0;  
	   
	   long count = 0;  
	   int mid = l + (r - l) / 2;  
	   
	   // sort subarrays if needed  
	   if (mid > l+1) count += countInversion(A, l, mid, B);  
	   if (mid < r-1) count += countInversion(A, mid, r, B);  
	   
	   // merge and count inversions  
	   count += mergeAndCount(A, l, mid, r, B);  
	   
	   return count;  
	 }  
	 
	public static void printInversions(int[] a) {
		long c = countInversion(a, 0, a.length, new int[a.length]);
		System.out.println("sort count: " + c);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 22, 48, 12, 35, 57 };
		System.out.println("brute force: " + countInversion_bruteforce(a));
		printInversions(a);
	}

}
