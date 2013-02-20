
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
		
		for(String str : strs) {
			if(str.isEmpty()) {
				return "";
			}
		}
        
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++) {
			String nextString = strs[i];
			
			int index = 0;
			for(index = 0; index < prefix.length() && index < nextString.length(); index++) {
				if(nextString.charAt(index) != prefix.charAt(index)) {
					break;
				}
			}
			
			if(index == 0) {
				return "";
			}
			prefix = prefix.substring(0, index);
			
		}
		
		return prefix;
    }
}
