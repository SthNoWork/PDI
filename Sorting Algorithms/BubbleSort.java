/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * BUBBLE SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Bubble Sort is a simple comparison-based sorting algorithm. It repeatedly steps
 * through the list, compares adjacent elements, and swaps them if they are in the
 * wrong order. This process continues until no more swaps are needed.
 * 
 * HOW IT WORKS:
 * 1. Start at the beginning of the array
 * 2. Compare each pair of adjacent elements
 * 3. Swap them if they are in the wrong order
 * 4. After one complete pass, the largest element "bubbles up" to the end
 * 5. Repeat for the remaining unsorted portion
 * 6. Continue until no swaps are made in a complete pass
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [64, 34, 25, 12, 22, 11, 90]
 * 
 * Pass 1: [34, 25, 12, 22, 11, 64, 90]  → 90 bubbles to end
 * Pass 2: [25, 12, 22, 11, 34, 64, 90]  → 64 bubbles to position
 * Pass 3: [12, 22, 11, 25, 34, 64, 90]  → 34 bubbles to position
 * Pass 4: [12, 11, 22, 25, 34, 64, 90]  → 25 bubbles to position
 * Pass 5: [11, 12, 22, 25, 34, 64, 90]  → 22 bubbles to position
 * Pass 6: [11, 12, 22, 25, 34, 64, 90]  → Already sorted
 * 
 * TIME COMPLEXITY:
 * - Best Case: O(n) - when array is already sorted
 * - Average Case: O(n²)
 * - Worst Case: O(n²) - when array is reverse sorted
 * 
 * SPACE COMPLEXITY: O(1) - sorts in place
 * 
 * STABILITY: Stable - maintains relative order of equal elements
 * 
 * USE CASES:
 * - Small datasets (< 10 elements)
 * - Educational purposes (easy to understand)
 * - Nearly sorted data (with optimization)
 * - Memory is extremely limited (in-place sorting)
 * 
 * ADVANTAGES:
 * + Simple to understand and implement
 * + No additional memory required
 * + Stable sort
 * + Can detect if list is already sorted
 * 
 * DISADVANTAGES:
 * - Very slow for large datasets
 * - O(n²) comparisons in worst case
 * - Not suitable for production use with large data
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class BubbleSort {
    
    /**
     * Bubble Sort implementation with optimization
     * Stops early if no swaps are made in a pass
     * 
     * @param arr The array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Inner loop for comparisons in current pass
            // -i because last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap if they are in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swaps were made, array is sorted
            if (!swapped) {
                System.out.println("Array sorted after " + (i + 1) + " passes (early termination)");
                break;
            }
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
     * Main method to test Bubble Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("           BUBBLE SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Random unsorted array
        System.out.println("Test Case 1: Random unsorted array");
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Before: ");
        printArray(arr1);
        bubbleSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Already sorted array
        System.out.println("Test Case 2: Already sorted array");
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("Before: ");
        printArray(arr2);
        bubbleSort(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Reverse sorted array
        System.out.println("Test Case 3: Reverse sorted array (Worst Case)");
        int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print("Before: ");
        printArray(arr3);
        bubbleSort(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Array with duplicates
        System.out.println("Test Case 4: Array with duplicate values");
        int[] arr4 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.print("Before: ");
        printArray(arr4);
        bubbleSort(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: Single element
        System.out.println("Test Case 5: Single element array");
        int[] arr5 = {42};
        System.out.print("Before: ");
        printArray(arr5);
        bubbleSort(arr5);
        System.out.print("After:  ");
        printArray(arr5);
        System.out.println();
        
        // Test Case 6: Large numbers
        System.out.println("Test Case 6: Large numbers");
        int[] arr6 = {1000, 500, 2000, 100, 5000, 300};
        System.out.print("Before: ");
        printArray(arr6);
        bubbleSort(arr6);
        System.out.print("After:  ");
        printArray(arr6);
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
