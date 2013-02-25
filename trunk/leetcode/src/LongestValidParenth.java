
/**
 * Given a string containing just the characters '(' and ')',
 *  find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring
is "()()", which has length = 4.
 * */
public class LongestValidParenth {
	 public int longestValidParentheses(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 char[] cs = s.toCharArray();
		 char left = '(';
		 char right = ')';
		 
		 int maxLength = 0;
		 for(int i = 0; i < cs.length - 1; i++) {
			 if(cs[i] == left && cs[i+1] == right) {
				 //expand from here
				 
				 int iter = Math.min(i, cs.length - )
			 }
		 }
	        
	 }
}
