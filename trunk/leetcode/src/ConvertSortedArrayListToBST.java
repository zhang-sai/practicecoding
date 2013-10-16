
public class ConvertSortedArrayListToBST {

	/**
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 * */
	public TreeNode sortedArrayToBST(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num.length == 0) {
            return null;
        }
        //get the middle
        int mid = num.length/2;
        TreeNode node = new TreeNode(num[mid]);
        if(mid > 0) {
            int[] leftNums = new int[mid];
            for(int i = 0; i < mid; i++) {
                leftNums[i] = num[i];
            }
            node.left = sortedArrayToBST(leftNums);
        }
        if(mid < num.length - 1) {
            int[] rightNums = new int[num.length - mid - 1];
            for(int i = mid + 1; i < num.length; i++) {
                rightNums[i - mid - 1] = num[i];
            }
            node.right = sortedArrayToBST(rightNums);
        }
        return node;
    }
}
