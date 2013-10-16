import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * */
//http://blog.unieagle.net/2012/10/23/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Ascramble-string%EF%BC%8C%E4%B8%89%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
//xxx
public class ScrambleString {
	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble_recursive("rgtae", "great"));
	}
	
	//adapt from: http://codekevin.blogspot.com/2013/03/scramble-string.html
	public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
			return false;
		if (s1.length() == 0 && s1.length() == 0)
			return true;

		int length = s1.length();
		boolean[][][] scramble = new boolean[length][length][length];

		for (int i = 0; i < s1.length(); ++i) {
			for (int j = 0; j < s2.length(); ++j) {
				scramble[i][j][0] = (s1.charAt(i) == s2.charAt(j));
			}
		}

		for (int l = 1; l < s1.length(); ++l) {
			for (int i = 0; i < s1.length() - l; ++i) {
				for (int j = 0; j < s2.length() - l; ++j) {
					for (int k = 0; k < l; ++k) {
						if ((scramble[i][j][k] && scramble[i + k + 1][j + k + 1][l - k - 1])
							|| (scramble[i][j + l - k][k] && scramble[i + k	+ 1][j][l - k - 1]))
							scramble[i][j][l] = true;
					}
				}
			}
		}

		return scramble[0][0][s1.length() - 1];
    }
	
	//use the same string as pruning can pass all tests
	 public boolean isScramble_recursive(String s1, String s2) {
		 if(s1.length() != s2.length()) {
			 throw new Error(s1 + ", " + s2);
		 }
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(s1.isEmpty()) {
	        	return true;
	        }
	        if(s1.length() == 1) {
	        	return s1.equals(s2);
	        } else if(s1.length() == 2) {
	        	return s1.equals(s2) || new StringBuffer(s1).reverse().toString().equals(s2);
	        } else {
	        	for(int i = 1; i < s1.length(); i++) {
	        		String firstS1 = s1.substring(0, i);
	        		String secondS1 = s1.substring(i);
	        		//two possibilities
	        		String firstS2 = s2.substring(0, i);
	        		String secondS2 = s2.substring(i);
	        		if(this.sameString(firstS1, firstS2) && this.sameString(secondS1, secondS2)) {
	        		    if(this.isScramble_recursive(firstS1, firstS2) && this.isScramble_recursive(secondS1, secondS2)) {
	        			    return true;
	        		    }
	        		}
	        		firstS2 = s2.substring(0, (s1.length() - i));
	        		secondS2 = s2.substring((s1.length() - i));
	        		if(this.sameString(firstS1, secondS2) && this.sameString(secondS1, firstS2)) {
	        		    if(this.isScramble_recursive(firstS1, secondS2) && this.isScramble_recursive(secondS1, firstS2)) {
	        			    return true;
	        		    }
	        		}
	        	}
	        }
	       return false;   
	    }
	 
	 private boolean sameString(String s1, String s2) {
		 Set<Character> set1 = new HashSet<Character>();
		 for(char c1 : s1.toCharArray()) {
			 set1.add(c1);
		 }
		 Set<Character> set2 = new HashSet<Character>();
		 for(char c2 : s2.toCharArray()) {
			 set2.add(c2);
		 }
		 return set1.equals(set2);
	 }
}
