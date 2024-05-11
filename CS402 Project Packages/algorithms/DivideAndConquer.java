package algorithms;

/**
 * Implements the Divide and Conquer algorithm to find the maximum subarray sum.
 * This approach splits the array into two halves and recursively finds the maximum subarray sum
 * in each half, and also considers the maximum sum that crosses the midpoint.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public class DivideAndConquer implements SubarrayAlgorithm {

    /**
     * Calculates the maximum subarray sum for the entire array by invoking the recursive divide and conquer method.
     * @param array An array of integers.
     * @return The maximum subarray sum found in the array, or 0 if the array is empty.
     */
    @Override
    public int findMaximumSubarray(int[] array) {
        
        if (array.length == 0) return 0; // Return 0 for an empty array
        
        return divideAndConquer(array, 0, array.length - 1);
    }

    /**
     * Recursively divides the array into halves to find the maximum subarray sum within each half,
     * and also finds the maximum sum that crosses the midpoint, combining these to get the global maximum.
     *
     * @param array The input array.
     * @param low The starting index of the current subarray.
     * @param high The ending index of the current subarray.
     * @return The maximum subarray sum in the given range.
     */
    private int divideAndConquer(int[] array, int low, int high) {
        
        if (low == high) return Math.max(0, array[low]); // Handle the base case of a single element

        int mid = (low + high) / 2;
        
        int leftMax = divideAndConquer(array, low, mid); // Maximum subarray sum in the left half
        
        int rightMax = divideAndConquer(array, mid + 1, high); // Maximum subarray sum in the right half
        
        int crossMax = findMaxCrossingSum(array, low, mid, high); // Maximum sum crossing the midpoint

        return Math.max(Math.max(leftMax, rightMax), crossMax); // The maximum of the three
    }

    /**
     * Finds the maximum sum of a subarray that crosses the midpoint of the array.
     *
     * @param array The input array.
     * @param low The starting index of the left subarray.
     * @param mid The midpoint index, where the left and right subarrays meet.
     * @param high The ending index of the right subarray.
     * @return The maximum sum of a subarray crossing the midpoint.
     */
    private int findMaxCrossingSum(int[] array, int low, int mid, int high) {
        
        int leftSum = 0, maxLeftSum = 0;
        
        for (int i = mid; i >= low; i--) {
            
            leftSum += array[i];
            maxLeftSum = Math.max(maxLeftSum, leftSum); // Accumulate from mid to low and keep track of the maximum
        }

        int rightSum = 0, maxRightSum = 0;
        
        for (int j = mid + 1; j <= high; j++) {
            
            rightSum += array[j];
            maxRightSum = Math.max(maxRightSum, rightSum); // Accumulate from mid+1 to high and keep track of the maximum
        }

        return maxLeftSum + maxRightSum; // Combine the maximum sums from both sides of the midpoint
    }
}

