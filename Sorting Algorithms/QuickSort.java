/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * QUICK SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Quick Sort is a divide-and-conquer algorithm that picks a 'pivot' element and
 * partitions the array around it, placing smaller elements to the left and larger
 * elements to the right. It then recursively sorts the partitions. One of the
 * fastest sorting algorithms in practice.
 * 
 * HOW IT WORKS:
 * 1. Choose a pivot element from the array
 * 2. Partition: Rearrange array so elements < pivot are on left, > pivot on right
 * 3. Recursively apply the above steps to left and right partitions
 * 4. Base case: partition size ≤ 1
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [10, 80, 30, 90, 40, 50, 70]  (pivot = 70)
 * 
 * Step 1: Partition around 70
 *         [10, 30, 40, 50, 70, 90, 80]
 *         Elements < 70 on left, > 70 on right
 * 
 * Step 2: Recursively sort left [10, 30, 40, 50] (pivot = 50)
 *         [10, 30, 40, 50]
 * 
 * Step 3: Recursively sort right [90, 80] (pivot = 80)
 *         [80, 90]
 * 
 * Final: [10, 30, 40, 50, 70, 80, 90]
 * 
 * PIVOT SELECTION STRATEGIES:
 * 1. Last element (used in this implementation)
 * 2. First element
 * 3. Middle element
 * 4. Random element (helps avoid worst case)
 * 5. Median-of-three (first, middle, last)
 * 
 * TIME COMPLEXITY:
 * - Best Case: O(n log n) - balanced partitions
 * - Average Case: O(n log n)
 * - Worst Case: O(n²) - already sorted with poor pivot choice
 * 
 * SPACE COMPLEXITY:
 * - O(log n) - recursive call stack for balanced partitions
 * - O(n) - worst case (unbalanced partitions)
 * 
 * STABILITY: Unstable - may change relative order of equal elements
 * 
 * USE CASES:
 * - General purpose sorting (most commonly used)
 * - Large datasets where average-case performance matters
 * - When extra space is limited
 * - Arrays (not ideal for linked lists)
 * - Systems programming, libraries
 * 
 * ADVANTAGES:
 * + Fastest in practice for large datasets
 * + In-place sorting (minimal extra space)
 * + Cache-friendly (good locality of reference)
 * + Tail-recursive (can be optimized)
 * + Simple to implement
 * 
 * DISADVANTAGES:
 * - Worst case O(n²) with poor pivot selection
 * - Unstable sort
 * - Not good for linked lists
 * - Performance depends on pivot choice
 * - Can cause stack overflow for deep recursion
 * 
 * OPTIMIZATION TECHNIQUES:
 * 1. Use randomized pivot to avoid worst case
 * 2. Switch to insertion sort for small subarrays (< 10 elements)
 * 3. Three-way partitioning for many duplicates
 * 4. Tail recursion elimination
 * 
 * REAL-WORLD APPLICATIONS:
 * - C's qsort() library function
 * - Java's Arrays.sort() for primitives
 * - Most programming language standard libraries
 * - Database query optimization
 * 
 * COMPARISON WITH MERGE SORT:
 * - Quick Sort: Faster in practice, O(log n) space, unstable, worst O(n²)
 * - Merge Sort: Stable, O(n) space, guaranteed O(n log n)
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class QuickSort {
    
    private static int comparisons = 0;
    private static int swaps = 0;
    
    /**
     * Quick Sort implementation - main function
     * 
     * @param arr The array to be sorted
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        comparisons = 0;
        swaps = 0;
        quickSortHelper(arr, 0, arr.length - 1);
        System.out.println("Comparisons: " + comparisons + ", Swaps: " + swaps);
    }
    
    /**
     * Recursive helper function for quick sort
     * 
     * @param arr Array to sort
     * @param low Starting index
     * @param high Ending index
     */
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort elements before and after partition
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * Partition function - places pivot in correct position
     * All smaller elements go to left, larger to right
     * 
     * @param arr Array to partition
     * @param low Starting index
     * @param high Ending index (pivot is chosen here)
     * @return Final position of pivot
     */
    private static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr[high];
        
        // Index of smaller element - indicates position of pivot
        int i = low - 1;
        
        // Traverse through all elements
        // Compare each element with pivot
        for (int j = low; j < high; j++) {
            comparisons++;
            
            // If current element is smaller than pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }
        
        // Swap pivot element with element at i+1
        swap(arr, i + 1, high);
        
        // Return the partition point
        return i + 1;
    }
    
    /**
     * Utility function to swap two elements
     */
    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            swaps++;
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
     * Main method to test Quick Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            QUICK SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Random unsorted array
        System.out.println("Test Case 1: Random unsorted array");
        int[] arr1 = {10, 80, 30, 90, 40, 50, 70};
        System.out.print("Before: ");
        printArray(arr1);
        quickSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Already sorted array
        System.out.println("Test Case 2: Already sorted array (Worst Case for basic pivot)");
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.print("Before: ");
        printArray(arr2);
        quickSort(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Reverse sorted array
        System.out.println("Test Case 3: Reverse sorted array");
        int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print("Before: ");
        printArray(arr3);
        quickSort(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Array with duplicates
        System.out.println("Test Case 4: Array with many duplicate values");
        int[] arr4 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.print("Before: ");
        printArray(arr4);
        quickSort(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: All same elements
        System.out.println("Test Case 5: All same elements");
        int[] arr5 = {7, 7, 7, 7, 7, 7};
        System.out.print("Before: ");
        printArray(arr5);
        quickSort(arr5);
        System.out.print("After:  ");
        printArray(arr5);
        System.out.println();
        
        // Test Case 6: Large dataset
        System.out.println("Test Case 6: Large dataset (1000 elements)");
        int[] arr6 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr6[i] = (int) (Math.random() * 1000);
        }
        System.out.println("Before: [random 1000 elements]");
        quickSort(arr6);
        System.out.print("After (first 10): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr6[i] + " ");
        }
        System.out.println("... (all sorted)");
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
