package test;

import algorithms.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Provides JUnit tests for the subarray algorithms implemented in the algorithms package.
 * Tests include general usage cases and edge cases to ensure that each algorithm correctly computes
 * the maximum subarray sum under various conditions.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public class SubarrayAlgorithmTest {
    
    private Enumeration enumeration;
    private BetterEnumeration betterEnumeration;
    private DivideAndConquer divideAndConquer;
    private Kadane kadane;

    /**
     * Sets up instances of each subarray algorithm before each test.
     */
    @Before
    public void setUp() {
        
        enumeration = new Enumeration();
        betterEnumeration = new BetterEnumeration();
        divideAndConquer = new DivideAndConquer();
        kadane = new Kadane();
    }

    /**
     * Tests each algorithm with a sample array to ensure they all find the correct maximum subarray sum.
     */
    @Test
    public void testAlgorithmsWithExample() {
        
        int[] testArray = {1, -2, 3, 4, -1, 2};
        int expectedMaxSum = 8;  // Correct maximum subarray sum
        
        assertEquals(expectedMaxSum, enumeration.findMaximumSubarray(testArray));
        assertEquals(expectedMaxSum, betterEnumeration.findMaximumSubarray(testArray));
        assertEquals(expectedMaxSum, divideAndConquer.findMaximumSubarray(testArray));
        assertEquals(expectedMaxSum, kadane.findMaximumSubarray(testArray));
    }

    /**
     * Tests edge cases including empty arrays, arrays with all negative numbers, and single-element arrays.
     */
    @Test
    public void testEdgeCases() {
        
        // Test with an empty array
        assertEquals(0, enumeration.findMaximumSubarray(new int[] {}));
        assertEquals(0, betterEnumeration.findMaximumSubarray(new int[] {}));
        assertEquals(0, divideAndConquer.findMaximumSubarray(new int[] {}));
        assertEquals(0, kadane.findMaximumSubarray(new int[] {}));

        // Test with an array of all negative numbers
        int[] allNegatives = {-1, -2, -3};
        
        assertEquals(0, enumeration.findMaximumSubarray(allNegatives));
        assertEquals(0, betterEnumeration.findMaximumSubarray(allNegatives));
        assertEquals(0, divideAndConquer.findMaximumSubarray(allNegatives));
        assertEquals(0, kadane.findMaximumSubarray(allNegatives));

        // Test with a single-element array
        int[] singleElement = {5};
        
        assertEquals(5, enumeration.findMaximumSubarray(singleElement));
        assertEquals(5, betterEnumeration.findMaximumSubarray(singleElement));
        assertEquals(5, divideAndConquer.findMaximumSubarray(singleElement));
        assertEquals(5, kadane.findMaximumSubarray(singleElement));
    }
}

