
/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 * */
//discussion goes to: http://discuss.leetcode.com/questions/281/distinct-subsequences
public class DistinctSubSeqs {
	
	public int numDistinct(String s, String t) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null && t == null) {
            return 1;
        }
        if(t.length() == 0) {
            return s.length();
        }
        if(s.length() < t.length()) {
            return 0;
        }
        if(s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }
        
        //credit goes to:
        //http://tech-lightnight.blogspot.com/2012/11/distinct-subsequences.html
        //use dynamic programming to solve this problem
        int[][] numbers = new int[s.length() + 1][t.length() + 1];
        //leave an extra
        
        //compute the initial cases in dynamic programming
        //compare the last character of t with all s
        int lastTChar = t.charAt(t.length() - 1);
        for(int i = 0; i < s.length(); i++) {
            if(lastTChar == s.charAt(i)) {
                numbers[i][t.length() - 1] = 1;
            }
        }
        
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = t.length() -1; j >=0; j--) {
                if(s.charAt(i) == t.charAt(j)) {
                    //two possiblities
                    numbers[i][j] += numbers[i+1][j];
                    numbers[i][j] += numbers[i+1][j+1];
                } else {
                    numbers[i][j] += numbers[i+1][j];
                }
            }
        }
        
        return numbers[0][0];
    }
	
	public int numDistinct_old_but_work(String str, String target) {
		if(target.length() > str.length()) {
			return 0;
		}
		if(target.isEmpty()) {
			return str.length();
		}
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] nums = new int[target.length()][str.length()];
        
        //compute the first row/column
        //first column
        for(int i = 0; i < target.length(); i++) {
        	if(i == 0 && str.charAt(0) == target.charAt(0)) {
        		nums[i][0] = 1;
        	} else {
        	    nums[i][0] = 0;
        	}
        }
        //first row
        for(int i = 0; i < str.length(); i++) {
        	if(i == 0) {
        		nums[0][i] = str.charAt(0) == target.charAt(0) ? 1 : 0;
        	} else {
        		if(str.charAt(i) == target.charAt(0)) {
        	        nums[0][i] = 1 + nums[0][i-1];
        		} else {
        			nums[0][i] = nums[0][i-1];
        		}
        	}
        }
        
        for(int i = 1; i < target.length(); i++) {
        	for(int j = 1; j < str.length(); j++) {
        		if(target.charAt(i) == str.charAt(j)) {
        			nums[i][j] = nums[i-1][j-1] + nums[i][j-1];
        		} else {
        			nums[i][j] = nums[i][j-1];
        		}
        	}
        }
        
//        for(int i = 0; i < target.length(); i++) {
//        	for(int j = 0; j < str.length();j++) {
//        		System.out.print(nums[i][j] + "  ");
//        	}
//        	System.out.println();
//        }
        
        return nums[target.length() - 1][str.length()-1];
    }
	
	public static void main(String[] args) {
		DistinctSubSeqs ds = new DistinctSubSeqs();
		//System.out.println(ds.numDistinct("ccc", "c"));
		System.out.println(ds.numDistinct("ddd", "dd"));
	}
}
