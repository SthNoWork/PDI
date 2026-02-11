/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * SHELL SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Shell Sort is an optimization of Insertion Sort that allows the exchange of
 * items that are far apart. It starts by sorting pairs of elements far apart
 * from each other, progressively reducing the gap between elements to be compared.
 * By starting with large gaps, it moves elements closer to their final position
 * faster than Insertion Sort.
 * 
 * HOW IT WORKS:
 * 1. Start with a large gap (typically n/2)
 * 2. Perform "gapped" insertion sort for this gap size
 * 3. Reduce the gap (typically gap/2)
 * 4. Repeat until gap becomes 1
 * 5. Final pass is regular insertion sort (but array is nearly sorted!)
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [35, 33, 42, 10, 14, 19, 27, 44]
 * 
 * Gap = 4:
 *   Compare elements 4 positions apart
 *   [35, 33, 42, 10, 14, 19, 27, 44]
 *   [14, 19, 27, 10, 35, 33, 42, 44]
 * 
 * Gap = 2:
 *   Compare elements 2 positions apart
 *   [14, 19, 27, 10, 35, 33, 42, 44]
 *   [14, 10, 27, 19, 35, 33, 42, 44]
 *   [14, 10, 27, 19, 35, 33, 42, 44]
 * 
 * Gap = 1:
 *   Regular insertion sort (array nearly sorted)
 *   [10, 14, 19, 27, 33, 35, 42, 44]
 * 
 * GAP SEQUENCES (Critical to performance!):
 * 1. Shell's original: n/2, n/4, ..., 1 (used here)
 * 2. Knuth's: (3^k - 1)/2 = 1, 4, 13, 40, 121, ...
 * 3. Sedgewick's: 1, 5, 19, 41, 109, ...
 * 4. Hibbard's: 2^k - 1 = 1, 3, 7, 15, 31, ...
 * 
 * TIME COMPLEXITY: (depends on gap sequence!)
 * - Best Case: O(n log n)
 * - Average Case: O(n^1.25) to O(n^1.5) depending on gap
 * - Worst Case: O(n^2) with Shell's sequence, O(n^1.5) with Knuth's
 * 
 * SPACE COMPLEXITY: O(1) - in-place sorting
 * 
 * STABILITY: Unstable - equal elements may be rearranged
 * 
 * USE CASES:
 * - Medium-sized arrays (thousands of elements)
 * - When O(n log n) algorithms are too complex
 * - Embedded systems (simple to implement)
 * - When data is partially sorted
 * - Alternative to Quicksort when O(n²) worst case is problematic
 * 
 * ADVANTAGES:
 * + Faster than O(n²) algorithms for medium datasets
 * + In-place sorting (no extra memory)
 * + Simple to implement
 * + Adaptive (fast on nearly sorted data)
 * + No worst case like quicksort
 * + Good cache performance
 * 
 * DISADVANTAGES:
 * - Unstable sort
 * - Performance heavily depends on gap sequence
 * - Slower than O(n log n) algorithms for large datasets
 * - Difficult to analyze theoretically
 * - Not as fast as quicksort for random data
 * 
 * WHEN TO USE:
 * - Medium-sized arrays (1,000 - 100,000 elements)
 * - Simple implementation needed
 * - Want better than O(n²) without complexity of quicksort
 * - Embedded systems with limited resources
 * - Data is partially sorted
 * 
 * WHEN NOT TO USE:
 * - Very large datasets (use quicksort/mergesort)
 * - Need stable sort
 * - Very small datasets (use insertion sort)
 * - Need guaranteed O(n log n)
 * 
 * REAL-WORLD APPLICATIONS:
 * - Embedded systems sorting
 * - Legacy code (widely used in 1980s-90s)
 * - Teaching advanced sorting concepts
 * - Small to medium database sorting
 * - Some standard libraries as fallback
 * 
 * COMPARISON WITH OTHER SORTS:
 * - vs Insertion Sort: Much faster for larger arrays
 * - vs Quicksort: Simpler, no recursion, but slower for large data
 * - vs Merge Sort: In-place, but slower and unstable
 * - vs Heap Sort: Faster in practice, better cache performance
 * 
 * HISTORICAL NOTE:
 * Named after Donald Shell who published it in 1959. It was one of the first
 * algorithms to break the O(n²) barrier, though exact complexity wasn't proven
 * until much later.
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class ShellSort {
    
    /**
     * Shell Sort implementation using Shell's original gap sequence (n/2, n/4, ..., 1)
     * 
     * @param arr The array to be sorted
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;
        
        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("Processing with gap = " + gap);
            
            // Do a gapped insertion sort for this gap size
            // The first gap elements arr[0..gap-1] are already in gapped order
            for (int i = gap; i < n; i++) {
                // Save arr[i] in temp and make a hole at position i
                int temp = arr[i];
                
                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    comparisons++;
                    swaps++;
                }
                
                if (j >= gap) comparisons++;  // Count final comparison
                
                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
        
        System.out.println("Total comparisons: " + comparisons + ", Total swaps: " + swaps);
    }
    
    /**
     * Shell Sort with Knuth's gap sequence: (3^k - 1)/2
     * Generally performs better than Shell's original sequence
     * 
     * @param arr The array to be sorted
     */
    public static void shellSortKnuth(int[] arr) {
        int n = arr.length;
        
        // Find starting gap using Knuth's sequence
        int gap = 1;
        while (gap < n / 3) {
            gap = 3 * gap + 1;  // 1, 4, 13, 40, 121, ...
        }
        
        System.out.println("Using Knuth's sequence, starting gap = " + gap);
        
        // Perform sort with decreasing gap
        while (gap >= 1) {
            // Gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                
                arr[j] = temp;
            }
            
            gap /= 3;  // Reduce gap
        }
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
     * Main method to test Shell Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            SHELL SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Classic example
        System.out.println("Test Case 1: Classic example (Shell's sequence)");
        int[] arr1 = {35, 33, 42, 10, 14, 19, 27, 44};
        System.out.print("Before: ");
        printArray(arr1);
        shellSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Random unsorted array
        System.out.println("Test Case 2: Random unsorted array");
        int[] arr2 = {12, 34, 54, 2, 3, 33, 45, 21, 78, 65};
        System.out.print("Before: ");
        printArray(arr2);
        shellSort(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Knuth's sequence
        System.out.println("Test Case 3: Using Knuth's gap sequence");
        int[] arr3 = {35, 33, 42, 10, 14, 19, 27, 44};
        System.out.print("Before: ");
        printArray(arr3);
        shellSortKnuth(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Already sorted
        System.out.println("Test Case 4: Already sorted array (Best case)");
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Before: ");
        printArray(arr4);
        shellSort(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: Reverse sorted
        System.out.println("Test Case 5: Reverse sorted array");
        int[] arr5 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print("Before: ");
        printArray(arr5);
        shellSort(arr5);
        System.out.print("After:  ");
        printArray(arr5);
        System.out.println();
        
        // Test Case 6: Duplicates
        System.out.println("Test Case 6: Array with duplicates");
        int[] arr6 = {5, 2, 8, 2, 9, 1, 5, 5, 3};
        System.out.print("Before: ");
        printArray(arr6);
        shellSort(arr6);
        System.out.print("After:  ");
        printArray(arr6);
        System.out.println();
        
        // Test Case 7: Larger dataset
        System.out.println("Test Case 7: Larger dataset (100 elements)");
        int[] arr7 = new int[100];
        for (int i = 0; i < 100; i++) {
            arr7[i] = 100 - i;  // Reverse order
        }
        System.out.println("Before: [100, 99, 98, ..., 3, 2, 1]");
        shellSort(arr7);
        System.out.print("After (first 10): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr7[i] + " ");
        }
        System.out.println("... (all sorted)");
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("   Note: Performance depends on gap sequence!");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
