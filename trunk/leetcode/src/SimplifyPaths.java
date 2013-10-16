import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * Simplify PathApr 4 '12
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 * */
public class SimplifyPaths {
	public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String slash = "/";
        String[] splits = path.split(slash);
        Stack<String> stack = new Stack<String>();
        for(String split : splits) {
            if(split.equals("")) {
                continue;
            }
            if(split.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (split.equals(".")) {
                continue;
            } else {
                stack.push(split);
            }
        }
        String result = "";
        while(!stack.isEmpty()) {
            String p = stack.pop();
            result = "/" +  p + result;
        }
        if(result.length() ==  0) {
            return "/";
        }
        return result;
    }
	
	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		String[] pathsElements = path.split("/");
		for(String p : pathsElements) {
			System.out.println(p);
		}
		
		SimplifyPaths sp = new SimplifyPaths();
		System.out.println(sp.simplifyPath(path));
	}
}
