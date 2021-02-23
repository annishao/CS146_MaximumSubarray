package cs146F20.shao.project2;

public class BruteForce {
	private int max;
	private int arrival;
	private int departure;
	private int[] result;
	
	public BruteForce() {
		result = new int[3];
		max = 0;
		arrival = 0;
		departure = -1;
	}
	
	// Finds the maximum subarray given an array using brute force - 0(n^2).
	// Returns an array containing sum, arrival date, and departure date respectively.
	public int[] findMaxSubarray(int[] array) {
		// Max should be initialized as the first element of the array.
		max = array[0];
		
		// Creates 2 for loops to check every arrive/leave pair compared to the max.
		for(int i = 0; i < array.length; i++) {
			// Initializes the value of the arrive/leave pair to an element in the array.
			int value = 0;
				
			for(int j = i; j < array.length; j++) {
				// Adds element at index j to the value of the arrive/leave pair.
				value += array[j];
				
				// If value is larger than the currently recorded largest value of the subarray, 
				// updates the max variable and arrival and departure
				// dates accordingly.
				if(value > max) {
					max = value;
					arrival = i;
					departure = j;
				}
			}
		}
			
		// Adds the correct values to the result array.
		this.updateReturn();
		
		// Returns the array with the desired data.
		return result;
	}
	
	// Helper method to add sum, arrival day, and departure day 
	// respectively to the result array.
	// If sum is negative, sum should be 0, arrival day is 0, and departure is -1.
	private void updateReturn() {
		if(max < 0) {
			result[0] = 0;
			result[1] = 0;
			result[2] = -1;
		} else {
			result[0] = max;
			result[1] = arrival;
			result[2] = departure;
		}
	}
}
