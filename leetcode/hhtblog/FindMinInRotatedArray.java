import java.util.Random;


public class FindMinInRotatedArray {

	
	//1, 2, 3, 4, 5, 6
	//5, 6, 1, 2, 3, 4
	//3, 4, 5, 6, 1, 2
	public int getMin(int[] nums) {
		if(nums.length == 0) {
			throw new Error();
		}
		int startIndex = 0;
		int endIndex = nums.length - 1;
		int minIndex = startIndex;
		//did not find the value
		while(nums[startIndex] >= nums[endIndex]) {  //XXX the array is still rotated
			if(endIndex - startIndex == 1) { //XXX need to break out
				minIndex = endIndex;
				break;
			}
			minIndex = (startIndex + endIndex)/2;
			if(nums[minIndex] > nums[endIndex]) {
				startIndex = minIndex; //XXX cannot -1 or + 1
			} else {
				endIndex = minIndex;
			}
//			minIndex = startIndex;
		}
		return nums[minIndex];
	}
	
	public int getMax(int[] nums) {
		if(nums.length == 0) {
			throw new Error();
		}
		//1, 2, 3, 4, 5, 6
		//3, 4, 5, 6. 1, 2,
		//5, 6. 1, 2, 3, 4
		int startIndex = 0;
		int endIndex = nums.length - 1;
		int maxIndex = endIndex;
		while(nums[startIndex] >= nums[endIndex]) {
			if(endIndex - startIndex == 1) {
				maxIndex = startIndex;
				break;
			}
			maxIndex = (startIndex + endIndex)/2;
			if(nums[maxIndex] > nums[endIndex]) {
				startIndex = maxIndex;
			} else {
				endIndex = maxIndex;
			}
//			System.out.println("start: " + startIndex + ", endIndex: " + endIndex + ", maxIndex: " + maxIndex);
		}
			
		return nums[maxIndex];
	}
	
	
	public static void main(String[] args) {
		int round = 100;
		Random r = new Random();
		while(round-- > 0) {
//			System.out.println(round);
			int[] nums = new int[r.nextInt(100) + 1];
			
			
			int min = r.nextInt(10);
			int max = -1;
			int prev = min;
			int pos = r.nextInt(nums.length);
			int currPos = pos;
			for(int i = 0; i < nums.length; i++) {
				if(currPos == pos) {
					nums[currPos] = min;
				} else {
					nums[currPos] = prev + r.nextInt(20);
					
				}
				prev = nums[currPos];
				currPos = currPos == nums.length - 1 ? 0 : currPos+ 1;
				if(i == nums.length - 1) {
					max = prev;
				}
			}
			
			FindMinInRotatedArray fm = new FindMinInRotatedArray();
			int minvalue = fm.getMin(nums);
			if(minvalue != min) {
				System.out.println("wrong: " + minvalue + ",  min is: " + min);
				for (int n : nums) {
					System.out.print(n + "  ");
				}
				System.out.println();
			}
			int maxvalue = fm.getMax(nums);
			if(maxvalue != max) {
				System.out.println("wrong output value: " + maxvalue + ",  max is: " + max);
				for (int n : nums) {
					System.out.print(n + "  ");
				}
				System.out.println();
			}
		}
	}
	
}

