/**
 * Given a number represented as an array of digits, plus one to the number.
 * */
public class PlusOne {

	public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(digits == null || digits.length == 0) {
			return digits;
		}
        int carrier = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
        	int v = digits[i];
        	if(i == digits.length - 1) {
        		v = digits[i] + 1;
        	} else {
        		v = digits[i] + carrier;
        	}
        	digits[i] = v % 10;
            carrier = v/10;
        	//a short cut
        	if(carrier == 0) {
        		break;
        	}
        }
        
        if(carrier > 0) {
        	int[] newDigits = new int[digits.length + 1];
        	for(int i = 1; i < digits.length + 1; i++) {
        		newDigits[i] = digits[i-1];
        	}
        	newDigits[0] = carrier;
        	return newDigits;
        } else {
        	return digits;
        }
    }
}
