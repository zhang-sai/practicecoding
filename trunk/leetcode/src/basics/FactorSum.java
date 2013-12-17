package basics;

import java.math.BigInteger;

/**
 * 10!= 3628800
 * returns 3+6+2+8 + 8
 * */
public class FactorSum {

	public static void main(String[] args) {
		System.out.println(factorSum(10000));
	}
	
	public static int factorSum(int v) {
		BigInteger ten = BigInteger.valueOf(10);
		BigInteger r = BigInteger.valueOf(1);
		for(int i = 1; i <=v; i++) {
			BigInteger bi = BigInteger.valueOf(i);
			r = r.multiply(bi);
			while(r.divideAndRemainder(ten)[1].intValue() == 0) {
				r = r.divide(ten);
			}
		}
		
		System.out.println(r);
		int sum = 0;
		while(r.divide(ten).intValue() != 0) {
			sum += r.divideAndRemainder(ten)[1].intValue();
			r = r.divide(ten);;
		}
		sum += r.intValue();
		
		return sum;
	}
	
}