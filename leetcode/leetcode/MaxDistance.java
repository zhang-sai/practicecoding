/**
 * Given an array A of integers, find the maximum of j-i subjected to the constraint of A[i] < A[j].
 * 
 * */
public class MaxDistance {

	public static int findMax(int[] a) {
		
		
		int n = a.length;
		boolean[] minLeft = new boolean[n];
		
		//only shorter than the previous one
		int min = a[0];
		minLeft[0] = true;
		for(int i = 1; i < n; i++) {
			if(a[i] < min) {
				minLeft[i] = true;
				min = a[i];
			} else {
				minLeft[i] = false;
			}
		}
		
		//compute the max
		int maxDist = 0;
		int i = n - 1;
		int j = n - 1;
		//the start/end points
		int start = 0;
		int end = 0;
		while(i >= 0) {
			//get the first min
			if(minLeft[i] = false) {
				i--;
				continue;
			}
			//move j to the first valid location
			while(a[j] <= a[i] && j > i) {
				j--;
			}
			//check the results
			if( j - i > maxDist) {
				maxDist = j - i;
				start = i;
				end = j;
			}
			//move the short bar
			i--;
		}
		
		System.out.println(start + "   " + end);
		return maxDist;
	}
	
	public static void main(String[] args) {
		System.out.println(findMax(new int[]{4,3,5,2,1,3,11,3}));
	}
	
}
