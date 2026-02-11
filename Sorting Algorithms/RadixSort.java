/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * RADIX SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Radix Sort is a non-comparison based sorting algorithm that sorts integers by
 * processing individual digits. It processes digits from least significant digit
 * (LSD) to most significant digit (MSD), using counting sort as a subroutine for
 * each digit position.
 * 
 * HOW IT WORKS:
 * 1. Find the maximum number to determine number of digits
 * 2. For each digit position (from rightmost to leftmost):
 *    a. Use counting sort to sort array by current digit
 *    b. Maintain stability (important!)
 * 3. After processing all digits, array is sorted
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [170, 45, 75, 90, 802, 24, 2, 66]
 * Maximum = 802 (3 digits)
 * 
 * Pass 1: Sort by ones place (rightmost digit)
 *         [170, 90, 802, 2, 24, 45, 75, 66]
 *         Sorted by: 0, 0, 2, 2, 4, 5, 5, 6
 * 
 * Pass 2: Sort by tens place
 *         [802, 2, 24, 45, 66, 170, 75, 90]
 *         Sorted by: 0, 0, 2, 4, 6, 7, 7, 9
 * 
 * Pass 3: Sort by hundreds place
 *         [2, 24, 45, 66, 75, 90, 170, 802]
 *         Sorted by: 0, 0, 0, 0, 0, 0, 1, 8
 * 
 * Final: [2, 24, 45, 66, 75, 90, 170, 802]
 * 
 * TIME COMPLEXITY:
 * - Best Case: O(d * (n + k)) where d = digits, k = base (usually 10)
 * - Average Case: O(d * (n + k))
 * - Worst Case: O(d * (n + k))
 * - Simplified: O(d * n) when k is constant
 * 
 * SPACE COMPLEXITY: O(n + k) - for counting sort subroutine
 * 
 * STABILITY: Stable - must use stable sorting for each digit
 * 
 * USE CASES:
 * - Large numbers of integers with fixed number of digits
 * - When all numbers have similar number of digits
 * - Sorting strings of same length
 * - Sorting dates (YYYYMMDD format)
 * - When comparison-based sorts are too slow
 * 
 * ADVANTAGES:
 * + Linear time O(d*n) when d is constant
 * + No comparisons needed
 * + Stable sort
 * + Can be faster than O(n log n) comparison sorts
 * + Good for large datasets with small range
 * 
 * DISADVANTAGES:
 * - Only works with integers or data that can be represented as integers
 * - Requires extra space O(n)
 * - Slower than comparison sorts for small datasets
 * - Performance depends on number of digits
 * - Not in-place
 * 
 * WHEN TO USE:
 * - Large arrays of integers with fixed digit count
 * - Numbers have small range relative to array size
 * - Need stable sort
 * - Want O(n) performance for specific cases
 * 
 * WHEN NOT TO USE:
 * - Numbers have vastly different ranges
 * - Very long numbers (many digits)
 * - Floating-point numbers
 * - Memory is limited
 * 
 * REAL-WORLD APPLICATIONS:
 * - Sorting credit card numbers
 * - Sorting IP addresses
 * - Sorting dates in numeric format
 * - Sorting serial numbers
 * - Parallel processing (can sort different digit positions in parallel)
 * 
 * VARIATIONS:
 * - LSD (Least Significant Digit) - most common, used here
 * - MSD (Most Significant Digit) - can stop early for some data
 * - Different bases (binary, hexadecimal)
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class RadixSort {
    
    /**
     * Radix Sort implementation using Counting Sort for each digit
     * 
     * @param arr The array to be sorted
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        // Find the maximum number to know number of digits
        int max = getMax(arr);
        System.out.println("Maximum value: " + max);
        System.out.println("Number of digits: " + String.valueOf(max).length());
        
        // Do counting sort for every digit
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            System.out.println("Sorting by digit at position 10^" + 
                             (int)(Math.log10(exp)));
            countingSortByDigit(arr, exp);
        }
    }
    
    /**
     * Find maximum value in array
     */
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Counting sort based on digit represented by exp (1, 10, 100, ...)
     * This is a stable sort which is crucial for radix sort
     * 
     * @param arr Array to sort
     * @param exp Current digit position (1 for units, 10 for tens, etc.)
     */
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];  // Base 10 (digits 0-9)
        
        // Store count of occurrences
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        
        // Change count[i] to contain actual position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array (go from right to left for stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        
        // Copy output array to arr[]
        System.arraycopy(output, 0, arr, 0, n);
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
     * Main method to test Radix Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            RADIX SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Classic example
        System.out.println("Test Case 1: Mixed digit lengths");
        int[] arr1 = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.print("Before: ");
        printArray(arr1);
        radixSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Large numbers
        System.out.println("Test Case 2: Large numbers");
        int[] arr2 = {9999, 123, 8888, 456, 7777, 789};
        System.out.print("Before: ");
        printArray(arr2);
        radixSort(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Already sorted
        System.out.println("Test Case 3: Already sorted");
        int[] arr3 = {10, 20, 30, 40, 50};
        System.out.print("Before: ");
        printArray(arr3);
        radixSort(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Reverse sorted
        System.out.println("Test Case 4: Reverse sorted");
        int[] arr4 = {987, 654, 321, 100, 50, 10};
        System.out.print("Before: ");
        printArray(arr4);
        radixSort(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: Duplicates
        System.out.println("Test Case 5: Array with duplicates");
        int[] arr5 = {100, 50, 200, 50, 100, 25};
        System.out.print("Before: ");
        printArray(arr5);
        radixSort(arr5);
        System.out.print("After:  ");
        printArray(arr5);
        System.out.println();
        
        // Test Case 6: Credit card-like numbers (realistic use case)
        System.out.println("Test Case 6: Credit card numbers (last 4 digits)");
        int[] arr6 = {1234, 5678, 9012, 3456, 7890, 2468};
        System.out.print("Before: ");
        printArray(arr6);
        radixSort(arr6);
        System.out.print("After:  ");
        printArray(arr6);
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("           Note: O(d*n) time complexity!");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
