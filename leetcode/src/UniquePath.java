
/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 * */
public class UniquePath {

	public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m == 0 || n == 0) {
            return 0;
        }
        if(m == 1 || n== 1) {
            return 1;
        }
        int[][] paths = new int[m][n];
        for(int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m-1][n-1];
    }
	
}
