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
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() > 12) { //check max length
            return new ArrayList<String>();
        }
        return restoreIp(s, 0, 4);
    }
    
    public ArrayList<String> restoreIp(String s, int startIndex, int num) {
        ArrayList<String> ips = new ArrayList<String>();
        if(startIndex >= s.length()) {
            return ips;
        }
        
        if(num == 1) {
            String str = s.substring(startIndex);
            if(str.startsWith("0") && str.length() > 1) {
                return ips;
            }
            Integer v = Integer.parseInt(str);  //it may overflow
            if(v <= 255) {
                ips.add(str);
                return ips;
            }
        }
        
        //the possiblity of first character
        ArrayList<String> list1 = restoreIp(s, startIndex + 1, num-1);
        String str = s.substring(startIndex, startIndex+1);
        if(!list1.isEmpty()) {
            for(String ip : list1) {
                ips.add(str + "." + ip);
            }
        }
        
        ArrayList<String> list2 = restoreIp(s, startIndex + 2, num-1);
        if(startIndex + 1 <= s.length() - 1) {
            str = s.substring(startIndex, startIndex+2);
            if(!list2.isEmpty() && !str.startsWith("0")) {
                for(String ip : list2) {
                    ips.add(str + "." + ip);
                }
            }
        }
        
        ArrayList<String> list3 = restoreIp(s, startIndex + 3, num-1);
        if(startIndex + 2 <= s.length() - 1) {
            str = s.substring(startIndex, startIndex+3);
            Integer v = Integer.parseInt(str);  //it may overflow
            if(!list3.isEmpty() && !str.startsWith("0") && v <= 255) {
                for(String ip : list3) {
                    ips.add(str + "." + ip);
                }
            }
        }
        
        return ips;
    }
	
	public static void main(String[] args) {
		RestoreIPAddress r = new RestoreIPAddress();
		ArrayList<String> list = r.restoreIpAddresses("0279245587303");
		System.out.println(list);
	}
}
