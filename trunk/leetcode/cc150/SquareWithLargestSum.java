
//find the largest subsquare with the max sum
public class SquareWithLargestSum {

	
	public static int findSquareValue(int[][] board) {
		int rowNum = board.length;
		int colNum = board[0].length;
		
		
		
		//for each row, compute the sum from i -> j
		int[][][] sums = new int[rowNum][colNum][colNum];
		//fill in this cube
		for(int row = 0; row < rowNum; row++) {
			for(int step = 0; step < colNum; step++) {
				for(int startcol = 0; startcol < colNum; startcol ++) {
					int endcol = startcol + step;
					if(endcol >= colNum) {
						break;
					}
					if(startcol == endcol) {
						sums[row][startcol][endcol] = board[row][startcol];
					} else {
						sums[row][startcol][endcol] = 
							sums[row][startcol][endcol-1] + board[row][endcol];
					}
					
				}
			}
		}
		
		int globalmax = Integer.MIN_VALUE;
		int cStart = -1;
		int cEnd = -1;
		
		int[][] rowStart = new int[colNum][colNum];
		int[][] rowEnd = new int[colNum][colNum];
		
		//then try to compute the local maximum
		//the max rectange if column i to j has been included
		int[][] maxValues = new int[colNum][colNum];
//		rStart = 0;
//		int currStart = -1;
		for(int row = 0; row < rowNum; row++) {
			for(int startcol = 0; startcol < colNum; startcol++) {
				for(int endcol = startcol; endcol < colNum; endcol++) {
					boolean reset = false;
					if(maxValues[startcol][endcol] < 0) {
						maxValues[startcol][endcol] = sums[row][startcol][endcol];
						reset = true;
						//reset the rStart
//						currStart = row;
						
					} else {
						maxValues[startcol][endcol] =
							maxValues[startcol][endcol] + sums[row][startcol][endcol];
						
					}
					//reassign
					if(maxValues[startcol][endcol] > globalmax) {
						globalmax = maxValues[startcol][endcol];
						//update columns
						cStart = startcol;
						cEnd = endcol;
						
						if(reset) {
							rowStart[startcol][endcol] = row; 
						}
						rowEnd[startcol][endcol] = row;
						
						//update the end row
//						rEnd = row;
//						if(currStart != -1 ) {
//							rStart = currStart;
//						}
					}
				}
			}
		}
		
		System.out.println("Rows: " + rowStart[cStart][cEnd] + ",  " + rowEnd[cStart][cEnd]);
		System.out.println("Columns: " + cStart + ",  " + cEnd);
		
		return globalmax;
	}
	
	public static void main(String[] args) {
		int[][] board = new int[][] {
				new int[]{1,   2,   3,   4,    5,  7},
				new int[]{-1,  -1,  -2, -3,   -9,  10},
				new int[]{12,  32,  3,   4,   5,   -70},
				new int[]{19,  -32, 3,   4,   55,  -70},
				new int[]{-23, -32, 99,  99,  -40, -70}
		};
		System.out.println(findSquareValue(board));
	}
	
}
