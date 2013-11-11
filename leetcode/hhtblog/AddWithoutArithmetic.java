//http://zhedahht.blog.163.com/blog/static/254111742011125100605/
public class AddWithoutArithmetic {

	static int addWithoutArithmetic(int num1, int num2) {
		if(num1 == 0) {
            return num2;
		}
		if(num2 == 0) {
			return num1;
		}

		//the sum
        int sum = num1 ^ num2;
        
        //the carrier
        int carry = (num1 & num2) << 1; //only when both bits are 1, so goes to the next bit

        return addWithoutArithmetic(sum, carry);
	}
	
	public static void main(String[] args) {
		System.out.println(addWithoutArithmetic(1, 3));
	}
	
}
