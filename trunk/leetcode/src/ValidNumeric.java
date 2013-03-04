
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
		s = s.trim();
        if(s.isEmpty()) {
        	return false;
        }
        //the single digit
        if(s.length() == 1) {
        	return s.charAt(0) >= '0' && s.charAt(0) <= '9';
        }
        if(s.startsWith("+") || s.startsWith("-")) {
        	if(s.length() == 1) {
        		return false;
        	}
        	s = s.substring(1);
        }
        //remove heading 0
        if(this.allDigit('0', '9', s)) {
        int index = -1;
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) != '0') {
        		break;
        	} else {
        		index = i;
        	}
        }
        if(index != -1) {
        	if(index == s.length() - 1) {
        		return true;
        	}
        	s = s.substring(index + 1);
        }
        }
        
        return this.isNumberInternal(s);
	}
	
	public boolean isNumberInternal(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //first check the first character
        char first = s.charAt(0);
        if(!(first >= '1' && first <= '9')) {
        	if(first == '0') {
//        		if(s.length() < 3) {
//        			return false;
//        		} else {
        			if(s.charAt(1) != '.') {
        				return false;
        			} else {
        				if(s.length() > 2 && !this.allDigit('0', '9', s.substring(3))) {
        					return false;
        				}
        			}
//        		}
        	} else { //start with other charcter
        		if(s.startsWith(".") && s.length() > 1 && this.allDigit('0', '9', s.substring(1))) {
        			//OK
        		} else {
        		    return false;
        		}
        	}
        }
        
        //check the e case
        int eIndex = s.indexOf("e");
        if(eIndex != -1) {
        	if(eIndex == s.length() - 1) { //the last is e
        		return false;
        	}
        	String before = s.substring(0, eIndex);
        	String after = s.substring(eIndex + 1);
        	//the before, must be well-formed
        	if(!this.checkDot(before)) {
        		return false;
        	}
        	
        	//the after must be all digit
//        	if(after.startsWith("0") && after.length() > 1) {
//        		return false;
//        	}
        	if(after.startsWith("+") || after.startsWith("-")) {
        		if(after.length() == 1) {
        			return false;
        		} else {
        			after = after.substring(1);
        		}
        	}
        	if(!this.allDigit('0', '9', after)) {
        		return false;
        	}
        } else {
        	//the dot case
        	if(!this.checkDot(s)) {
        		return false;
        	}
        }
        
        return true;
    }
	
	private boolean checkDot(String before) {
		int dotIndex = before.indexOf(".");
    	if(dotIndex == -1) {
    		if(before.startsWith("0")) {
    			if(before.length() != 1) { //XXX check the length
    			    return false;
    			}
    		} else if(!this.allDigit('0', '9', before)) {
    			return false;
    		}
    	} else {
    		//has some dot
//    		if(dotIndex == before.length() - 1 || dotIndex == 0) {
//    			return false;
//    		} else 
    		{
    			String beforeDot = dotIndex == 0 ? "9" /*valid*/ : before.substring(0, dotIndex);
    			String afterDot = dotIndex == before.length() - 1 ? "9": before.substring(dotIndex + 1);
    			//check the before
    			if(beforeDot.startsWith("0") && beforeDot.length() != 1) {
    				return false;
    			} else {
    				if(!this.allDigit('0', '9', beforeDot)) {
    					return false;
    				}
    			}
    			
    			//check the after
    			if(!this.allDigit('0', '9', afterDot)) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
	}
	
	private boolean allDigit(char low, char high, String s) {
		for(char  c : s.toCharArray()) {
			if(c >= low && c <= high) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		ValidNumeric vn = new ValidNumeric();
		System.out.println(vn.isNumber("0e3"));
	}
}
