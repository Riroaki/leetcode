public class ClimbingStairs {
    public int climbStairs1(int n) {
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
    public int climbStairs2(int n) {
        if (n <= 0) return 0;
        int a = 1, b = 1, count = 1;
        while (count++ < n) {
            int tmp = b;
            b = a + b;
            a = b - tmp;
        }
        return b;
    }

    // fib的log n优化
    public int climbStairs3(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    private int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = mul(ret, a);
            }
            n >>= 1;
            a = mul(a, a);
        }
        return ret;
    }

    private int[][] mul(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
