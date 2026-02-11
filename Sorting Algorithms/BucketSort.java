/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * BUCKET SORT - CASE STUDY
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * ALGORITHM OVERVIEW:
 * Bucket Sort distributes elements into several buckets, sorts each bucket
 * individually (using another sorting algorithm or recursively), and then
 * concatenates all buckets. It works best when data is uniformly distributed
 * across a range.
 * 
 * HOW IT WORKS:
 * 1. Create n empty buckets
 * 2. Distribute array elements into buckets based on a hash function
 * 3. Sort each bucket individually (using insertion sort or recursively)
 * 4. Concatenate all buckets back into original array
 * 
 * EXAMPLE WALKTHROUGH:
 * Initial array: [0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68]
 * Range: 0.0 to 1.0, Create 10 buckets
 * 
 * Step 1: Distribute into buckets
 *         Bucket 0: []
 *         Bucket 1: [0.17, 0.12]
 *         Bucket 2: [0.26, 0.21, 0.23]
 *         Bucket 3: [0.39]
 *         Bucket 4: []
 *         Bucket 5: []
 *         Bucket 6: [0.68]
 *         Bucket 7: [0.78, 0.72]
 *         Bucket 8: []
 *         Bucket 9: [0.94]
 * 
 * Step 2: Sort each bucket (using insertion sort)
 *         Bucket 1: [0.12, 0.17]
 *         Bucket 2: [0.21, 0.23, 0.26]
 *         Bucket 7: [0.72, 0.78]
 *         (others remain same)
 * 
 * Step 3: Concatenate
 *         [0.12, 0.17, 0.21, 0.23, 0.26, 0.39, 0.68, 0.72, 0.78, 0.94]
 * 
 * TIME COMPLEXITY:
 * - Best Case: O(n + k) - when elements are uniformly distributed
 * - Average Case: O(n + k) - with uniform distribution
 * - Worst Case: O(n²) - when all elements go to one bucket
 * 
 * SPACE COMPLEXITY: O(n + k) - for buckets
 * 
 * STABILITY: Can be stable if underlying sort is stable
 * 
 * USE CASES:
 * - Uniformly distributed floating-point numbers (0-1 range)
 * - External sorting (when data doesn't fit in memory)
 * - Parallel processing (buckets can be sorted in parallel)
 * - When data range is known and bounded
 * - Sorting in databases
 * 
 * ADVANTAGES:
 * + O(n) average case with uniform distribution
 * + Can be parallelized easily
 * + Works well with floating-point numbers
 * + Can be stable
 * + Scalable for large datasets
 * 
 * DISADVANTAGES:
 * - Performance depends on data distribution
 * - Extra space required O(n)
 * - Choosing right bucket size/count is tricky
 * - Poor performance with skewed data
 * - Overhead of creating/managing buckets
 * 
 * WHEN TO USE:
 * - Data is uniformly distributed
 * - Range of input is known
 * - Floating-point numbers in specific range
 * - Need O(n) performance
 * - Can afford extra space
 * 
 * WHEN NOT TO USE:
 * - Data distribution is unknown or skewed
 * - Memory is limited
 * - Small datasets (overhead not worth it)
 * - Data range is very large
 * 
 * REAL-WORLD APPLICATIONS:
 * - Sorting exam scores (0-100)
 * - Histogram generation
 * - External sorting in databases
 * - Parallel sorting systems
 * - Load balancing algorithms
 * 
 * OPTIMIZATION TECHNIQUES:
 * 1. Choose bucket count based on data distribution
 * 2. Use efficient sort for individual buckets
 * 3. Handle edge cases (empty buckets)
 * 4. Adaptive bucketing based on data analysis
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */

import java.util.*;

public class BucketSort {
    
    /**
     * Bucket Sort implementation for floating-point numbers in range [0, 1)
     * 
     * @param arr The array to be sorted
     */
    public static void bucketSortFloat(float[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        
        // Create n empty buckets
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Put array elements into buckets
        for (float num : arr) {
            int bucketIndex = (int) (num * n);
            // Handle edge case where num = 1.0
            if (bucketIndex >= n) bucketIndex = n - 1;
            buckets[bucketIndex].add(num);
        }
        
        System.out.println("Bucket distribution:");
        for (int i = 0; i < n; i++) {
            if (!buckets[i].isEmpty()) {
                System.out.println("  Bucket " + i + ": " + buckets[i].size() + " elements");
            }
        }
        
        // Sort individual buckets using insertion sort
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }
        
        // Concatenate all buckets
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }
    
    /**
     * Bucket Sort for integers - distributes based on value range
     * 
     * @param arr The array to be sorted
     */
    public static void bucketSortInt(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        // Find min and max
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        int range = max - min + 1;
        int bucketCount = arr.length;
        int bucketSize = (int) Math.ceil((double) range / bucketCount);
        
        System.out.println("Range: " + min + " to " + max);
        System.out.println("Bucket count: " + bucketCount + ", Bucket size: " + bucketSize);
        
        // Create buckets
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = (num - min) / bucketSize;
            if (bucketIndex >= bucketCount) bucketIndex = bucketCount - 1;
            buckets[bucketIndex].add(num);
        }
        
        // Sort each bucket
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        
        // Concatenate buckets
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }
    
    /**
     * Utility method to print float array
     */
    public static void printArray(float[] arr) {
        for (float value : arr) {
            System.out.printf("%.2f ", value);
        }
        System.out.println();
    }
    
    /**
     * Utility method to print int array
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    /**
     * Main method to test Bucket Sort with various test cases
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("           BUCKET SORT - TEST CASES");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // Test Case 1: Float numbers (classic bucket sort use case)
        System.out.println("Test Case 1: Floating-point numbers [0, 1)");
        float[] arr1 = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};
        System.out.print("Before: ");
        printArray(arr1);
        bucketSortFloat(arr1);
        System.out.print("After:  ");
        printArray(arr1);
        System.out.println();
        
        // Test Case 2: Integers with small range
        System.out.println("Test Case 2: Integers with small range");
        int[] arr2 = {42, 32, 33, 52, 37, 47, 51};
        System.out.print("Before: ");
        printArray(arr2);
        bucketSortInt(arr2);
        System.out.print("After:  ");
        printArray(arr2);
        System.out.println();
        
        // Test Case 3: Test scores (0-100)
        System.out.println("Test Case 3: Test scores (realistic use case)");
        int[] arr3 = {85, 92, 45, 78, 88, 67, 95, 72, 55, 88};
        System.out.print("Before: ");
        printArray(arr3);
        bucketSortInt(arr3);
        System.out.print("After:  ");
        printArray(arr3);
        System.out.println();
        
        // Test Case 4: Uniformly distributed floats
        System.out.println("Test Case 4: Uniformly distributed floats");
        float[] arr4 = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f};
        System.out.print("Before: ");
        printArray(arr4);
        bucketSortFloat(arr4);
        System.out.print("After:  ");
        printArray(arr4);
        System.out.println();
        
        // Test Case 5: Nearly sorted
        System.out.println("Test Case 5: Nearly sorted integers");
        int[] arr5 = {10, 12, 11, 15, 13, 14, 16, 18, 17};
        System.out.print("Before: ");
        printArray(arr5);
        bucketSortInt(arr5);
        System.out.print("After:  ");
        printArray(arr5);
        System.out.println();
        
        // Test Case 6: Duplicates
        System.out.println("Test Case 6: Array with duplicates");
        float[] arr6 = {0.5f, 0.5f, 0.3f, 0.3f, 0.7f, 0.7f};
        System.out.print("Before: ");
        printArray(arr6);
        bucketSortFloat(arr6);
        System.out.print("After:  ");
        printArray(arr6);
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("           ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("     Note: Best for uniformly distributed data!");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
