/**
 * The second largest number in a sequence
 * */
public class FindTheSecondLargest {

	public int findSecondLargest(int[] nums) {
		int largest = Integer.MIN_VALUE;
		int secondlargest = Integer.MIN_VALUE;
		for(int num : nums) {
			if(num > largest) {
				secondlargest = largest;
				largest = num;
			} else if (num > secondlargest) {
				secondlargest = num;
			}
		}
		return secondlargest;
	}
	
	public static void main(String[] args) {
		FindTheSecondLargest f = new FindTheSecondLargest();
		int[]  nums = {1, 3, 4, 5, 10, 6, 11, 1, 5};
		System.out.println(f.findSecondLargest(nums));
	}
}