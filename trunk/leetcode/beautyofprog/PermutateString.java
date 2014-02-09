
public class PermutateString {

	public static void main(String[] args) {
		String str = "1234";
		permute(str.toCharArray(), 0);
	}
	
	/**
	 * Basic idea, either move the current index to the next, or do swap first, then go to the next
	 * */
	public static void permute(char[] chars, int curr) {
//		
		if(curr == chars.length - 1) {
		    System.out.println(new String(chars));
		    return;
		}
		
		permute(chars, curr + 1);
		
		for(int i = curr + 1; i < chars.length; i++) {
			//swap
			swap(chars, i, curr);
			permute(chars, curr + 1);
			//swap back
			swap(chars, i, curr);
		}
	}
	
	private static void swap(char[] chars, int i, int curr) {
		char tmp = chars[i];
		chars[i] = chars[curr];
		chars[curr] = tmp;
	}
	
}
