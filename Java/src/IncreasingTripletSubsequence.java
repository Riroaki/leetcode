public class IncreasingTripletSubsequence {
    // 这是一个稳妥的方案，保存每个位置向左边看的最小值，和向右边看的最大值
    // 遍历3遍
    public boolean increasingTripletNaive(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] minFromLeft = new int[n], maxFromRight = new int[n];
        minFromLeft[0] = nums[0];
        maxFromRight[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            minFromLeft[i] = Math.min(minFromLeft[i - 1], nums[i]);
            maxFromRight[n - 1 - i] = Math.max(maxFromRight[n - i], nums[n - i]);
        }
        for (int i = 1; i < n - 1; i++)
            if (minFromLeft[i] < nums[i] && nums[i] < maxFromRight[i]) return true;
        return false;
    }

    // 这个方案不太容易想到
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            // n is smaller than both.
            if (n <= small) {
                small = n;
            }
            // n is larger than small but smaller than big.
            else if (n <= big) {
                big = n;
            }
            // return if you find a number bigger than both.
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{1, 4, 3, 2, 5}));
    }
}
