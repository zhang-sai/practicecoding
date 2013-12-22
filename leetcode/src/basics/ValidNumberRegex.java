package basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//http://leetcode.com/onlinejudge#question_65
//good explanation: http://n00tc0d3r.blogspot.com/search?q=number+expression
public class ValidNumberRegex {

	//http://n00tc0d3r.blogspot.com/?view=classic
	public static void main(String[] args) {
		String regex = 
			"^\\s*" + //headiing space
			"[+-]?" + //a sign
			//three possibilities
			"(\\d+|" + //just a normal number like 2233, 0044
			"\\d*\\.\\d+|" +  //.444
			"\\d+\\.\\d*)" +  //44.   //must separete, since there is no: .
			"([eE][+-]?\\d+)?" + //the exp
			"\\s*$"; //trailing space
			
			Pattern pattern = Pattern.compile(regex);
			
			String num = "+1";
			Matcher matcher = pattern.matcher(num);
			System.out.println(num + " matches regex - " + matcher.matches());
			
			num = "-1.0";
			matcher = pattern.matcher(num);
			System.out.println(num + " matches regex - " + matcher.matches());
			
			num = "-01.0"; //this is OK
			matcher = pattern.matcher(num);
			System.out.println(num + " matches regex - " + matcher.matches());
	}
}
