package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Handles the creation and reading of data for maximum subarray sum algorithms.
 * Provides methods to generate random arrays and read test cases from a file.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public class InputDataHandler {

    /**
     * Generates an array of random integers.
     * @param size The number of elements in the array.
     * @return An array filled with random integers between -100 and 100.
     */
    public int[] generateRandomArray(int size) {
        
        Random random = new Random();
        
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            
            array[i] = random.nextInt(201) - 100;  // Generate integers between -100 and +100
        }
        
        return array;
    }

    /**
     * Reads test cases from a specified file.
     * Each line in the file represents a test case with an array of integers.
     * @param fileName The name of the file containing the test cases.
     * @return A list of integer arrays, each representing a test case.
     * @throws IOException If an error occurs while reading the file.
     */
    public List<int[]> readTestCases(String fileName) throws IOException {
        
        String path = "data/" + fileName;  // Path to the test file
        
        List<int[]> testCases = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            
            String line;
            
            while ((line = reader.readLine()) != null) {
                
                if (line.trim().isEmpty()) continue;  // Skip empty lines
                
                String[] parts = line.split("],");
                String[] numberStrings = parts[0].replace("[", "").split(",");
                
                int[] numbers = new int[numberStrings.length];
                
                for (int i = 0; i < numberStrings.length; i++) {
                    
                    numbers[i] = Integer.parseInt(numberStrings[i].trim());  // Convert strings to integers
                }
                
                testCases.add(numbers);  // Add the array of numbers to the list of test cases
            }
        }
        return testCases;
    }
}


