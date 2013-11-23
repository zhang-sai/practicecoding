
//given a sequence number, one number appears more than half, find it out
//what about 1/3??

public class FindHalfOccuranceIds {

	public static int findHalf(int[] a) {
		int candidate = a[0];
		int times = 1;
		for(int i = 1 ; i < a.length; i++ ) {
			if(a[i] == candidate) {
				times++;
			} else {
				if(times==0) {
					candidate = a[i];
					times = 1;
				} else {
					times--;
				}
			}
		}
		return candidate;
	}
	
	public static void main(String[] args) {
		System.out.println(findHalf(new int[]{1, 1, 1, 1, 2, 2 ,2}));
		System.out.println(findHalf(new int[]{2, 2, 2,2, 1, 1, 1, 1, 2, 2 ,2}));
		System.out.println(findHalf(new int[]{1, 1, 1, 1, 2, 2 ,2, 2, 2,2}));
	}
	
}