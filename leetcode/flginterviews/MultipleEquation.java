import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * For some N, print all the solutions of A * B = C * D where A, B, C
, D are all 1-N.


eg. n=2
print:
1 * 1 = 1 * 1
1 * 2 = 1 * 2
1 * 2 = 2 * 1
2 * 1 = 1 * 2
2 * 1 = 2 * 1
2 * 2 = 2 * 2
 * */
//x
public class MultipleEquation {
	
	public static void main(String[] args) {
		MultipleEquation me = new MultipleEquation();
		me.print(24);
//		me.printN(2);
	}

	public void print(int number) {
		int max = number;
		List<Integer> num = new ArrayList<Integer>();
		for(int i = 2; i <= number/2; i++) {
			while(max%i == 0) {
				num.add(i);
				max = max/i;
			}
		}
		
		//no we have a list
		System.out.println(num);
		
		//then enumerate all possible subset of the the list
		printSubset(num.toArray(new Integer[0]), new boolean[num.size()], 0);
	}
	
	public void printSubset(Integer[] a, boolean[] c, int index) {
		if(index == a.length) {
			for(int i = 0; i < a.length; i++) {
				if(c[i]) {
					System.out.print(a[i] + "  ");
				}
			}
			System.out.println();
		} else {
			printSubset(a, c, index + 1);
			
			//or choose the current
			c[index] = true;
			printSubset(a, c, index + 1);
			c[index] = false;
		}
	}
	
	//use factorization
	//max number = N*N
	//factorize that number into a sequence of primes, and then do the combiantion
	
}
