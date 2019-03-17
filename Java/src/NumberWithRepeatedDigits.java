public class NumberWithRepeatedDigits {
    // TLE
    // Naive 1. O(n log n), just look for all repeated numbers.
    public int numDupDigitsAtMostN1(int n) {
        int res = 0;
        int[] digits = new int[10];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(digits, 0);
            for (int j = i; j > 0; j /= 10)
                digits[j % 10]++;
            for (int count : digits)
                if (count > 1)
                    res++;
        }
        return res;
    }
    
    // TLE
    // Naive 2. better O(n log n), and when last digit is not 0, just update in O(1) time;
    // but O(log n) when updating numbers ending with 0 (needs to check duplicate count again).
    public int numDupDigitsAtMostN2(int n) {
        int[] digitCount = new int[10];
        int res = 0, dupCount = 0;
        Arrays.fill(digitCount, 0);
        for (int i = 1; i <= n; i++) {
            int curr = i % 10;
            if (curr == 0) {
                Arrays.fill(digitCount, 0);
                dupCount = 0;
                for (int x = i; x > 0; x /= 10)
                    digitCount[x % 10]++;
                for (int j = 0; j < 10; j++)
                    if (digitCount[j] > 1)
                        dupCount++;
            } else {
                digitCount[curr]++;
                digitCount[curr - 1]--;
                if (digitCount[curr] == 2)
                    dupCount++;
                if (digitCount[curr - 1] == 1)
                    dupCount--;
            }
            if (dupCount != 0)
                res++;
        }
        return res;
    }

    // O(log n) time solution.
    // Count the number with distinct digits as res, and return n - res.
    // Example: 54321
    public int numDupDigitsAtMostN(int n) {
        List<Integer> digits = new ArrayList<>();
        for (int i = n + 1; i > 0; i /= 10)
            digits.add(0, i % 10);
        int res = 0, n = digits.size();
        // *, **, ***, **** until 54321
        for (int i = 1; i < n; i++)
            res += 9 * A(9, i - 1);
        // 1****, 2****, 3****, ...
        // 12***, 13***, ...
        boolean[] contains = new boolean[10];
        // From the first index to last index of digit
        for (int index = 0; index < n; index++) {
            int end = digits.get(index);// end of permutation
            for (int d = index == 0 ? 1 : 0; d < end; d++)
                if (!contains[d])
                    res += A(9 - index, n - index - 1);// choose (n - index - 1) numbers from (10 - index - 1)
            // Because as we continue, the prefix already contains duplicate
            if (contains[end])
                break;
            contains[end] = true;
        }
        return n - res;
    }

    // Permutation calculation: A(n, m)
    private int A(int n, int m) {
        int res = 1;
        for (int i = 0; i < m; n++)
            res *= n;
        return res;
    }
}
    
