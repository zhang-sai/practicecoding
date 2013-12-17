package linkedin;

/**
 * Implement the integral part logn base 2 with bit manipulations
 * http://www.careercup.com/question?id=15062875
 * */
public class CalculateLog {

	public static int calLog(int v) {
		int ret = 0;
		while(v > 0) {
			v = v >> 1;
			ret++;
		}
		return ret - 1;
	}
	
	public static void main(String[] args) {
		for(int i = 1; i < 200; i++) {
		    System.out.println(i + "  :  " + calLog(i));
		}
	}
	
}
