package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * print out prime factors. e.g., 20=2x2x5, 90=2x3x3x5 How to get a list of
 * prime numbers
 * */

//same see: FactorSum
public class PrimeFactors {
	
	public static List<Integer> primeFactors(int number) {
		int n = number;
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= number/2; i++) {
			while ( n % i == 0) {
				factors.add(i);
				n /= i;
//				System.out.println("n is: " + n);
			}
//			System.out.println("n is: " + n);
//			System.out.println("i is: " + i);
		}
		return factors;
	}
	
	public static void main(String[] args) {
	    System.out.println("Primefactors of 44");
	    System.out.println(primeFactors(44));
//	    System.out.println("Primefactors of 3");
//	    for (Integer integer : primeFactors(3)) {
//	      System.out.println(integer);
//	    }
//	    System.out.println("Primefactors of 32");
//	    for (Integer integer : primeFactors(32)) {
//	      System.out.println(integer);
//	    }
	  }
}
