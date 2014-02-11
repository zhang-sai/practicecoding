
//here: http://leetcode.com/2010/05/here-is-another-google-phone-interview.html
public class StringReorder {

	char find_max(int freq[], boolean excep[]) {
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

	void create(char[] str, int d, char ans[]) {
		  int n = str.length;
		  int[] freq = new int[256];
		  for (int i = 0; i < n; i++) {
		      freq[str[i]]++;
		  }
		 
		  int[] used = new int[256];
		  for (int i = 0; i < n; i++) {
			  //for every char it keeps the exception list
		      boolean[] excep = new boolean[256];
		      boolean done = false;
		      while (!done) {
		         char j = find_max(freq, excep);
		         if (j == '\0') {
		             System.out.println("Error");
		             return;
		         }
		         excep[j] = true;
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
}
