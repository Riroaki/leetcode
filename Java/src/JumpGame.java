import java.util.Arrays;
import java.util.Stack;

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
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        Stack<Integer> pos = new Stack<>();
        pos.push(0);
        visited[0] = true;
        while (!pos.empty()) {
            int current = pos.peek();
            int step = 0;
            for (; step < nums[current]; step++) {
                int tmp = current + step;
                if (tmp >= nums.length - 1)
                    return true;
                if (!visited[tmp]) {
                    pos.push(tmp);
                    visited[tmp] = true;
                    break;
                }
            }
            if (step == nums[current]) {
                int whatever = pos.pop();
                pos.pop();
                pos.push(whatever);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{0}));
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
