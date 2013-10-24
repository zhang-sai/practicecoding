
/**
 * Pick up an element from each different row and different line, and
 * get the max sum value
 * */
public class MaxSumInMatrix {
	
	public static void main(String[] args) {
		MaxSumInMatrix m = new MaxSumInMatrix();
		int[][] matrix = new int[][] {
			new int[]{1, 3, 4, 5},
			new int[]{5, 2, 6, 4},
			new int[]{7, 6, 9, 10}
		};
		System.out.println(m.getMaxSum(matrix));
	}
	
	public int getMaxSum(int[][] matrix) {
		if(matrix.length == 0) {
			throw new Error();
		}
		if(matrix[0].length == 0) {
			throw new Error();
		}
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				max = Math.max(max, findMax(matrix, i, j));
			}
		}
		
		return max;
	}
	
	int findMax(int[][] matrix, int row, int col) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < matrix.length; i++) {
			if(i == row) {
				continue;
			}
			for(int j = 0; j < matrix[i].length; j++) {
				if(j == col) {
					continue;
				}
				if(matrix[row][col] + matrix[i][j] > max) {
					max = matrix[row][col] + matrix[i][j];
					System.out.println(max + ",  row: " + row + ", col: " + col);
				}
			}
		}
		return max;
	}
	
}
