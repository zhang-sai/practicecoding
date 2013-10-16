
/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * */
public class AddBinary {

	public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs1 = a.toCharArray();
        char[] cs2 = b.toCharArray();
        
        boolean hasCarrier = false;
        
        String result = "";
        
        int i1 = cs1.length - 1;
        int i2 = cs2.length -1;
        while(i1 >= 0 || i2>=0) {
            char c1 = i1 >= 0 ? cs1[i1] : '0';
            char c2 = i2 >= 0 ? cs2[i2] : '0';
            
            if(c1 == '0' && c2 == '0') {
                if(hasCarrier) {
                    result = "1" + result;
                    hasCarrier = false;
                } else {
                    result = "0" + result;
                }
            }
            
            if((c1 == '1' && c2 == '0') || (c1 == '0' && c2 == '1')) {
                if(hasCarrier) {
                    result = "0" + result;
                    hasCarrier = true;
                } else {
                    result = "1" + result;
                    hasCarrier = false;
                }
            }
            
            if(c1 == '1' && c2 == '1') {
                if(hasCarrier) {
                    result = "1" + result;
                    hasCarrier = true;
                } else {
                    result = "0" + result;
                    hasCarrier = true;
                }
            }
            
            i1--;
            i2--;
        }
        
        if(hasCarrier) {
            result = "1" + result;
        }
        
        return result;
    }
}
