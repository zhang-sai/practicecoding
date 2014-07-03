
//here: http://leetcode.com/2010/05/here-is-another-google-phone-interview.html
/**
 * Given a string of lowercase characters, reorder them such that the same characters are at least distance d from each other.

Input: { a, b, b }, distance = 2
Output: { b, a, b }
 * 
 * */
public class StringReorder {

	/**
	 * Create a permutation
	 * */
	public void create(char[] str, int d, char ans[]) {
		  int n = str.length;
		  //the frequency of each character
		  int[] freq = new int[256];
		  for (int i = 0; i < n; i++) {
		      freq[str[i]]++;
		  }
		  //is the char has been used
		  int[] used = new int[256];
		  for (int i = 0; i < n; i++) {
			  //for every char it keeps the exception list
		      boolean[] excep = new boolean[256];
		      boolean done = false;
		      while (!done) {
		    	  //find the most frequent char here
		         char j = find_max(freq, excep);
		         //cannot find a valid one, e.g., str="abc" & d = 5
		         if (j == '\0') {
		             System.out.println("Error");
		             return;
		         }
		         //cannot use this char
		         excep[j] = true;
		         //only when j is usable now
		         if (used[j] <= 0) {
		              ans[i] = j;
		              freq[j]--;
		              used[j] = d;
		              done = true;
		        } 
		     }
		     //reduce each used
		     for (int index = 0; index < 256; index++) {
		    	 if(used[index] > 0) {
		            used[index]--;
		    	 }
		     }	  
		}
	}
	
	/**
	 * find the most frequent char, in which excep is false (i.e., can be used)
	 * */
	private char find_max(int freq[], boolean excep[]) {
		char max_i = '\0';
		int max = -1;
		for (char c = 'a'; c <= 'z'; c++) {
			if (!excep[c] && freq[c] > 0 && freq[c] > max) {
				max = freq[c];
				max_i = c;
			}
		}
		return max_i;
	}

}
