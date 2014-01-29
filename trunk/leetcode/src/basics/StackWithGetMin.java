package basics;

import java.util.Stack;

public class StackWithGetMin {

	public static void main(String[] args) {

	}

}

class DoubleStackGetMin {

	Stack<Integer> elements = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	void push(int x) {
		elements.push(x);
		if (minStack.empty() || x <= minStack.peek())
			minStack.push(x);
	}

	Integer pop() {
		if (elements.empty()) {
			throw new Error();
		}
		Integer element = elements.pop();

		if (element == minStack.peek()) {
			minStack.pop();
		}

		return element;
	}

	Integer getMin() {
		if (minStack.empty()) {
			throw new Error();
		} else {
			Integer min = minStack.peek();
			return min;
		}
	}
}

class SingleFastMinStack {
	private Stack<Integer> stack = new Stack<Integer>();
	// Could pass this in to the constructor

	private Integer currentMin;

	public Integer getMinimum() {
		return currentMin;
	}

	// [bottom of stack: currentMin element
	public void push(Integer element) {
		if (stack.size() == 0 || element <= currentMin) {
			stack.push(currentMin);
			stack.push(element);
			currentMin = element;
		} else {
			stack.push(element);
		}
	}

	public Integer pop() {
		Integer ret = stack.pop();
		if (ret == currentMin) {
			currentMin = stack.pop();
		}
		return ret;
	}
}