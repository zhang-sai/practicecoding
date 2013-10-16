/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

//XXX be aware of a and A should be treated as the same
 * */
public class ValidPalindrone {

	public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty()) {
        	return true;
        }
        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while(i <=j ) {
        	if(!this.isAlphDigit(c[i])) {
        		i++;
        		continue;
        	}
        	if(!this.isAlphDigit(c[j])) {
        		j--;
        		continue;
        	}
        	if(this.isSameChar(c[i], c[j])) {
        		i++;
        		j--;
        	} else {
        		return false;
        	}
        }
        return true;
    }
    boolean isSameChar(char c1, char c2) {
		return Character.toLowerCase(c1) == Character.toLowerCase(c2);
	}
	
	boolean isAlphDigit(char c) {
		return (c>= '0' && c <= '9') || (c >= 'a' && c <='z') || (c >= 'A' && c <= 'Z');
	}
}
