/**
 * Container With Most WaterJan 9 '12
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

http://blog.unieagle.net/2012/09/16/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Acontainer-with-most-water/
 * */

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(height.length < 2) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while(start < end) {
            max = Math.max(max, (end-start)*Math.min(height[start], height[end]));
            if(height[start] > height[end]) {
                end --;
            } else {
                start ++;
            }
        }
        return max;
    }
}
