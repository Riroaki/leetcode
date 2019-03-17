public class PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        // When even length, first player always win.
        // See `stone game`.
        if ((n & 1) == 0)
            return true;
        int[][] dp = new int[n + 1][n];
        for (int i = n; i >= 0; i--) {
            for (int j = i
        }
    }
}
