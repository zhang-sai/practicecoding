import java.util.LinkedList;
import java.util.List;


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
        if(path == null) {
        	return "";
        }
        if(path.length() == 0) {
        	return path;
        }
        String[] pathsElements = path.split("/");
        
        List<String> paths = new LinkedList<String>();
        for(String p : pathsElements) {
        	if(p.length() == 0) {
        		continue;
        	}
        	if(p.equals(".")) {
        		continue;
        	} else if(p.equals("..")) {
        		if(paths.isEmpty()) {
        			continue; //XXX there is no illegal path
        			//if the path cannot be lifted, just do nothing
        		} else {
        		    paths.remove(paths.size() - 1);
        		}
        	} else {
        		paths.add(p);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String p : paths) {
        	sb.append("/");
        	sb.append(p);
        }
        
        if(sb.length() == 0) {
        	sb.append("/");
        }
        
        return sb.toString();
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
