package main;

import algorithms.*;
import utils.CommandLineParser;
import utils.InputDataHandler;
import java.util.List;
import java.util.Arrays;

/**
 * The main entry point for running the maximum subarray sum algorithms.
 * This class handles user input to execute different algorithms based on command line arguments,
 * including data generation and reading from a test file.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public final class MaximumSubarrayMain {

    /**
     * Main method that processes the command line arguments and invokes the appropriate subarray algorithm.
     * @param args Command line arguments to specify the algorithm and input method.
     */
    public static void main(String[] args) {
        // Check if any arguments were provided
        if (args.length == 0) {
            
            System.out.println("Usage:");
            System.out.println("To run with a random array: java MaximumSubarrayMain <algorithm> --size <n>");
            System.out.println("To run with a test file: java MaximumSubarrayMain <algorithm> --testfile <filename>");
            return;
        }

        // Parse the command line arguments
        CommandLineParser parser = new CommandLineParser(args);
        CommandLineParser.CommandLineOptions options = parser.parse();

        // Determine which algorithm to run based on the parsed options
        SubarrayAlgorithm algorithm = null;
        
        switch (options.getAlgorithmType()) {
            
            case "enumeration":
                algorithm = new Enumeration();
                break;
                
            case "betterEnumeration":
                algorithm = new BetterEnumeration();
                break;
                
            case "dc":
                algorithm = new DivideAndConquer();
                break;
                
            case "dp":
                algorithm = new Kadane();
                break;
                
            default:
                System.out.println("Invalid algorithm type: " + options.getAlgorithmType());
                return;
        }

        // Handle data input and algorithm execution based on the options
        InputDataHandler dataHandler = new InputDataHandler();
        
        try {
            
            if (options.getTestFileName() != null) {
                
                List<int[]> testCases = dataHandler.readTestCases(options.getTestFileName());
                
                for (int[] testCase : testCases) {
                    
                    System.out.println("Test case: " + Arrays.toString(testCase));
                    
                    int maxSum = algorithm.findMaximumSubarray(testCase);
                    
                    System.out.println("Maximum Subarray Sum: " + maxSum);
                }
            } else if (options.getSize() > 0) {
                
                int[] array = dataHandler.generateRandomArray(options.getSize());
                
                System.out.println("Random Array: " + Arrays.toString(array));
                
                int maxSum = algorithm.findMaximumSubarray(array);
                
                System.out.println("Maximum Subarray Sum: " + maxSum);
                
            } else {
                
                System.out.println("No valid input provided. Please specify either --size for a random array or --testfile for a test file.");
            }
            
        } catch (Exception e) {
            
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

