package algorithms;

/**
 * Implements Kadane's algorithm for finding the maximum subarray sum.
 * This dynamic programming approach calculates the maximum sum of a contiguous subarray in linear time,
 * effectively handling arrays with both positive and negative integers.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public class Kadane implements SubarrayAlgorithm {

    /**
     * Calculates the maximum sum of any contiguous subarray within the given array using Kadane's algorithm.
     * The method iterates through the array, at each step extending the current subarray sum or resetting it based on its value.
     *
     * @param array An array of integers where the maximum subarray sum is to be found.
     * @return The maximum sum of any contiguous subarray within the array. Returns 0 if the array is empty or if all elements are non-positive.
     */
    @Override
    public int findMaximumSubarray(int[] array) {
        
        if (array.length == 0) return 0;  // Return 0 for an empty array

        int maxSum = 0;  // Initialize maxSum to 0 to properly handle arrays with non-positive values
        int currentSum = 0;  // Initialize currentSum to track the sum of the current subarray

        for (int value : array) {
            
            currentSum += value;  // Add the current element to the currentSum
            
            if (currentSum > maxSum) {
                
                maxSum = currentSum;  // Update maxSum if currentSum is greater
            }
            
            if (currentSum < 0) {
                
                currentSum = 0;  // Reset currentSum if it drops below zero
            }
        }
        return maxSum;  // Return the maximum subarray sum found
    }
}

