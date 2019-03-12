public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int[][] count = new int[7][2];
        int n = A.length, res = Integer.MAX_VALUE;
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < n; j++) {
                if (A[j] != i && B[j] != i) {
                    count[i][0] = count[i][1] = Integer.MAX_VALUE;
                    break;
                }
                if (A[j] != i)
                    count[i][0]++;
                else if (B[j] != i)
                    count[i][1]++;
            }
        }
        for (int i = 1; i < 7; i++)
            for (int j = 0; j < 2; j++)
                res = Math.min(res, count[i][j]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
