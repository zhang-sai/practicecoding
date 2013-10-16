/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 * */
public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //search from the top-right corner
        if(matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int x = 0;
        int y = cols - 1;
        while(x < rows && y >= 0) {
            if(matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
	 
	 public static void main(String[] args) {
		 Search2DMatrix s = new Search2DMatrix();
		 System.out.println(s.searchMatrix(new int[][]{new int[]{1}, new int[]{3}}, 2));
	 }
}
