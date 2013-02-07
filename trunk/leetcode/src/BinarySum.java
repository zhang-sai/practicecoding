
/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * */
public class BinarySum {
	public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a == null || b == null) {
        	return "";
        }
        if(a.length() == 0 || b.length() == 0) {
        	return a + b;
        }
        //assign the long one to l, short one to s
        String l, s;
        if(a.length() >= b.length()) {
        	l = a;
        	s = b;
        } else {
        	l = b;
        	s = a;
        }
        //padding with "0"

//        System.out.println(l.length());
//        System.out.println(s.length());
        if(l.length() > s.length()) { //must add the check
        	int delta = l.length() - s.length();
            for(int i = 0; i < delta; i++) { //XX it is <= rather than <
        	    s = "0" + s;
            }
        }
        
//        System.out.println(l);
//        System.out.println(s);
        
        //the result string
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = s.length() - 1; i >= 0; i--) {
        	char c1 = s.charAt(i);
        	char c2 = l.charAt(i);
        	
        	String r = null;
        	if(c1 == '0' && c2 == '0') {
        		r = flag ? "1" : "0";
        		flag = false;
        	} else if(c1 == '0' && c2 == '1') {
        		r = flag ? "0" : "1"; //flag does not change
        	} else if (c1 == '1' && c2 == '0') {
        		r = flag ? "0" : "1"; //flag does not change
        	} else if (c1 == '1' && c2 == '1') {
        		r = flag ? "1" : "0";
        		flag = true;
        	} else {
        		throw new Error("illegal charecters");
        	}
        	sb.append(r);
        }
        //XXX easy to forget
        if(flag) {
        	sb.append("1");
        }
        sb = sb.reverse();
        //reverse sb
        String result = sb.toString();
        
        return result;
    }
	
	public static void main(String[] args) {
		BinarySum bs = new BinarySum();
//		System.out.println(bs.addBinary("111", "1"));
//		100", "110010
		System.out.println(bs.addBinary("100", "110010"));
	}
}
