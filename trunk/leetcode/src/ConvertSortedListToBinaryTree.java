
public class ConvertSortedListToBinaryTree {

    ListNode gb = null;
    
    public TreeNode sortedListToBST(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int length = 0;
        ListNode node = head;
        while(node!=null) {
        	node = node.next;
            length++;
        }
        gb = head;
        return sortedListToBST(0, length - 1);
    }
    
    /**
     * 
     *   1  2  3  4  5 6 7
     *   
     *   gb = 1
     *   
     *   mid = 4
     *   
     *   gb = 2
     *   
     *   2.left = 1
     *   
     *   gb = 3
     *   
     *   
     *   
     * 
     * */
    
    public TreeNode sortedListToBST(int start, int end) {
    	
        if(start > end) {
        // 	System.out.println("return null: " + start + ", " + end);
            return null;
        }
        int mid = start + (end - start) / 2;
        // System.out.println("   mid: " + mid);
        TreeNode leftChild = sortedListToBST(start, mid-1);
        // System.out.println("   create parent: " + gb.val);
        TreeNode parent = new TreeNode(gb.val);
        parent.left = leftChild;
        gb = gb.next;
        parent.right = sortedListToBST( mid+1, end);
        
        // System.out.println(" ==> return parent: " + parent.val);
        return parent;
    }
}
