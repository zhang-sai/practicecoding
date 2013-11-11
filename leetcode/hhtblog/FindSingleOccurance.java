//http://zhedahht.blog.163.com/blog/static/2541117420071128950682/
//http://zhedahht.blog.163.com/blog/static/25411174201283084246412/
public class FindSingleOccurance {

	//two numbers occur once, all others occur twice
	public static void getTwoSingleOccurance(int[] nums) {
		
		int xor = nums[0];
		for(int i = 1; i < nums.length; i++) {
			xor = xor^nums[i];
		}
		
		//find the first bit which is not 0
//		for()
		int index = firstBit1(xor);
		
		int num1 = 0;
		int num2 = 0;
		
		for(int num : nums) {
			if(isBit1(num, index)) {
				num1 = num1^num;
			} else {
				num2 = num2^num;
			}
		}
		
		System.out.println(num1 + "    " + num2);
		
	}
	
	static int firstBit1(int value) {
		for(int i = 0; i < 32; i++) {
			if(isBit1(value, i)) {
				return i;
			}
		}
		throw new Error();
	}
	
	//the index includes 0
	static boolean isBit1(int value, int bitIndex) {
		if ((value & (1L << bitIndex)) != 0) {
		   return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		getTwoSingleOccurance(new int[]{1, 3, 4, 4, 6, 6, 7, 7});
//		
//		int a = 16;
//		System.out.println(a >> 3);
//		
//		System.out.println(isBit1(15, 0));
//		System.out.println(isBit1(15, 1));
//		System.out.println(isBit1(15, 2));
//		System.out.println(isBit1(15, 3));
//		System.out.println(isBit1(15, 4));
//		System.out.println(isBit1(15, 5));
	}
	
//	public int[] getThreeSingleOccurance(int[] nums) {
//		
//	}
	
}
