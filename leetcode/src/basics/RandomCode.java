package basics;

public class RandomCode {
	
	int seed = 0;
	
	long curr = -1;
	
	static long value = 281474976710656l;

	public long next() {
		if(curr == -1) {
			curr = seed >> value;
		} else {
			curr = (25214903917l* curr + 11)%value; 
		}
		return curr;
	}
	
	public static void main(String[] args) {
		RandomCode rc = new RandomCode();
		System.out.println(rc.next());
		System.out.println(rc.next());
		System.out.println(rc.next());
		System.out.println(rc.next());
		System.out.println(rc.next());
		System.out.println(rc.next());
		System.out.println(rc.next());
	}
	
}
