/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * */
// a sample answer:
// http://gongxuns.blogspot.com/2012/12/leetcodetrapping-rain-water.html
//and http://fenghaolw.blogspot.com/2012/11/trapping-rain-water.html (explanation)
/**
 * Given: 0 1 0 2 1 0 1 3 2 1 2 1
First traverse from left to right and get the maximum water height
Get A: 0 1 1 2 2 2 2 3 3 3 3 3
Then traverse from right to left to get the maximum water height on the other side
Get B: 3 3 3 3 3 3 3 3 2 2 2 1
Compare A and B to get the minimum, which is maximum allowable water height on each bar
Min(A, B): 0 1 1 2 2 2 2 3 2 2 2 1
Extract the height of each bar to get the allowable water level
Water: 0 0 1 0 1 2 1 0 0 1 0 0
 * */
public class TappingRainWaters {
	public int trap(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int res = 0;
		if (a.length < 3) {
			return res;
		}
		int[] left = new int[a.length];
		int[] right = new int[a.length];
		
		for(int i = 0; i < a.length; i++) {
			left[i] = i==0 ? a[i] : Math.max(left[i-1], a[i]);
		}
		for(int i = a.length - 1; i >= 0; i--) {
			right[i] = (i == a.length - 1) ? a[i] : Math.max(right[i+1], a[i]);
		}
		for(int i = 0; i < a.length; i++) {
			int h = Math.min(left[i], right[i]);
			res += (h > a[i]) ? (h - a[i]) : 0;
		}

		return res;
	}
	
	public static void main(String[] args) {
		TappingRainWaters trw = new TappingRainWaters();
		System.out.println(trw.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}
}
