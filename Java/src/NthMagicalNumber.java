public class NthMagicalNumber {
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    
    public int nthMagicalNumber(int N, int A, int B) {
        long c = A * B / gcd(A, B), left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid / A + mid / B - mid / c < N)
                left = mid + 1;
            else
                right = mid;
        }
        return (int)(left % 1_000_000_007);
    }
}
