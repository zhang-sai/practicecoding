import java.util.Random;


public class MoveAllOddsBeforeEvens {

	public void moveOddsBeofreEvens(int[] nums) {
		//do nothing
		if(nums.length < 2) {
			return;
		}
		int headIndex = 0;
		int tailIndex = nums.length - 1;
		while(headIndex < tailIndex) {
			if(nums[headIndex] % 2 == 1) {
				headIndex++;
				continue;
			}
			if(nums[tailIndex] % 2 == 0) {
				tailIndex--;
				continue;
			}
			//swap two numbers
			int tmp = nums[headIndex];
			nums[headIndex] = nums[tailIndex];
			nums[tailIndex] = tmp;
			headIndex++;
			tailIndex--;
		}
	}
	
	//a test driver
	public static void main(String[] args) {
		MoveAllOddsBeforeEvens m = new MoveAllOddsBeforeEvens();
		Random r = new Random();
		for(int j = 0; j < 100; j++) {
			int[] nums = new int[r.nextInt(50)];
			for(int i = 0; i < nums.length; i++) {
				nums[i] = r.nextInt(100);
			}
			//
			m.moveOddsBeofreEvens(nums);
			if(!checkTrue(nums)) {
				System.out.println("Fail at: " + j + "-th input");
				for(int num : nums) {
					System.out.print(num + "  ");
				}
			}
		}
	}
	
	static boolean checkTrue(int[] nums) {
		boolean isOdd = true;
		for(int num : nums) {
			if(num % 2 == 0) {
				isOdd = false;
			} else { //is odd
				if(!isOdd) {
					return false;
				}
			}
		}
		return true;
	}
	
}
