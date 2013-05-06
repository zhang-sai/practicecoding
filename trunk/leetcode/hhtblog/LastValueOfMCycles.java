import java.util.List;


/**
 * http://zhedahht.blog.163.com/blog/static/2541117420072250322938/
 * */
public class LastValueOfMCycles {

	//repeatedly delete the m-th value in a list
	//and get the remaining value
	public int getRemainingValue(List<Integer> vals, int m) {
		if(m <= 0 || vals.size() == 0) {
			throw new Error();
		}
		if(vals.size() == 1) {
			return vals.get(0);
		}
		//repeatedly delete the vals
	}
}
