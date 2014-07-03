import java.util.Random;

import util.Utils;

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


public class CountingInversions {

	public static long countInversion_bruteforce(Integer[] a) {
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
	 private static long mergeAndCount(Integer[] A, int l, int mid, int r, Integer[] B) {  
	   long count = 0;  

	   // copy from A to B  
	   //src, src-index, dest, dest-index, length
	   System.arraycopy(A, l, B, l, r-l);  
	   // merge
	   
	   int index = l;
	   int h1 = l;
	   int h2 = mid;
	   while(h1 < mid && h2 < r) {
		   if(B[h2] < B[h1]) {
			   count += (h2 - index); //count the number of inversion
			   A[index++] = B[h2++];
		   } else {
			   A[index++] = B[h1++];
		   }
	   }
	   
	   while(h1 < mid) {
		   A[index++] = B[h1++];
	   }
	   while(h2 < r) {
		   A[index++] = B[h2++];
	   }
	   
//	   for (int i=l, h1=l, h2=mid;  i<r;  ++i) {
//		   /**
//		    *  i
//		    *  1 3 9  midpoint 2 4 6
//		    *  h1              h2
//		    * */
//		   
//		   
//	     if (h1 >= mid || (h2 < r && B[h2] < B[h1])) {
//	      //XXX this step is critical: why h2 - i?
//	      // suppose  1 3 9  mid-point  2 4 6
//	      // when h2 = 3 with value 2,  h1 = 1 with value 3
//	      //   now i = 2, so h2 - i = 1 
//	    	 
//	       //which means that h2 should be put in the position i
//	       //now h2 - i many elements are before it!
//	    	 
//	    	 //the first condition is redundant
//	    	 if(h1 >= mid) {
//	    		 if(h2 != i) {
//	    			 throw new Error("h2: " + h2 + " i: " + i + Utils.dumpArray(B));
//	    		 }
//	    	 }
//	       count += (h2 - i);
//	       A[i] = B[h2++];
//	     } else {
//	       A[i] = B[h1++];
//	     }
//	   }  
	   
	   return count;  
	 }  
	   
	 /* count inversions in A[l..r) */  
	 public static long countInversion(Integer[] A, int l, int r, Integer[] B) {  
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
	 
	public static long printInversions(Integer[] a) {
		long c = countInversion(a, 0, a.length, new Integer[a.length]);
		System.out.println("sort count: " + c);
		return c;
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 22, 48, 12, 35, 57 };
		System.out.println("brute force: " + countInversion_bruteforce(a));
		printInversions(a);
		
		Random r = new Random();
		for(int i = 0; i < 100; i++) {
			Integer[] array = new Integer[r.nextInt(100) + 1];
			for(int j = 0; j < array.length; j++) {
				array[j] = r.nextInt(10*array.length);
			}
			long r_bf = countInversion_bruteforce(array);
			long r_r = printInversions(array);
			if(r_bf != r_r) {
				throw new Error();
			}
		}
	}

}
