
public class ConvertSortedArrayListToBST {

	/**
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 * */
	public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0) {
        	return null;
        }
        return this.createTreeNode(num, 0, num.length - 1); 
    }
	
	private TreeNode createTreeNode(int[] num, int low, int high) {
		if(low == high) {
			return new TreeNode(num[low]);
		}
		//get the mid index
		int midIndex = (low+high)/2;
		TreeNode midNode = new TreeNode(num[midIndex]);
		//create the left part
		if(midIndex > low) {
			midNode.left = this.createTreeNode(num, low, midIndex - 1);
		}
		
		//create the right part
		if(high > midIndex) {
			midNode.right = this.createTreeNode(num, midIndex + 1, high);
		}
		
		return midNode;
	}
	
	/**
	 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	 * */
	public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = 0;
        ListNode node = head;
        while(node != null) {
        	length ++;
        	node = node.next;
        }
        int[] nums = new int[length];
        node = head;
        int index = 0;
        while(node != null) {
        	nums[index++] = node.val;
        	node = node.next;
        }
        return this.sortedArrayToBST(nums);
    }
}
