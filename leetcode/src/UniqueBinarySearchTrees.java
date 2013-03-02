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
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
        // Start typing your Java solution below
        // DO NOT write main() function
        int totalNum = 0;
        for(int i = 1; i <= n; i++) {
        	//suppose if i is the pivot
        	int leftNum = i - 1;
        	int rightNum = n - i;
        	//then count the possible left and right num
        	if(leftNum == 0 || rightNum == 0) {
        		totalNum += Math.max(this.numTrees(leftNum), this.numTrees(rightNum));
        	} else {
        		totalNum += this.numTrees(leftNum)*this.numTrees(rightNum);
        	}
        }
        
        return totalNum;
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
		ArrayList<TreeNode> retList = new ArrayList<TreeNode>();
		if(n == 0) {
			return retList;
		}
        return this.generateTrees(1, n);
    }
	
	private ArrayList<TreeNode> generateTrees(int low, int high) {
		ArrayList<TreeNode> retList = new ArrayList<TreeNode>();
		if(low == high) {
			retList.add(new TreeNode(low));
			return retList;
		}
		//low must < high
		for(int pivot = low ; pivot <= high; pivot++) {
			//select a pivot
			ArrayList<TreeNode> leftNodes = pivot == low ? new ArrayList<TreeNode>() : this.generateTrees(low, pivot - 1);
			ArrayList<TreeNode> rightNodes = pivot == high ? new ArrayList<TreeNode>() : this.generateTrees(pivot + 1, high);
			if(!leftNodes.isEmpty() && !rightNodes.isEmpty()) {
				for(TreeNode left : leftNodes) {
					for(TreeNode right : rightNodes) {
						TreeNode node = new TreeNode(pivot);
						node.left = left;
						node.right = right;
						retList.add(node);
					}
				}
				
			} else if (leftNodes.isEmpty()) {
				for(TreeNode right : rightNodes) {
					TreeNode node = new TreeNode(pivot);
					node.right = right;
					retList.add(node);
				}
			} else {
				//right is empty
				for(TreeNode left : leftNodes) {
					TreeNode node = new TreeNode(pivot);
					node.left = left;
					retList.add(node);
				}
			}
		}
		
		return retList;
	}
}
