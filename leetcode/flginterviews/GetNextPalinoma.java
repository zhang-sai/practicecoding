//http://www.mitbbs.com/article_t/JobHunting/32581581.html
//http://www.ardendertat.com/2011/12/01/programming-interview-questions-19-find-next-palindrome-number/

public class GetNextPalinoma {

	//here is the basic idea:
	//1. first mirror the left part to the right
	//   e.g., a b c d e  ==> a b c b a
	//2. check whether the new number is the desired one
	//   if not, just increase c
	//   if c is 9, then round it up, for instance: 197 ==> 191 ==> 200, then use 200 as the new input
	//3. if there are even numbers
	//   a b c d e f ===> a b c c b a
	//  then increase two c together

	public static void main(String[] args) {
		char[] cs = new char[]{'1', '2', '3'};
		System.out.println(getNextPalinoma(cs, cs));
		cs = new char[]{'1', '9', '3'};
		System.out.println(getNextPalinoma(cs, cs));
		cs = new char[]{'1', '2', '3', '4'};
		System.out.println(getNextPalinoma(cs, cs));
		cs = new char[]{'1', '9', '9', '4'};
		System.out.println(getNextPalinoma(cs, cs));
		cs = new char[]{'1', '9', '9', '9', '9', '4'};
		System.out.println(getNextPalinoma(cs, cs));
	}
	
	public static int getNextPalinoma(char[] nums, char[] originalNums) {
		int length = nums.length;
		boolean isEven = nums.length % 2 == 0;
		int mid = isEven ? length/2 - 1 : length/2;
		char[] newNums = new char[nums.length];
		for(int i = 0; i <= mid; i++) {
			newNums[i] = nums[i];
			newNums[nums.length - 1 - i] = nums[i];
		}
		System.out.println("curr new nums: " + new String(newNums));
		
		//decide if newNums is great than the original one
		boolean great = false;
		for(int i = 0; i < originalNums.length; i++) {
			if(newNums[i] > originalNums[i]) {
				great = true;
				break;
			}
		}
		
		if(great) {
			System.out.println("Final output: " + new String(newNums) + " is for: " + new String(originalNums));
		} else {
			
			//increase the mid
			if(newNums[mid] == '9') {
				//clear all to zero from mid to length
				for(int i = mid; i < nums.length; i++) {
					newNums[i] = '0';
				}
//				System.out.println(new String(newNums));
				
				boolean carrier = true;
				for(int i = mid - 1; i >=0; i--) {
					int v = newNums[i] - '0';
					int newV = carrier ? v + 1 : v;
					carrier = newV >= 10;
					newV = carrier ? 1 : newV;
					newNums[i] = (char)('0' + newV);
				}
			} else {
				if(isEven) {
					newNums[mid] = (char)(newNums[mid] + 1);
					newNums[mid + 1] = (char)(newNums[mid + 1] + 1);
				} else {
					newNums[mid] = (char)(newNums[mid] + 1);
				}
			}
			
			System.out.println(new String(newNums));
			
//			System.exit(1);
			return getNextPalinoma(newNums, originalNums);
		}
		
		return 0;
	}
	
}
