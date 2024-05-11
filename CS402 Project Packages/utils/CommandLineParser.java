package utils;

/**
 * Parses command line arguments to extract options for running the maximum subarray sum algorithms.
 * It handles input for selecting the algorithm, the size of the data, or the test file to be used.
 *
 * @author Michael Dankanich
 * @version May 10, 2024
 */
public class CommandLineParser {
    
    private String[] args; // Array of command-line arguments passed to the application

    /**
     * Constructor for the CommandLineParser.
     * @param args The command-line arguments passed to the main function.
     */
    public CommandLineParser(String[] args) {
        
        this.args = args;
    }

    /**
     * Parses the command-line arguments and creates a CommandLineOptions object containing the parsed options.
     * @return A populated CommandLineOptions object.
     */
    public CommandLineOptions parse() {
        
        CommandLineOptions options = new CommandLineOptions();
        
        options.setAlgorithmType("enumeration"); // Default algorithm if not specified
        
        options.setSize(10); // Default size if not specified
        
        options.setTestFileName(null); // Default is no test file

        for (int i = 0; i < args.length; i++) {
            
            switch (args[i]) {
                
                case "--size":
                    
                    if (i + 1 < args.length) {
                        
                        try {
                            options.setSize(Integer.parseInt(args[++i]));
                            
                        } catch (NumberFormatException e) {
                            
                            System.err.println("Invalid format for size: " + args[i]);
                            options.setSize(10); // Reset to default size on format error
                        }
                    }
                    
                    break;
                case "--testfile":
                    
                    if (i + 1 < args.length) {
                        
                        options.setTestFileName(args[++i]); // Set the filename for test data
                    }
                    
                    break;
                    
                default:
                    // Check if the argument is a valid algorithm type
                    
                    if (args[i].equals("enumeration") || args[i].equals("betterEnumeration") || args[i].equals("dc") || args[i].equals("dp")) {
                        options.setAlgorithmType(args[i]);
                    }
                    break;
            }
        }
        return options;
    }

    /**
     * Inner class to store the options parsed from the command line.
     */
    public static class CommandLineOptions {
        
        private String algorithmType; // The type of algorithm to run
        private int size; // The size of the input array
        private String testFileName; // The file name containing test data

        // Getters and setters for each field
        public String getAlgorithmType() { return algorithmType; }
        
        public void setAlgorithmType(String algorithmType) { this.algorithmType = algorithmType; }
        
        public int getSize() { return size; }
        
        public void setSize(int size) { this.size = size; }
        
        public String getTestFileName() { return testFileName; }
        
        public void setTestFileName(String testFileName) { this.testFileName = testFileName; }
    }
}
