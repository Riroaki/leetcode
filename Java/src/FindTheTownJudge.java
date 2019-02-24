public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        if (N <= 0 || trust == null) return -1;
        if (trust.length == 0) return N == 1 ? 1 : -1;
        boolean[][] mat = new boolean[N + 1][N + 1];
        int[] trusted = new int[N + 1];
        for (int[] pair : trust) {
            mat[pair[0]][pair[1]] = true;
            trusted[pair[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (trusted[i] == N - 1) {
                boolean unTrust = true;
                for (int j = 1; j <= N; j++) {
                    if (mat[i][j]) {
                        unTrust = false;
                    }
                }
                if (unTrust) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheTownJudge().findJudge(1, new int[][]{}));
        System.out.println(new FindTheTownJudge().findJudge(2, new int[][]{{1, 2}}));
        System.out.println(new FindTheTownJudge().findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(new FindTheTownJudge().findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println(new FindTheTownJudge().findJudge(3, new int[][]{{1, 2}, {2, 3}}));
        System.out.println(new FindTheTownJudge().findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }
}
