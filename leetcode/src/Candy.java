
public class Candy {

	/**
	 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
	 * */
	public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(ratings.length == 0) {
            return 0;
        }
        if(ratings.length == 1) {
            return 1;
        }
        boolean[] shortest = new boolean[ratings.length];
        for(int i = 0; i < ratings.length; i++) {
            if(i == 0) {
                if(ratings[i] <= ratings[i+1]) {
                    shortest[i]=true;
                }
            } else if (i == ratings.length -1) {
                if(ratings[i] <= ratings[i-1]) {
                    shortest[i] = true;
                }
            } else {
                if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]) { /**should be <=, consider 5, 1, 1, 1, 10, 2, 1, 3*/
                    shortest[i] = true;
                }
            }
        }
        //the number of candies
        int[] candies = new int[ratings.length];
        for(int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }
        //starting from those shortest indices
        for(int i = 0; i < shortest.length; i++) {
            if(shortest[i]) {
                for(int j = i + 1; j < shortest.length; j++) {
                    if(ratings[j] < ratings[j-1]) {
                        break;
                    } else if(ratings[j] == ratings[j-1]) {
                        continue;
                    } else {
                        candies[j] = Math.max(candies[j-1] + 1, candies[j]);
                    }
                }
                for(int j = i - 1; j >= 0; j--) {
                    if(ratings[j] < ratings[j+1]) {
                        break;
                    } else if(ratings[j] == ratings[j+1]) {
                        continue;
                    } else {
                        candies[j] = Math.max(candies[j+1] + 1, candies[j]);
                    }
                }
            }
        }
        int sum = 0;
        for(int num : candies) {
            sum += num;
        }
        return sum;
    }
}
