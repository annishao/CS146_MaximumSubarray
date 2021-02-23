package cs146F20.shao.project2;

import java.util.Random;

public class RandomArray {
	private int[] array;
	private Random random;
	
	// Helper class that generates random array with n elements.
	public RandomArray(int n) {
		array = new int[n];
		random = new Random();
	}
	
	// Generates random array with n elements.
	public int[] generateRandomArray() {
		// Loops n amount of times and adds random integer to the array.
		for(int i = 0; i < array.length; i++) {
			if(!random.nextBoolean()) {
				array[i] = random.nextInt();
			} else {
				//If boolean is false, multiply value by -1 to 
				// add a negative value to the array.
				array[i] = random.nextInt() * -1;
			}
		}
		return array;
	}
}
