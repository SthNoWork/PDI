public class Lab11Ex3 {
    public static void main(String[] args) {
        String[] name = { "Dara", "Sok", "Sokha", "Daro", "Panha", "Pisey" };
        selectionSort(name);
        for (String s : name)
            System.out.println(s);
    }

    static void selectionSort(String[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(a[min]) < 0)
                    min = j;
            }
            String t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }
}
