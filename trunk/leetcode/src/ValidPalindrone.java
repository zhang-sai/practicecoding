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
//        return this.isPalindrome(s.toCharArray(), 0, s.length() - 1);
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
	
	//XXX this recursive question does not pass big test
	public boolean isPalindrome(char[] c, int start, int end) {
		if(start == end || start > end) {
			return true;
		}
		if(this.isAlphDigit(c[start]) && this.isAlphDigit(c[end])) {
			if(Character.toLowerCase(c[start]) == Character.toLowerCase(c[end])) {
			    return this.isPalindrome(c, start + 1, end - 1);
			} else {
				return false;
			}
		} else {
			return this.isPalindrome(c, this.isAlphDigit(c[start]) ? start : start + 1,
					this.isAlphDigit(c[end]) ? end : end - 1);
		}
	}
	
	boolean isSameChar(char c1, char c2) {
		return Character.toLowerCase(c1) == Character.toLowerCase(c2);
	}
	
	boolean isAlphDigit(char c) {
		return (c>= '0' && c <= '9') || (c >= 'a' && c <='z') || (c >= 'A' && c <= 'Z');
	}
}
