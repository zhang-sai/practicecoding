
/**
 * It should be elevation:
 *   design the place that an evaluation should stop, which minimize the number of floors that each employee
 *   should climb.
 * 
 * Stop the evaluation on a certain flow, to minimize the steps every one need to take
 * */
public class Elevation {

	public static void main(String[] args) {
		getSteps(new int[]{0, 1, 3, 5, 3, 3});
	}
	
	//persons start with 1
	public static int getSteps(int[] persons) { //the number of person on every flow {
		int minFloor = 0;
		
		//stop at the first floor
		int n1 = 0;  //living below the current floor
		int n2 = persons[1]; //living on the current floor
		int n3 = 0; //people living above of the current floor
		
		int targetFloor = 1;
		
		for(int i = 2; i < persons.length; i++) {
			n3 +=  persons[i];
			minFloor = minFloor + (i-1)*persons[i];
		}
		
		
		
		//stop at the i-thh floor, starting from 2
		for(int i = 2; i < persons.length; i++) {
			if(n1 + n2 < n3) {
				
				//since n1 + n2 is keep increasing
				//there must be some point that n1 + n2 > n3
				targetFloor = i;
//				minFloor = (n1 + n2 - n3);
				minFloor = minFloor + (n1 + n2) - n3;
				n1 += n2;
				n2 = persons[i];
				n3 -= persons[i];
				
			} else {
				break;
			}
		}
		
		System.out.println("target floor: " + targetFloor + ", min floor: " + minFloor);
		
		return minFloor;
    }
	
}
