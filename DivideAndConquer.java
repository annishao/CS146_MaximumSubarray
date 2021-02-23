package cs146F20.shao.project2;

public class DivideAndConquer {
	private int[] array;
	
	public DivideAndConquer(int[] array) {
		this.array = array;
	}
	
	// Finds the maximum subarray using divide and conquer - O(nlgn).
	// Returns an array containing sum, arrival date, and departure date respectively.
	public int[] findMaxSubarray(int low, int high) {
		// Initializes array that returns the desired data.
		int[] result = new int[3];
		
		// Base case: return if low and high are the same index.
		if(low == high) {
			result[0] = array[low];
			result[1] = low;
			result[2] = high;
			return result;
		}
		// Declares midpoint of array.
		int mid = (low + high) / 2;
		
		// Finds the maximum value of left subarray, right subarray, and 
		// subarray crossing the midpoint.
		int[] maxSumLeft = findMaxSubarray(low, mid);
		int[] maxSumRight = findMaxSubarray(mid + 1, high);
		int[] maxCross = findMaxCross(low, mid, high);
		
		// Returns the largest maximum value of the 3 subarrays.
		return this.findLargestValue(maxSumLeft, maxSumRight, maxCross);
		}
	
	// Helper method that finds the maximum value of the subarray 
	// crossing the midpoint.
	// Returns an array containing sum, arrival date, and departure date respectively.
	private int[] findMaxCross(int low, int mid, int high) {
		// Initializes array that returns the desired data.
		int[] result = new int[3];
		
		// Declares maximum value of left subarray.
		int[] maxLeft = findMaxLeft(low, mid);
		
		// Declares maximum value of right subarray.
		int[] maxRight = findMaxRight(mid + 1, high);
		
		// Finds maximum value of the subarray crossing the midpoint.
		int maxCross = maxLeft[0] + maxRight[0];
		
		// Updates the sum.
		result[0] = maxCross;
		// Updates the arrival date.
		result[1] = maxLeft[1];
		// Updates the departure date.
		result[2] = maxRight[1];
		
		// Returns an array containing departure value, arrival value, and 
		// maximum value of subarray crossing the midpoint.
		return result;
	}
	
	// Helper method that finds the maximum value of the left subarray.
	// Returns an array containing sum and arrival date respectively.
	private int[] findMaxLeft(int low, int high) {
		// Initializes maxLeftSum to the smallest possible integer value.
		int maxLeftSum = Integer.MIN_VALUE;
		// Initializes leftSum to 0.
		int leftSum = 0;
		// Initializes the day of departure for left subarray.
		int leftIndex = high;
		// Initializes array that returns the desired data.
		int[] result = new int[2];
		
		for(int i = high; i >= low; i--) {
			// Adds elements of the array to the subarray.
			leftSum += array[i];
			
			// If leftSum is larger than maxLeftSum,
			// then change value of maxLeftSum to leftSum.
			if(leftSum > maxLeftSum) {
				maxLeftSum = leftSum;
				leftIndex = i;
			}
		}
		
		// Updates sum.
		result[0] = maxLeftSum;
		// Updates the index (arrival date).
		result[1] = leftIndex;
		return result;
	}
	
	// Helper method that finds the maximum value of the right subarray.
	// Returns an array containing sum and departure date respectively.
	private int[] findMaxRight(int low, int high) {
		// Initializes maxRightSum to the smallest possible integer value.
		int maxRightSum = Integer.MIN_VALUE;
		// Initializes rightSum to 0.
		int rightSum = 0;
		// Initializes departure day for the right subarray.
		int maxRight = low;
		// Initializes the array that returns the desired data.
		int[] result = new int[2];
		
		for(int j = low; j <= high; j++) {
			// Adds elements of the array to the subarray.
			rightSum += array[j];
			
			// If rightSum is larger than maxRightSum,
			// then change value of maxRightSum to rightSum.
			if(rightSum > maxRightSum) {
				maxRightSum = rightSum;
				maxRight = j;
			}
		}
		
		// Updates the sum.
		result[0] = maxRightSum;
		// Updates the index (departure date).
		result[1] = maxRight;
		return result;
	}
	
	// Helper method that returns the array with 
	// the largest value in the first index (max sum) given 3 array inputs.
	private int[] findLargestValue(int[] array1, int[] array2, int[] array3) {
		int sum1 = array1[0];
		int sum2 = array2[0];
		int sum3 = array3[0];
		
		// Special case: if all values are negative.
		if(sum1 < 0 && sum2 < 0 && sum3 < 0) {
			int[] negativeCase = new int[3];
			negativeCase[0] = 0;
			negativeCase[1] = 0;
			negativeCase[2] = -1;
			return negativeCase;
		}
		
		// Returns the array with the largest sum.
		if(sum1 > sum2 && sum1 > sum3) {
			return array1;
		} else if(sum2 > sum1 && sum2 > sum3) {
			return array2;
		} else {
			return array3;
		}
	}
}