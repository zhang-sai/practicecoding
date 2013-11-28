
/**
 * Each char in the string is 'A', 'B', or 'C'
 * any neighboring 3 characters cannot be 'A', 'B', 'C', such as BACCC is not valid
 * 
 * output all valid strings with length N
 * */

public class NValidString {

	public static void main(String[] args) {
		int length = 3;
		generateString(new char[length], new boolean[]{true, true, true}, 0, length);
	}
	
	static int count = 0;
	public static void generateString(char[] chars, boolean[] next, int curr, int length) {
		
		if(curr == length) {
			String s = new String(chars);
			System.out.println(count++ + ". " + s);
			return;
		}
		
		for(int i = 0; i < next.length; i++) {
			if(next[i]) {
				//set the current
				chars[curr] = (char)('A' + i);
				boolean[] nextPoss = null;
				if(curr == 0 || chars[curr] == chars[curr - 1]) {
					nextPoss = new boolean[]{true, true, true};
				} else {
					nextPoss = new boolean[]{false, false, false};
					nextPoss[chars[curr] - 'A'] = true;
					nextPoss[chars[curr - 1] - 'A'] = true;
				}
				generateString(chars, nextPoss, curr + 1, length);
				
				chars[curr] = '\u0000';
			}
		}
	}
	
}
