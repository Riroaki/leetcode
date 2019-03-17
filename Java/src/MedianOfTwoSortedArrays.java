public class MedianOfTwoSortedArrays {
    // O(n1 + n2) sol. Merge the two arrays.
    public double findMedianSortedArraysNaive(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        int[] c = new int[n1 + n2];
        int i1 = 0, i2 =  0, i = 0;
        while (i1 < n1 && i2 < n2) {
            if (a[i1] < b[i2])
                c[i++] = a[i1++];
            else
                c[i++] = b[i2++];
        }
        while (i1 < n1)
            c[i++] = a[i1++];
        while (i2 < n2)
            c[i++] = b[i2++];
        int half = (n1 + n2) / 2;
        if (half % 2 == 1)
            return (double)c[half];
        return (c[half] + c[half - 1]) / 2.0;
    }

    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //...
        return 0.0;
    }
}
