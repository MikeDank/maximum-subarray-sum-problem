package algorithms;

/**
 * Implements the Enumeration algorithm to find the maximum subarray sum.
 * This is a brute force approach that examines every possible subarray in the given array
 * to determine the maximum sum.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public class Enumeration implements SubarrayAlgorithm {

    /**
     * Calculates the maximum sum of any contiguous subarray within the given array using a brute force approach.
     * This method iteratively checks all possible subarrays to find the subarray with the maximum sum.
     *
     * @param array An array of integers where the maximum subarray sum is to be found.
     * @return The maximum sum of any contiguous subarray within the array. Returns 0 if the array is empty or all elements are negative.
     */
    @Override
    public int findMaximumSubarray(int[] array) {
        
        int n = array.length;
        if (n == 0) return 0;  // Return 0 for an empty array

        int maxSum = 0;  // Initialize maxSum as 0 to handle non-positive arrays effectively
        
        for (int start = 0; start < n; start++) {
            
            for (int end = start; end < n; end++) {
                
                int currentSum = 0;  // Sum of the current subarray
                
                for (int i = start; i <= end; i++) {
                    
                    currentSum += array[i];  // Add each element in the subarray to currentSum
                    
                }
                maxSum = Math.max(maxSum, currentSum);  // Update maxSum if currentSum is larger
            }
        }
        return maxSum;  // Return the found maximum subarray sum
    }
}


