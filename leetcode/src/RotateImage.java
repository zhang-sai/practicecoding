/**
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 * */

public class RotateImage {
	
	public static void main(String[] args) {
//		int[][] matrix = new int[][]{new int[]{1, 2, 3, 4}, 
//				new int[]{5, 6, 7, 8}, 
//				new int[]{9, 10, 11, 12}, 
//				new int[]{13, 14, 15, 16}
//		};
//		int[][] matrix = new int[][]{new int[]{1, 2, 3}, 
//				new int[]{4, 5, 6}, 
//				new int[]{7, 8, 9}
//		};
		int[][] matrix = new int[][]{new int[]{1, 2}, 
				new int[]{3, 4}
		};
		RotateImage ri = new RotateImage();
		ri.rotate(matrix);
	}
	
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
		
		for(int x = 0; x < (n / 2); x++) {
			for(int y = x; y < n-x - 1 /*not 2*row */; y++) { //XXX note it is y < n -x - 1
				//pictorially denoted as:
				// 1, 2, 3
				// 4, 5, 6
				// 7, 8, 9
				// is divided into four parts: 1,2 == 3, 6 == 9, 8 == 7, 4
				
				System.out.println(x + ", " + y);
				//do rotation here
				int nextX1 = y;
				int nextY1 =  n - 1 - x;
				
				System.out.println(nextX1 + ", " + nextY1);
				
				int nextX2 = nextY1;
				int nextY2 = n - 1 - nextX1;
				
				System.out.println(nextX2 + ", " + nextY2);
				
				int nextX3 = nextY2;
				int nextY3 = n - 1 - nextX2;
				
				System.out.println(nextX3 + ", " + nextY3);
				
				
				
				int tmp = matrix[nextX3][nextY3];
				matrix[nextX3][nextY3] = matrix[nextX2][nextY2];
				matrix[nextX2][nextY2] = matrix[nextX1][nextY1];
				matrix[nextX1][nextY1] = matrix[x][y];
				matrix[x][y] = tmp;
				
				
				System.out.println("---");
			}
		}
    }
}
