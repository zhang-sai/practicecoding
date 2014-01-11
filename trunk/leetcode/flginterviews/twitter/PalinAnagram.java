package twitter;

/**
 * A string is a palindrome if it has exactly the same sequence of characters when read left-to-right as it has when read right-to-left. For example, the following strings are palindromes:
"kayak",
"codilitytilidoc",
"neveroddoreven".
A string A is an anagram of a string B if A can be obtained from B by rearranging the characters. For example, in each of the following pairs one string is an anagram of the other:
"mary" and "army",
"rocketboys" and "octobersky",
"codility" and "codility".
Write a function:
class Solution { public int solution(String S); }
that, given a non-empty string S consisting of N characters, returns 1 if S is an anagram of some palindrome and returns 0 otherwise.
Assume that:
N is an integer within the range [1..100,000];
string S consists only of lower-case letters (a-z).
For example, given S = "dooernedeevrvn", the function should return 1, because "dooernedeevrvn" is an anagram of the palindrome "neveroddoreven". Given S = "aabcba", the function should return 0.
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
Copyright 2009–2014 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * */
public class PalinAnagram {

	public int solution(String s) {
        // write your code in Java SE 6
        //the idea: count the frequency of each characters in s
        //          s is an anagram of some palindrome if and only
        //          if the odd-number character <= 1
        
        //keep track the frequence of each char
        int[] charFreq = new int[26]; 
        //keep track the frequency of each character
        for(char c : s.toCharArray()) {
        	charFreq[c - 'a']++;
        }
        //count the number of chars that appears with odd numbers
        int oddNum = 0;
        for(int freq : charFreq) {
        	if(freq % 2 == 1) {
        		oddNum++;
                //immediately return 0 if there is more than 1 such chars
        		if(oddNum > 1) {
        			return 0;
        		}
        	}
        }
        return 1;
    }
}
