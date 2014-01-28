package fb;

import java.util.HashMap;
import java.util.Map;

/**
 * "this is a sentence" => [t, h, i, s, i, s, a, s, e, n, t, e, n, c, e]
   "thiis iss a senntencee" => [i, s, n, e]
   "thiisss iss a senntttenceee" => [s, t, e]
   "thiisss iss a sennnntttenceee" => [n]
   
   The char with max successive count
   
   http://www.mitbbs.com/clubarticle_t/New_Mommy_and_New_Daddy/20299839.html
 * */
public class CountMaxNumberChars {
	
	public static void printMaxNumChars(String str) {
		//a map to keep the count
		Map<Integer, Integer> indexCount = new HashMap<Integer, Integer>();
		
		char[] cs = str.toCharArray();
		int startIndex = 0;
		int maxCount = Integer.MIN_VALUE;
		//iterate through the string
		while(startIndex < cs.length) {
			int c = cs[startIndex];
			int count = 1;
			int forwardIndex = startIndex + 1;
			while(forwardIndex < cs.length && cs[forwardIndex] == c) {
				count++;
				forwardIndex++;
			}
			if(count > maxCount) {
				maxCount = count;
			}
			indexCount.put(startIndex, count);
			startIndex = forwardIndex;
		}
		//start to print
		for(Integer key : indexCount.keySet()) {
			if(indexCount.get(key) == maxCount) {
				System.out.print(cs[key] + "  ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		printMaxNumChars("this is a sentence");
		printMaxNumChars("thiis iss a senntencee");
		printMaxNumChars("thiisss iss a senntttenceee");
		printMaxNumChars("thiisss iss a sennnntttenceee");
	}
	
}
