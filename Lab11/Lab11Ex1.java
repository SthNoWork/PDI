public class Lab11Ex1 {
    public static void main(String[] args) {
        int[] array = { 90, 6, -10, 2, 70, 9, 1, 5, 22 };
        bubbleSort(array);
        for (int v : array)
            System.out.print(v + " ");
        System.out.println();
    }

    static void bubbleSort(int[] x) {
        int n = x.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    int t = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = t;
                }
            }
        }
    }
}
