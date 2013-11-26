package basics;


public class KthLargestNumberInAArray {

	//two possible solutions
	//1. use a k heap
	//2. use quick partition
	
	public static void main(String[] args) {
		int[] a = new int[]{3, 2, 1, 4, 5, 9, 8, 7, 6, 10};
		for(int i = 1; i < 10; i++) {
			System.out.println(findKthLargest(a, i));
		}
	}

	public static int findKthLargest(int[] nums, int k) {
		if(k<1 || k > nums.length) {
			return -1;
		}
		return findKthLargest(nums, 0, nums.length - 1, k);
	}
	
	public static int findKthLargest(int[] nums, int start, int end, int k) {
		int pivot = start;
		int left = start;
		int right = end;
		while(left <= right) {
			while(left <= right && nums[left] <= nums[pivot]) {
				left++;
			}
			while(left <= right && nums[right] >= nums[pivot]) {
				right--;
			}
			if(left < right) {
				swap(nums, left, right);
			}
		}
		//after the loop, the correct pivot should rely on right's position
		//
		swap(nums, pivot, right);
		
		if(k == right + 1) {
			return nums[right];
		} else if (k > right + 1) {
			return findKthLargest(nums, right+1, end, k);
		} else {
			return findKthLargest(nums, start, right-1, k);
		}
	}
	
	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
