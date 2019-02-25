import java.util.Arrays;

// 100%一次过，耶
public class SpiralMatrix3 {
    private int[][] res;
    private int num = 0, currentR, currentC;

    private void helper(int C, int R, int diffR, int diffC, int len) {
        for (int i = 0; i < len; i++, currentR += diffR, currentC += diffC) {
            if (currentC < C && currentC >= 0
                    && currentR >= 0 && currentR < R) {
                res[num][0] = currentR;
                res[num][1] = currentC;
                num++;
            }
        }
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        res = new int[R * C][2];
        int bound = R * C, len = 1;
        currentR = r0;
        currentC = c0;
        while (num < bound) {
            helper(C, R, 0, 1, len);
            helper(C, R, 1, 0, len++);
            helper(C, R, 0, -1, len);
            helper(C, R, -1, 0, len++);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrix3().spiralMatrixIII(5, 6, 1, 4)));
    }
}
