import java.util.Random;

public class Lab11Ex4 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[25];
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(100);
        System.out.println("Original:");
        print(array);

        insertionSortDesc(array);
        System.out.println("Sorted descending:");
        print(array);

        insertionSortAsc(array);
        System.out.println("Sorted ascending:");
        print(array);
    }

    static void insertionSortDesc(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static void insertionSortAsc(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static void print(int[] a) {
        for (int v : a)
            System.out.print(v + " ");
        System.out.println();
    }
}
