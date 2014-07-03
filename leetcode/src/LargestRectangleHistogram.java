import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.

http://tech-queries.blogspot.com/2011/03/maximum-area-rectangle-in-histogram.html


 * */
public class LargestRectangleHistogram {

	public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
				 /**
				  * measure the largest possible area construct by the top bar
				  * */
				 int topIndex = leftIndex.pop();
				 //use the left popped bar
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
		LargestRectangleHistogram r = new LargestRectangleHistogram();
		int area = r.largestRectangleArea(new int[]{0, 2, 0});
		System.out.println(area);
	}
	
}
