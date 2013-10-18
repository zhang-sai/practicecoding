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

//http://computationalpuzzles.wordpress.com/2011/11/17/substring-with-concatenation-of-all-words-in-a-list/
public class MinWindowSubstring {
	public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[] needToFind = new int[256];
        for(int i = 0; i < tLen; i++) {
            needToFind[t.charAt(i)]++;
        }
        
        int minWindowBegin = -1;
        int minWindowEnd = -1;
        int minWindowLen = Integer.MAX_VALUE;
        
        
        int[] hasFound = new int[256];
        int count = 0;
        
        for (int begin = 0, end = 0; end < sLen; end++) {
            // skip characters not in T
            if (needToFind[s.charAt(end)] == 0) {
                continue;
            }
            hasFound[s.charAt(end)]++;
            if (hasFound[s.charAt(end)] <= needToFind[s.charAt(end)]) {
              count++;
            }
 
            // if window constraint is satisfied
            if (count == tLen) {
               // advance begin index as far right as possible,
               // stop when advancing breaks window constraint.
               while (needToFind[s.charAt(begin)] == 0 ||
                    hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]) {
                    if (hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]) {
                         hasFound[s.charAt(begin)]--;
                    }
                    begin++;
              }
 
               // update minWindow if a minimum length is met
               int windowLen = end - begin + 1;
               if (windowLen < minWindowLen) { 
                   minWindowBegin = begin;
                   minWindowEnd = end;
                   minWindowLen = windowLen;
               } // end if
            } // end if
         } // end for
 
         return (count == tLen) ? s.substring(minWindowBegin, minWindowEnd + 1) : "";
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
