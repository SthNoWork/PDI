/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * INSERTION SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Insertion Sort builds the sorted array one element at a time by repeatedly taking
 * the next element and inserting it into its correct position among the previously
 * sorted elements. Similar to how you sort playing cards in your hands.
 * 
 * HOW IT WORKS:
 * 1. Start with the second element (assume first element is sorted)
 * 2. Compare it with elements in the sorted portion (to its left)
 * 3. Shift all larger elements one position to the right
 * 4. Insert the element in its correct position
 * 5. Repeat for all remaining elements
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [12, 11, 13, 5, 6]
 * 
 * Pass 1: key = 11
 *         [11, 12, 13, 5, 6]  → 11 inserted before 12
 * 
 * Pass 2: key = 13
 *         [11, 12, 13, 5, 6]  → 13 already in correct position
 * 
 * Pass 3: key = 5
 *         [5, 11, 12, 13, 6]  → 5 inserted at beginning
 * 
 * Pass 4: key = 6
 *         [5, 6, 11, 12, 13]  → 6 inserted after 5
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
 * - Small datasets (< 20 elements)
 * - Nearly sorted data (very efficient!)
 * - Online sorting (can sort data as it arrives)
 * - When data is being received in real-time
 * - As part of more complex algorithms (Timsort, Introsort)
 * 
 * ADVANTAGES:
 * + Simple and intuitive
 * + Efficient for small datasets
 * + Adaptive - O(n) for nearly sorted data
 * + Stable sort
 * + In-place (no extra memory)
 * + Online algorithm (can sort as data arrives)
 * 
 * DISADVANTAGES:
 * - O(n²) for large datasets
 * - Inefficient for reverse sorted arrays
 * - Many shift operations for large elements
 * 
 * REAL-WORLD ANALOGY:
 * Like sorting playing cards: pick one card at a time and insert it
 * into its correct position among the cards already in your hand.
 * 
 * WHEN TO USE:
 * - Array is small (typically < 20 elements)
 * - Array is nearly sorted
 * - Simplicity is more important than speed
 * - Used as final step in hybrid sorting algorithms
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class InsertionSort {
    
    /**
     * Insertion Sort implementation
     * Inserts each element into its correct position in the sorted portion
     * 
     * @param arr The array to be sorted
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int shifts = 0;
        
        // Start from second element (first is considered sorted)
        for (int i = 1; i < n; i++) {
            int key = arr[i];  // Element to be inserted
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
                shifts++;
            }
            
            // Insert key at correct position
            arr[j + 1] = key;
            
            if (j >= 0) comparisons++;  // Count final comparison
        }
        
        System.out.println("Comparisons: " + comparisons + ", Shifts: " + shifts);
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
     * Main method to test Insertion Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("          INSERTION SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Random unsorted array
        System.out.println("Test Case 1: Random unsorted array");
        int[] arr1 = {12, 11, 13, 5, 6};
        System.out.print("Before: ");
        printArray(arr1);
        insertionSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Already sorted array (Best Case)
        System.out.println("Test Case 2: Already sorted array (Best Case - O(n))");
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("Before: ");
        printArray(arr2);
        insertionSort(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Reverse sorted array (Worst Case)
        System.out.println("Test Case 3: Reverse sorted array (Worst Case - O(n²))");
        int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print("Before: ");
        printArray(arr3);
        insertionSort(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Nearly sorted array
        System.out.println("Test Case 4: Nearly sorted array (Very efficient!)");
        int[] arr4 = {1, 2, 3, 7, 5, 6, 4, 8};
        System.out.print("Before: ");
        printArray(arr4);
        insertionSort(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: Array with duplicates
        System.out.println("Test Case 5: Array with duplicate values");
        int[] arr5 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.print("Before: ");
        printArray(arr5);
        insertionSort(arr5);
        System.out.print("After:  ");
        printArray(arr5);
        System.out.println();
        
        // Test Case 6: Single element
        System.out.println("Test Case 6: Single element array");
        int[] arr6 = {42};
        System.out.print("Before: ");
        printArray(arr6);
        insertionSort(arr6);
        System.out.print("After:  ");
        printArray(arr6);
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
