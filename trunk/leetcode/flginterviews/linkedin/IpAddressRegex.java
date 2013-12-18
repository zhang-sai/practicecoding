package linkedin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a file using regex find all the ip address ina text file.
 * 
 * http://www.careercup.com/question?id=16388662
 * */
public class IpAddressRegex {

	//a1: ips = re.findall(r' [0-255](.[0-255]){3}', text)
	
	//a2: \b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\b
	
	
	
	public static void main(String[] args) {
		String regex = 
		"^(\\d?\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\." +
		"(\\d?\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\." +
		"(\\d?\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\." +
		"(\\d?\\d|1\\d\\d|2[0-4]\\d|25[0-5])$";
		
		Pattern pattern = Pattern.compile(regex);
		
		String ip = "0.0.0.0";
		Matcher matcher = pattern.matcher(ip);
		System.out.println("Input String matches regex - " + matcher.matches());
		
		ip = "255.255.255.255";
		matcher = pattern.matcher(ip);
		System.out.println("Input String matches regex - " + matcher.matches());
		
		ip = "1.1.1.1";
		matcher = pattern.matcher(ip);
		System.out.println("Input String matches regex - " + matcher.matches());
		
		ip = "128.1.192.255";
		matcher = pattern.matcher(ip);
		System.out.println("Input String matches regex - " + matcher.matches());
		
		ip = "256.2.1.1";
		matcher = pattern.matcher(ip);
		System.out.println("Input String matches regex - " + matcher.matches());
		
		ip = "-1.1.0.0";
		matcher = pattern.matcher(ip);
		System.out.println("Input String matches regex - " + matcher.matches());
		
		for(int i = 0; i <= 255; i++) {
			for(int j = 0; j <= 255; j++) {
				ip = i + "." + j + ".255";
				matcher = pattern.matcher(ip);
				if(matcher.matches()) {
					throw new Error(ip);
				}
				ip = "255." + i + "." + j;
				matcher = pattern.matcher(ip);
				if(matcher.matches()) {
					throw new Error(ip);
				}
			}
		}
		// bad regular expression
//		pattern = Pattern.compile("*xx*");
	}
}
