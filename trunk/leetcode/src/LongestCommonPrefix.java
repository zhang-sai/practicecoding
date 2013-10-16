
public class LongestCommonPrefix {

	/**
	 * Write a function to find the longest common prefix string amongst an array of strings.
	 * */
	public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length == 0) {
            return "";
        }
        char[] firstChars = strs[0].toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < firstChars.length; i++) {
            char c = firstChars[i];
            boolean matched = true;
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i) { //check the length
                    matched = false;
                    break;
                }
                if(strs[j].charAt(i) != c) {
                    matched = false;
                    break;
                }
            }
            if(matched) {
                sb.append(c);
            } else {
                break;
            }
        }
        
        return sb.toString();
    }
}