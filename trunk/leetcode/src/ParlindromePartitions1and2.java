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
        	if(i == 0) {
        		ArrayList<ArrayList<String>> rList = this.partition(s.substring(i + 1));
        		for(ArrayList<String> aList : rList) {
        			ArrayList<String> bList = new ArrayList<String>();
        			bList.add(s.substring(0, i+1));
        			bList.addAll(aList);
        			list.add(bList);
        		}
        	} else {
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

	int minCut(String s) {  
        int len = s.length();  
        //store the number of palindrome
        int[] D = new int[len+1];  
        //check if P[i][j] is a palindrome
        boolean[][] P = new boolean[len][len];
        //the worst case is cutting by each char  
        for(int i = 0; i <= len; i++) {
            D[i] = len-i;  
        }
        
        for(int i = 0; i < len; i++) { 
            for(int j = 0; j < len; j++)  {
                P[i][j] = false;  
            }
        }
        for(int i = len-1; i >= 0; i--){  
             for(int j = i; j < len; j++){  
                  if(s.charAt(i) == s.charAt(j) && (j-i<2 || P[i+1][j-1])){  
                       P[i][j] = true;  
                       D[i] = Math.min(D[i],D[j+1]+1);  
                  }  
             }  
        }  
        return D[0]-1;  
   } 
	
	public static void main(String[] args) {
		ParlindromePartitions1and2 p = new ParlindromePartitions1and2();
		System.out.println(p.minCut("cdd"));
	}
	
}
