//http://zhedahht.blog.163.com/blog/static/2541117420073993725873/
//similarly rotate words: http://zhedahht.blog.163.com/blog/static/254111742007289205219/


//abcdef  -> rotation 2  --> cdefab

//here is a trick
//abcdef  ->  ba  cdef -> ba  fedc --> cdef ab

public class RotateAString {

	public static String rotate(String str, int step) {
		if(str.length() <= 1) {
			return str;
		}
		step = step % str.length();
		if(step == 0) {
			return str;
		}
		//start to rotate
		char[] cs = str.toCharArray();
		reverse(cs, 0, step - 1);
		reverse(cs, step, cs.length - 1);
		reverse(cs, 0, cs.length - 1);
		return new String(cs);
	}
	
	public static void reverse(char[] cs, int start, int end) {
		while(start < end) {
			char tmp = cs[start];
			cs[start] = cs[end];
			cs[end] = tmp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		String str = "abcdef";
		System.out.println(rotate(str, 2));
	}
	
}
