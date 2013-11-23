
//given a binary representation, count the number of 1
//e.g., 00010011 ==> 3
public class CountTheNumberOf1 {

	public int count(int v) {
		int num = 0;
		while(v != 0) {
			v =  v&(v-1);
			num++;
		}
		return num;
	}
	
}
