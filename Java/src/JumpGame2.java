import java.util.Arrays;

class JumpGame2Naive {
    public int jump(int[] nums) {
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

    public static void main(String[] args) {
        System.out.println(new JumpGame2Naive().jump(new int[]{2, 3, 1, 1, 4}));
    }
}

// Optimal Greedy algorithm.
// Produces the best answer most quickly.
// 在目前能到达的点中，取这些点能到达的最远的点做为下一跳
public class JumpGame2 {
    public int jump(int[] nums) {
        int len = nums.length;
        // Special situation
        if (len == 1) return 0;

        int[] final_pos = new int[len - 1];

        for (int i = 0; i < len - 1; i++)
            final_pos[i] = nums[i] + i >= len ? len - 1 : nums[i] + i;

        int i = 0;
        int step = 0;
        int max;
        while (true) {
            step++;
            if (nums[i] + i >= len - 1)
                break;

            max = i + 1;
            for (int j = i + 1; j <= final_pos[i]; j++)
                if (final_pos[j] >= final_pos[max])
                    max = j;
            i = max;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame2().jump(new int[]{1, 3, 2}));
        System.out.println(new JumpGame2().jump(new int[]{1, 2, 2, 0, 0}));
    }
}
