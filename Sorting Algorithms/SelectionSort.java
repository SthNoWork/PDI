/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * SELECTION SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Selection Sort divides the array into sorted and unsorted portions. It repeatedly
 * selects the smallest (or largest) element from the unsorted portion and moves it
 * to the end of the sorted portion.
 * 
 * HOW IT WORKS:
 * 1. Start with the entire array as unsorted
 * 2. Find the minimum element in the unsorted portion
 * 3. Swap it with the first element of the unsorted portion
 * 4. Move the boundary between sorted and unsorted portions one element forward
 * 5. Repeat until the entire array is sorted
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [64, 25, 12, 22, 11]
 * 
 * Pass 1: Find min (11), swap with position 0
 *         [11, 25, 12, 22, 64]  → 11 is now sorted
 * 
 * Pass 2: Find min (12), swap with position 1
 *         [11, 12, 25, 22, 64]  → 11, 12 are sorted
 * 
 * Pass 3: Find min (22), swap with position 2
 *         [11, 12, 22, 25, 64]  → 11, 12, 22 are sorted
 * 
 * Pass 4: Find min (25), already in position
 *         [11, 12, 22, 25, 64]  → 11, 12, 22, 25 are sorted
 * 
 * Pass 5: Last element is automatically sorted
 *         [11, 12, 22, 25, 64]  → All sorted
 * 
 * TIME COMPLEXITY:
 * - Best Case: O(n²) - even if sorted, still scans entire array
 * - Average Case: O(n²)
 * - Worst Case: O(n²)
 * 
 * SPACE COMPLEXITY: O(1) - sorts in place
 * 
 * STABILITY: Unstable - may change relative order of equal elements
 * 
 * USE CASES:
 * - Small datasets
 * - When memory is limited (in-place sorting)
 * - When number of swaps needs to be minimized
 * - Simple sorting with predictable performance
 * 
 * ADVANTAGES:
 * + Simple to understand and implement
 * + Performs well on small lists
 * + Minimum number of swaps: O(n)
 * + Works well when writing to memory is expensive
 * + No additional memory required
 * 
 * DISADVANTAGES:
 * - Always O(n²) time complexity, even for sorted arrays
 * - Not stable
 * - Not adaptive (doesn't benefit from partially sorted data)
 * - Poor performance on large datasets
 * 
 * COMPARISON WITH BUBBLE SORT:
 * - Selection Sort: Fewer swaps, always O(n²)
 * - Bubble Sort: More swaps, can be O(n) for sorted arrays
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class SelectionSort {
    
    /**
     * Selection Sort implementation
     * Finds minimum element and places it at the beginning
     * 
     * @param arr The array to be sorted
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        
        // Move boundary of unsorted portion one element at a time
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted portion
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                swapCount++;
            }
        }
        
        System.out.println("Total swaps made: " + swapCount);
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
     * Main method to test Selection Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("          SELECTION SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Random unsorted array
        System.out.println("Test Case 1: Random unsorted array");
        int[] arr1 = {64, 25, 12, 22, 11};
        System.out.print("Before: ");
        printArray(arr1);
        selectionSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Already sorted array
        System.out.println("Test Case 2: Already sorted array");
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("Before: ");
        printArray(arr2);
        selectionSort(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Reverse sorted array
        System.out.println("Test Case 3: Reverse sorted array (Worst Case)");
        int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print("Before: ");
        printArray(arr3);
        selectionSort(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Array with duplicates
        System.out.println("Test Case 4: Array with duplicate values");
        int[] arr4 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.print("Before: ");
        printArray(arr4);
        selectionSort(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: Two elements
        System.out.println("Test Case 5: Two element array");
        int[] arr5 = {42, 13};
        System.out.print("Before: ");
        printArray(arr5);
        selectionSort(arr5);
        System.out.print("After:  ");
        printArray(arr5);
        System.out.println();
        
        // Test Case 6: All same elements
        System.out.println("Test Case 6: All same elements");
        int[] arr6 = {7, 7, 7, 7, 7};
        System.out.print("Before: ");
        printArray(arr6);
        selectionSort(arr6);
        System.out.print("After:  ");
        printArray(arr6);
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
