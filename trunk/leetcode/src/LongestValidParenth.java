
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
		 
		 boolean[][] isValid = new boolean[s.length()][s.length()];
		 int[][] longest = new int[s.length()][s.length()];
		 
		 for(int i = 0; i < s.length(); i++) {
			 int j = i + 1;
			 if((cs[i] == left && cs[j] == right) || (cs[j] == left && cs[i] == right)) {
				 isValid[i][j] = true;
				 longest[i][j] = 2;
			 } else {
				 isValid[i][j] = false;
				 longest[i][j] = 0;
			 }
		 }
		 
		 for(int i = 0; i < s.length(); i++) {
			 for(int j = i + 2; j < s.length(); j++) {
				 //three possibilities
				 if(j > i + 2) {
					 int max = Integer.MIN_VALUE;
					 if(isValid[i][j-2] && ((cs[j] == left && cs[j-1] == right) || (cs[j-1] == left && cs[j] == right))) {
						 int length = longest[i][j-2] + 2;
						 if(length > max) {
							 max = length;
							 isValid[i][j] = true;
						 }
					 } else if(isValid[i+2][j] && ((cs[i] == left && cs[i+1] == right) || (cs[i+1] == left && cs[i] == right))) {
						 int length = longest[i][j-2] + 2;
						 if(length > max) {
							 max = length;
							 isValid[i][j] = true;
						 }
					 } else if {
						 
					 }
				 } else{
					 
				 }
			 }
		 }
		 
		 return longest[0][s.length() - 1];
	        
	 }
}
