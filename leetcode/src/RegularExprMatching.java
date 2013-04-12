/**
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

 * */
public class RegularExprMatching {
	public boolean isMatch(String s, String p) {
		XXXX
    }
	
	public boolean isMatch_Wrong_Question(String s, String p) {
		if(p.isEmpty()) {
			return s.isEmpty();
		}
		int numOfStar = 0;
		for(char c : p.toCharArray()) {
			if(c == '*') numOfStar ++;
		}
		if(p.length() - numOfStar > s.length()) {
			return false;
		}
		if(s.isEmpty()) {
			return p.length() - numOfStar == 0;
		}
		
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] match = new boolean[p.length()][s.length()];
        
        //compute the first row
        char pChar = p.charAt(0);
        for(int i = 0; i < s.length(); i++) {
        	if(pChar == '*') {
        		match[0][i] = true;
        	} else if(pChar == '.') {
        		match[0][i] = (i == 0) ? true : false;
        	} else {
        		match[0][i] = (i == 0 && s.charAt(0) == pChar) ? true : false;
        	}
        }
        
        //compute the first column
        char sChar = s.charAt(0);
		if (pChar == '*') {
			for (int i = 1; i < p.length(); i++) {
				if (p.charAt(i) == '*') {
					match[i][0] = match[i - 1][0];
				} else if (p.charAt(i) == '.') {
					match[i][0] = (p.charAt(i - 1) == '*' && match[i - 1][0]) ? true : false;
					break; // XXX MUST break;
				} else {
					match[i][0] = (p.charAt(i - 1) == '*' && match[i - 1][0] && sChar == p.charAt(i)) ? true : false;
					break; // XXX must break;
				}
			}
        }
        
        //compute the rest cells
        for(int j = 1; j < s.length(); j++) {
        	char sc = s.charAt(j);
        	for(int i = 1; i < p.length(); i++) {
        		char pc = p.charAt(i);
        		if(pc == '*') {
        			match[i][j] = match[i-1][j-1] || match[i-1][j];
        		} else if (pc == '.') {
        			match[i][j] = match[i-1][j-1]; //match any char
        		} else {
        			match[i][j] = match[i-1][j-1] && sc == pc; 
        		}
        	}
        }
        
        return match[p.length() - 1][s.length() - 1];
    }
}
