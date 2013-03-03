import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ParlindromePartitions1and2 {

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
	 * */
	public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        if(s.isEmpty()) {
        	return list;
        }
        if(s.length() == 1) {
        	ArrayList<String> slist = new ArrayList<String>();
        	slist.add(s);
        	list.add(slist);
        	return list;
        }
        //then search for partitions
        List<Character> stack = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++) {
//        	System.out.println("i: " + i);
        	if(i == 0) {
        		stack.add(s.charAt(i));
        		ArrayList<ArrayList<String>> rList = this.partition(s.substring(i + 1));
        		for(ArrayList<String> aList : rList) {
        			ArrayList<String> bList = new ArrayList<String>();
        			bList.add(s.substring(0, i+1));
        			bList.addAll(aList);
        			list.add(bList);
        		}
        	} else {
        		int size = stack.size();
        		if(!stack.isEmpty() && stack.get(0) == s.charAt(i)) {
        			stack.remove(0);
        		} else {
        			stack.add(s.charAt(i));
        		}
//        		System.out.println(stack);
        		if(this.isP(s.substring(0, i+1))) {
        			if(i < s.length() - 1) {
        			    ArrayList<ArrayList<String>> rList = this.partition(s.substring(i + 1));
            		    for(ArrayList<String> aList : rList) {
            			    ArrayList<String> bList = new ArrayList<String>();
            			    bList.add(s.substring(0, i+1));
            			    bList.addAll(aList);
            			    list.add(bList);
            		    }
        			} else {
        				ArrayList<String> bList = new ArrayList<String>();
        				bList.add(s);
        				list.add(bList);
        			}
        		}
        	}
        }
        return list;
    }
	
	public boolean isP(String s) {
		if(s.length() == 1) {
			return true;
		}
		int size = s.length();
		if(s.charAt(0) != s.charAt(size - 1)) {
			return false;
		} else {
			if(size == 2) {
				return true;
			} else {
				return this.isP(s.substring(1, size-1));
			}
		}
	}
	

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
	 * */
	//https://sites.google.com/site/mytechnicalcollection/algorithms/dynamic-programming/palindrome-partitioning
//	XXX use dynamic programming
	public int minCut(String s) {
        int length = s.length();
        if(length == 0 || length == 1) {
        	return 0;
        }
		//create two array
        boolean[][] isP = new boolean[length][length];
        int[][] mCuts = new int[length][length];
        
        for(int i = 0; i < length; i++) {
        	isP[i][i] = true;
        	mCuts[i][i] = 0;
        }
        
        //XXX iterate by string length, this is the key point
        for(int sl = 2; sl <= length; sl++) {
        	for(int startPoint = 0; startPoint < length - sl + 1; startPoint++) {
        		int i = startPoint;
        		int j = startPoint + sl - 1;
        		if(sl == 2) {
        			isP[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
        			mCuts[i][j] = isP[i][j] ? 0 : 1;
        		} else {
        			System.out.println(i + ",  " + j);
        			isP[i][j] = (s.charAt(i) == s.charAt(j) && isP[i+1][j-1]) ? true : false;
        			System.out.println(isP[i][j]);
        			if(isP[i][j]) {
        				
        				mCuts[i][j] = 0;
        			} else {
        				//check the internal
        				int min = Integer.MAX_VALUE;
        				for(int k = i; k < j; k++) {
        					System.out.println("k: " + k);
        					if(mCuts[i][k] + mCuts[k+1][j] < min) {
        						min = mCuts[i][k] + mCuts[k+1][j] + 1; //XXX do not forget + 1
        						System.out.println("min : " + min);
        					}
        				}
        				mCuts[i][j] = min;
        			}
        		}
        	}
        }
        
        return mCuts[0][length-1];
    }
	
	public static void main(String[] args) {
		ParlindromePartitions1and2 p = new ParlindromePartitions1and2();
		System.out.println(p.minCut("cdd"));
	}
	
}
