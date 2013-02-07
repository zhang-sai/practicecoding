import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * */
public class RestoreIPAddress {
	public ArrayList<String> restoreIpAddresses(String s) {
		if(s == null || s.isEmpty()) {
			return new ArrayList<String>();
		}
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> list =  this.restoreIpAddresses(s, 4);
		if(list == null) {
			return new ArrayList<String>();
		} else {
			return list;
		}
    }
	
	private Integer parseIntegerNoExp(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Throwable e) {
			return -1;
		}
	}
	
	private ArrayList<String> restoreIpAddresses(String s, int num) {
		
//		System.out.println("string: " + s + "  -- num: " + num);
		if(s.isEmpty()) {
			return null;
		}
		//the case of only 1 num
		if(num == 1) {
			if(s.length() > 1 && s.startsWith("0")) { //XXX add this constraint
				return null;
			}
			ArrayList<String> list = new ArrayList<String>();
			int address = parseIntegerNoExp(s);
			if(address >= 0 && address < 256) {
				list.add(s);
				return list;
			} else {
				return null;
			}
		} else {
			//for the current address part, either 1 digit or 2 digit or 3 digit
			//some tricks can be employed to remove some possibilities here
			String firstDigit =  s.substring(0, 1);
//			if(Integer.parseInt(firstDigit) == 0) {
//				return null;
//			} else 
			{
				ArrayList<String> list = new ArrayList<String>();
				
				ArrayList<String> restAddresses = this.restoreIpAddresses(s.substring(1), num - 1);
				if(restAddresses != null) {
					for(String addr : restAddresses) {
						list.add(firstDigit + "." + addr);
						//do not return here
					}
				}
				
				String firstTwoDigits = s.length() > 1 ? s.substring(0, 2) : null;
				if(firstTwoDigits != null && !firstDigit.equals("0")) { //XXX add this constraint
					restAddresses = this.restoreIpAddresses(s.substring(2), num - 1);
					if(restAddresses != null) {
					    for(String addr : restAddresses) {
						    list.add(firstTwoDigits + "." + addr);
					    }
					}
				}
				
				String firstThreeDigits = s.length() > 2 ? s.substring(0, 3) : null;
				if(firstThreeDigits != null && !firstDigit.equals("0")) {
					if(Integer.parseInt(firstThreeDigits) < 256) {
					    restAddresses = this.restoreIpAddresses(s.substring(3), num - 1);
					    if(restAddresses != null) { 
					        for(String addr : restAddresses) {
						        list.add(firstThreeDigits + "." + addr);
					        }
					    }
					}
				}
				
				if(list.isEmpty()) {
					return null;
				}
				
				return list;
			}
		}
	}
	
	public static void main(String[] args) {
		RestoreIPAddress r = new RestoreIPAddress();
		ArrayList<String> list = r.restoreIpAddresses("0279245587303");
		System.out.println(list);
	}
}
