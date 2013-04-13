/**
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

 * */
//http://leetcode.com/2011/09/regular-expression-matching.html
public class RegularExprMatching {
	
	public static void main(String[] args) {
		RegularExprMatching rem = new RegularExprMatching();
//		System.out.println(rem.isMatch("ab", ".*c"));
//		System.out.println(rem.isMatch("aab", "c*a*b"));
//		System.out.println(rem.isMatch("bbbba", ".*a*a"));
//		System.out.println(rem.isMatch("aaba", "ab*a*c*a"));
		System.out.println(rem.isMatch("aa", "a*"));
	}
	//Note p.charAt(0) != *
	public boolean isMatch(String s, String p) {
		System.out.println("matching: " + s + ",  " + p);
		if(s == null || p == null) {
			return false;
		}
		//no char in the pattern
		if(p.isEmpty()) {
			return s.isEmpty();
		}
		//NO need to consider the case that s is empty
		if(p.length() == 1) { //cannot be just a *, two possibilities
			
			boolean r = s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
			System.out.println("  match: " + s + ", " + p + " -> " + r);
			return r;
		}
		//need to take care of *
		if(p.charAt(1) != '*') {
			if(s.isEmpty()) {
				return false;
			} else {
				if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
					return this.isMatch(s.substring(1), p.substring(1));
				} else {
					return false;
				}
			}
		} else { //the next is *
			if(s.isEmpty()) {
				return this.isMatch(s, p.substring(2));
			} else {
				//it can match 0 or many 
				for(int i = 0; i < s.length(); i++) {
					if(s.charAt(i) == p.charAt(0) || p.charAt(0) == '.') {
						System.out.println(" recusive matching: " + s.substring(i + 1) + "  with " + p.substring(2));
						if(this.isMatch(s.substring(i + 1), p.substring(2))) {
							return true;
						}
					} else {
						break; //XXX do not forget break it out
					}
				}
			}
		}
		
		return this.isMatch(s, p.substring(2)); 
		//XXX return match nothing of s
    }
}

