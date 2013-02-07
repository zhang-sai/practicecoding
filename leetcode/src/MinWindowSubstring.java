import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Given a string S and a string T, find the minimum window in S which
 * will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * */
//XXX note that t may have some repetition
xxx
public class MinWindowSubstring {
	public String minWindow(String s, String t) {
		if(s == null || t == null) {
			return "";
		}
		if(s.isEmpty() || t.isEmpty()) {
			return "";
		}
        // Start typing your Java solution below
        // DO NOT write main() function
        Set<Character> charSet = new HashSet<Character>();
        for(char c : t.toCharArray()) {
        	charSet.add(c);
        }
        if(charSet.size() > s.length()) {
        	return "";
        }
        //find the starting and ending point
        Map<Character, Integer> coveredChar = new HashMap<Character, Integer>();
        int startingPoint = -1;
        for(int i = 0; i < s.length(); i++) {
        	if(charSet.contains(s.charAt(i))) {
        		startingPoint = i;
        		break;
        	}
        }
        if(startingPoint == -1) {
        	return "";
        }
        //get the ending point
        int endingPoint = -1;
        for(int i = startingPoint; i < s.length(); i++) {
        	if(charSet.contains(s.charAt(i))) {
        		coveredChar.put(s.charAt(i),
        				coveredChar.containsKey(s.charAt(i)) ? coveredChar.get(s.charAt(i)) + 1: 1 );
        		
        	}
        	if(coveredChar.keySet().equals(charSet)) {
        		endingPoint = i;
        		break;
        	}
        }
        if(endingPoint == -1) {
        	return "";
        }
        //now, we at least find some window
        //record the initial min window
        String minWindow = s.substring(startingPoint, endingPoint + 1);

//        System.out.println("init: " + minWindow + " starting: " + startingPoint + "ending: " + endingPoint);
        //now start to move
//        while(true) {
        	for(int i = startingPoint; i < endingPoint; i++) {
        		char c = s.charAt(i);
        		if(charSet.contains(c)) {
        			if(!coveredChar.containsKey(c)) {
        				throw new Error("Error");
        			}
        			if(coveredChar.get(c) > 1) {
        				//remove this from the coveredChar set
        				startingPoint = i;
        				coveredChar.put(c, coveredChar.get(c) - 1);
        				String window = s.substring(startingPoint, endingPoint + 1);
//        				System.out.println(window + " starting: " + startingPoint + "ending: " + endingPoint);
        				if(window.length() < minWindow.length()) {
							minWindow = window;
						}
        			} else {
        				//only one char
        				for(int j = endingPoint + 1; j < s.length(); j++) {
        					char jc = s.charAt(j);
        					if(jc == c) {
//        						System.out.println("find: " + jc + " at: " + j);
        						endingPoint = j;
        						startingPoint = i;
        						//XXX easy to miss, to move starting point to the next character
        						for(startingPoint = i + 1; i < endingPoint; startingPoint++) {
        							if(charSet.contains(s.charAt(startingPoint))) {
        								break;
        							}
        						}
        						
        						String window = s.substring(startingPoint, endingPoint + 1);
//        						System.out.println(window + " starting: " + startingPoint + "ending: " + endingPoint);
        						if(window.length() < minWindow.length()) {
        							minWindow = window;
        						}
        						break;
        					} else if(charSet.contains(jc)) {
        						    coveredChar.put(jc, coveredChar.get(jc) + 1);
        					}
        				}
        			}
        		}
        	}
//        }
        return minWindow;
    }
	
	public static void main(String[] args) {
		MinWindowSubstring min = new MinWindowSubstring();
//		System.out.println(min.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(min.minWindow("abcabdebac", "cda"));
	}
}
