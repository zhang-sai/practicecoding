package basics;

public class StackOverflow {
	
	public static void foo(int num) {
		if(num == 0) {
			return;
		}
		//char 16 bit
		//so it is 64bit == 8 bytes
		//for 8*10000 = 8 00000 bytes = 800 kb
		
		//http://docs.oracle.com/cd/E13150_01/jrockit_jvm/jrockit/jrdocs/refman/optionX.html#wp1024112
		String s = "abcd";
		foo(num-1);
	}

	//java, use Xss to set the stack, its between 64 kB -- 1 MB
	public static void main(String[] args) {
		foo(10000);
	}
	
}
