public class MatchsticksToSquare {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0, len, N = nums.length;
        for (int n : nums) sum += n;
        if (sum % 4 != 0) return false;
        len = sum / 4;
        if (nums[N - 1] > len) return false;
        int[] fill = new int[4];

        return true;
    }
}
