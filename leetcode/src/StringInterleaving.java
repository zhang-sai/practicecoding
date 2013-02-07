import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 * */

xx
/**
 * Not as easy as expected!!!
 * 
 * basic idea:
 * 
 * initialize 3 list:
 * 
 * is interleaving == remove each char in l2 from l3 in the order of its appearance in l2
 *  and check whether the remaining list is l3
 *  
 *  or
 *  
 * remove l1 first
 * 
 * */
public class StringInterleaving {
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null) {
			return false;
		}
		
		if(s1.length() + s2.length() != s3.length()) {
			return false;
		}
		
		//initialize
		List<Character> l3 = new LinkedList<Character>();
		for(char c : s3.toCharArray()) {
			l3.add(c);
		}
		List<Character> l1 = new LinkedList<Character>();
		for(char c : s1.toCharArray()) {
			l1.add(c);
		}
		List<Character> l2 = new LinkedList<Character>();
		for(char c : s2.toCharArray()) {
			l2.add(c);
		}
		

		System.out.println(l3);
		System.out.println(l1);
		int currPos = 0;
		Set<Integer> removedInteger = new HashSet<Integer>();
		for(Character c : l1) {
			if(l3.subList(currPos, l3.size() - 1).indexOf(c) >= currPos) {
				currPos = l3.subList(currPos, l3.size() - 1).indexOf(c) + 1;
				//l3.remove(currPos - 1);
				
			} else {
				break;
			}
		}
		System.out.println(l3);
		System.out.println(l2);
		if(l3.equals(l2)) {
			return true;
		}
		
		System.out.println("------");
		l3.clear();
		for(char c : s3.toCharArray()) {
			l3.add(c);
		}
		
		System.out.println(l3);
		System.out.println(l2);
		currPos = -1;
		for(Character c : l2) {
			if(l3.indexOf(c) > currPos) {
				currPos = l3.indexOf(c);
				l3.remove(c);
			} else {
				break;
			}
		}
		System.out.println(l3);
		System.out.println(l2);
		System.out.println(l1);
		if(l3.equals(l1)) {
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		StringInterleaving s = new StringInterleaving();
		System.out.println(s.isInterleave("ab", "bc", "bcab"));
		//ab", "bc", "bbac
	}
	
}

/**
 * public static void interleave(String ab, String cd, String str) {
 
     if(ab.length() == 0) {
 
          str += cd;
 
          System.out.println(str);
 
          return;
 
     }
 
     interleave(ab.substring(1), cd, str + ab.charAt(0));
 
     interleave(cd.substring(1), ab, str + cd.charAt(0));
 
}
 
 * 
 * */
 */