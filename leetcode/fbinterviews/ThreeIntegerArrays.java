import java.util.HashSet;
import java.util.Set;

/**
 * Given 3 integer arrays, find an item from each array s.t. a+b+c=0 in O(
nlogn) time
http://www.mitbbs.com/article_t/JobHunting/32394795.html
 * */
public class ThreeIntegerArrays {
	
	public static void main(String[] args) {
		ThreeIntegerArrays t = new ThreeIntegerArrays();
		int[] a = new int[]{1, 2, 3, 4, 5};
		int[] b = new int[]{-4, -2, -1, 1, 2, 4};
		int[] c = new int[]{-5, -2, 0, 1, 4};
		t.getThreeInteger(a, b, c);
	}

	public void getThreeInteger(int[] a, int[] b, int[] c) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i : a) {
			set.add(i);
		}
//		int maxA = Math.m
		for(int i : a) {
			for(int j : b) {
				if(set.contains(0 - i - j)) {
					System.out.println(i + ",  " + j + ", " + (0-i-j));
				}
			}
		}
	}
}
