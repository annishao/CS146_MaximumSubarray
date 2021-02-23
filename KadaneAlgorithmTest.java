package cs146F20.shao.project2;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KadaneAlgorithmTest {
	KadaneAlgorithm tester;
	RandomArray randomGen;
	int expectedMax;
	int expectedArrive;
	int expectedDepart;
	double time;
	
	@BeforeEach
	void setUp() {
		tester = new KadaneAlgorithm();
		randomGen = new RandomArray(0);
		expectedMax = 0;
		expectedArrive = 0;
		expectedDepart = 0;
		time = 0;
	}
	
	@Test
	public void testCasesInFile() throws IOException {
		// Initializes Scanner object to read file maxSumtest.txt.
		Scanner in = new Scanner(new File("maxSumtest.txt"));
		
		// Runs 10 times to test the 10 cases in the file.
		for(int i = 0; i < 10; i++) {
			// Initializes the array containing the test case.
			int[] testCase = new int[100];
			
			for(int j = 0; j < 100; j++) {
				// Adds each element to the array testCase.
				testCase[j] = in.nextInt();
			}
			// Declares the next 3 integers as expectedMax, expectedArrive, and expectedDepart.
			expectedMax = in.nextInt();
			expectedArrive = in.nextInt();
			expectedDepart = in.nextInt();
			
			// Runs the Kadane's Algorithm.
			int[] actual = tester.findMaxSubarray(testCase);
			
			// Tests that Kadane's Algorithm performs correctly.
			assertEquals(expectedMax, actual[0]);
			assertEquals(expectedArrive, actual[1]);
			assertEquals(expectedDepart, actual[2]);
		}
		
		// Closes Scanner object.
		in.close();
	}
	
	@Test
	public void testSmallCase1() {
		// Test case with negative and positive values.
		int[] array = {2, -3, 4, -1, -2, 1, 5, -3};
		expectedMax = 7;
		expectedArrive = 2;
		expectedDepart = 6;
		int[] actual = tester.findMaxSubarray(array);
		assertEquals(expectedMax, actual[0]);
		assertEquals(expectedArrive, actual[1]);
		assertEquals(expectedDepart, actual[2]);	
	}
	
	@Test
	public void testSmallCase2() {
		// Test case with only negative values.
		int[] array = {-3, -4, -5, -6, -7, -8, -9, -10};
		expectedMax = 0;
		expectedArrive = 0;
		expectedDepart = -1;
		int[] actual = tester.findMaxSubarray(array);
		assertEquals(expectedMax, actual[0]);
		assertEquals(expectedArrive, actual[1]);
		assertEquals(expectedDepart, actual[2]);
	}
	
	@Test
	public void testSmallCase3() {
		// Test case with only positive values.
		int[] array = {1, 5, 8, 6, 9, 2, 7, 2};
		expectedMax = 40;
		expectedArrive = 0;
		expectedDepart = 7;
		int[] actual = tester.findMaxSubarray(array);
		assertEquals(expectedMax, actual[0]);
		assertEquals(expectedArrive, actual[1]);
		assertEquals(expectedDepart, actual[2]);
	}
	
	@Test
	public void testSmallCase4() {
		// Test case with arrival and departure date on the same day.
		int[] array = {-3, 5, -9, -4, -1, -3, -8, -8};
		expectedMax = 5;
		expectedArrive = 1;
		expectedDepart = 1;
		int[] actual = tester.findMaxSubarray(array);
		assertEquals(expectedMax, actual[0]);
		assertEquals(expectedArrive, actual[1]);
		assertEquals(expectedDepart, actual[2]);
	}
	
	@Test
	public void testRunningTimeSize100() {
		// Tests running time of Kadane's algorithm with an array size of 100.
		
		// Uses helper class to generate a random array with size 100.
		randomGen = new RandomArray(100);
		
		double sum = 0;
		// Runs 10 different random arrays and Kadane's algorithm running time
		// and prints out the average time it takes to find max subarray.
		for(int i = 0; i < 10; i++) {
			int[] array = randomGen.generateRandomArray();
			time = System.nanoTime();
			tester.findMaxSubarray(array);
			sum += System.nanoTime() - time;
		}
		System.out.println("Running time for size 100: " + (double) sum / 10);
	}
	
	@Test
	public void testRunningTimeSize200() {
		// Tests running time of Kadane's algorithm with an array size of 200.
		
		// Uses helper class to generate a random array with size 200.
		randomGen = new RandomArray(200);
		
		double sum = 0;
		// Runs 10 different Kadane's algorithm and Kadane's algorithm running time
		// and prints out the average time it takes to find max subarray.
		for(int i = 0; i < 10; i++) {
			int[] array = randomGen.generateRandomArray();
			time = System.nanoTime();
			tester.findMaxSubarray(array);
			sum += System.nanoTime() - time;
		}
		System.out.println("Running time for size 200: " + (double) sum / 10);
	}
	
	@Test
	public void testRunningTimeSize500() {
		// Tests running time of Kadane's algorithm with an array size of 500.
		// Uses helper class to generate a random array with size 500.
		randomGen = new RandomArray(500);
		
		double sum = 0;
		// Runs 10 different random arrays and Kadane's algorithm running time
		// and prints out the average time it takes to find max subarray.
		for(int i = 0; i < 10; i++) {
			int[] array = randomGen.generateRandomArray();
			time = System.nanoTime();
			tester.findMaxSubarray(array);
			sum += System.nanoTime() - time;
		}
		System.out.println("Running time for size 500: " + (double) sum / 10);
	}
	
	@Test
	public void testRunningTimeSize1000() {
		// Tests running time of Kadane's algorithm with an array size of 1000.
		// Uses helper class to generate a random array with size 1000.
		randomGen = new RandomArray(1000);
				
		double sum = 0;
		// Runs 10 different random arrays and Kadane's algorithm running time
		// and prints out the average time it takes to find max subarray.randomGen = new RandomArray(1000);
		for(int i = 0; i < 10; i++) {
			int[] array = randomGen.generateRandomArray();
			time = System.nanoTime();
			tester.findMaxSubarray(array);
			sum += System.nanoTime() - time;
		}
		System.out.println("Running time for size 1000: " + (double) sum / 10);
	}
	
	@Test
	public void testRunningTimeSize2000() {
		// Tests running time of Kadane's algorithm with an array size of 2000.
		// Uses helper class to generate a random array with size 2000.
		randomGen = new RandomArray(2000);
				
		double sum = 0;
		// Runs 10 different random arrays and Kadane's algorithm running time
		// and prints out the average time it takes to find max subarray.
		for(int i = 0; i < 10; i++) {
			int[] array = randomGen.generateRandomArray();
			time = System.nanoTime();
			tester.findMaxSubarray(array);
			sum += System.nanoTime() - time;
		}
		System.out.println("Running time for size 2000: " + (double) sum / 10);
	}
	
	@Test
	public void testRunningTimeSize5000() {
		// Tests running time of Kadane's algorithm with an array size of 5000.
		// Uses helper class to generate a random array with size 5000.
		randomGen = new RandomArray(5000);
				
		double sum = 0;
		// Runs 10 different random arrays and Kadane's algorithm running time
		// and prints out the average time it takes to find max subarray.
		for(int i = 0; i < 10; i++) {
			int[] array = randomGen.generateRandomArray();
			time = System.nanoTime();
			tester.findMaxSubarray(array);
			sum += System.nanoTime() - time;
		}
		System.out.println("Running time for size 5000: " + (double) sum / 10);
	}
	
	@Test
	public void testRunningTimeSize10000() {
		// Tests running time of Kadane's algorithm with an array size of 10000.
		// Uses helper class to generate a random array with size 10000.
		randomGen = new RandomArray(10000);
				
		double sum = 0;
		// Runs 10 different random arrays and Kadane's algorithm running time
		// and prints out the average time it takes to find max subarray.
		for(int i = 0; i < 10; i++) {
			int[] array = randomGen.generateRandomArray();
			time = System.nanoTime();
			tester.findMaxSubarray(array);
			sum += System.nanoTime() - time;
		}
		System.out.println("Running time for size 10000: " + (double) sum / 10);
	}
}
