public class KnightDialer {
    // dp[i][j]表示从i（0到9）出发跳j-1步总共的可能性
    // nextDigit[i]表示从i出发跳1步能够到达的数字集合
    public int knightDialer(int N) {
        if (N < 1) return 0;
        final int MOD = 1000000007;
        int[] currentJump = new int[10], lastJump = new int[10];
        int[][] nextDigit = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        for (int i = 0; i < 10; i++) currentJump[i] = 1;
        for (int i = 1; i < N; i++) {
            // 拷贝上一步的数量
            for (int digit = 0; digit < 10; digit++) {
                lastJump[digit] = currentJump[digit];
                currentJump[digit] = 0;
            }
            for (int digit = 0; digit < 10; digit++) {
                for (int next : nextDigit[digit]) {
                    currentJump[digit] = currentJump[digit] % MOD + lastJump[next] % MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + currentJump[i] % MOD) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new KnightDialer().knightDialer(1));
        System.out.println(new KnightDialer().knightDialer(2));
        System.out.println(new KnightDialer().knightDialer(3));
        System.out.println(new KnightDialer().knightDialer(4));
    }
}
