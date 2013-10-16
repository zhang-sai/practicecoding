
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
