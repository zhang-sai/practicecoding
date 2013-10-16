
/**
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

NOTE:
+1
-1
+0.xx
1e00000 is OK
.34
13.  is ok
000000 is OK
1e000000000  is OK

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

XXX
 * */
//cannot pass the large test
//http://www.cnblogs.com/remlostime/archive/2012/11/18/2775938.html


public class ValidNumeric {
	
	public boolean isNumber(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        s = s.trim();
        if(s.length() == 0) {
            return false;
        }
        
        boolean hasDot = false;
        boolean hasE = false;
        boolean beginWithMinusOrPlus = false;
        
        int digitCount = 0;
        
        char[] cs = s.toCharArray();
        
        for(int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if(i==0) {
                if(c == '.') {
                    hasDot = true;
                } else if(c=='-' || c == '+') {
                    beginWithMinusOrPlus = true;
                } else {
                    if(!isDigit(c)) {
                        return false;
                    } else {
                        digitCount++;
                    }
                }
            } else {
                //check others
                if(c=='.') {
                    if(hasDot || hasE) {
                        return false;
                    } else {
                        hasDot = true;
                    }
                } else if (c == 'e') {
                    if(hasE) {
                        return false;
                    } else {
                        if(i == cs.length-1 || digitCount == 0) {
                            return false; //e cannot be the last digit
                        }
                        hasE = true;
                    }
                } else if (c == '-' || c == '+') {
                    if(cs[i-1] != 'e' || i == cs.length - 1) { //this is OK: 4e+1, but not this: 4e+
                        return false;
                    }
                } else {
                    if(!isDigit(c)) {
                        return false;
                    } else {
                        digitCount++;
                    }
                }
            }
        }
        
        if(digitCount == 0) {
            return false;
        }
        
        return true;
    }
    
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
