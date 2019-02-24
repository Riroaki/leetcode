public class ClimbingStairs {
    public int climbStairsNaive(int n) {
        if (n <= 0) return 0;
        int[] method = new int[n + 1];
        method[1] = 1;
        for (int i = 1; i < n; i++) {
            method[i + 1] += method[i];
            if (i + 2 <= n) method[i + 2] += method[i];
        }
        return method[n];
    }

    // 等价于斐波纳契数列的求法，可以改进以获得更好的空间效率
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        int a = 1, b = 1, count = 1;
        while (count++ < n) {
            int tmp = b;
            b = a + b;
            a = b - tmp;
        }
        return b;
    }
}
