import java.util.Stack;


/**
 * Given a string containing just the characters '(' and ')',
 *  find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring
is "()()", which has length = 4.
 * */

//sample answer: https://gist.github.com/xiaonanz/4123341
public class LongestValidParenth {
	
	public static void main(String[] args) {
		LongestValidParenth lvp = new LongestValidParenth();
		//be aware of the following cases
		//the length should be 2 rather than 4
		System.out.println(lvp.longestValidParentheses("()(()"));
	}
	
	public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs = s.toCharArray();
		 char left = '(';
		 char right = ')';
		 
		 int maxLength = 0;
		 int currLength = 0;
		 int count = 0; //used to simulate a stack
		 
		 for(int i = 0; i < cs.length; i++) {
			 currLength ++;
			 char c = cs[i];
			 count += c == left ? 1 : -1;
			 if(count == 0) {
				//perfectly matched but not the case: (() 
				 maxLength = Math.max(maxLength, currLength);
			 } else if (count < 0) {
				 count = 0;
				 currLength = 0;
			 }
			 //do nothing for count > 0
		 }
		 
		 currLength = 0;
		 count = 0;
		 for(int i = cs.length - 1; i >= 0; i--) {
			 currLength ++;
			 char c = cs[i];
			 count += c == right ? 1 : -1;
			 if(count == 0) {
				//perfectly matched but not the case: (() 
				 maxLength = Math.max(maxLength, currLength);
			 } else if (count < 0) {
				 count = 0;
				 currLength = 0;
			 }
			 //do nothing for count > 0
		 }
		 
		 return maxLength;
    }
}
