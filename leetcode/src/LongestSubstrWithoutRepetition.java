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
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[] cs = s.toCharArray();
        if(cs.length < 2) {
            return cs.length;
        }
        //check the existence
        boolean[] set = new boolean[26];
        
        int start = 0;
        set[cs[start] - 'a']=true;
        int end = start + 1;
        int max = 1;
        
        while(end < cs.length) {
            char c = cs[end];
            if(!set[c-'a']) {
                set[c-'a'] = true;
                end ++;
            } else {
                max = Math.max(max, end - start);
                //move the start
                while(cs[start] != c) {
                    set[cs[start] - 'a'] = false;
                    start++;
                }
                start++; //do not forget to move the start index one step further
                // set.remove(cs[start]);
                end++;
            }
        }
        
        max = Math.max(max, end - start);
        
        return max;
    }
	
	public static void main(String[] args) {
		LongestSubstrWithoutRepetition lwr = new LongestSubstrWithoutRepetition();
//		System.out.println(lwr.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lwr.lengthOfLongestSubstring("abcd"));
	}
}
