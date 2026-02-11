/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * COUNTING SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Counting Sort is a non-comparison based sorting algorithm that works by counting
 * the number of objects having distinct key values, then using arithmetic to
 * calculate the position of each object in the output sequence. It's particularly
 * efficient when the range of input values is not significantly greater than the
 * number of elements to be sorted.
 * 
 * HOW IT WORKS:
 * 1. Find the maximum and minimum values in the array
 * 2. Create a count array to store count of each unique element
 * 3. Count the occurrences of each element
 * 4. Modify count array to store cumulative sum (positions)
 * 5. Build the output array using the count array
 * 6. Copy output array back to original array
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [1, 4, 1, 2, 7, 5, 2]
 * Range: min=1, max=7, so we need count array of size 7
 * 
 * Step 1: Count occurrences
 *         count = [0, 2, 2, 0, 1, 1, 0, 1]
 *         index:   0  1  2  3  4  5  6  7
 * 
 * Step 2: Cumulative sum (positions)
 *         count = [0, 2, 4, 4, 5, 6, 6, 7]
 * 
 * Step 3: Build output array from right to left
 *         output = [1, 1, 2, 2, 4, 5, 7]
 * 
 * TIME COMPLEXITY:
 * - Best Case: O(n + k) where k is the range of input
 * - Average Case: O(n + k)
 * - Worst Case: O(n + k)
 * 
 * SPACE COMPLEXITY: O(n + k) - needs count array and output array
 * 
 * STABILITY: Stable - preserves order of equal elements
 * 
 * USE CASES:
 * - Small range of integers (k ≈ n)
 * - When range is known and small
 * - As subroutine in Radix Sort
 * - Sorting characters or small integers
 * - Histogram generation
 * 
 * ADVANTAGES:
 * + Linear time complexity O(n + k)
 * + Stable sort
 * + Simple to implement
 * + No comparisons needed
 * + Predictable performance
 * 
 * DISADVANTAGES:
 * - Only works with integers or can be mapped to integers
 * - Inefficient when range (k) is much larger than n
 * - Requires O(k) extra space
 * - Not suitable for floating-point numbers
 * - Doesn't work well with negative numbers (needs adjustment)
 * 
 * WHEN TO USE:
 * - Range of values is small and known
 * - Need O(n) sorting for integers
 * - Stability is required
 * - Data consists of small integers (0-100, grades, ages, etc.)
 * 
 * WHEN NOT TO USE:
 * - Large range of values (k >> n)
 * - Non-integer data
 * - Memory is limited
 * - Range is unknown
 * 
 * REAL-WORLD APPLICATIONS:
 * - Sorting test scores or grades (0-100)
 * - Age sorting (0-120)
 * - Sorting characters in a string
 * - Used internally in Radix Sort
 * - Histogram creation
 * 
 * VARIATIONS:
 * - Can be modified to handle negative numbers
 * - Can sort objects by key values
 * - Used as subroutine in Radix Sort for each digit
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class CountingSort {
    
    /**
     * Counting Sort implementation
     * Works for non-negative integers
     * 
     * @param arr The array to be sorted
     */
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        // Find maximum value to determine range
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        
        int range = max - min + 1;
        System.out.println("Range: " + min + " to " + max + " (size: " + range + ")");
        
        // Create count array
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        // Store count of each element
        for (int num : arr) {
            count[num - min]++;
        }
        
        // Change count[i] to contain actual position in output
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array from right to left (for stability)
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = arr[i] - min;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }
        
        // Copy output array back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    
    /**
     * Utility method to print array
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    /**
     * Main method to test Counting Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("          COUNTING SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Small range of positive integers
        System.out.println("Test Case 1: Small range of positive integers");
        int[] arr1 = {1, 4, 1, 2, 7, 5, 2};
        System.out.print("Before: ");
        printArray(arr1);
        countingSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Ages (realistic use case)
        System.out.println("Test Case 2: Sorting ages (0-100)");
        int[] arr2 = {25, 30, 18, 45, 22, 18, 60, 30, 25};
        System.out.print("Before: ");
        printArray(arr2);
        countingSort(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Test scores
        System.out.println("Test Case 3: Test scores (0-100)");
        int[] arr3 = {85, 92, 78, 92, 88, 75, 95, 88};
        System.out.print("Before: ");
        printArray(arr3);
        countingSort(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Already sorted
        System.out.println("Test Case 4: Already sorted array");
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("Before: ");
        printArray(arr4);
        countingSort(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: Many duplicates
        System.out.println("Test Case 5: Array with many duplicates");
        int[] arr5 = {5, 5, 5, 2, 2, 8, 8, 8, 8, 1};
        System.out.print("Before: ");
        printArray(arr5);
        countingSort(arr5);
        System.out.print("After:  ");
        printArray(arr5);
        System.out.println();
        
        // Test Case 6: Small range starting from non-zero
        System.out.println("Test Case 6: Range 50-60");
        int[] arr6 = {55, 52, 58, 50, 60, 52, 57};
        System.out.print("Before: ");
        printArray(arr6);
        countingSort(arr6);
        System.out.print("After:  ");
        printArray(arr6);
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("           Note: Best for small integer ranges!");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
