package twitter;

public class NotVisitedIndex {

	public int solution(int[] a) {
        // write your code in Java SE 6
		//return 0 for zero length
		if(a.length == 0) {
			return 0;
		}
		//or we can use a bit set for further reducing the space cost
		boolean[] visited = new boolean[a.length];
		//keep track of the current index
		int currIndex = 0;
		while(currIndex >= 0 && currIndex < a.length) {
			if(visited[currIndex]) {
				//re-visited, there must be a loop
				System.out.println("break!");
				break;
			}
			visited[currIndex] = true;
			currIndex = currIndex + a[currIndex];
		}
		//count the number un-visited index
		int indexNum = 0;
		for(boolean flag : visited) {
			if(!flag) {
				indexNum++;
			}
		}
		return indexNum;
    }
	
	public static void main(String[] args) {
		NotVisitedIndex nv = new NotVisitedIndex();
		System.out.println(nv.solution(new int[]{1, 1, 2}));
	}
}
