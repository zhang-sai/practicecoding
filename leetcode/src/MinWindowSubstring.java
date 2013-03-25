import java.util.HashMap;
import java.util.HashSet;
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
xxx
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
        
    }
	
	public static void main(String[] args) {
		MinWindowSubstring min = new MinWindowSubstring();
//		System.out.println(min.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(min.minWindow("abcabdebac", "cda"));
	}
}
