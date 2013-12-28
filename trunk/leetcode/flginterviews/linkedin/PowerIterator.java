package linkedin;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Provide an implementation of the following interface:
 * 
 * http://www.careercup.com/question?id=8591375
 * 
 * */
public class PowerIterator {

	public static interface Powers extends Iterator<Long> {
		/*
		 * Returns the next integer a in the arithmetic sequence of integers
		 * where a = m^n, m > 1 n > 1, and m and n are both integers Thus, the
		 * first few outputs will be 4, 8, 9, 16, 25, 27, 32, 36, etc.
		 */

		// 2^2, 2^3, 3^2, 2^4 (4^2), 5^2, 3^3, ...

		public Long next();

		/*
		 * Resets the sequence to the beginning, such that the next call to
		 * next() will return 4.
		 */
		public void reset();
	}

	public static class PIter implements Powers {

//		private long next = 4;
		private NumPair curr = new NumPair(2, 2);
			
		@Override
		public void reset() {
			curr = new NumPair(2, 2);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public Long next() {
			long retValue = curr.v;
			//compute the next NumPair
			this.computeNextValue();
			return retValue;
		}
		
		private void computeNextValue() {
			int minValue = curr.v + 1;
			int maxValue = (int) Math.min(Math.pow(curr.a + 1, curr.b),
					Math.pow(curr.a, curr.b + 1));
			for(int v = minValue; v <= maxValue; v++) {
				NumPair np = isPerfectSquareNum(v);
				if(np != null) {
					this.curr = np;
//					System.out.println(np);
					break;
				}
			}
		}

	}
	
	static class NumPair {
		final int a;
		final int b;
		final int v;
		public NumPair(int a, int b) {
			this.a = a;
			this.b = b;
			this.v = (int)Math.pow(a, b);
		}
		public String toString() {
			return a + "^" + b + "=" + v;
		}
	}
	
	//check whether it can be written as a^b = n
	public static NumPair isPerfectSquareNum(int n) {
		//b <= log2(n)
		//a <= sqrt(n)
		int bMax = (int)(Math.log(n)/Math.log(2));
		int aMax = (int)Math.sqrt(n);
//		System.out.println(bMax + "   " + aMax);
		//check every b
		for(int b = 2; b <= bMax; b++) {
			//binary search a and compute a^b
			int low = 2;
			int high = aMax;
			while(low <= high) {
				int a = (low + high)/2;
				int v = (int) Math.pow(a, b);
				if(v == n) {
//					System.out.println(a + "^" + b + "=" + n);
					return new NumPair(a, b);
				} else if (v > n) {
					high = a - 1;
				} else {
					low = a + 1;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		for(int i = 5; i < 100; i++) {
			NumPair p =  isPerfectSquareNum(i);
			if(p != null) {
				System.out.println(p);
			}
		}
		PIter p = new PIter();
		for (int i = 0; i < 1000; i++) {
			System.out.println(p.next());
		}
	}
}
