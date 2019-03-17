public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long lo = 1, hi = n;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            if (mi * (mi + 1) / 2 < n)
                lo = mi + 1;
            else
                hi = mi;
        }
        return (int) (lo * (lo + 1) / 2 == n ? lo : lo - 1);
    }
}
