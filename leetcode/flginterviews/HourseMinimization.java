/**
 * minimize the cost of painting K houses, each house has different
costs to paint in different colors, 
        	2 houses (next to each other) cannot be painted in the same 

 * */
//x
//a good explanation:
//http://stackoverflow.com/questions/15630743/is-house-coloring-with-three-colors-np
public class HourseMinimization {

	//costs is a k-dimension array
	//each dimension represents the cost of the color
	public static int getCost(int[][] costs) {
		int hnum = costs.length; //number of houses
		int cnum = costs[0].length;
		
		//use a big array to keep track of 
		//[cnum][hnume]
		int[][] minCosts = new int[cnum][hnum];
		int[][] prevcolors = new int[cnum][hnum]; //keep track of the color
		for(int house = 0;  house < hnum; house++) {
			for(int color = 0; color < cnum; color++) {
				if(house == 0) {
					minCosts[color][house] = costs[house][color];
//					System.out.println("color: " + color + ",  house: " + house + ", cost: " + minCosts[color][house]);
//					colors[color]
					prevcolors[color][house] = -1;
				} else {
					int minCost = Integer.MAX_VALUE;
					for(int i = 0; i < cnum; i++) {
						if(i == color) {
							continue;
						}
//						System.out.println(" min cost: " + minCosts[i][house  - 1]);
						int currCost = costs[house][color] + minCosts[i][house  - 1];
						if(currCost < minCost) {
							minCost = currCost;
							
							prevcolors[color][house] = i;
						}
						
					}
//					System.out.println("color: " + color + ",  house: " + house + ", cost: " + minCost);
					minCosts[color][house] = minCost;
				}
			}
		}
		
		int globalMin = Integer.MAX_VALUE;
		
		int cindex = -1;
		for(int i = 0; i < cnum; i++) {
			if(minCosts[i][hnum - 1] < globalMin) {
				globalMin = minCosts[i][hnum - 1];
				cindex = i;
			}
		}
		
		
		int hNum = hnum - 1;
		while(cindex != -1) {
			System.out.println("The color of: " + hNum + " is: " + cindex);
			cindex = prevcolors[cindex][hNum];
//			cindex = prevcolors[][];
			hNum --;
		}
		
		return globalMin;
	}
	
	public static void main(String[] args) {
		int[][] costs = new int[][] {
				new int[]{1, 2, 3, 5},
				new int[]{3, 4, 5, 1},
				new int[]{2, 3, 4, 10},
				new int[]{6, 3, 7, 2},
				new int[]{8, 4, 2, 5}
		};
		System.out.println("The total cost: " + getCost(costs));
	}
	
}
