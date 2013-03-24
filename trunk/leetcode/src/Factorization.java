import java.util.ArrayList;


/**
 * Given a number, factor it into x1*x2*x3... xn primes.
 * 
 * Sorted in non-descending order
 * */
public class Factorization {

	//factorizing into primes
	public ArrayList<Integer> factor(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int d = 2;
		while(num > 1) {
			while(num%d == 0) {
				list.add(d);
				num = num/d;
			}
			d++;
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Factorization f = new Factorization();
		System.out.println(f.factor(27));
	}
	
}