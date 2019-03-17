public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (guess(mi) == 1)
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
}
