
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
        if(x == 1 || x==0) { //special case
            return x;
        }
        int low = 1;
        int high = Math.min(x/2, 46340);
        //avoid overflow
        int mid = (low+high)/2;
        while(low < high) {
            int sq = mid*mid;
            int sq2 = (mid+1)*(mid + 1);
            
            if(sq == x || (sq < x && sq2 > x)) {
                break;
            } 
            
            if (sq > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low+high)/2;
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
