import util.Utils;

//find 1, 3, 5, 6
//in 1, 7, 3, 9, 5, 7, 6
//n2  is the complexity
//http://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
//http://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
public class LongestIncreasingSubstring {
	
	public static int printLongestIncreasingSubstr(Integer[] a) {
	
		//use dynamic programming
		if(a.length == 1) {
			return 1;
		}
		
		int globalMax = 1;
		int bestEnd = 0;
		
		Integer[] dp = new Integer[a.length];
		Integer[] backtrack = new Integer[a.length];
		
		for(int i = 0; i < a.length; i++) {
			
			dp[i] = 1;
			backtrack[i] = -1;
			
			for(int j = 0; j < i; j++) {
				if(a[j] <= a[i]) {
					int currMax = dp[j] + 1;
					if(currMax > dp[i]) {
						dp[i] = currMax;
						backtrack[i] = j;  //backtrack the previous one
					}
				}
			}
			
			//keep a global record of the best end index
			if(dp[i] > globalMax) {
				globalMax = dp[i];
				bestEnd = i;
			}
			
		}
		
		
//		System.out.println(backtrack);
		System.out.println("Best end: " + bestEnd  + ", max length: " + globalMax);
		System.out.println("Original array: " + Utils.dumpArray(a));
		System.out.println("Length: " + Utils.dumpArray(dp));
		
		System.out.println("Backtrack: " + Utils.dumpArray(backtrack));
		
		int index = bestEnd;
		while(index != -1) {
			System.out.print(a[index] + "  ");
			index = backtrack[index];
		}
		
		return -1;
	}

	
	public static void main(String[] args) {
		Integer[] a = new Integer[]{1, 7, 3, 9, 5, 7, 6, 7, 8};
		printLongestIncreasingSubstr(a);
	}
	
}
