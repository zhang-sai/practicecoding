import java.util.Comparator;
import java.util.PriorityQueue;

// numbers are randomly generated and passed to a method
//find and maintain the median values as new values comes in//18.9

//Note the comparator
public class GetMedianInIntegerStream {

	//use two priority queue
	public static void printOutMedian(int[] values) {
		
		class MinComparator implements Comparator<Integer> {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2) {
					return -1;
				} else if (o1 == o2) {
					return 0;
				} else {
					return 1;
				}
			}
			
		}
		
		//return the smallest one by peek
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(); //values above the median
		//return the largest one by peek
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10, new MinComparator());  //values below the median
		
		//here is the algorithm
		//make maxHeap always have 1 more element than minHeap
		for(int v : values) {
//			System.out.println("------- value: " + v);
			if(maxHeap.isEmpty() && minHeap.isEmpty()) {
				System.out.println("start ...");
				maxHeap.offer(v);
			} else {
//				System.out.println("max: " + maxHeap + ",  min: " + minHeap);
				if(maxHeap.size() == minHeap.size()) {
					System.out.println( "max: " + maxHeap.peek() + ", min: "
							+ minHeap.peek() + ", median: " + (double)(maxHeap.peek() + minHeap.peek())/2 );
				} else {
					//return the smallest one
					System.out.println(maxHeap.peek());
				}
				//then insert the value v
				//peek returns the largest one
				if(maxHeap.size() == minHeap.size()) {
					if(minHeap.peek() <= v) {
						maxHeap.offer(v);
					} else {
						maxHeap.offer(minHeap.poll());
						minHeap.offer(v);
					}
				} else {
					//maxHeap has one more extra element
					if(v <= maxHeap.peek()) {
						minHeap.offer(v);
					} else {
						minHeap.offer(maxHeap.poll());
						maxHeap.offer(v);
					}
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[] values = new int[]{1, 3, 4,6, 7, 2, 1, 3, 4, 8, 10, 11, 2, 3, 5, 5};
		printOutMedian(values);
	}
}
