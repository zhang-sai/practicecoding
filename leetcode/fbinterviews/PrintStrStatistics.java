/**
 * print the number of words, characters, and line number
 * */
public class PrintStrStatistics {

	public void printNum(String line) {
		char br = '\n';
		int numOfWords = 0;
		int numOfChars = 0;
		int numOfLines = line.isEmpty() ? 0 : 1;
		
		boolean inAWord = false;
		
		for(char c : line.toCharArray()) {
			if(isAlpha(c)) {
				if(!inAWord) {
					inAWord = true;
				}
				numOfChars++;
			} else {
				if(c == br) {
					numOfLines++;
				}
				if(inAWord) {
					inAWord = false;
					numOfWords++;
				}
			}
		}
		
		System.out.println(numOfWords + ",  " + numOfChars + ", " + numOfLines);
	}
	
	public boolean isAlpha(char c) {
		return (c>='a' && c <= 'z') || (c>='A' && c <= 'Z');
	}
	
	public static void main(String[] args) {
		PrintStrStatistics p = new PrintStrStatistics();
		String str = "i like a \n dog cat \n cow ";
		p.printNum(str);
	}
}
