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

    // 第三种是最优，使用deque，O(n)时间复杂度
    // 这是一种叫做monotonic queue单调队列的东西。它的性质：在队尾添加，在队首删除，时刻维护最大值，查询效率O(1)
    // 顺便一提，deq全称叫做double end queue
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return new int[]{};
        int n = nums.length;
        Deque<Integer> maxIndices = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            // 对新元素，从队尾插入，并将较小元素依次排除
            while (!maxIndices.isEmpty() && nums[maxIndices.peekLast()] < nums[i])
                maxIndices.pollLast();
            maxIndices.offerLast(i);
            // 对于旧元素，检查是否在窗口外并排除之
            if (maxIndices.peekFirst() == i - k) maxIndices.pollFirst();
            // 当大小超过窗口大小，开始记录最大值
            if (i >= k - 1) res[i - k + 1] = nums[maxIndices.peekFirst()];
        }
        return res;
    }
}
