
/**
 * Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * */
public class StrStr {
	public String strStr(String haystack, String needle) {
		if(needle.length() == 0) {
			return haystack;
		}
		if(needle.length() > haystack.length()) {
			return null;
		}
        // Start typing your Java solution below
        // DO NOT write main() function
		char[] n_chars = needle.toCharArray();
		char[] h_chars = haystack.toCharArray();
		
		for(int i = 0; i < h_chars.length; i++) {
			int current = i;
			boolean matched = true;
			for(int j = 0; j < n_chars.length; j++) {
				if(current + j >= h_chars.length) {
					matched = false;
					break;
				}
				if(h_chars[current + j] != n_chars[j]) {
					matched = false;
					break;
				}
			}
			if(matched) {
				return haystack.substring(current);
			}
		}
		
		return null;
        
    }
	
	//a better
	public String better_strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
 
        if (needle.length() == 0) {//you can always find an empty string
            return haystack;
        }
        if (haystack.length () < needle.length()) {
            return null;
        }
 
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return haystack.substring(i - j);
                }
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }
        return null;
    }
}
