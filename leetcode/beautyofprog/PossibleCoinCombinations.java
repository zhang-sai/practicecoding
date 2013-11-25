import util.Utils;


//all possible coins that can make a total amount
//avoid duplication
//e.g., total == 8
//so that:  [1, 1, 1, 5] [1, 5, 1, 1] are duplications
public class PossibleCoinCombinations {

	//do recursiion
	public static void main(String[] args) {
		Integer[] coins = new Integer[]{1, 5, 10, 25};
		Integer[] counts = new Integer[]{0, 0, 0, 0};
		printCoinsCombinations(25, coins, counts, 0);
	}
	
	//a variant of the combination sum problem
	public static void printCoinsCombinations(int amount, Integer[] coins, Integer[] counts, int index) {
		
//		System.out.println(amount +  " ==  " +
//				Utils.dumpArray(counts) + " ==  " + index);
		
		if(amount == 0) {
			for(int i = 0; i < coins.length; i++) {
				System.out.print(counts[i] + " * " + coins[i] + " cents + ");
			}
			System.out.println();
			return;
		}
		
		if(index == coins.length - 1) {
			if(amount % coins[index] == 0) {
				//we find a good combination
				counts[index] = counts[index] + amount/coins[index];
				printCoinsCombinations(0, coins, counts, index+1);
				return;
			}
			//do nothing
		} else {
			//two ways, either increase the current number of coins,
			//or use the next one
			if(amount >= coins[index]) {
				
				counts[index]++;
				printCoinsCombinations(amount - coins[index], coins, counts, index);
				counts[index]--; //restore
				
				printCoinsCombinations(amount, coins, counts, index + 1);
				
			} else {
				//no possible combination here
			}
		}
	}
}
