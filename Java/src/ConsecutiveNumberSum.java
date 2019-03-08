public class ConsecutiveNumberSum {
    // TLE for large N
    public int consecutiveNumbersSumNaive(int N) {
        int res = 1;
        // i stands for the number of parts to split.
        // Split into odd parts.
        for (int i = 3; i < N; i += 2) {
            if (N % i != 0)
                continue;
            int tmp = N / i - i / 2;
            if (tmp > 0)
                res++;
        }
        // Split into even parts.
        for (int i = 2; i < N; i += 2) {
            if (N % (i / 2) != 0)
                continue;
            int tmp = N / (i / 2) - i + 1;
            if (tmp > 0 && tmp % 2 == 0)
                res++;
        }
        return res;
    }

    // start from a, and split for b parts:
    // a + (a + 1) + ... + (a + b - 1) = a * b + (b - 1) * b / 2
    // = (2 * a + b - 1) * b / 2.
    public int consecutiveNumbersSumNaive2(int N) {
        int res = 0;
        N *= 2;
        for (int i = 1; i < N / 2; i++) {
            if (N % i != 0)
                continue;
            int tmp = N / i - i + 1;
            if (tmp > 0 && tmp % 2 == 0)
                res++;
        }
        return res;
    }

    // O(n^0.5), beautiful answer.
    // (N - (b - 1) * b / 2) % b == 0.
    public int consecutiveNumbersSum(int N) {
        int res = 0, tmp = 0;
        for (int b = 1; tmp < N; b++, tmp = (b - 1) * b / 2) {
            if ((N - tmp) % b == 0)
                res++;
        }
        return res;
    }
}
