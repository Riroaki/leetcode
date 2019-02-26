public class Sort {
    private static void sort(Comparable[] a) {
        // sort a.
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (Comparable i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    private boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    private static void main(String[] args) {
        String[] a = System.in.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
