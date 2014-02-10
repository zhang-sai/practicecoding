
/**
 * Given the root of a binary search tree and 2 numbers min and max, trim the tree such that all the numbers in the new tree are between min and max (inclusive). - See more at: http://www.ardendertat.com/2012/01/17/programming-interview-questions-26-trim-binary-search-tree/#sthash.pwMxkvoZ.dpuf
 * */
public class TrimATree {

	public TreeNode trim(TreeNode t, int min, int max) {
		if(t == null) {
			return t;
		}
		
		if(t.val > min && t.val < max) {
			t.left = trim(t.left, min, max);
			t.right = trim(t.right, min, max);
			return t;
		}
		
		//discard the current nodes
		//if the value is < min or > max
		if(t.val < min) {
			return trim(t.left, min, max);
		} else {
			return trim(t.right, min, max);
		}
	}
	
}
