
/**
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * */


public class StringToInteger {
	//1. overflow
	//+2, -2
	//trailing space
	//illegal case: ++1, ccd
	//illegal character between characters  +4  9 = +4
	//    or  134abc = 134
	//illegal space  +  4 is illegal
	public int atoi(String str) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // Start typing your Java solution below
        // DO NOT write main() function
		
		/**
		 * Many cases to consider:
		 * 1. str with 0-length ==> 0
		 * 2. start with + and -
		 * 3. it can only contains +, -, num.
		 *    It is illegal if there are other chars
		 *    
		 *    +4  5 ==> +4
		 *    134 abc ==> 134
		 *    
		 * 4. also consider overflow / underflow
		 *    for any overflow just return Integer.Max_Number
		 *    for any underflow just return INteger.Min_Number
		 * 
		 * */
        str = str.trim();
        if(str.length() == 0) {
        	return 0;
        }
        int first_illegal_char = -1;
        for(int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	if(i == 0) {
        		if(c == '+' || c == '-') {
        			continue;
        		}
        	}
        	if(c >= '0' && c <= '9') {
        		continue;
        	} else {
        		first_illegal_char = i;
        		break;
        	}
        }
        if(first_illegal_char != -1) {
            str = str.substring(0, first_illegal_char);
        }
        
        if(str.length() == 0) { //XXX check this after every trunk
        	return 0;
        }
        
        //check whether str is legal or not
        boolean isNegative = str.charAt(0) == '-' ? true : false;
        if(isNegative) {
        	str = str.substring(1);
        } else {
        	if(str.charAt(0) == '+') {
        		str = str.substring(1);
        	}
        }
        
        //only + or - left
        if(str.length() == 0 ) {
        	return 0;
        }
        
        int value = 0;
        for(int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	int v = c - '0';
        	if(v > 9 || v < 0) {
        		return 0;
        	}
        	
        	//XXX check overflow or underflow
        	if(value >= 214748365) {
        		if(!isNegative) {
        			return Integer.MAX_VALUE;
        		} else {
        			return Integer.MIN_VALUE;
        		}
        	}
        	
        	value = value*10;
        	
        	//XXX check overflow or underflow
        	if(Integer.MAX_VALUE - value < v) {
        		if(!isNegative) {
        			return Integer.MAX_VALUE;
        		}
        	}
        	if(Integer.MIN_VALUE + value + v > 0) {
        		if(!isNegative) {
        			return Integer.MAX_VALUE;
        		} else {
        			return Integer.MIN_VALUE;
        		}
        	}
        	
        	value = value + v;
        }
        
        if(isNegative) {
        	return value*(-1);
        } else {
        	return value;
        }
    
    }
	
	public static void main(String[] args) {
		System.out.println(new StringToInteger().atoi("abc"));
	}
}
