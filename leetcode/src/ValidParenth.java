import java.util.LinkedList;
import java.util.List;


/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * */
public class ValidParenth {
	public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.isEmpty()) {
        	return true;
        }
        List<Character> list = new LinkedList<Character>();
        for(char c : s.toCharArray()) {
        	if(list.isEmpty()) {
        		list.add(c);
        	} else {
        		if(c == '(' || c == '[' || c == '{') {
        			list.add(c);
        		} else {
        			if(c == ')') {
        				if(list.get(list.size() - 1) == '(') {
        					list.remove(list.size() - 1);
        				} else {
        					return false;
        				}
        			} else if (c == ']') {
        				if(list.get(list.size() - 1) == '[') {
        					list.remove(list.size() - 1);
        				} else {
        					return false;
        				}
        			} else if (c == '}') {
        				if(list.get(list.size() - 1) == '{') {
        					list.remove(list.size() - 1);
        				} else {
        					return false;
        				}
        			}
        		}
        	}
        }
        return list.isEmpty();
    }
}
