package fb;

// implement char *remove_badchars(char string[], char bad_chars[]) in place
// how to binary search chars
public class RemoveBadChars {


	public static void removeBadChars(char[] cs, char[] badchars) {
		boolean[] flags = new boolean[26];
		for(char c : badchars) {
			flags[c - 'a'] = true;
		}
		//iterate through the char list
		int index = 0;
		for(int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if(flags[c - 'a']) {
				//do nothing
			} else {
				cs[index++] = c;
			}
		}
		
		for(int i = 0; i < index; i++) {
			System.out.print(cs[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		removeBadChars(new char[]{'c', 'f', 'a', 'b', 'e', 'c', 'd', 'd', 'f', 'e'}, new char[]{'c','d', 'e'});
	}
	
}