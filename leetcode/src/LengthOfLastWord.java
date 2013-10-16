
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
        if(s == null || s.length() == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int startFromEnd = cs.length - 1;
        while(startFromEnd >= 0 && !isAlpha(cs[startFromEnd]) ) {
            startFromEnd--;
        }
        if(startFromEnd == -1) {
            return 0;
        }
        int endFromEnd = startFromEnd - 1;
        while(endFromEnd >= 0 && isAlpha(cs[endFromEnd]) ) {
            endFromEnd --;
        }
        return startFromEnd - endFromEnd;
    }
    
    private boolean isAlpha(char c) {
        return (c>='a' && c <= 'z') || (c>= 'A' && c <='Z');
    }
}
