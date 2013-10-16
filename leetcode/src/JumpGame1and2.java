import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 * */
public class JumpGame1and2 {
	public boolean canJump(int[] A) {
        //do in a reverse way, avoiding perform search
        //in which you do not know which index to expand next
        boolean[] table = new boolean[A.length];
        table[A.length-1] = true;
        int start = A.length - 2;
        while(start >= 0) {
            table[start] = false;
            for(int j = start + 1; j < A.length; ++j) {
                if(table[j] && j - start <= A[start]) {
                    table[start] = true;
                    break;
                }
            }
            start--;
        }
        return table[0];
    }
	
	//return minimum number of jumps
	//credit goes to: http://fisherlei.blogspot.com/2012/12/leetcode-jump-ii.html
    int jump(int A[]) {  
      int n = A.length;
      if(n == 1) {
          return 0;  
      }
      
      //the interval of jump.
      //for n-step, it can jump to [start, end]
      //increment start by 1 every time, and increase end by the number of jumps
      int start = 0;  
      int end = 0;  
      int count =0; //the number of jumps
      while(end < n) {  
        int max = 0;  
        count++;  
        for(int i =start; i<= end ; i++ ) {   
          if(A[i] + i >= n-1) {            
            return count;  
          }  
          if(A[i]+ i > max) {  
            max = A[i]+i;  
          }
        }  
        start = end + 1;  
        end = max;        
      }  
      
      //cannnot jump
      return Integer.MAX_VALUE;
    } 
}
