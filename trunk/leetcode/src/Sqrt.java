
/**
 * 
 * Implement int sqrt(int x).
 * 
 * XXX Note about overflow
 * 
 * */
public class Sqrt {
	public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x == 0 || x == 1) {
        	return x;
        }
        //for x > 1 we know the sqrt 1 -- x/2
        int begin = 1;
        //XXXX to avoid overflow
        int end = Math.min(x/2, 46340); //XXX this is the magic num
        if(begin == end) {
        	return begin;
        }
        
        int mid = -1;
        while(begin < end) { //it must be <
        	
        	
        	
        	mid = (begin + end)/2;
        	System.out.println(mid);
        	
        	//XXXMUST check mid*mid, to avoid cases that mid+1 * mid + 1 overflows
        	if(mid*mid == x) {
        		break;
        	} else if (mid*mid < x && (mid + 1)*(mid + 1) > x) {
//        		if((mid + 0.5)*(mid + 0.5) < x) {
//        			mid = mid + 1;
//        		}
        		break;
        	}
        	if(mid*mid > x) {
        		end = mid - 1; //XXX must mid -1 1, not mid, other wise would be infinite loop
        	} else if (mid*mid < x) {
        		begin = mid + 1; //
        	}
        	
        	//jump here
        	if(end == begin) {
        		mid = begin;
        		break;
        	}
        }
        
        return mid;
    }
	
	public static void main(String[] args) {
		Sqrt s = new Sqrt();
//		System.out.println(s.sqrt(2147395599));
		
		System.out.println(s.sqrt(2147483647));
////		System.out.println(s.sqrt(4));
//		
//		System.out.println(Integer.MAX_VALUE);
//		
//		System.out.println(1073697799 * 1073697799);
//		
//		System.out.println((1073697799 + 1) * (1073697799 + 1));
	}
}
