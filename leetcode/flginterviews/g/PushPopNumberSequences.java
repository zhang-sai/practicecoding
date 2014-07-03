package g;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//http://get-that-job-at-google.blogspot.com/2013/02/rocketfuel-codesprint-at-iit-bombay.html
//http://www.mitbbs.com/article_t/JobHunting/32613553.html


//5,1,4,2,3 this is not possible
//supports only pushFront, pushBack, and popBack.

/**
 * Input: 3,2,1 Output: pushBack,pushBack,pushBack,popBack,popBack,popBack
 * 
 * Input: 1,2,3 Output (note choice of pushBack over pushFront):
 * pushBack,popBack,pushBack,popBack,pushBack,popBack
 * 
 * Input: 4,1,5,2,3 Output (pushFront is needed in some cases):
 * pushBack,pushFront
 * ,pushFront,pushBack,popBack,popBack,pushBack,popBack,popBack,popBack
 * 
 * Input: 5,1,4,2,3 Output (some sequences are impossible): impossible
 * 
 * */

public class PushPopNumberSequences {

	//credit goes to: http://www.mitbbs.com/article_t/JobHunting/32613553.html
	
	/**
	 * Basic algorithm:
	 * 
	 * */
	static List<String> getOps(String seq) {
		List<String> v = new LinkedList<String>();
		int n = seq.length();

		//map from integer_value to its index
		Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			pos.put(seq.charAt(i) - '0', i);
		}

		//create a stack to mimic the whole process
		Stack<Integer> stack = new Stack<Integer>();
		//i is the value which is [1, n]
		//j is the index in the output result
		for (int i = 1, j = 0; i <= n; i++) {
			//Important: the stack top should be popped later than the current i
			if (stack.empty() || pos.get(stack.peek()) > pos.get(i)) {
				stack.push(i);
				v.add("push_back");
			//Important: the stack bottom is popped earlier than the current i, so push front
			} else if (pos.get(stack.get(0)) < pos.get(i)) {  //mimic the front
				stack.add(0, i);  //mimic the front
				v.add("push_front");
			} else {
				v.clear();
				break;
			}

			//check whether the stack can start pop to meet the current j
			while (!stack.empty() && stack.peek() == seq.charAt(j) - '0') {
				stack.pop();
				v.add("pop_back");
				j++;
			}
		}

		return v;
	}

	public static void main(String[] args) {
		System.out.println(getOps("41523"));
		System.out.println(getOps("51423"));
		System.out.println(getOps("321"));
		System.out.println(getOps("123"));
	}

}
