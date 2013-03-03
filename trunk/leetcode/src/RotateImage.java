/**
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 * */
XX
public class RotateImage {
	//in a spiral way
	public void rotate(int[][] matrix) {
		if(matrix.length == 0) {
			return;
		}
		
		
		int n = matrix.length;
		
        // Start typing your Java solution below
        // DO NOT write main() function
        
		//basic idea:
		// original index: i, j ==> (j , n-1-i)
		
		for(int x = 0; x < (n / 2) + n%2 /**ceiling*/; x++) {
			for(int y = x; y < n - x /*not 2*row */; y++) {
				//do rotation here
				int nextX1 = y;
				int nextY1 =  n - 1 - x;
				
				int nextX2 = nextY1;
				int nextY2 = n - 1 - nextX1;
				
				int nextX3 = nextY2;
				int nextY3 = n - 1 - nextX2;
				
				int tmp = matrix[nextX3][nextY3];
				matrix[nextX3][nextY3] = matrix[nextX2][nextY2];
				matrix[nextX2][nextY2] = matrix[nextX1][nextY1];
				matrix[nextX1][nextY1] = matrix[x][y];
				matrix[x][y] = tmp;
				
			}
		}
    }
}
