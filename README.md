# CS402 Maximum Sum Subarray Problem Runtime Analysis Project

## Authors
- Michael Dankanich

## Version
- Date: May 10, 2024

## Purpose of Project
This project implements and analyzes four algorithms for solving the maximum subarray sum problem in Java, using the BlueJ IDE. It includes a setup with multiple packages that contain the implementations, tests, and performance analyses of different algorithms.

## Project Structure
The project is organized into six packages containing a total of 10 classes. Here's the package organization:

- **main**: Contains the `MaximumSubarrayMain` class which is the entry point for running the algorithms.
- **algorithms**: Contains four classes (`Enumeration`, `BetterEnumeration`, `DivideAndConquer`, `Kadane`), each implementing a different algorithm to solve the maximum subarray sum problem.
- **utils**: Includes utility classes such as `InputDataHandler` for data management and `CommandLineParser` for argument parsing.
- **performance**: Contains the `PerformanceAnalysis` class used to measure and output the performance of each algorithm.
- **test**: Includes the `SubarrayAlgorithmTest` class for testing the algorithms using JUnit.
- **data**: Used for storing test files and output results.

## How to Start This Project
### Prerequisites
- BlueJ IDE installed on your computer.
- Download the project zip file.

### Running the Project
1. **Open the Project:**
   - Unzip the downloaded project file.
   - Open the project in BlueJ IDE.

2. **Compile the Classes:**
   - Right-click on each class and select 'Compile'.
   - Ensure all classes compile without errors.

## User Instructions
### Solving the Maximum Subarray Problem
To run the program, right-click on the `MaximumSubarrayMain` class in the main package and select `void main(String[] args)`. Input the arguments as follows based on your needs:

#### For Random Data Generation
- Syntax: `{"<algorithm>", "--size", "<n>"}`
- Examples:
  - `{"enumeration", "--size", "100"}`
  - `{"betterenumeration", "--size", "100"}`
  - `{"divideandconquer", "--size", "100"}`
  - `{"kadane", "--size", "100"}`

#### For Reading From a Test File
- Syntax: `{"<algorithm>", "--testfile", "max-subarray-tests.txt"}`
- Examples:
  - `{"enumeration", "--testfile", "max-subarray-tests.txt"}`
  - `{"betterenumeration", "--testfile", "max-subarray-tests.txt"}`
  - `{"divideandconquer", "--testfile", "max-subarray-tests.txt"}`
  - `{"kadane", "--testfile", "max-subarray-tests.txt"}`

### Running Tests
To execute the tests, navigate to the `SubarrayAlgorithmTest` class in the test package and run `test all`.

### Performing and Analyzing Performance
- Run the `PerformanceAnalysis` class:
  - Right-click on the class and choose `void main(String[] args)`.
  - Leave the popup field blank (`{}`) and proceed.
  - Ensure the `data/results` directory exists within the project structure; create it if it does not exist to avoid errors.
  - Performance results will be outputted to CSV files in the `data/results` directory, detailing the date, algorithm, input size `n`, and running time.
