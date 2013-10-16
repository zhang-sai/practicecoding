import java.util.ArrayList;


public class UniqueBinarySearchTrees {

	/**
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
	 * */
	public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        //for n >= 3
        int num = 0;
        for(int i = 1; i <=n; i++) {
            int leftNum = numTrees(i-1);
            int rightNum = numTrees(n-i);
            if(leftNum != 0 && rightNum !=0 ) {
                num = num + leftNum*rightNum;
            } else {
                num += Math.max(leftNum, rightNum);   
            }
        }
        return num;
    }
	
	/**
	 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2      
	 * */
	public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) {
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        int[] vals = new int[n];
        for(int i = 1; i <=n; i++) {
            vals[i-1] = i;
        }
        return generateTrees(vals, 0, n-1);
    }
    
    private ArrayList<TreeNode> generateTrees(int[] vals, int start, int end) {
        if(start > end) {
            return new ArrayList<TreeNode>();
        } else if (start == end) {
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            list.add(new TreeNode(vals[start]));
            return list;
        } else {
            //do recursion
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            
            for(int i = start; i <= end; i++) {
                ArrayList<TreeNode> leftNodes = generateTrees(vals, start, i-1);
                ArrayList<TreeNode> rightNodes = generateTrees(vals, i+1, end);
                
                //the number of trees
                if(!leftNodes.isEmpty() && !rightNodes.isEmpty()) {
                    for(TreeNode leftNode : leftNodes) {
                        for(TreeNode rightNode : rightNodes) {
                            TreeNode newNode = new TreeNode(vals[i]);
                            newNode.left = leftNode;
                            newNode.right = rightNode;
                            list.add(newNode);
                        }
                    }
                } else if (leftNodes.isEmpty() && !rightNodes.isEmpty()) {
                    for(TreeNode rightNode : rightNodes) {
                        TreeNode newNode = new TreeNode(vals[i]);
                        newNode.right = rightNode;
                        list.add(newNode);
                    }
                } else if (!leftNodes.isEmpty() && rightNodes.isEmpty()) {
                    for(TreeNode leftNode : leftNodes) {
                        TreeNode newNode = new TreeNode(vals[i]);
                        newNode.left = leftNode;
                        list.add(newNode);
                    }
                } else {
                    list.add(new TreeNode(vals[i]));
                }
            }
            
            return list;
        }
    }
}
