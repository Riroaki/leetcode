import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutive {
    // 这不是O（n）的做法，因为使用了sort；但是效率足够快了
    public int longestConsecutiveNaive(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        Arrays.sort(nums);
        int res = 0;
        for (int index = 0; index < n - 1; index++) {
            int currentLen = 1;
            while (index < n - 1) {
                // 遇到重复元素的时候长度不增加
                if (nums[index + 1] == nums[index] + 1) currentLen++;
                else if (nums[index + 1] > nums[index] + 1) break;
                index++;
            }
            res = Math.max(res, currentLen);
        }
        return res;
    }

    // 如果要求O（n），那么应该用map存数字和它对应的长度，而且逻辑会比较复杂
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        HashMap<Integer, Integer> map = new HashMap<>();// store the number and its length
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(num, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                // 非常机智地省略了判断，因为如果没有左邻居的话num-left=num，右邻居同理
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
