/**
 * http://n00tc0d3r.blogspot.com/2013/03/probability-of-alive-on-island.html
 * 
 * There is an island which is represented by square matrix NxN, represented as (0,0) to (N-1,N-1).
A person on the island is standing at given coordinates (x,y). He can move in any direction one step, right, left, up, down on the island. If he steps outside the island, he dies. 

Now He is allowed to move n steps on the island (along the matrix). What is the probability that he is alive after he walks n steps on the island? 

Write an efficient full code and tests for function double probabilityOfAlive(int x,int y, int n).
 * */
public class ProbabilityOfAlive {
	
	
	/**
	 * Generalizing the formula, we have:
Prob(x, y, step) = 0.25*Prob(x-1, y, step-1) + 0.25*Prob(x, y-1, step-1)
                            + 0.25*Prob(x+1, y, step-1) + 0.25*Prob(x, y+1, step-1)
	 * 
	 * */
	
	//use recursive or dp
	public static double probabilityOfAlive(int x,int y, int step, int n) {  
	     if (x<0 || y<0 || x>=n || y>=n) return 0;  
	     if (step == 0) return 1;  
	     return 0.25*probabilityOfAlive(x-1, y, step-1, n)  
	         + 0.25*probabilityOfAlive(x, y-1, step-1, n)  
	         + 0.25*probabilityOfAlive(x+1, y, step-1, n)  
	         + 0.25*probabilityOfAlive(x, y+1, step-1, n);  
	   }  
	   
	   public static void main (String[] args) throws java.lang.Exception {  
	     int n = 1;  
	     System.out.println("n=" + n + "(0,0,1) => " + probabilityOfAlive(0,0,1,n));  
	     n = 2;  
	       System.out.println("n=" + n + "(0,0,1) => " + probabilityOfAlive(0,0,1,n));  
	     System.out.println("n=" + n + "(0,0,2) => " + probabilityOfAlive(0,0,2,n));  
	     n = 3;  
	       System.out.println("n=" + n + "(0,1,1) => " + probabilityOfAlive(0,1,1,n));  
	     System.out.println("n=" + n + "(0,1,2) => " + probabilityOfAlive(0,1,2,n));  
	     System.out.println("n=" + n + "(1,1,1) => " + probabilityOfAlive(1,1,1,n));  
	       System.out.println("n=" + n + "(1,1,2) => " + probabilityOfAlive(1,1,2,n));  
	   }  
	   
	   /**
	    * The case for dynamic programming is simple
	    * use a 3-d array [width][height][step]
	    * initialize when step == 1
	    * then go to step = 2, ...,  n
	    * */

}
