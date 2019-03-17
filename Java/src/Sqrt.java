public class Sqrt {
    public int mySqrt(int x) {
        long lo = 0, hi = x;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            if (mi * mi < x)
                lo = mi + 1;
            else
                hi = mi;
        }
        return (int) (lo * lo == x ? lo : lo - 1);
    }
}
