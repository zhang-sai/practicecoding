import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Given a string S and a string T, find the minimum window in S which
 * will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * */
//XXX note that t may have some repetition
xx
//http://computationalpuzzles.wordpress.com/2011/11/17/substring-with-concatenation-of-all-words-in-a-list/
public class MinWindowSubstring {
	public String minWindow(String s, String t) {
		if(s == null || t == null) {
			return "";
		}
		if(s.isEmpty() || t.isEmpty()) {
			return "";
		}
        // Start typing your Java solution below
        // DO NOT write main() function
		Set<Character> set = new HashSet<Character>();
        List<Character> tset = new ArrayList<Character>();
        for(char c : t.toCharArray()) {
        	tset.add(c);
        	set.add(c);
        }
        //two indices
        int i = 0;
        while(i < s.length() && !tset.contains(s.charAt(i))) {
        	i++;
        }
        if(i >= s.length()) {
        	return "";
        }
        tset.remove((Character)s.charAt(i));
        int j = i + 1;
        String minLenStr = null;
        while(j < s.length()) {
        	//exclusive j
        	if(tset.isEmpty()) {
        		minLenStr = minLenStr == null
        		    ? s.substring(i, j)
        		    : (j - i < minLenStr.length() ? s.substring(i, j) : minLenStr);
        		tset.add(s.charAt(i));
        		i ++;//XXX move i to the next matched
        		while(i < s.length() && !set.contains(s.charAt(i))) {
        			i++;
        		}
        		if(i >= s.length()) {
        			return minLenStr == null ? "" : minLenStr;
        		}
        		j ++;
        	} else {
        		tset.remove((Character)s.charAt(j));
        		j++;
        	}
        }
        if(tset.isEmpty()) {
    		minLenStr = minLenStr == null
    		    ? s.substring(i, j)
    		    : (j - i < minLenStr.length() ? s.substring(i, j) : minLenStr);
    		
    	}
        return minLenStr == null ? "" : minLenStr;
    }
	
	public static void main(String[] args) {
		MinWindowSubstring min = new MinWindowSubstring();
//		System.out.println(min.minWindow("ADOBECODEBANC", "ABC"));
//		System.out.println(min.minWindow("abcabdebac", "cda"));
//		System.out.println(min.minWindow("a", "b"));
//		System.out.println(min.minWindow("a", "a"));
//		System.out.println(min.minWindow("bdab", "ab"));
//		System.out.println(min.minWindow("abc", "a"));
		System.out.println(min.minWindow("ADOBECODEBANC", "ABC"));
		
	}
}
