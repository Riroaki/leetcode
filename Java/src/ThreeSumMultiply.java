public class ThreeSumMultiply {
    // Naive version. 50%
    private final int MOD = 1_000_000_007;
    
    public int threeSumMulti(int[] a, int target) {
        Arrays.sort(a);
        int n = a.length, res = 0;
        for (int i = 0; i < n - 2; i++)
            res = (res + twoSumMulti(a, target - a[i], i + 1)) % MOD;
        return res;
    }
    
    private int twoSumMulti(int[] a, int target, int start) {
        int l = start, r = a.length - 1, res = 0;
        while (l < r) {
            if (a[l] + a[r] < target) {
                do {
                    l++;
                } while (l < r && a[l] == a[l - 1]);
            } else if (a[l] + a[r] > target) {
                do {
                    r--;
                } while (l < r && a[r] == a[r + 1]);
            } else {
                if (a[l] == a[r]) {
                    res = (res + (r - l) * (r - l + 1) / 2) % MOD;
                    break;
                }
                int countl = 1, countr = 1;
                while (l + countl < r && a[l + countl] == a[l])
                    countl++;
                while (r - countr > l && a[r - countr] == a[r])
                    countr++;
                res = (res + countl * countr) % MOD;
                l += countl;
                r -= countr;
            }
        }
        return res;
    }

    // Better version beating 99%. but ... I think it's very rough.
    public int threeSumMulti(int[] a, int target) {
        final long MOD = 1_000_000_007;
        long res = 0;
        int uniq = 0;
        long[] count = new long[101];
        for (int x : a) {
            count[x]++;
            if (count[x] == 1)
                uniq++;
        }
        int[] keys = new int[uniq];
        int t = 0;
        for (int i = 0; i < 101; i++)
            if (count[i] > 0)
                keys[t++] = i;
        for (int i = 0; i < keys.length; i++) {
            int x = keys[i];
            int T = target - x;
            int j = i, k = keys.length - 1;
            while (j <= k) {
                int y = keys[j], z = keys[k];
                if (y + z < T)
                    j++;
                else if (y + z > T)
                    k--;
                else {
                    if (i < j && j < k)
                        res += count[x] * count[y] * count[z];
                    else if (i == j && j < k)
                        res += count[x] * (count[x] - 1) / 2 * count[z];
                    else if (i < j && j == k)
                        res += count[x] * (count[y] - 1) * count[y] / 2;
                    else
                        res += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                    res %= MOD;
                    j++;
                    k--;
                }
            }
        }
        return (int) res;
    }
}
