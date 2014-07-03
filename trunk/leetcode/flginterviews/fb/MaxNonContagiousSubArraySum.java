package fb;

/**
 * http://n00tc0d3r.blogspot.com/2013/07/maximum-sum-of-non-contiguous.html?q=
 * adjacent
 * 
 * Given an array of integers, find the maximum sum of a subsequence with the
 * constraint that no 2 numbers in the sequence should be adjacent in the array.
 * 
 * For example, given [3 2 7 10], return 13 (sum of 3 and 10); given [3 2 -5 10
 * 7], return 13 (sum of 3 and 7).
 * 
 * If all numbers are negative, return 0.
 * */
public class MaxNonContagiousSubArraySum {

	// the dp solution is straightfoward, with O(n2) time and O(n) space
	public int maxSumInSubsequence_dp(int[] data) {  
		   if (data == null) return 0;  
		   int n = data.length;  
		   
		   // maxSum[i] == the maximum sum of subsequences of data[0 .. i] that include data[i]  
		   int[] maxSum = new int[n];  
		   for (int i=0; i<n; ++i) {  
		     maxSum[i] = data[i];  
		     // maxSum[i-1] includes data[i-1] and thus cannot include data[i]  
		     for (int j=0; j<i-1; ++j) {  
		       maxSum[i] = Math.max(data[i] + maxSum[j], maxSum[i]);  
		     }  
		   } 
		   
		   // find the max of all subsequences  
		   int max = 0;  
		   for (int i=0; i<n; ++i) {  
		     max = Math.max(max, maxSum[i]);  
		   }  
		   
		   return max;  
		 }  
	
	//this is O(n) with O(1)
	//incl and excl keep the max value of the max
	//value of including or excluding the current value
	// so, excl_i = excl_(i-1) or incl_(i-1)
	//     incl_i = exel_(i-1) + data
	public int maxSumInSubsequence(int[] data) {
		if (data == null)
			return 0;
		int n = data.length;

		//excluding current one
		int incl = data[0], excl = 0;
		for (int i = 1; i < n; ++i) {
			// current max excluding data[i]
			//either include previous or exclude previous
			int exclNew = Math.max(incl, excl);
			// current max including data[i]
			incl = excl + data[i];
			excl = exclNew;
		}

		return Math.max(incl, excl);
	}

}
