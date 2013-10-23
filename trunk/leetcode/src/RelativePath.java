/**
 * a = '/a/b/c/d/e.php';
   b ='/a/b/12/34/c.php';
 ../../c/d
 
 the path is from b to a
 * */
public class RelativePath {

	//need to simply the path first
	public static void main(String[] args) {
		RelativePath r = new RelativePath();
		System.out.println(r.relativePath("/a/b/12/34/c.php", "/a/b/c/d/e.php"));
	}
	
	public String relativePath(String src, String dest) {
		String[] srcSplits = src.split("/");
		String[] destSplits = dest.split("/");
		
		String rest = "";
		
		int i = 0; int j = 0;
		while(i < srcSplits.length - 1 && j < destSplits.length - 1) {
			if(!srcSplits[i].equals(destSplits[j])) {
				rest = "../" + rest;
				rest = rest + (rest.endsWith("/") ? destSplits[j] : "/" + destSplits[j]);
			}
			i++;
			j++;
		}
		
		while(i < srcSplits.length - 1) {
			rest = "../" + rest;
			i++;
		}
		
		if(j < destSplits.length - 1) {
			rest = rest + (rest.endsWith("/") ? destSplits[j] : "/" + destSplits[j]);
			j++;
		}
		
		return rest;
	}
	
}
