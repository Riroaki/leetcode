import java.util.*;

public class SlidingWindowMaximum {
    // 第一想法用堆做但是时间复杂度为O(n lgn)，时间上比较慢
    public int[] maxSlidingWindowNaive(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return new int[]{};
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        res[0] = queue.peek();
        for (int i = k; i < n; i++) {
            queue.remove(nums[i - k]);
            queue.offer(nums[i]);
            res[i - k + 1] = queue.peek();
        }
        return res;
    }

    // 第二想法是用list插入排序，每次移除一个元素和插入元素都用二分，效率也是O(n lgn)
    // 这个比第一个更慢了。。。
    private int lowerBound(List<Integer> nums, int target) {
        int left = 0, right = nums.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int[] maxSlidingWindowNaive2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return new int[]{};
        int n = nums.length;
        List<Integer> orderedWindow = new ArrayList<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) orderedWindow.add(nums[i]);
        orderedWindow.sort((Comparator.comparingInt(o -> o)));// 按照从小到大排列
        res[0] = orderedWindow.get(k - 1);
        for (int i = k; i < n; i++) {
            int numToRemove = nums[i - k], numToAdd = nums[i];
            orderedWindow.remove(lowerBound(orderedWindow, numToRemove));
            orderedWindow.add(lowerBound(orderedWindow, numToAdd), numToAdd);
            res[i - k + 1] = orderedWindow.get(k - 1);
        }
        return res;
    }
}
