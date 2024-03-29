
/**
 * Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * */
public class StrStr {
	public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(needle.length() > haystack.length()) {
            return null;
        }
        int index = -1;
        
        char[] needleChars = needle.toCharArray();
        char[] haystackChars = haystack.toCharArray();
        
        for(int i = 0; i < haystackChars.length - needleChars.length + 1; i++) {
            boolean matched = true;
            for(int j = 0; j < needleChars.length; j++) {
                if(needleChars[j] != haystackChars[i + j]) {
                    matched = false;
                    break;
                }
            }
            if(matched) {
                index = i;
                break;
            }
        }
        
        if(index == -1) {
            return null;
        } else {
            return haystack.substring(index);
        }
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
