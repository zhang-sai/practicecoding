import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 4, 6, 5, 7, 9, 10
 * outputs: [4,7] [9,10]
 * */
public class ArrayToInterval {
	
	public static void main(String[] args) {
		int[] a = new int[]{4, 6, 5, 7, 9, 10, 16};
		System.out.println(getIntervals(a));
	}

	public static List<Interval> getIntervals(int[] array) {
		//start from
		Arrays.sort(array);
		
		List<Interval> l = new LinkedList<Interval>();
		
		int start = array[0];
		int prev = start;
//		boolean has = true;
		for(int i = 1; i < array.length; i++) {
			if(array[i] == prev + 1) {
				prev = array[i];
			} else {
				l.add(new Interval(start, prev));
				start = array[i];
				prev = start;
			}
		}
		
		//do not forget the end
		l.add(new Interval(start, prev));
		
		return l;
	}
	
}
