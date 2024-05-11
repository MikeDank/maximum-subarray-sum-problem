package algorithms;

/**
 * Implements the Better Enumeration algorithm for finding the maximum subarray sum.
 * This version optimizes the basic enumeration approach by reducing unnecessary recomputation
 * of sums that have already been computed, thus improving efficiency.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public class BetterEnumeration implements SubarrayAlgorithm {

    /**
     * Calculates the maximum sum of any contiguous subarray within the given array using an optimized enumeration approach.
     * This method iteratively adds the next element in the array to the current subarray sum to avoid starting the sum from scratch.
     *
     * @param array An array of integers where the maximum subarray sum is to be found.
     * @return The maximum sum of any contiguous subarray within the array. Returns 0 if the array is empty or all elements are negative.
     */
    @Override
    public int findMaximumSubarray(int[] array) {
        
        int n = array.length;
        if (n == 0) return 0;  // Return 0 for an empty array

        int maxSum = 0;  // Initialize maxSum as 0 to handle non-positive arrays effectively
        
        for (int i = 0; i < n; i++) {
            
            int currentSum = 0;  // Initialize currentSum for the current starting index
            
            for (int j = i; j < n; j++) {
                
                currentSum += array[j];  // Add the next element in the array to the current sum
                
                maxSum = Math.max(maxSum, currentSum);  // Update maxSum if the current sum is larger
            }
        }
        return maxSum;  // Return the found maximum subarray sum
    }
}


