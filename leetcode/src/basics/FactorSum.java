package basics;

/**
 * 10!= 3628800
 * returns 3+6+2+8 + 8
 * */
public class FactorSum {

	public static void main(String[] args) {
		System.out.println(factorSum(100));
	}
	
	public static int factorSum(int v) {
		int mul = 1;
		for(int i = 1; i <= v; i++) {
			mul = mul*i;
			while(mul % 10 == 0) {
				mul = mul / 10;
			}
		}
		System.out.println(mul);
		int sum = 0;
		while(mul/10 != 0) {
			sum += mul%10;
			mul = mul / 10;
		}
		sum += mul;
		
		return sum;
	}
	
}