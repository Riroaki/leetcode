public class TotalHammingDistance {
    public int totalHammingDistanceNaive(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res += calDist(nums[i], nums[j]);
            }
        }
        return res;
    }

    private int calDist(int x, int y) {
        int z = x ^ y, res = 0;
        while (z > 0) {
            res += z % 2;
            z >>= 1;
        }
        return res;
    }

    // 每个数排成一列，按位比较，每个位对总和的贡献等于0的个数✖1的个数
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0, n = nums.length;
        for (int bit = 0; bit < 32; bit++) {
            int bitCount = 0;
            for (int num : nums) {
                if ((num >> bit) % 2 == 1) bitCount++;
            }
            res += bitCount * (n - bitCount);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TotalHammingDistance().totalHammingDistance(new int[]{4, 14, 4, 14}));
    }
}
