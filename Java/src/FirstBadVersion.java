public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!isBadVersion(mi))
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
}
