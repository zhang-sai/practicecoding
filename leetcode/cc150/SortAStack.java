import java.util.Stack;


/**
 * Sort a stack with another stack
 * */
public class SortAStack {

	//use another stack
	
	public static void sortStack(Stack<Integer> s) {
		Stack<Integer> tmp = new Stack<Integer>();
		tmp.push(s.pop());
		
		//if the original stack has some element
		while(!s.isEmpty()) {
			Integer v = s.pop();
			while( !tmp.isEmpty() && v > tmp.peek()) {
				s.push(tmp.pop());
			}
			tmp.push(v);
		}
		
		//go back to s
		while(!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
		
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(3);
		s.push(2);
		s.push(10);
		s.push(7);
		s.push(6);
		s.push(11);
		s.push(8);
		s.push(9);
		sortStack(s);
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	
}