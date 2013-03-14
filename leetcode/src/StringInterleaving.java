import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 * */

/**
 * Not as easy as expected!!!
 * 
 * basic idea:
 * 
 * initialize 3 list:
 * 
 * is interleaving == remove each char in l2 from l3 in the order of its appearance in l2
 *  and check whether the remaining list is l3
 *  
 *  or
 *  
 * remove l1 first
 * 
 * */
public class StringInterleaving {
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null) {
			return false;
		}
		if(s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if(s1.isEmpty() || s2.isEmpty()) {
			return s3.equals(s1 + s2);
		}
		//then use dynamic programming to solve this
		boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
		matrix[0][0] = true; //it is ok to be true
		for(int i = 1; i <= s2.length(); i++) {
			boolean prevCell = i == 1 ? true : matrix[0][i-1];
			if(prevCell && s3.charAt(i - 1) == s2.charAt(i - 1)) {
				matrix[0][i] = true;
			}
		}
		
		for(int i = 1; i <= s1.length(); i++) {
			boolean prevCell = i == 1 ? true : matrix[i-1][0];
			if(prevCell && s3.charAt(i - 1) == s1.charAt(i - 1)) {
				matrix[i][0] = true;
			}
		}
		
		//start to compute each cell
//		System.out.println("s1 length: " + s1.length());
//		System.out.println("s2 length: " + s2.length());
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				//two possibilities
				//1. matrix[i-1][j] = true && s3[i + j -1] == s1[i-1]
				//2. matrix[i][j-1] = true && s3[i+j - 1] = s2[j-1]
				
				char s3char = s3.charAt(i + j - 1);
				char s1char = s1.charAt(i - 1);
				char s2char = s2.charAt(j - 1);
//				System.out.println(i + ", " + j + ", matrix size: "
//						+ matrix.length + ", " + matrix[0].length
//						+ " s1char: " + s1char + ", s2char: " + s2char + ", s3 char: " + s3char
//						+ "  last two cells: " + matrix[i-1][j] + ", and " + matrix[i][j-1]);
				if(matrix[i-1][j] && s3char == s1char) {
					matrix[i][j] = true;
				} else if (matrix[i][j-1] && s3char == s2char) {
					matrix[i][j] = true;
				}
			}
		}
		
//		for(int i = 0; i < s1.length() + 1; i++) {
//			for(int j = 0; j < s2.length() + 1; j++) {
//				System.out.print(matrix[i][j] + "  ");
//			}
//			System.out.println();
//		}
		
		return matrix[s1.length()][s2.length()];
	}
	
	
	
	public static void main(String[] args) {
		StringInterleaving s = new StringInterleaving();
		System.out.println(s.isInterleave("aabaac", "aadaaeaaf", "aadaaeaabaafaac"));
//		System.out.println(s.isInterleave("ab", "bc", "abbc"));
		//ab", "bc", "bbac
	}
	
}