import java.util.Arrays;


/**
 * there are two groups of people; n number of A's & n of B's. We want to have n pairs of A and B from two groups and  to minimize the sum of the weight differences.
EG

        A[]={5,3,4};
        B[]={1,6,2}; 
min = 5
3-1, 4-2,5-6

do not have to be the same, an element can be re-used multiple times
 * 
 * */
public class MinWeightTwoGroups {

	public static void main(String[] args) {
		System.out.println(minWeight(new int[]{5, 3, 4}, new int[]{1, 6, 2}));
	}
	
	public static int minWeight(int[]a, int[]b){
	    int dp[][] = new int[a.length+1][b.length+1];
	    Arrays.sort(a);
	    Arrays.sort(b);
	    
	    for(int i =1;i<dp.length;i++) { 
	    	dp[i][0]=Integer.MAX_VALUE;
	    }
	    
	    for(int i =1;i<dp[0].length;i++) {
	    	dp[0][i]=Integer.MAX_VALUE;  
	    }
	    
	    dp[0][0]=0;
	    for(int i =1;i<dp.length;i++)
	        for(int j=1;j<dp[0].length;j++){
	            int temp=Math.min(dp[i-1][j], dp[i][j-1]);
	            dp[i][j] = Math.abs(a[i-1]-b[j-1]) + Math.min(dp[i-1][j-1],temp);
	        }
	    return dp[a.length][b.length];
	}
}
