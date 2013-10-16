
/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * */

public class CountAndSay {
	public String countAndSay(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int round = 1;
        String value = "1";
        while(round++ < n) {
        	StringBuilder sb = new StringBuilder();
        	char[] cs = value.toCharArray();
        	char currChar = cs[0];
        	int currCount = 1;
        	for(int i = 1; i < cs.length; i++) {
        			if(currChar != cs[i]) {
        				sb.append(currCount);
//        				System.out.println("now sb: " + sb.toString());
        				sb.append(String.valueOf(currChar));
//        				System.out.println("now sb: " + sb.toString());
        				currChar = cs[i];
        				currCount = 1;
        			} else {
        				currCount++;
        			}
        	}
        	//XXX donot forget this step
        	sb.append(currCount);
			sb.append(String.valueOf(currChar));
        	value = sb.toString();
        }
        
        return value;
    }
	
	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		for(int i = 0; i < 10; i++) {
			System.out.println(cas.countAndSay(i));
		}
	}
}
