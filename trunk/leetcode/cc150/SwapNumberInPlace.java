
public class SwapNumberInPlace {

	// 0 ________b__(diff)______a
	
	//without using any extra space
	public void swap(int a, int b) {
		int diff = a - b;
		b = b + diff;
		a = b - diff;
	}
	
}
