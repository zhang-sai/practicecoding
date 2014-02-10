import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
» Solve this problem
//XXX the same as subsets but with one more check for duplication
 * */
//another solution: http://smartlhc.blogspot.com/2013/02/subsets-ii.html
//did not read but SHOULD

//this uses recursion
public class Subsets2 {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	       ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
	       if(num.length<1) {
	           return results;
	       }
	       Arrays.sort(num);
	     
	       //store unique numbers
	       ArrayList<Integer> number=new ArrayList<Integer>();
	       //store the apprearance of each  number
	       ArrayList<Integer> times=new ArrayList<Integer>();   
	       
	       for(int i = 0; i < num.length; i++) {
	         //check repetition
	         if(number.isEmpty() || number.get(number.size()-1)!=num[i]) {
	             number.add(num[i]);
	             times.add(1);
	         } else {
	             int count=times.get(times.size()-1);
	             times.set(times.size()-1,count+1);
	         }
	       }
	       ArrayList<Integer> out=new ArrayList<Integer>();
	       generateSubsets(number, times, out, results,0);
	       return results;   
	    }
	    
	 public void generateSubsets(ArrayList<Integer> number, ArrayList<Integer> times,
	         ArrayList<Integer> out, ArrayList<ArrayList<Integer>>results, int pos) {
	     //reach out of the boundary
	     if(pos == number.size()) {
	         ArrayList<Integer> temp=new ArrayList<Integer>(out);
	         results.add(temp);
	         return;
	     }         
	     
	     //essentially, consider 2 possibilities: 0 --- max number of the current number
	     //then do backtracking
	        
	     //do not select the number at current pos
	     //generate subsets recursively from the next position
	     generateSubsets(number, times, out, results, pos + 1);   
	     
	     //get the appearance times of the number at this position
	     int count=times.get(pos);
	     //select the number at current pos from 1 to appearance times
	     for(int i = 0; i < count; i++) {
	         //add the current number
	         out.add(number.get(pos));
	         //proceed to the next number recursively
	         generateSubsets(number, times, out, results, pos + 1);
	     }
	     
	     //remove all appearances of the current number
	     //backtracking
	     int size=out.size();
	     for(int i=size-1;i>=size-count;i--) {
	         out.remove(i);
	     }
	 }
	
	public static void main(String[] args) {
		Subsets as = new Subsets();
		int[] set = new int[]{4, 1, 0};
		System.out.println(as.subsets(set));
	}
}
