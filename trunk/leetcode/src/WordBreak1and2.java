import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class WordBreak1and2 {

	/**
	 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
	 * */
	public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s.length() == 0) {
            return true;
        }
        boolean[][] results = new boolean[s.length()][s.length()];
        
        for(int length = 1; length <= s.length(); length++) {
            for(int i = 0; i < s.length(); i++) {
                if(i + length > s.length()) {
                    break;
                }
                String sub = s.substring(i, i + length);
                if(dict.contains(sub)) {
                    results[i][i+length-1] = true;
                } else {
                    //check if existing any j that [i][j] [j][i+length-1] is true
                    int end = i + length - 1;
                    if(end != i) {
                        for(int j = i; j < end; j++) {
                            if(results[i][j] && results[j+1][end]) {
                                results[i][end] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return results[0][s.length() -1];
	}
	
	public static boolean isSegmented(String s, HashSet<String> dict) {  
		   int n = s.length();  
		   if (n < 1) return false;  
		   
		   // T[i] == true iff s[0..i) is segmentable  
		   boolean[] seg = new boolean[n];  
		   for (int i=0; i<n; ++i) {  
		     seg[i] = (seg[i] || dict.contains(s.substring(0, i+1)));
		     // if seg[i] is false, check the current prefix  
		     if (!seg[i])  continue;  
		   
		     // now seg[i] is true, update remaining elements  
		     for (int j=i+1; j<n; ++j) {  
		       seg[j] = (seg[j] || dict.contains(s.substring(i+1, j+1)));  
		     }  
		   
		     // fast return  
		     if (seg[n-1]) return true;  
		   }  
		   
		   return false;  
		 }  
	/**
	 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
	 * */
	
	//it keeps track the previously-valid indices
	public ArrayList<String> wordBreak_2(String s, Set<String> dict) {  
        int n = s.length();  
        ArrayList<ArrayList<Integer>> pres = new ArrayList<ArrayList<Integer>>(n);  
        // initialize  
        for (int i = 0; i < n; ++i) {
            pres.add(new ArrayList<Integer>());  
        }
        // DP. pres[i] stores position j where should insert space  
        // i is the ending index
        for (int i = 0; i < n; ++i) {  
            for (int j = 0; j <= i; ++j) {  
                String suffix = s.substring(j, i + 1);  
                if ((j == 0 || pres.get(j - 1).size() > 0) && dict.contains(suffix))  {
                    pres.get(i).add(j);  
                }
            }  
        }  
        return getPath(s, n, pres);  
}  
  
    public ArrayList<String> getPath(String s, int n, ArrayList<ArrayList<Integer>> pres) {  
        ArrayList<String> res = new ArrayList<String>();  
        for (int pre : pres.get(n - 1)) {  
            if (pre == 0) {  
                 res.add(s.substring(0, n));  
            } else {  
                ArrayList<String> preres = getPath(s, pre /**the previous one*/, pres);  
                String sub = s.substring(pre, n);  
                for (String ss : preres)   {
                    res.add(ss + " " + sub);  
                }
            }  
        }  
        return res;  
}  
    
}
