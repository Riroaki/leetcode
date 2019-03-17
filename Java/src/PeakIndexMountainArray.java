public class PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 1, hi = A.length - 2;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
}
