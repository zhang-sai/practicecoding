import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "*") ? true
isMatch("aa", "a*") ? true
isMatch("ab", "?*") ? true
isMatch("aab", "c*a*b") ? false
 * */
//credit goes to: http://discuss.leetcode.com/questions/222/wildcard-matching
public class WildcardMatching {
	
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
//		System.out.println(wm.isMatch_recusive("aa", "*"));
//		System.out.println(wm.isMatch("a", "a*"));
		System.out.println(wm.isMatch("aab", "c*a*b"));
	}
	
	//NOT SO EFFICIENT, fail on large
	//credit goes to: http://discuss.leetcode.com/questions/222/wildcard-matching
	public boolean isMatch_recusive(String s, String p) {
		for(int index = 0; index < p.length(); index++) {
			char c = p.charAt(index);
			if(c == '?') {
				if(s.isEmpty()) {
					return false;
				}
				return this.isMatch_recusive(s.substring(1), p.substring(1));
			} else if (c == '*') {
				//XXX goes to the last char after last *
				while(p.charAt(index) == '*') {
					index++;
					if(index >= p.length()) {
						break;
					}
				}
				if(index == p.length()) {
					return true;
				}
				
				//XXX this most tricky part
				//check whether the remaining of p after * can match any of s
				for(int i = 0; i < s.length(); i++) {
					if(this.isMatch_recusive(s.substring(i), p.substring(index))) {
						return true;
					}
				}
				return false;
			} else {
				if(s.isEmpty()) {
					return false;
				}
				if(s.charAt(0) != c) {
					return false;
				} else {
					return this.isMatch_recusive(s.substring(1), p.substring(1));
				}
			}
		}
		
		if(p.isEmpty()) {
			return s.isEmpty();
		}
		
		return false;
	}
	
	//XXX fail on large set
	public boolean isMatch(String s, String regex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //first remove all successive starts
		int slen = s.length();
		//count the number of no stars
		int lengthOfNoStar = 0;
		for(char c : regex.toCharArray()) {
			if(c != '*') {
				lengthOfNoStar++;
			}
		}
		if(lengthOfNoStar > slen) {
			return false;
		}
		//some optimization
		if(slen == 0) {
			if(lengthOfNoStar == 0) {
			    return true;
			} else {
				return false;
			}
		}
		
		if(regex.length() == 0) {
			return s.isEmpty() ? true : false;
		}
		
		//need to eliminate the regex to remove neighboring *
		List<Character> lchar = new ArrayList<Character>();
		for(int i = 0; i < regex.length(); i++) {
			char c = regex.charAt(i);
			if(i != 0) {
				if(c == '*' && c == regex.charAt(i-1)) {
					continue;
				}
			}
			lchar.add(c);
		}
		char[] newChars = new char[lchar.size()];
		for(int i = 0; i < newChars.length; i++) {
			newChars[i] = lchar.get(i);
		}
		regex = String.valueOf(newChars);
		
		//create a matrix
		boolean[][] matrix = new boolean[regex.length()][s.length()];
		
		//for the special case
		for(int i = 0; i < s.length(); i++) {
			if(regex.charAt(0) == '*') {
			    matrix[0][i] = true;
			} else if (regex.charAt(0) == '?') {
				matrix[0][0] = true; //XXX set the first being matched
				break;
			} else {
				if(regex.charAt(0) == s.charAt(0)) {
					matrix[0][0] = true;
					break;
				}
			}
		}
		boolean seeNonStarChar = false;
		for(int i = 0; i < regex.length(); i++) { //XXX this step is critical, be aware: "aab", "c*a*b"
			if(regex.charAt(i) == '*') {
				if(seeNonStarChar && !matrix[i-1][0]) { //XXX Must check this
					matrix[i][0] = false;
				} else {
				    matrix[i][0] = true;
				}
			} else if (regex.charAt(i) == '?') {
				if(!seeNonStarChar) { //all star chars
				    matrix[i][0] = true;  //XXX be aware of the case: a -> a*
				}
				seeNonStarChar = true;
			} else {
				if(regex.charAt(i) == s.charAt(0)) {
					if(!seeNonStarChar) {
					    matrix[i][0] = true;
					}
				}
				seeNonStarChar = true;
			}
		}
		
		//fill in the matrix
		for(int i = 1; i < matrix.length; i++) {
			
			//the matched last columns
			Set<Integer> matchedColumns = new HashSet<Integer>();
			for(int j = 0; j < matrix[i-1].length; j++) {
				if(matrix[i-1][j]) {
					matchedColumns.add(j);
				}
			}
			
			char regexChar = regex.charAt(i);
			for(int j = 1; j < matrix[i].length; j++) {
				char cChar = s.charAt(j);
				if(regexChar == '*') {
					matrix[i][j] = !matchedColumns.isEmpty() && j >= Collections.min(matchedColumns) ? true : false;
				} else if (regexChar == '?') {
					matrix[i][j] = matchedColumns.contains(j-1) ? true : false;
				} else {
					matrix[i][j] = (cChar == regexChar) && matchedColumns.contains(j-1) ? true : false;
				}
			}
		}
		
		//print the matrix
// 		for(int i = 0; i < matrix.length; i++) {
// 			for(int j = 0; j < matrix[i].length; j++) {
// 				System.out.print(matrix[i][j] + "  ");
// 			}
// 			System.out.println();
// 		}
		
		return matrix[regex.length() - 1][s.length() - 1];
    }
	
	//this passes on the large test
	public boolean isMatch_others(String s, String regex) {
		// without this optimization, it will fail for large data set
		// without this optimization, it will fail for large data set
	    int plenNoStar = 0;
	    for (char c : regex.toCharArray()) {
	        if (c != '*') {
	            plenNoStar++;
	        }
	    }
	    if (plenNoStar > s.length()) {
	        return false;
	    }

        //add a special space before s and regex
	    s = " " + s;
	    regex = " " + regex;
	    int slen = s.length();
	    int plen = regex.length();

        //did the regex match up to the i-th string
	    boolean[] dp = new boolean[slen];
	    TreeSet<Integer> firstTrueSet = new TreeSet<Integer>();
	    firstTrueSet.add(0);
	    dp[0] = true;

	    boolean allStar = true; //if any non-star character has been seen
	    for (int pi = 1; pi < plen; pi++) {
	        if (regex.charAt(pi) != '*') {
	            allStar = false;
	        }
	        for (int si = slen - 1; si >= 0; si--) {
	            if (si == 0) { //zero is an inserted symbol, canonly be matched through all star
	                dp[si] = allStar ? true : false;
	            } else if (regex.charAt(pi) != '*') {
	                if (s.charAt(si) == regex.charAt(pi) || regex.charAt(pi) == '?') {
	                    dp[si] = dp[si-1];
	                } else {
	                    dp[si] = false;
	                }
	            } else { //if it is star
	                int firstTruePos = firstTrueSet.isEmpty() ? Integer.MAX_VALUE : firstTrueSet.first();//the minimual one
	                if (si >= firstTruePos) {
	                    dp[si] = true;
	                }
	                else {
	                    dp[si] = false;
	                }
	            }
	            if (dp[si]) {
	                firstTrueSet.add(si);
	            } else {
	                firstTrueSet.remove(si);
	            }
	        }
	    }
	    return dp[slen - 1];
    }
}
