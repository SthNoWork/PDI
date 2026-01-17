public class Lab11Ex5 {
    public static void main(String[] args) {
        float[] scores = { 90.5f, 20, 50, 75, 80, 85, 69, 0, 80, 40, 70 };
        System.out.println("Original:");
        print(scores);
        mergeSort(scores, 0, scores.length - 1);
        System.out.println("Sorted ascending:");
        print(scores);
    }

    static void mergeSort(float[] a, int l, int r) {
        if (l >= r)
            return;
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    static void merge(float[] a, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        float[] L = new float[n1];
        float[] R = new float[n2];
        for (int i = 0; i < n1; i++)
            L[i] = a[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = a[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                a[k++] = L[i++];
            else
                a[k++] = R[j++];
        }
        while (i < n1)
            a[k++] = L[i++];
        while (j < n2)
            a[k++] = R[j++];
    }

    static void print(float[] a) {
        for (float v : a)
            System.out.print(v + " ");
        System.out.println();
    }
}
