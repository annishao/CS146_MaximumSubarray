package cs146F20.shao.project2;

public class KadaneAlgorithm {
	// No constructor needed! No instance variable so no need to initialize anything.
	
	// Finds the maximum subarray using Kadane's algorithm - O(n).
	// Returns array containing sum, arrival date, and departure date respectively.
	public int[] findMaxSubarray(int[] array) {
		// Initializes array that returns the desired data.
		int[] result = new int[3];
		
		// Initializes variables.
		int maxSum = 0;
		int maxTemp = 0;
		int arrive = 0;
		int tempArrive = 0;
		int depart = -1;
		
		for(int i = 0; i < array.length; i++) {
			// Adds element of index i to maxTemp.
			maxTemp += array[i];
			
			// If maxTemp is negative, reset maxTemp to 0
			// and increment the arrival day by 1.
			if(maxTemp < 0) {
				maxTemp = 0;
				arrive = i + 1;
			}
			
			// If maxTemp is greater than maxSum, 
			// update maxSum to maxTemp. The departure day is updated to index
			// and temporary arrival day is updated to arrive.
			if(maxSum < maxTemp) {
				maxSum = maxTemp;
				depart = i;
				tempArrive = arrive;
			}
		}
		
		// Updates arrive variable to tempArrive.
		arrive = tempArrive;
		
		// Returns the result array with the desired data.
		result[0] = maxSum;
		result[1] = arrive;
		result[2] = depart;
		
		// Returns the array with the desired data.
		return result;
	}
}
