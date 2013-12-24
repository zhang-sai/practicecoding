package linkedin;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Provide an implementation of the following interface: 

http://www.careercup.com/question?id=8591375

 * */
public class PowerIterator {

	public static interface Powers extends Iterator<Long> 
	{ 
	/* Returns the next integer a in the arithmetic sequence of integers where 
	* a = m^n, m > 1 n > 1, and m and n are both integers 
	* Thus, the first few outputs will be 4, 8, 9, 16, 25, 27, 32, 36, etc. 
	*/ 

		//2^2, 2^3, 3^2, 2^4 (4^2), 5^2, 3^3, ...
		
	public Long next(); 

	/* Resets the sequence to the beginning, such that the next call to next() 
	* will return 4. 
	*/ 
	public void reset(); 
	}
	
	public static class PIter implements Powers {
		
		   private long next = 4;  
		   private int base = 2;  

		   /* b = logn/loga */
//		   private int isPerfectPower(long n) {  
//		     for (int a=2; a<n/2; ++a) {  
//		       double b = Math.log(n) / Math.log(a);  
//		       if (b - (int)b == 0) return a;  
//		     }  
//		     return -1;  
//		   }  

		   /* binary search */
		   public int isPerfectPower(long n) {  
		     for (int b=2; b<(int)(Math.log(n)/Math.log(2)+1); ++b) {  
		       long l = 2, r = n/2;  
		       while (l <= r) {  
		         long mid = l + (r - l) / 2;  
		         long v = (long)Math.pow(mid, b);  
		         if (v == n) return (int)mid;  
		         if (v > n) {  
		           r = mid - 1;  
		         } else {  
		           l = mid + 1;  
		         }  
		       }  
		     }  
		     return -1;  
		   }  

		   @Override  
		   public Long next() {  
		     long pre = next;  
		     next = next*base;  
		     for (long i=pre+1; i<next; ++i) {  
		       int a = isPerfectPower(i);  
		       if (a > 0) {  
		         next = i;  
		         base = j;  
		         break;  
		       }  
		     }  
		     return pre;  
		   }  
		   
		   @Override  
		   public void reset() {  
		     next = 4; base = 2;  
		   }

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}  
		
	}
	
	
	
	public static void main(String[] args) {
		PIter p = new PIter();
		for(int i = 0; i < 10; i++) {
			System.out.println(p.next());
		}
	}
}
