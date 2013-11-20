package basics;

public class SqrtFloat {
	
	public double sqrt(double x) {
		double delta = 0.00000000001d;
		if(x < 0) {
			throw new Error();
		}
		if(x == 0d || x == 1.0d) {
			return x;
		}
		
		
		if(x > 1.0d) {
			double start = 1.0d;
			double end = x;
			//the answer must be between 1.0d and x
			double ret = (start + end) /2;
			
			while(Math.abs(ret*ret - x) > delta) {
				if(ret*ret > x) {
					end = ret;
					ret = (start + end)/2;
				} else {
					start = ret;
					ret = (end + start)/2;
				}
			}
			return ret;
		} else {
			double start = 1.0d;
			double end = x;
			//the answer must be between 1.0d and x
			double ret = (start + end) /2;
			while(Math.abs(ret*ret - x) > delta) {
				if(ret*ret > x) {
					start = ret;
					ret = (start + end)/2;
				} else {
					end = ret;
					ret = (end + start)/2;
				}
			}
			return ret;
		}	
	}
	
	//a test driver
	public static void main(String[] args) {
		SqrtFloat sf = new SqrtFloat();
		
		double start = 0.0d;
		double delta = 0.1d;
		double e = 0.000000001d;
		for(int i = 0; i < 100; i++) {
			double v = start + delta*i;
			double sqrtv = Math.sqrt(v);
			double computed = sf.sqrt(v);
			if(Math.abs(sqrtv - computed) > e) {
				System.err.println("value: " + v
						+ ", computed: " + computed + ", real: " + sqrtv);
			}
		}
	}
}
