package algorithms;

/**
 * Defines the structure for subarray algorithms used to find the maximum subarray sum.
 * This interface is implemented by various algorithms that solve the maximum subarray sum problem,
 * ensuring that they all provide a method for finding the maximum sum in an integer array.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public interface SubarrayAlgorithm {

    /**
     * Calculates the maximum sum of any contiguous subarray within the given array.
     * @param array An array of integers.
     * @return The maximum subarray sum found in the array.
     */
    int findMaximumSubarray(int[] array);
}
