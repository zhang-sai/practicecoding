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
	        if(matrix.length == 0) {
	        	return false;
	        }
	        int rowNum = matrix.length;
	        int colNum = matrix[0].length;
	        int size = rowNum*colNum;
	        
	        return this.searchInMatrix(matrix, target, 0, size - 1);
	 }
	 
	 private boolean searchInMatrix(int[][] matrix, int target, int start, int end) {
		 if(start > end) {
			 return false;
		 }
		 int midIndex = (start + end)/2;
		 if(this.getValueInMatrix(matrix, midIndex) > target) {
			 return this.searchInMatrix(matrix, target, start, midIndex - 1);
		 } else if (this.getValueInMatrix(matrix, midIndex) < target) {
			 return this.searchInMatrix(matrix, target, midIndex + 1, end);
		 } else {
			 return true;
		 }
	 }
	 
	 //given a 8X8 matrix
	 //index 1 ==> 0, 1
	 //index 7 => 0, 7
	 //index 8 ==> 1, 0
	 //index 9 ==> 1, 1
	 
	 //given a 2*1 matrix
	 //index 0 => 0, 0
	 //index 1 => 1, 0
	 private int getValueInMatrix(int[][] matrix, int index) {
		 int rowNum = matrix.length;
	     int colNum = matrix[0].length;
	     
	     int rowIndex = (index) / colNum;  //XXX this part is critical
	     int colIndex = index % colNum;
	     
	     return matrix[rowIndex][colIndex];
	     
	 }
	 
	 public static void main(String[] args) {
		 Search2DMatrix s = new Search2DMatrix();
		 System.out.println(s.searchMatrix(new int[][]{new int[]{1}, new int[]{3}}, 2));
	 }
}
