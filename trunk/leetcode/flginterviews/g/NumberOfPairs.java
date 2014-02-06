package g;

/**
 * how many (m, n) pairs such that m*m+n*n<N
 * */
public class NumberOfPairs {

	
	//first restrict m, n to [0, sqrt(N)]
	
	//do binary search to find the value
	
	//aslo, they are symmetry
	
    public static void main(String[] args) {
    	int N = 2;
    	if(N < 0) {
    		System.out.println("No pair exists.");
    		return;
    	}
    	if(N == 0) {
    		System.out.println("m = 0, n = 0");
    		return;
    	}
    	
    	int upbound = (int)Math.sqrt(N);
    	
    	//count the number of nodes in the axis
    	int num = 4*((int)N) + 1; //including the middle part)
    	
    	//search a point between [0, and upbound]
    	for(int m = 1; m <= upbound; m++) {
    		int start = 1;
    		int end = upbound;
    		
    		//get the middle point
    		int mid = (start + end)/2;
    		
    		while(!(mid*mid + m*m <= N && (mid + 1)*(mid + 1) + m*m > N)) {
    			if(mid*mid + m*m < N) {
    				start = mid + 1;
    			} else {
    				end = mid - 1;
    			}
    			mid = (start + end)/2;
    		}
    		
    		//add the number of points when m is fixed
    		num += 4*mid;  //add symmetry points in four parts.
    	}
    	
    	System.out.println("Number of points: " + num);
    	
    }
}
