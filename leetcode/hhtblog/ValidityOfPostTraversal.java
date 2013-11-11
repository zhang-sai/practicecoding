/**
 * http://zhedahht.blog.163.com/blog/static/25411174200725319627/
 * */

/**
 * 
 * Given an array, to check whether it is the result of a post-traversal of of a BST
 *       8
       /  \
      6    10
    / \    / \
   5   7   9  11
 * 
 * */
public class ValidityOfPostTraversal {

	public boolean isPostTraversal(int[] vals) {
		if(vals.length <= 1) {
			return true;
		}
		return this.isValid(0, vals.length - 1, vals);
	}
	
	private boolean isValid(int startIndex, int endIndex, int[] vals) {
		System.out.println("start: " + startIndex + ", endIndex: " + endIndex);
		if(startIndex > endIndex) {
			throw new Error();
		}
		if(startIndex == endIndex) {
			return true;
		}
		int v = vals[endIndex];
		//search for the first index that is larger than the v
		int index = -1;
		for(int i = startIndex; i < endIndex; i++) {
			if(vals[i] > v) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			return this.isValid(startIndex, endIndex - 1, vals);
		}
		//check the right part
		for(int i = index; i < endIndex; i++) {
			if(vals[i] < v) {
				return false;
			}
		}
		System.out.println("  index: " + index);
		//check the left part
		boolean isLeftValid = index == startIndex ? true :
			this.isValid(startIndex, index -1, vals );
		boolean isRightValid = this.isValid(index, endIndex - 1, vals);
		return isLeftValid && isRightValid;
	}
	
	public static void main(String[] args) {
		ValidityOfPostTraversal vpt = new ValidityOfPostTraversal();
		int[] vals = new int[]{5, 7, 6, 9, 11, 10, 8};
		System.out.println(vpt.isPostTraversal(vals));
		 vals = new int[]{7, 4, 6, 5};
			System.out.println(vpt.isPostTraversal(vals));
	}
}
