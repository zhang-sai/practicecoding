import java.util.PriorityQueue;
xxxx
//11.8
public class RankOfStreamValue {

	/**
	 * construct a tree, with a node stating the number of
	 * element less or equal than it
	 * */
	
	public static void processStream(int[] array) {
		//it build a tree, the number element = numbers <= it
		TreeNode root = new TreeNode(array[0]);
		root.elem++;
		for(int i = 1; i < array.length; i++) {
			int v = array[i];
			TreeNode curr = root;
			while(curr != null) {
				if(curr.val == v) {
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{5, 4, 5, 1, 3, 4, 5, 6, 7, 8, 9, 10, 3, 2, 4, 5, 6, 11};
		processStream(array);
	}
}