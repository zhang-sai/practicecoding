package basics;

import java.util.ArrayList;


/**
 * 
 * given an array of 32-bit integers, the array is already sorted according
to the most significant 28bits, sort the array in O(n)

(just use four radix sort)

the basic idea is to use radix sort
 * */

public class RadixSort {

	public void radixSort(int arr[], int maxDigits){
		int exp = 1;//10^0;
		for(int i =0; i < maxDigits; i++){
			//create a number of bucket
			ArrayList<Integer> bucketList[] = new ArrayList[10];
			for(int k=0; k < 10; k++){
				bucketList[k] = new ArrayList<Integer>();
			}
			//get that number
			for(int j =0; j < arr.length; j++){
				int number = (arr[j]/exp)%10; //put to the right bucket
				bucketList[number].add(arr[j]);
			}
			exp *= 10;
			int index =0;
			for(int k=0; k < 10; k++){
				for(int num: bucketList[k]){
					arr[index] = num;
					index++;
				}
			}
			
			System.out.println("pass: ");
			for(int in =0; in < arr.length; in++){
				System.out.print(arr[in] +", ");
			}
		}

		System.out.println("Sorted numbers");
		for(int i =0; i < arr.length; i++){
			System.out.print(arr[i] +", ");
		}
	}

	public static void main(String[] argv){
		int n = 5;
		int arr[] = {1,4,2,3,5,10,8};
		new RadixSort().radixSort(arr, 2);
	}
}
