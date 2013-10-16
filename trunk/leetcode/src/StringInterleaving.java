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
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if(l3 != l1 + l2) {
            return false;
        }
        if(l1 == 0 || l2 == 0) {
            return s3.equals(s1 + s2);
        }
        //use dynamic programming
        boolean[][] matches = new boolean[l1 + 1][l2 + 1];
        
        //compute each columns
        matches[0][0]= true;
        for(int i = 0; i < l1; i++) {
            if(s3.startsWith(s1.substring(0, i+1))) {
                matches[i+1][0] = true;
            } else {
                matches[i+1][0] = false;
            }
        }
        for(int i = 0; i < l2; i++) {
            if(s3.startsWith(s2.substring(0, i+1))) {
                matches[0][i+1] = true;
            } else {
                matches[0][i+1] = false;
            }
        }
        //compute the rest
        for(int i = 1; i < l1 + 1; i++) {
            for(int j = 1; j < l2 + 1; j++) {
                if(s1.charAt(i-1) == s3.charAt(i - 1 + j - 1 + 1)) {
                    matches[i][j] = matches[i-1][j];
                } 
                
                if(!matches[i][j])  //need check here
                    if (s2.charAt(j-1) == s3.charAt(i - 1 + j - 1 + 1)) {
                        matches[i][j] = matches[i][j-1];
                    } 
            }
        }
        
        return matches[l1][l2];
    }
	
	
	
	public static void main(String[] args) {
		StringInterleaving s = new StringInterleaving();
		System.out.println(s.isInterleave("aabaac", "aadaaeaaf", "aadaaeaabaafaac"));
//		System.out.println(s.isInterleave("ab", "bc", "abbc"));
		//ab", "bc", "bbac
	}
	
}