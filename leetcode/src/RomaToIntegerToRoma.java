public class RomaToIntegerToRoma {
	/**
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * */

	
	/**
	 * III --> 3
	 * IIII --> 4
	 * V --> 5
	 * VI --> 6
	 * VII --> 7
	 * VIII --> 8
	 * IX --> 9
	 * */
	public int romanToInt(String s) {
		int result = 0;
		if (s.length() != 0) {
			int prev = getDigit(s.charAt(s.length() - 1));
			result += prev;
			/**
			 * a roman string:  s1 s2
			 * 
			 * if s1 > prev  then result = result + s1
			 * if s1 <= prev  then result = result - s1 
			 * */
			for (int i = s.length() - 2; i >= 0; i--) {
				int d = getDigit(s.charAt(i));
				if (d < prev) {
					result -= d;
				} else if (d >= prev) {
					result += d;
				}
				prev = d;
			}
		}
		return result;
	}

	private int getDigit(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	/**
	 * Given an integer, convert it to a roman numeral.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * */
	public String intToRoman(int num) {
		String a[][] = {
				//1 -- 9
				{ "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				//10, 20, 30, 40, 50, 60, 70, 80, 90
				{ "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				//100, -- 900
				{ "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				//1000 -- 3000
				{ "M", "MM", "MMM", "", "", "", "", "", "" } };
		String result = "";
		int key = 0;
		while (num != 0) {
			//compute each part
			int d = num - num / 10 * 10;  //d is the remaining part of 1-- 9
			if (d != 0) {
				result = a[key][d - 1] + result;
			}
			//599 --> 59 --> 5
			num /= 10;
			key++;
		}
		return result;
	}
}
