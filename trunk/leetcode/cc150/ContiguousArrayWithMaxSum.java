
public class ContiguousArrayWithMaxSum {

	//2 -8 3 -2 4 -10
	//return  3 -2 4
	//
	public static int findMaxSubarray(int[] array) {
		int max = Integer.MIN_VALUE;
//		int index = 0;
		int currMax = 0;
		for(int v : array) {
			currMax += v;
			if(currMax > max) {
				max = currMax;
			} 
			if(currMax < 0) {
				currMax = 0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(findMaxSubarray(new int[]{-22, 8, 3, -2, 4, -10}));
	}
}
