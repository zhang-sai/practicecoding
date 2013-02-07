import java.util.LinkedList;
import java.util.List;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.

http://tech-queries.blogspot.com/2011/03/maximum-area-rectangle-in-histogram.html


 * */
public class LargestRectangle {

	public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height == null || height.length == 0) {
        	return 0;
        }
        
        //if the i-th bar is added, then compute the rectange area
        int[] widths = new int[height.length];
        
        //the max to the left
        List<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < height.length; i++) {
        	int h = height[i];
        	while(!stack.isEmpty()) {
        		if(h <= height[stack.get(0)]) {  //XXX note it is height[index]
        			stack.remove(0);
        		} else {
        			break;
        		}
        	}
        	
        	int leftMost = stack.isEmpty() ? - 1 : stack.get(0);
        	int leftLength = i - leftMost - 1;
        	stack.add(0, i); //XXX just push the index
        	widths[i] = leftLength;
        	
        	System.out.println("element num: " + i + ",  " + widths[i]);
        }
        
        System.out.println("-------");
        
        //the max to the right
        stack.clear();
        
        for(int i = height.length - 1; i >= 0; i--) {
        	int h = height[i];
        	while(!stack.isEmpty()) {
        		if(h <= height[stack.get(0)]) {
        			stack.remove(0);
        		} else {
        			break;
        		}
        	}
        	
        	System.out.println("stack length: " + stack.size());
        	int rightMost = stack.isEmpty() ? height.length : stack.get(0); //XXX note, it is height.length - 1
        	System.out.println("right most: " + rightMost);
        	int rightLength = rightMost - i - 1;
        	System.out.println("right length num: " + i + ",  " + rightLength + ", right most: " + rightMost);
        	
        	stack.add(0, i); //just push the index XXX
        	widths[i] += rightLength;
        	
        	System.out.println("element num: " + i + ",  " + widths[i]);
        	System.out.println();
        }
        
        System.out.println("-------");
        
        //now compute the max
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++) {
        	System.out.println(i + ",  " + widths[i]);
        	int area = (1 + widths[i])*height[i];
        	if(area > max) {
        		max = area;
        	}
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		LargestRectangle r = new LargestRectangle();
		int area = r.largestRectangleArea(new int[]{0, 2, 0});
		System.out.println(area);
	}
	
}
