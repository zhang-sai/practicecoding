//http://www.mitbbs.com/article_t/JobHunting/32586021.html

//the missing number is between 1 - 9999
public class MissingNumberVariants {

	//123456891011  ==> 7
	//9991000100110021004  ==> 1003
	
	public static int findMissingNumber(String str) {
		int length = str.length();
		if(length < 1) {
			return -1;
		}
		for(int num = 1; num <=4; num++) {
			int missingNum = findMissingNumber(str, num);
			if(missingNum != -1) {
				return missingNum;
			}
		}
		throw new Error("String: " + str + " is not valid.");
	}
	
	//the starting digit number
	private static int findMissingNumber(String str, int num) {
		int firstNum = Integer.parseInt(str.substring(0, num));
		int nextNum = firstNum + 1;
		String nextNumStr = String.valueOf(nextNum);
		
		int startIndex = num;
		int missingNum = -1;
		boolean findMissingNum = false;
		
		while(startIndex + nextNumStr.length() <= str.length()) {
			
			String substr = str.substring(startIndex, startIndex + nextNumStr.length());
//			System.out.println("start index: " + startIndex
//					+ ", expected num: " + nextNumStr + ", sub str: " + substr);
			if(substr.equals(nextNumStr)) {
				startIndex = startIndex + nextNumStr.length();
				nextNum ++;
				nextNumStr = String.valueOf(nextNum);
			} else {
				if(findMissingNum) {
					return -1; //illegal combinations
				}
				//suppose we find the missing number
				missingNum = Integer.parseInt(nextNumStr);
				findMissingNum = true;
				nextNum = nextNum + 1;
				nextNumStr = String.valueOf(nextNum);
			}
		}
		
		//illegal 
		if(startIndex != str.length()) {
			return -1;
		}
		
		return missingNum;
		
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(findMissingNumber("123456891011"));
		System.out.println(findMissingNumber("9991000100110021004"));
	}
	
}
