
public class Palindrome {

	public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty()) {
            return true;
        }
        
        for(int i = 0, j = s.length() - 1; i <= j;) {
        	char ichar = s.charAt(i);
        	if(!this.isAlphanumeric(ichar)) {
        		i++;
        		continue;
        	}
        	char jchar = s.charAt(j);
        	if(!this.isAlphanumeric(jchar)) {
        		j--;
        		continue;
        	}
        	if(!this.isCharEqual(ichar, jchar)) {
        		return false;
        	} else {
        		i++;
        		j--;
        	}
        }
        
        return true;
    }
	
	boolean isCharEqual(char c1, char c2) {
		if(c1 == c2) {
			return true;
		} else {
			int i1 = (int)c1;
			int i2 = (int)c2;
			int max = Math.max(i1, i2);
			int min = Math.min(i1, i2);
			if((max > 96 && max < 122 ) && (max - min) == 32) {
				return true;
			}
		}
		return false;
	}
	
	boolean isAlphanumeric(char c) {
		return (c > 47 && c < 58) || (c>64 && c < 90 ) || (c > 96 && c < 122);
	}
	
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		System.out.println(p.isPalindrome("a,bc,ba"));
	}
}