/**
 * Container With Most WaterJan 9 '12
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

http://blog.unieagle.net/2012/09/16/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Acontainer-with-most-water/
 * */

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int max = 0;
        if(height.length < 2) {
        	return max;
        }
        
        int start = 0;
        int end = height.length - 1;
        while(start < end) {
        	max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
        	//always move the lower bar, since it woudl not
        	//contain more water using this lower bar
        	if(height[start] >= height[end]) {
        		end--;
        	} else {
        		start ++;
        	}
        }
        return max;
    }
}
