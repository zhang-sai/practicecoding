/**
 * http://leetcode.com/2011/01/double-square-problem-analysis.html
 * 
 * For each value of X, you should output the number of ways to write X as the
 * sum of two squares
 * */
public class DoubleSquare {

	// brute force way
	// search for different combinations
	// the complexity is O(N)
	int doubleSquare(int m) {
		int total = 0;
		int iUpper = (int) Math.sqrt((double) m / 2.0);
		for (int i = 0; i <= iUpper; i++) {
			int ii = i * i;
			for (int j = i;; j++) {
				int sum = ii + j * j;
				if (sum == m)
					total++;
				else if (sum > m)
					break;
			}
		}
		return total;
	}

	// a slightly smart way
	// check whether sqrt(x)^2 == x
	// O(sqrt(N))
	int doubleSquare_smart(int m) {
		int p = (int) Math.sqrt((double) m / 2.0);
		int total = 0;
		for (int i = 0; i <= p; i++) {
			double j = Math.sqrt((double) m - i * i);
			if (j - (int) j == 0.0) // might have precision issue,
				total++; // can be resolved using |j-(int)j| == delta
		}
		return total;
	}

}
