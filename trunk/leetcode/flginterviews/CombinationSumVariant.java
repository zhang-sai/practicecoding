/**
 * Given a number N, write a program that returns all possible combinations of
 * numbers that add up to N, as lists. (Exclude the N+0=N) 

For example, if N=4 return {{1,1,1,1},{1,1,2},{2,2},{1,3}}
http://www.careercup.com/question?id=6321181669982208
 * */

public class CombinationSumVariant {

	public static void printAllCombinations(int n) {
		if(n < 2) {
			throw new Error();
		}
		int[] values = new int[n - 1];
		for(int i = 0; i < values.length; i++) {
			values[i] = i + 1;
		}
		int[] counts = new int[n-1];
		findCombinations(values, counts, 0, n);
	}
	
	public static void findCombinations(int[] vals, int[] counts, int currIndex, int target) {
//		System.out.println("index: " + currIndex + ",  value: " + vals[currIndex] + ", target: "+ target);
		
		//we find it
		if(target == 0) {
			for(int i = 0; i < vals.length; i++) {
				if(counts[i] != 0) {
					for(int j = 0; j < counts[i]; j++) {
						System.out.print(" " + vals[i]);
					}
				}
			}
			System.out.println();
			return;
		}
		
		//XXX exit condition
		if(currIndex >= vals.length || vals[currIndex] > target) {
//			System.out.println("  return.");
			return; //should not proceed more
		}
		
		//recursively find it
		int maxNum = target / vals[currIndex];
		for(int i = 0; i <= maxNum; i++) {
			counts[currIndex] = counts[currIndex] + i;
			findCombinations(vals, counts, currIndex + 1, target - vals[currIndex]*i);
			counts[currIndex] = counts[currIndex] - i;
		}
	}
	
	public static void main(String[] args) {
		printAllCombinations(4);
	}
}
