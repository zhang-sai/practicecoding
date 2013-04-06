/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * */
public class LongestPalindrome {
	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
		System.out.println(lp.longestPalindrome("a"));
	}
	public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty()) {
        	return s;
        }
        String maxStr = "";
        
        for(int i = 0; i < s.length(); i++) {
        	//possible center
        	int k = i - 1;
        	int j = i + 1;
        	while(k >= 0 && j < s.length() && s.charAt(k) == s.charAt(j)) {
        		k--;
        		j++;
        	}
        	k++; //XXX revert to the original place
        	j--;
        	if(j-k+1 > maxStr.length()) {
        		maxStr = s.substring(k, j + 1);
        	}
        	
        	//possible 2 centers
        	if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
        		k = i - 1;
        		j = i + 2;
        		while(k >= 0 && j < s.length() && s.charAt(k) == s.charAt(j)) {
            		k--;
            		j++;
            	}
        		k++; //XXX revert to the original place
            	j--;
            	if(j-k+1 > maxStr.length()) {
            		maxStr = s.substring(k, j + 1);
            	}
        	}
        }
        
        return maxStr;
    }
}
