import java.util.LinkedList;

//http://leetcode.com/2011/01/sliding-window-maximum.html
/**
 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. Following is an example:
The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]
 * 
 * */
public class SlidiingWindows {

	public static void main(String[] args) {
		
		int[] a = new int[]{1,  3,  -1, -3,  5,  3,  6,  7};
		int[] b = new int[a.length];
		maxSlidingWindow(a, 3, b);
		for(int v : b) {
			System.out.print(v + "  ");
		}
	}
	
	static void maxSlidingWindow(int a[], int w, int b[]) {
		//use a linked list to mimic a double queue, only keep the index
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < w; i++) {
			while(!queue.isEmpty() && a[queue.getLast()] < a[i]) {
				queue.removeLast();
			}
			queue.add(i);
		}
		for(int i = w; i < a.length; i++) {
			System.out.println("i: " + i + ", queue: " + queue + ", max: " + a[queue.getFirst()]);
			b[i-w] = a[queue.getFirst()]; //the front always keep the largest index
			
			while(!queue.isEmpty() && a[queue.getLast()] < a[i]) { //remove smaller elements
				queue.removeLast();
			}
			queue.add(i);
			while(queue.getFirst() <= i - w) { //pop up obseleted index
				queue.removeFirst();
			}
		}
		
		b[a.length-w] = a[queue.getFirst()];
		
	}
}
