import java.util.Collection;
import java.util.LinkedHashSet;
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
		System.out.println(wm.isMatch_recusive("aa", "*"));
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
	
	public boolean isMatch(String s, String regex) {
		//first remove all successive starts
		int slen = s.length();
		int rlen = regex.length();
		
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
		
		//
		
		//slen must > 0
		boolean[][] matrix = new boolean[regex.length()][s.length()];
		
		int lastMatchedCol = -1;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(j < lastMatchedCol) {
					matrix[i][j] = false;
				}
				if(regex.charAt(i) == '?') {
					
				} else if (regex.charAt(i) == '*') {
					
				} else {
					//normal character
					if(regex.charAt(i) == s.charAt(j)) {
						matrix[i][j] = true;
					} else {
						matrix[i][j] = false;
					}
				}
			}
		}
	}
	
	//XXX a dynamic programming algorithm
	public boolean isMatch_others(String s, String regex) {
		// without this optimization, it will fail for large data set
	    int plenNoStar = 0;
	    for (char c : regex.toCharArray())
	        if (c != '*') plenNoStar++;
	    if (plenNoStar > s.length()) return false;

	    s = " " + s;
	    regex = " " + regex;
	    int slen = s.length();
	    int plen = regex.length();

	    boolean[] dp = new boolean[slen];
	    TreeSet<Integer> firstTrueSet = new TreeSet<Integer>();
	    firstTrueSet.add(0);
	    dp[0] = true;

	    boolean allStar = true;
	    for (int pi = 1; pi < plen; pi++) {
	        if (regex.charAt(pi) != '*')
	            allStar = false;
	        for (int si = slen - 1; si >= 0; si--) {
	            if (si == 0) {
	                dp[si] = allStar ? true : false;
	            } else if (regex.charAt(pi) != '*') {
	                if (s.charAt(si) == regex.charAt(pi) || regex.charAt(pi) == '?') dp[si] = dp[si-1];
	                else dp[si] = false;
	            } else {
	                int firstTruePos = firstTrueSet.isEmpty() ? Integer.MAX_VALUE : firstTrueSet.first();
	                if (si >= firstTruePos) dp[si] = true;
	                else dp[si] = false;
	            }
	            if (dp[si]) firstTrueSet.add(si);
	            else firstTrueSet.remove(si);
	        }
	    }
	    return dp[slen - 1];
    }
}
