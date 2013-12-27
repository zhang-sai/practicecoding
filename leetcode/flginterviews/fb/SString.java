package fb;

/**
 * 
 * A string is called sstring if it consists of lowercase english
 * letters and no two of its consecutive characters are the same. 

You are given string s of length n. Calculate the number of sstrings
of length that are not lexicographically greater than s. 
Input format 
The only line of input contains the string s. It's length is not
greater than 100. 
All characters of input are lowercase english letters. 

Output format: 
Print the answer of test modulo 1009 to the only line of output. 

Sample input: 
bcd 

Sample output: 
653

http://www.careercup.com/question?id=23869663
 * */

public class SString {
	
	static int count = 0;

	public static void printAllSString(char[] sample, char[] str, int currIndex) {
		if(currIndex == sample.length) {
			System.out.println(new String(str));
			count++;
			return;
		}
		Character prev = currIndex == 0 ? null : sample[currIndex - 1];
		boolean smaller = false;
		for(int i = 0; i < currIndex; i++) {
			if(str[i] < sample[i]) {
				smaller = true;
				break;
			}
		}
		//select the current
		for(char c = 'a'; c <= 'z'; c++) {
			if(prev != null) {
				if(c == prev) {
					continue;
				}
			}
			if(!smaller) {
				if(c > sample[currIndex]) {
					continue;
				}
			}
			str[currIndex] = c;
			printAllSString(sample, str, currIndex + 1);
			str[currIndex] = '\0'; //reset
		}
	}
	
	public static void main(String[] args) {
		String s = "bcd";
		printAllSString(s.toCharArray(), new char[s.length()], 0);
		System.out.println("count: " + count);
	}
}
