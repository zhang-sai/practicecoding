import java.util.ArrayList;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 * */
public class SpiralMatrix {

	/**
	 * http://leetcode.com/2010/05/printing-matrix-in-spiral-order.html another
	 * solution without using any extra space
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
				new int[] { 1, 2, 3 },
				new int[] { 8, 9, 4 },
				new int[] { 7, 6, 5 } };
		printSpiralMatrix(matrix);

		System.out.println();

		matrix = new int[][] {
				new int[] { 1, 2, 3, 4 },
				new int[] { 12, 13, 14, 5 }, 
				new int[] { 11, 16, 15, 6 },
				new int[] { 10, 9, 8, 7 } };
		printSpiralMatrix(matrix);
		
		System.out.println();

		matrix = new int[][] {
				new int[] { 1, 2, 3, 4 },
				new int[] { 8, 7, 6, 5 }
				};
		printSpiralMatrix(matrix);
		
		System.out.println();

		matrix = new int[][] {
				new int[] { 1, 2, 3, 4 },
				new int[] { 10, 11, 12, 5 },
				new int[] { 9, 8, 7, 6 }
				};
		printSpiralMatrix(matrix);
	}

	public static void printSpiralMatrix(int[][] matrix) {
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		
		int x = 0;
		int y = 0;
		int xsteps = colNum - 1;
		int ysteps = rowNum - 1;
		
		//this check the condition
		while(xsteps >= 0 && ysteps >= 0) {
			printInternal(matrix, x, y, xsteps, ysteps);
			xsteps = xsteps - 2;
			ysteps = ysteps - 2;
			x++;
			y++;
		}
		
	}

	private static void printInternal(int[][] matrix, int x, int y, int xsteps, int ysteps) {
		if(xsteps == 0 || ysteps == 0) {
			printLinear(matrix, x, y, xsteps, ysteps);
			return;
		}
		for(int i = 0; i < xsteps; i++) {
			System.out.print(matrix[x][y] + " ");
			y++;
		}
		for(int i = 0; i < ysteps; i++) {
			System.out.print(matrix[x][y] + " ");
			x++;
		}
		for(int i = 0; i < xsteps; i++) {
			System.out.print(matrix[x][y] + " ");
			y--;
		}
		for(int i = 0; i < ysteps; i++) {
			System.out.print(matrix[x][y] + " ");
			x--;
		}
	}
	
	private static void printLinear(int[][] matrix, int x, int y, int xsteps, int ysteps) {
		if(xsteps == 0 && ysteps == 0) {
			System.out.println(matrix[x][y]);
			return;
		}
		if(xsteps == 0) {
			for(int i = 0; i < ysteps; i++) {
				System.out.print(matrix[x][y++] + " ");
			}
		} else {
			for(int i = 0; i < xsteps; i++) {
				System.out.print(matrix[x++][y] + " ");
			}
		}
	}

	// here is a recusive way:
	// http://leetcode.com/2010/05/printing-matrix-in-spiral-order.html
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return list;
		}
		int row = matrix.length;
		int column = matrix[0].length;
		boolean[][] flag = new boolean[row][column]; // XXX need some extra
														// space here
		int index = 1;
		int x = 0;
		int y = 0;
		flag[x][y] = true;
		list.add(matrix[x][y]);
		while (index++ < row * column) {
			while (y + 1 < column && !flag[x][y + 1]) {
				y++;
				list.add(matrix[x][y]);
				flag[x][y] = true;
			}
			while (x + 1 < row && !flag[x + 1][y]) {
				x++;
				list.add(matrix[x][y]);
				flag[x][y] = true;
			}
			while (y - 1 >= 0 && !flag[x][y - 1]) {
				y--;
				list.add(matrix[x][y]);
				flag[x][y] = true;
			}
			while (x - 1 >= 0 && !flag[x - 1][y]) {
				x--;
				list.add(matrix[x][y]);
				flag[x][y] = true;
			}
		}

		return list;
	}

	/**
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n2 in spiral order.
	 * 
	 * For example, Given n = 3,
	 * 
	 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7,
	 * 6, 5 ] ]
	 * */
	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] matrix = new int[n][n];
		if (n == 0) {
			return matrix;
		}
		// start
		int x = 0;
		int y = 0;
		matrix[x][y] = 1;
		int i = 2;
		while (i <= n * n) {
			while (y + 1 < n && matrix[x][y + 1] == 0) {
				y++;
				matrix[x][y] = i;
				i++;
			}

			while (x + 1 < n && matrix[x + 1][y] == 0) {
				x++;
				matrix[x][y] = i;
				i++;
			}

			while (y - 1 >= 0 && matrix[x][y - 1] == 0) {
				y--;
				matrix[x][y] = i;
				i++;
			}

			while (x - 1 >= 0 && matrix[x - 1][y] == 0) {
				x--;
				matrix[x][y] = i;
				i++;
			}
		}

		return matrix;
	}
}
