public class ShellSort {
    public static class sort(Comparable[] a) {
        int N = a.length, h = 1;
	while (h < N / 3)
	    h = 3 * h + 1;
	while (h >= 1) {
	    for (int i = h; i < N; i++) {
	        for (int j = i; j >= h && less(a[j], a[j - h]; j -= h) {
		    exch(a, j, j - h);
		}
	    }
	    h /= 3;
	}
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
	a[i] = a[j];
	a[j] = t;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
	    if (less(a[i], a[i - 1])
		return false;
	return true;
    }
}
