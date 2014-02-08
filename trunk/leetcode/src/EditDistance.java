/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 * */

public class EditDistance {
	public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		if(word1.isEmpty() || word2.isEmpty()) {
			return Math.max(word1.length(), word2.length());
		}
		
		//init a grid
		int[][] distances = new int[word1.length()][word2.length()];
		distances[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
		//compute the first row
		//if the same, use i, otherwise, +1 of previous distance
		for(int i = 1; i < word1.length(); i++) {
			distances[i][0] = word1.charAt(i) == word2.charAt(0) ?
					i : distances[i-1][0] + 1;
		}
		for(int j = 1; j < word2.length(); j++) {
			distances[0][j] = word1.charAt(0) == word2.charAt(j) ?
					j : distances[0][j-1] + 1;
		}
		
		for(int i = 1; i < word1.length(); i++) {
			for(int j = 1; j < word2.length(); j++) {
				char ci = word1.charAt(i);
				char cj = word2.charAt(j);
				
				//compute the value in distances[i][j]
				if(ci == cj) {
					//three possibilities
					int deleteCost = distances[i-1][j] + 1;
					int addCost = distances[i][j - 1] + 1 ;
					int replaceCost =  distances[i-1][j-1];  //the diff case when ci == cj
					distances[i][j] = Math.min(deleteCost, Math.min(addCost, replaceCost));
				} else {
					//three possibilities
					int deleteCost = distances[i-1][j] + 1;
					int addCost = distances[i][j - 1] + 1 ;
					int replaceCost = distances[i-1][j-1] + 1;
					distances[i][j] = Math.min(deleteCost, Math.min(addCost, replaceCost));
				}
			}
		}
		
		return distances[word1.length() - 1][word2.length() - 1];
    }
}
