import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word 
 * in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 * */
//see http://interview.googlecode.com/svn/trunk/leetcode/substringWithConcatenationAllWords.java
public class SubstringWithAllWords {
	
	//it is all word connecting without space
	public ArrayList<Integer> findSubstring(String s, String[] ls) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
        ArrayList<Integer> indices = new ArrayList<Integer>();
        if(ls.length == 0 || s.length() < ls.length*ls[0].length()) {
        	return indices;
        }
        
        //use a map to keep all strings
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        for(String l : ls) {
        	if(wordCount.containsKey(l)) {
        		wordCount.put(l, wordCount.get(l) + 1);
        	} else {
        		wordCount.put(l, 1);
        	}
        }
        
        int wordLength = ls[0].length();
        //now start searching
        
        Map<String, Integer> foundCount = new HashMap<String, Integer>();
        
        for(int start = 0; start < s.length() - ls.length * wordLength + 1/**XXX donot forget +1*/; start++) {
//        	System.out.println("start: " + start );
        	//check the occurance of each word
        	boolean matched = true;
        	foundCount.clear(); //XXX donot forget clear it
        	for(int i = 0; i < ls.length; i++) {
        		String w = s.substring(start + i*wordLength,  start + (i+1)*wordLength);
        		if(!wordCount.containsKey(w)) {
        			matched = false;
        			break;
        		} else {
        			if(foundCount.containsKey(w)) {
        				foundCount.put(w, foundCount.get(w) + 1);
        				if(foundCount.get(w) > wordCount.get(w)) {
        					matched = false;
        					break;
        				}
        			} else {
        				foundCount.put(w, 1);
        			}
        		}
        	}
        	
//        	System.out.println("  --- matched: " + matched);
        	if(matched) {
        		indices.add(start);
        	}
        }
        
        return indices;
    }
	
	public static void main(String[] args) {
		SubstringWithAllWords swaw = new SubstringWithAllWords();
		System.out.println(swaw.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
	}
}
