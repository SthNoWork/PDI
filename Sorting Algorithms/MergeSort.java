/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * MERGE SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Merge Sort is a divide-and-conquer algorithm that divides the array into two
 * halves, recursively sorts them, and then merges the sorted halves back together.
 * It's one of the most efficient sorting algorithms for large datasets.
 * 
 * HOW IT WORKS:
 * 1. DIVIDE: Split the array into two halves
 * 2. CONQUER: Recursively sort each half
 * 3. COMBINE: Merge the two sorted halves into one sorted array
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [38, 27, 43, 3, 9, 82, 10]
 * 
 * DIVIDE Phase:
 *                    [38, 27, 43, 3, 9, 82, 10]
 *                   /                          \
 *           [38, 27, 43, 3]                [9, 82, 10]
 *           /            \                  /          \
 *      [38, 27]        [43, 3]         [9, 82]        [10]
 *      /     \         /     \         /     \
 *    [38]   [27]    [43]   [3]      [9]   [82]
 * 
 * MERGE Phase:
 *    [27, 38]        [3, 43]         [9, 82]
 *         \             /                 \
 *      [3, 27, 38, 43]                [9, 10, 82]
 *                \                        /
 *             [3, 9, 10, 27, 38, 43, 82]
 * 
 * TIME COMPLEXITY:
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n log n) - Consistent performance!
 * 
 * SPACE COMPLEXITY: O(n) - requires additional array for merging
 * 
 * STABILITY: Stable - maintains relative order of equal elements
 * 
 * USE CASES:
 * - Large datasets where O(n log n) is needed
 * - When stable sort is required
 * - External sorting (sorting data that doesn't fit in memory)
 * - Linked lists (very efficient, O(1) space)
 * - When worst-case O(n log n) is required
 * 
 * ADVANTAGES:
 * + Guaranteed O(n log n) time complexity
 * + Stable sort
 * + Parallelizable (can sort subarrays independently)
 * + Good for linked lists
 * + Predictable performance
 * + Works well with any type of data
 * 
 * DISADVANTAGES:
 * - Requires O(n) extra space
 * - Slower than quicksort in practice for arrays
 * - Not in-place (needs auxiliary array)
 * - Recursive overhead
 * 
 * COMPARISON WITH QUICKSORT:
 * - Merge Sort: Stable, O(n) space, guaranteed O(n log n)
 * - Quick Sort: Unstable, O(log n) space, average O(n log n), worst O(n²)
 * 
 * REAL-WORLD APPLICATIONS:
 * - Java's Arrays.sort() for objects
 * - Python's sorted() and list.sort()
 * - External sorting in databases
 * - Inversion count problems
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class MergeSort {
    
    /**
     * Merge Sort implementation - main function
     * 
     * @param arr The array to be sorted
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSortHelper(arr, 0, arr.length - 1);
    }
    
    /**
     * Recursive helper function for merge sort
     * 
     * @param arr Array to sort
     * @param left Starting index
     * @param right Ending index
     */
    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;
            
            // Sort first half
            mergeSortHelper(arr, left, mid);
            
            // Sort second half
            mergeSortHelper(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    /**
     * Merges two sorted subarrays
     * 
     * @param arr Array containing both subarrays
     * @param left Starting index of left subarray
     * @param mid Ending index of left subarray
     * @param right Ending index of right subarray
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        
        // Merge the temporary arrays back
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
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
     * Main method to test Merge Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            MERGE SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Random unsorted array
        System.out.println("Test Case 1: Random unsorted array");
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.print("Before: ");
        printArray(arr1);
        mergeSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Already sorted array
        System.out.println("Test Case 2: Already sorted array");
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.print("Before: ");
        printArray(arr2);
        mergeSort(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Reverse sorted array
        System.out.println("Test Case 3: Reverse sorted array");
        int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print("Before: ");
        printArray(arr3);
        mergeSort(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Array with duplicates
        System.out.println("Test Case 4: Array with duplicate values");
        int[] arr4 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.print("Before: ");
        printArray(arr4);
        mergeSort(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: Large dataset
        System.out.println("Test Case 5: Larger dataset (100 elements)");
        int[] arr5 = new int[100];
        for (int i = 0; i < 100; i++) {
            arr5[i] = 100 - i;  // Reverse order
        }
        System.out.println("Before: [100, 99, 98, ..., 3, 2, 1]");
        mergeSort(arr5);
        System.out.print("After (first 10):  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr5[i] + " ");
        }
        System.out.println("... (all sorted)");
        System.out.println();
        
        // Test Case 6: Single and two elements
        System.out.println("Test Case 6: Edge cases");
        int[] arr6a = {42};
        System.out.print("Single element - Before: ");
        printArray(arr6a);
        mergeSort(arr6a);
        System.out.print("After: ");
        printArray(arr6a);
        
        int[] arr6b = {5, 2};
        System.out.print("Two elements - Before: ");
        printArray(arr6b);
        mergeSort(arr6b);
        System.out.print("After: ");
        printArray(arr6b);
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
