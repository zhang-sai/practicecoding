/**
 *  convert number to english e.g 101 -> one hundred and one
 *  
 *  less than six digits
 * */

public class DigitToEnglish {

	static String[] lessThanTen = new String[]{"zero", "one", "two", "three", "four", "five", "six",
			"seven", "eight", "nine"};
	static String[] tens = new String[] {"", "ten", "twenty", "thirty", "fourty",
			"fifty", "sixty", "seventy", "eighty", "ninety"};
	static String[] tenToTwenty = new String[] {"ten", "eleven", "twelve", "thirteen", "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] hundreds = new String[]{"hundred", "thousand"};
	
	public static String say(int number) {
		int thousands = number/1000;
		int rest = number - 1000*thousands;
		String result = "";
		if(thousands > 0) {
			result += sayLessThousand(thousands) + " thousand ";
		}
		if(rest > 0 && result.length() > 0) {
			result += result + " and ";
		}
		result += sayLessThousand(rest);
		return result;
	}
	
	public static String sayLessThousand(int number) {
		if(number < 10) {
			return lessThanTen[number];
		} else if (number < 20) {
			return tenToTwenty[number-10];
		} else if (number < 100) {
			int num = number/10;
			int rest = number - 10*num;
			return tens[num] + (rest == 0 ? "" : " " + sayLessThousand(rest));
		} else {
			int num = number/100;
			int rest = number - 100*num;
			return lessThanTen[num] + " hundred" + (rest == 0 ? "" : " and " + sayLessThousand(rest));
		}
	}
	
	public static void main(String[] args) {
//		for(int i = 0; i < 100; i++) {
//		    System.out.println(say(i));
//		}
		System.out.println(say(987));
	}
	
}
