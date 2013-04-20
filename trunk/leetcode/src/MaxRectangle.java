import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find 
 * the largest rectangle containing all ones and return its area.
 * 
 * http://www.drdobbs.com/database/the-maximal-rectangle-problem/184410529
 * 
 * related:
 * 
 * http://tech-queries.blogspot.com/2011/03/maximum-area-rectangle-in-histogram.html
 * 
 * or:
 * 
 * http://gongxuns.blogspot.com/2012/12/leetcode-maximal-rectangle.html
 * 
 * http://n00tc0d3r.blogspot.com/2013/03/largest-rectangle-in-histogram.html
 * */

public class MaxRectangle {

	 public int maximalRectangle(char[][] matrix) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 
		 //check the boundary cases
		 if(matrix == null) {
			 return 0;
		 }
		 int row = matrix.length;
		 if(row == 0) {
			 return 0;
		 }
		 int column = matrix[0].length;
		 if(column == 0) {
			 return 0;
		 }
		 
		 //find the largest all 1s
		 int[][] maxHeightMatrix = new int[row][column];
		 
		 //fill the max height matrix
		 for(int i = 0; i < row; i++) {
			 for(int j = 0; j < column; j++) {
				 if(i == 0) {
					 maxHeightMatrix[i][j] = matrix[i][j] == '1' ? 1 : 0;
				 } else {
					 if(matrix[i][j] == '0') {
						 maxHeightMatrix[i][j] = 0;
					 } else {
						 maxHeightMatrix[i][j] = maxHeightMatrix[i-1][j] == 0 ? 1 : maxHeightMatrix[i-1][j] + 1;
					 }
				 }
//				 System.out.print(maxHeightMatrix[i][j] + "  ");
			 }
//			 System.out.println();
		 }
		 
		 
		 int max = 0;
		 for(int i = 0; i < row; i++) {
			 int currMax = this.maxHistorgram(maxHeightMatrix[i]);
			 max = Math.max(max, currMax);
		 }
		 
		 return max;
	 }
	 
	 /**
	  * 
	  * one example: 2, 1, 5, 6, 2, 3
	  * Notice that we only push a new item into stack when the new item
	  * is no less than the top one in the stack. That said, when we pop
	  * up an item, the new top in the stack is the first one (go backwards
	  * from the popped one) that is smaller than the popped one, which
	  * implies that the left boundary of the current rectangle is top+1,
	  * inclusively. Also, when we pop it up, it means that we hit a new
	  * height that is smaller than it, which implies that the right
	  * boundary is cur-1, inclusively. With these information in hand,
	  * we only need to maintain one stack!
	  * */
	 private int maxHistorgram(int[] height) {
		 Stack<Integer> leftIndex = new Stack<Integer>();
		 int area = 0;
		 int index = 0;
		 while(index < height.length) {
			 //push every higher bar to the stack
//			 System.out.println(index);
			 if( leftIndex.isEmpty() || height[index] >= height[leftIndex.peek()]) {
				 leftIndex.push(index);
				 index++;
			 } else {
				 //if the curr bar is lower
				 //XXX we do NOT push curr into the stack
				 int topIndex = leftIndex.pop();
				 int currArea = height[topIndex]* (leftIndex.isEmpty() ? index : index - (leftIndex.peek()) - 1);
				 area = Math.max(area, currArea);
			 }
		 }
		 
		 //if there is still remaining items in the stack
		 while(!leftIndex.isEmpty()) {
			 int topIndex = leftIndex.pop();
			 int currArea = height[topIndex]*(leftIndex.isEmpty() ? index : index - (leftIndex.peek()) -1 );
			 area = Math.max(area, currArea);
		 }
		 
		 return area;
	 }
	 
	 public static void main(String[] args) {
		 MaxRectangle maxRect = new MaxRectangle();
		 char[][] matrix = new char[][] {
				 new char[]{'1', '0', '1', '0'},
				 new char[]{'1', '1', '0', '0'},
				 new char[]{'1', '1', '1', '0'},
				 new char[]{'0', '1', '1', '1'},
				 
		 };
		 
		 System.out.println(maxRect.maximalRectangle(matrix));
		 
		 System.out.println(maxRect.maxHistorgram(new int[]{2, 1, 5, 6, 2, 3}));
	 }
}
