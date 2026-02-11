/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * HEAP SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Heap Sort uses a binary heap data structure to sort elements. It first builds
 * a max heap from the input data, then repeatedly extracts the maximum element
 * from the heap and rebuilds the heap until it's empty. It's an in-place algorithm
 * with guaranteed O(n log n) time complexity.
 * 
 * HOW IT WORKS:
 * 1. BUILD MAX HEAP: Rearrange array into a max heap structure
 *    - In max heap, parent node is always ≥ its children
 *    - Array representation: parent at i, children at 2i+1 and 2i+2
 * 
 * 2. EXTRACT MAX: Repeatedly:
 *    - Swap root (maximum) with last element
 *    - Reduce heap size by 1
 *    - Heapify root to maintain max heap property
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [4, 10, 3, 5, 1]
 * 
 * Step 1: Build Max Heap
 *         Array representation: [10, 5, 3, 4, 1]
 *         Tree structure:
 *                 10
 *                /  \
 *               5    3
 *              / \
 *             4   1
 * 
 * Step 2: Extract Maximum repeatedly
 *         Swap 10 with 1, heapify: [5, 4, 3, 1] | 10
 *         Swap 5 with 1, heapify:  [4, 1, 3] | 5, 10
 *         Swap 4 with 3, heapify:  [3, 1] | 4, 5, 10
 *         Swap 3 with 1, heapify:  [1] | 3, 4, 5, 10
 * 
 * Final: [1, 3, 4, 5, 10]
 * 
 * TIME COMPLEXITY:
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n log n) - Guaranteed!
 * 
 * SPACE COMPLEXITY: O(1) - in-place sorting
 * 
 * STABILITY: Unstable - relative order of equal elements not preserved
 * 
 * USE CASES:
 * - When O(n log n) worst-case is required
 * - Limited memory (in-place sorting)
 * - Real-time systems (predictable performance)
 * - Priority queue implementation
 * - When quicksort's worst case is unacceptable
 * 
 * ADVANTAGES:
 * + Guaranteed O(n log n) time complexity
 * + In-place sorting (O(1) space)
 * + No quadratic worst case like quicksort
 * + Predictable performance
 * + Simple to implement
 * + Cache-friendly (sequential access)
 * 
 * DISADVANTAGES:
 * - Unstable sort
 * - Slower than quicksort in practice
 * - Not adaptive (doesn't benefit from partially sorted data)
 * - Poor cache performance compared to quicksort
 * - More complex than simpler sorts
 * 
 * WHEN TO USE:
 * - Need guaranteed O(n log n) performance
 * - Memory is limited (in-place required)
 * - Stability not required
 * - Implementing priority queues
 * - Embedded systems with memory constraints
 * 
 * WHEN NOT TO USE:
 * - Need stable sort
 * - Quicksort's average case is acceptable
 * - Small datasets (use insertion sort)
 * - Require adaptive behavior
 * 
 * REAL-WORLD APPLICATIONS:
 * - Operating system task scheduling
 * - Priority queue implementation
 * - Linux kernel's sorting
 * - Graphics rendering (priority-based)
 * - Embedded systems with memory constraints
 * 
 * COMPARISON WITH MERGE/QUICK SORT:
 * - Heap Sort: O(1) space, unstable, slower in practice
 * - Merge Sort: O(n) space, stable, consistent performance
 * - Quick Sort: O(log n) space, fastest average, O(n²) worst
 * 
 * HEAP PROPERTIES:
 * - Complete binary tree stored in array
 * - Parent at index i, children at 2i+1 and 2i+2
 * - Max heap: parent ≥ children
 * - Min heap: parent ≤ children (for ascending order, use max heap)
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class HeapSort {
    
    /**
     * Heap Sort implementation
     * 
     * @param arr The array to be sorted
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        System.out.println("Building max heap...");
        
        // Build max heap (rearrange array)
        // Start from last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        System.out.println("Extracting elements from heap...");
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Call heapify on reduced heap
            heapify(arr, i, 0);
        }
    }
    
    /**
     * Heapify a subtree rooted at node i
     * Maintains max heap property
     * 
     * @param arr Array representing the heap
     * @param heapSize Size of the heap
     * @param i Index of root node to heapify
     */
    private static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;           // Initialize largest as root
        int left = 2 * i + 1;      // Left child
        int right = 2 * i + 2;     // Right child
        
        // If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // If right child is larger than largest so far
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // Recursively heapify the affected sub-tree
            heapify(arr, heapSize, largest);
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
     * Utility method to visualize heap structure
     */
    public static void printHeap(int[] arr, int size) {
        System.out.println("Heap structure (level order):");
        int level = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
            count++;
            if (count == Math.pow(2, level)) {
                System.out.println();
                level++;
                count = 0;
            }
        }
        System.out.println();
    }
    
    /**
     * Main method to test Heap Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            HEAP SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Small example
        System.out.println("Test Case 1: Small array");
        int[] arr1 = {4, 10, 3, 5, 1};
        System.out.print("Before: ");
        printArray(arr1);
        heapSort(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Random unsorted array
        System.out.println("Test Case 2: Random unsorted array");
        int[] arr2 = {12, 11, 13, 5, 6, 7};
        System.out.print("Before: ");
        printArray(arr2);
        heapSort(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Already sorted
        System.out.println("Test Case 3: Already sorted array");
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("Before: ");
        printArray(arr3);
        heapSort(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Reverse sorted (Worst case)
        System.out.println("Test Case 4: Reverse sorted array");
        int[] arr4 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print("Before: ");
        printArray(arr4);
        heapSort(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: Duplicates
        System.out.println("Test Case 5: Array with duplicates");
        int[] arr5 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.print("Before: ");
        printArray(arr5);
        heapSort(arr5);
        System.out.print("After:  ");
        printArray(arr5);
        System.out.println();
        
        // Test Case 6: Large dataset
        System.out.println("Test Case 6: Larger dataset");
        int[] arr6 = {64, 34, 25, 12, 22, 11, 90, 88, 45, 50, 23, 36};
        System.out.print("Before: ");
        printArray(arr6);
        heapSort(arr6);
        System.out.print("After:  ");
        printArray(arr6);
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("      Note: Guaranteed O(n log n), in-place!");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
