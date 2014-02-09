
public class LargestSubsequenceProduct {

	//keep four variables
	//1. globalPos
	//2. globalNeg
	//3. currPos //largest
	//4. currNeg //smallest
	// if the current value < 1 discard it (like the 0)
	
	public static void main(String[] args) {
		//MAX 100
		double[] nums = new double[]{1, 2, 3, 4, 0, 100};
		System.out.println(computeMaxSubsequentProduct(nums));
		
		//MAX 120
		nums = new double[]{1, 2, 30, 4, 0, 100};
		System.out.println(computeMaxSubsequentProduct(nums));
		
		//MAX 100
		nums = new double[]{1, 2, 30, -4, 0, 100};
		System.out.println(computeMaxSubsequentProduct(nums));
		
		//MAX 0.4
		nums = new double[]{0.1, 0.2, 0.3, 0.4, 0, -100};
		System.out.println(computeMaxSubsequentProduct(nums));
		
		//MAX 0
		nums = new double[]{-0.1, 0};
		System.out.println(computeMaxSubsequentProduct(nums));
		
		//MAX 0
		nums = new double[]{-0.4, -9};
		System.out.println(computeMaxSubsequentProduct(nums));
		
		//MAX 0
		nums = new double[]{0.4, -0.1};
		System.out.println(computeMaxSubsequentProduct(nums));
		
		//is -0.1
		nums = new double[]{-0.1};
		System.out.println(computeMaxSubsequentProduct(nums));
	}
	
	/**
	 * The result is always positive here.
	 * */
	static double computeMaxSubsequentProduct(double[] nums) {
		
		//handle special case
		if(nums.length == 1) {
			return nums[0];
		}
		
		double globalMaxPos = Double.MIN_VALUE;
		
		double currPos = Double.NaN; //the initial state
		double currNeg = Double.NaN;
		
		for(double num : nums) {
			
//			System.out.println(num + "   " + currPos + "   " + currNeg + "  " + globalMaxPos);
			
			//two cases
			if(num > 0) {
				if(!Double.isNaN(currPos)) {
					currPos *= num;
				} else {
					currPos = num;
				}
				if(!Double.isNaN(currNeg)) {
					currNeg *= num;
				} else {
					//do nothing
					//still nan
				}
			} else if (num < 0) {
				if(!Double.isNaN(currNeg)) {
					currPos = currNeg*num;
					//keep a copy of the original currPos
					if(!Double.isNaN(currPos)) {
					    currNeg = currPos*num;
					} else {
						currNeg = Double.NaN;
					}
				} else {
					if(!Double.isNaN(currPos)) {
					    currNeg = currPos*num;
					} else {
						currNeg = num;
					}
					currPos = Double.NaN;
				}
			} else { //it is zero
				//set to the initial sate
				currPos = Double.NaN;
				currNeg = Double.NaN;
				if(globalMaxPos == Double.MIN_VALUE) {
					globalMaxPos = num;
				}
			}
			
			//check after each round
//			System.out.println("  ---> " + currPos + "  " + globalMaxPos);
			if(!Double.isNaN(currPos) && currPos > globalMaxPos) {
				globalMaxPos = currPos;
			}
			
			//discard it
			if(!Double.isNaN(currPos) && currPos < 1) {
				currPos = Double.NaN; //go to the initial state
			}
			
		}
		
		return globalMaxPos;
	}
	
}
