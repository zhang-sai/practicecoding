/**
 * not subsequence. the character must be next to each other
 * fsfsfABCDEFGsfff
 * fsfABCDEFGsf
 * is ABCDEFG
 * 
 * http://en.wikipedia.org/wiki/Longest_common_substring_problem
 * */

public class LongestCommonSubstring {

	public static void main(String[] args) {
		lcs("ABAB", "BABA");
		lcs("AXCBCABE", "ACBCAZBYE");
	}
	
	public static void lcs(String str1, String str2) {
		int start = -1;
		int end = -1;
		int maxSofar = Integer.MIN_VALUE;
		
		//a dynamic programming array
		int[][] max = new int[str1.length() + 1][str2.length() + 1];
		int row = max.length;
		int col = max[0].length;
		for(int i = 0; i < row; i++) {
			max[i][0] = 0;
		}
		for(int i = 0; i < col; i++) {
			max[0][i] = 0;
		}
		//do the rest stuff
		for(int i = 1; i < row; i++) {
			for(int j = 1; j < col; j++) {
				if(str1.charAt(i-1) == str2.charAt(j - 1)) {
					max[i][j] = max[i-1][j-1] + 1;
				} else {
					max[i][j] = 0;
				}
				//update the index
				//donot forget this step
				if(max[i][j] > maxSofar) {
					maxSofar = max[i][j];
					start = i;
					end = j;
				}
			}
		}
		
		System.out.println("start; " + start + ", end: " + end + ", length: " + maxSofar);
		System.out.println(str1.substring(start - maxSofar, start));
		//the same
		//System.out.println(str2.substring(end - maxSofar, end));
	}
	
}
