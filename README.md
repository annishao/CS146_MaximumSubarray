# CS146_MaximumSubarray

Problem:
On a work trip, how do we maximize our earnings with the requirements that the trip must be on
consecutive work days and I do not have to work all n days?

Solution 1: Brute Force

The most simplistic but largely inefficient way to solve the maximum subarray problem is to use 2
nested for loops. The loops will investigate every possible pair of arrival dates and departure dates (the
outer for loop investigating arrival dates and the inner for loop investigating departure dates) and keep
the pair with the largest sum and its respective arrival and departure dates. An array with these
elements will be returned. The running time of brute force is O(n²).

Solution 2: Divide and Conquer

The divide and conquer method divides the given array into 2 halves and then finds the maximum
subarray of each half respectively using recursion. The maximum subarray of the subarray crossing the
midpoint of the array is also calculated. The largest maximum subarray out of the 3 is returned. The
running time of divide and conquer is O(nlogn).

Solution 3: Kadane’s Algorithm
The Kadane’s Algorithm is a highly efficient way to solve the maximum subarray problem. Utilizing
dynamic programming, we only add positive contiguous sums by adding the elements one at a time with
a for loop. The greatest sum, its arrival date, and its departure date are saved and returned in an array.
The running time of Kadane’s Algorithm is O(n).

Testing
The test cases are the same used across across all 3 algorithms.
