import java.util.Random;


public class FindHalfOccuranceNum {

	public int getHalfOccNum(int[] nums) {
		if(nums.length == 0) {
			throw new Error();
		}
		int value = nums[0];
		int count = 1;
		for(int index = 1; index < nums.length; index++) {
			if(nums[index] == value) {
				count++;
			} else {
				if(count == 0) {
					value = nums[index];
					count = 1;
				} else {
					count--;
				}
			}
		}
		
		//it must verify the result
		count = 0;
		for(int num : nums) {
			if(num == value) {
				count++;
			}
		}
		if(count <= nums.length / 2) {
			throw new Error("count: " + count + ", value: " + value + ", length: " + nums.length);
		}
		return value;
	}
	
	
	public static void main(String[] args) {
		int round = 100;
		Random r = new Random();
		while(round -- > 0) {
			int length = r.nextInt(1000) + 13;
			if(length % 2 == 0) {
				length ++;
			}
			int nums[] = new int[length];
			int expectedNum = r.nextInt(100);
			int num = 0;
			while(num <= length/2) {
				int pos = r.nextInt(nums.length);
				if(nums[pos] == 0) {
					nums[pos] = expectedNum;
					num++;
				}
			}
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] == 0) {
					nums[i] = r.nextInt(50);
				}
			}
//			System.out.println("+ " + num + ", " + nums.length);
//			for(int n : nums) {
//				System.out.print(n + "  ");
//			}
//			System.out.println();
			//get the number
			FindHalfOccuranceNum fh = new FindHalfOccuranceNum();
			int foundNum = fh.getHalfOccNum(nums);
			if(foundNum != expectedNum) {
				System.out.println(" --- wrong");
			} else {
				System.out.println("found: " + foundNum);
			}
		}
	}
	
}
