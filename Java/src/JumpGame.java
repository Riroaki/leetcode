import java.util.Arrays;

class JumpGameRecursive {
    private boolean reachable = false;
    private int nextPos = 0;

    private void findReachable(int[] nums, boolean[] visited) {
        int thisPos = nextPos;
        visited[nextPos] = true;
        for (int i = 0; i <= nums[nextPos]; i++) {
            if (nums.length - 1 <= nextPos + i) {
                reachable = true;
                break;
            } else if (!visited[nextPos + i]) {
                nextPos = nextPos + i;
                findReachable(nums, visited);
                nextPos = thisPos;
            }
        }
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return false;
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        findReachable(nums, visited);
        return reachable;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameRecursive().canJump(new int[]{0}));
        System.out.println(new JumpGameRecursive().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGameRecursive().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return false;
        int maxReachable = 0;
        for (int i = 0; i < nums.length; i++)
            if (i <= maxReachable && nums[i] + i > maxReachable)
                maxReachable = nums[i] + i;
        return maxReachable >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{0}));
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
