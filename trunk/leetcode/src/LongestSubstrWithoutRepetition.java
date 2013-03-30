/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * */
// refer here:
// http://leetcode.com/2011/05/longest-substring-without-repeating-characters.html
public class LongestSubstrWithoutRepetition {
	public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s.length() < 2) {
			return s.length();
		}
		//use two indices
		int i = 0;
		int j = i + 1;
		int maxlen = -1;
		boolean[] exists = new boolean[256];
		exists[s.charAt(i)] = true;
		while(j < s.length()) {
//			System.out.println("j: " + j);
			if(!exists[s.charAt(j)]) {
				exists[s.charAt(j)] = true;
				j++;
			} else {
				maxlen = Math.max(maxlen, j - i);
				//increase i to j
				while(s.charAt(i) != s.charAt(j)) {
//					System.out.println("i: " + i+ ", j: " + j);
					exists[s.charAt(i)] = false; //clear it
					i++;
				}
//				System.out.println("Found: i: " + i+ ", j: " + j);
				i++;
				j++; //XXX must increase j here
			}
		}
		maxlen = Math.max(maxlen, j - i);
		return maxlen;
    }
	
	public static void main(String[] args) {
		LongestSubstrWithoutRepetition lwr = new LongestSubstrWithoutRepetition();
//		System.out.println(lwr.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lwr.lengthOfLongestSubstring("abcd"));
	}
}
