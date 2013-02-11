
/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 * */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		s = s.trim();
		if(s.isEmpty()) {
			return 0;
		}
		for(int i = s.length() - 1; i >=0; i--) {
			if(isChar(s.charAt(i))) {
				continue;
			} else {
				return s.length() - i - 1;
			}
		}
        return s.length();
    }
	
	private boolean isChar(char c) {
		return (c>='a' && c <= 'z') || (c>='A' && c <='Z');
	}
}
