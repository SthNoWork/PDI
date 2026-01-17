import java.util.Scanner;

public class Lab11Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++)
            a[i] = sc.nextInt();
        selectionSortDesc(a);
        for (int v : a)
            System.out.print(v + " ");
        System.out.println();
        sc.close();
    }

    static void selectionSortDesc(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++)
                if (a[j] > a[max])
                    max = j;
            int t = a[i];
            a[i] = a[max];
            a[max] = t;
        }
    }
}
