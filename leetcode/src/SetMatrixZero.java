/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * */
public class SetMatrixZero {
	//credit goes to: http://blog.unieagle.net/2012/10/23/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Aset-matrix-zeroes/
	public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length == 0) {
        	return;
        }
        //re-use the first row / column
        boolean firstRow = false;
        for(int i = 0; i < matrix[0].length; i++) {
        	if(matrix[0][i] == 0) {
        		firstRow = true;
        		break;
        	}
        }
        boolean firstCol = false;
        for(int i = 0; i < matrix.length; i ++) {
        	if(matrix[i][0] == 0) {
        		firstCol = true;
        		break;
        	}
        }
        
        //then reuse the first row and column
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[i].length; j++) {
        		if(matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        
        //set matrix to zero
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[i].length; j++) {
        		if(i == 0 || j == 0) {
        			continue;
        		}
        		if(matrix[0][j] == 0 ||matrix[i][0] == 0) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        //do sth for the first row
        if(firstRow) {
        	for(int i = 0; i < matrix[0].length; i++) {
        		matrix[0][i] = 0;
        	}
        }
        
        if(firstCol) {
        	for(int i = 0; i < matrix.length; i++) {
        		matrix[i][0] = 0;
        	}
        }
    }
	
	public static void main(String[] args) {
		SetMatrixZero smz = new SetMatrixZero();
		smz.setZeroes(new int[][]{new int[]{0}});
	}
}
