
public class FindSquareSumNumbers {

	//http://www.mitbbs.com/article_t/JobHunting/32633071.html
	
	//given a number N, find all k that <=N, such that k = a^2 + b^2
	
	public static void printAll(int N) {
		boolean[] flags = new boolean[N + 1];
		int upbound = (int)Math.sqrt(N) + 1;
		for(int a = 1; a <= upbound; a++) {
			for(int b = a; b <= upbound; b++) {
				int r = a*a + b*b;
				if(r <= N) {
					//65 = 4^2 + 7^2
					//65 = 8^2 + 1^2
					if(flags[r]) {
						throw new Error("Exit a flag: " + r + " = " + a + "^2 + " + b + "^2");
					}
					System.out.println(r + " = " + a + "^2 + " + b + "^2");
					flags[r] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		printAll(100);
	}
	
	/**
	 * (defn find-k [n]
  (let [s (int (Math/sqrt n))]
    (distinct
      (for [a (range 1 (inc s))
            b (range a (inc s))
            :let [c (+ (* a a) (* b b))]
            :when (<= c n)]
        c))))
	 * 
	 * */
	
	//some property: a + b = c
	//so a^2 + b^2 < c^2
	//if c is odd, must be both odd, or both even
	//if c is even, must be one odd, one even
	
}
