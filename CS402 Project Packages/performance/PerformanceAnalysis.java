package performance;

import algorithms.*;
import utils.InputDataHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Handles the performance analysis of different subarray algorithms.
 * This class conducts experiments on various algorithms to determine their runtime performance
 * across different input sizes and outputs the results to CSV files.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public class PerformanceAnalysis {

    // Constants for the sizes of the input arrays used in experiments
    private static final int[] SMALL_SIZES = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
    private static final int[] MEDIUM_SIZES = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};

    /**
     * Main method to run the performance experiments for all algorithms.
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        
        runExperiments(new Enumeration(), "enumeration");
        runExperiments(new BetterEnumeration(), "betterEnumeration");
        runExperiments(new DivideAndConquer(), "divideAndConquer");
        runExperiments(new Kadane(), "kadane");
    }

    /**
     * Runs performance experiments for a given algorithm and writes the results to a CSV file.
     * @param algorithm The algorithm to test.
     * @param algorithmName The name of the algorithm, used in naming the output file.
     */
    public static void runExperiments(SubarrayAlgorithm algorithm, String algorithmName) {
        
        String fileName = "data/results/" + algorithmName + ".csv";
        
        try (FileWriter writer = new FileWriter(fileName)) {
            
            writer.write("date,algorithm,n,running time\n");
            performExperimentsForSizes(algorithm, SMALL_SIZES, writer);
            performExperimentsForSizes(algorithm, MEDIUM_SIZES, writer);
            
        } catch (IOException e) {
            
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    /**
     * Performs the experiments for the given sizes and records the running time.
     * @param algorithm The algorithm to test.
     * @param sizes The array sizes for which to test the algorithm.
     * @param writer The FileWriter used to record results.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    private static void performExperimentsForSizes(SubarrayAlgorithm algorithm, int[] sizes, FileWriter writer) throws IOException {
        
        InputDataHandler dataHandler = new InputDataHandler();
        
        for (int size : sizes) {
            
            long totalTime = 0;
            int runs = 3;  // Number of runs to average
            
            for (int i = 0; i < runs; i++) {
                
                int[] array = dataHandler.generateRandomArray(size);
                
                long startTime = System.nanoTime(); // Start timing before the algorithm runs
                algorithm.findMaximumSubarray(array);
                
                long endTime = System.nanoTime(); // End timing after the algorithm finishes
                totalTime += (endTime - startTime);
            }
            
            long avgTime = totalTime / runs;
            writer.write(String.format("%s,%s,%d,%d\n", java.time.LocalDate.now(), algorithm.getClass().getSimpleName(), size, avgTime));
        }
    }
}

