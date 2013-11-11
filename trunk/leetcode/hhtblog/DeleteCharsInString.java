//http://zhedahht.blog.163.com/blog/static/25411174200801931426484/
public class DeleteCharsInString {
	
	//delete all characters
	//They are student,  aeiou   ==output==> Thy r stdnts

	public static void delete(String src, String dest) {
		boolean[] dict = new boolean[256];
		for(char c : dest.toCharArray()) {
			dict[c] = true;
		}
		//then start to delete
		char[] cs = src.toCharArray();
		int slowIndex = 0;
		int fastIndex = slowIndex;
		while(fastIndex < cs.length) {
			if(dict[cs[fastIndex]]) {
				//contain the char that should be deleted
				//just ignore that
			} else {
				cs[slowIndex] = cs[fastIndex];
				slowIndex++; //point to the next place
			}
			fastIndex++; 
		}
		
		System.out.println();
		for(int i = 0; i < slowIndex; i++) {
			System.out.print(cs[i]);
		}
	}
	
    public static void main(String[] args) {
    	delete("They are student", "aeiou");
    	delete("ffggxx", "aeiou");
    }
	
}
