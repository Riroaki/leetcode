import java.util.Arrays;

class JumpGame2 {
    public int jumpNaive(int[] nums) {
        if (nums.length == 0)
            return -1;
        int l = nums.length;
        int[] minSteps = new int[l];
        Arrays.fill(minSteps, Integer.MAX_VALUE);
        minSteps[0] = 0;
        for (int i = 0; i < l - 1; i++) {
            for (int j = 1; j <= nums[i] && i + j < l; j++) {
                if (minSteps[i + j] > minSteps[i] + 1)
                    minSteps[i + j] = minSteps[i] + 1;
            }
        }
        // System.out.println(minSteps);
        return minSteps[l - 1];
    }

    // Optimal Greedy algorithm.
    // Produces the best answer most quickly.
    // 在目前能到达的点中，取这些点能到达的最远的点做为下一跳
    public int jump(int[] nums) {
        int len = nums.length;
        // Special situation
        if (len < 2) return 0;
        int step = 0, currentMax = 0, preMax, pos = 0;
        while (currentMax < len - 1) {
            preMax = currentMax;
            while (pos <= preMax) {
                currentMax = Math.max(currentMax, nums[pos] + pos);
                pos++;
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame2().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame2().jump(new int[]{1, 3, 2}));
        System.out.println(new JumpGame2().jump(new int[]{1, 2, 2, 0, 0}));
    }
}
