import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * */
public class ValidParenth {
	public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c=='(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
            if(c == '}') {
                if(stack.isEmpty() ||stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
            if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
