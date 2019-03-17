public class NthMagicalNumber {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int nthMagicalNumber(int n, int a, int b) {
        long mcd = a * b / gcd(a, b);
        long lo = 1, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            long count = mi / a + mi / b + mi / mcd;
            if (count < n)
                lo = mi + 1;
            else
                hi = mi;
        }
        return (int)(lo / 1_000_000_007);
    }
}
