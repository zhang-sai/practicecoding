
public class Fibonacci {

	//discussion see: http://www.ics.uci.edu/~eppstein/161/960109.html
	public int getNum(int num) {
		if(num <=2) {
			return 1;
		}
		int first = 1;
		int second = 1;
		int result = 2;
		for(int i = 3; i < num; i++) {
			first = second;
			second = result;
			result = first + second; //XXX first assign new first, second, then calculate the result
		}
		
		return result;
	}
	
	/**
	 * 1, 1  ^n   =  f(n+1)  f(n)
	 * 1, 0          f(n)    f(n-1)
	 * */
	public int getNumMatrixMulti(int num) {
		if(num <= 2) {
			return 1;
		}
		int[][] matrix = new int[][]{new int[]{1, 1}, new int[]{1, 0}};
		int[][] ms = this.matrixPow(matrix, num - 1);
		return ms[0][0];
	}
	
	public int[][] matrixPow(int[][] m, int n) {
		if(n == 1) {
			return m;
		}
		int[][] m1 = this.matrixPow(m, n/2);
		int[][] ms = new int[2][2];
		ms[0][0] = m1[0][0]*m1[0][0] + m1[0][1]*m1[1][0];
		ms[0][1] = m1[0][0]*m1[0][1] + m1[0][1]*m1[1][1];
		ms[1][0] = m1[1][0]*m1[0][0] + m1[1][1]*m1[1][0];
		ms[1][1] = m1[1][0]*m1[0][1] + m1[1][1]*m1[1][1];
		if(n % 2 == 0) {
			return ms;
		} else {
			int[][] r = new int[2][2];
			r[0][0] = ms[0][0]*m[0][0] + ms[0][1]*m[1][0];
			r[0][1] = ms[0][0]*m[0][1] + ms[0][1]*m[1][1];
			r[1][0] = ms[1][0]*m[0][0] + ms[1][1]*m[1][0];
			r[1][1] = ms[1][0]*m[0][1] + ms[1][1]*m[1][1];
			return r;
		}
	}
	
	public static void main(String[] args) {
		for(int i = 1; i < 10; i++) {
			Fibonacci f = new Fibonacci();
			System.out.println(f.getNum(i) + ",  " + f.getNumMatrixMulti(i));
		}
	}
	
}
