/**
 * see here:
 * http://leetcode.com/2010/10/amazon-bar-raiser-interview-question.html
 * 
 * Given the sequence S1 = {a,b,c,d,…,x,y,z,aa,ab,ac…. } and given that this
 * sequence corresponds (term for term) to the sequence S2 = {0,1,2,3,….}. Write
 * code to convert an element of S2 to the corresponding element of S1
 * 
 * 
 * 
 * */
public class ExcelRowNumber {

	/**
	 * basic idea: (1) use a 26-base digit to represent abc (2) convert a
	 * 10-base digit to 26-based digit (3) add the number before the current
	 * digit
	 * 
	 * */

	/**
	 * formula: (1) n = 26 + 26^2 + ... + 26^k-1 + a^0 + a^1*26 + a^2*26^2 + ...
	 * + a^k-1*26^k-1 = a0 + (a1 + 1) 26 + (a^2 + 1) 26^2 + ... + (a^k-1 + 1)
	 * 26^k-1
	 * 
	 * */

	static String numToStr(int n) {
		String str = (char)('a' + n%26) + "";
		n = n / 26;
		while (n != 0) {
			str = (char) ('a' + (n - 1) % 26) + str;
			n = (n - 1) / 26;
		}
		return str;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) {
		    System.out.println(numToStr(i));
		}
	}

}
