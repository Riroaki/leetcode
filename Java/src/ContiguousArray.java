import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLengthNaive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j] == 0 ? -1 : 1;
                if (sum == 0) res = Math.max(res, j - i + 1);
            }
            if (res >= n - i) break;
        }
        return res;
    }

    // 同样是使用了sum来计算当前是否数量相等，这里用了hash map存每个sum值第一次出现的位置
    // 当出现同样的sum的时候，那么这两个sum之间的数组一定是平衡的。
    // 效率是O（n），时间和空间都是。
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> firstAppear = new HashMap<>();
        int res = 0, sum = 0;
        firstAppear.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (firstAppear.containsKey(sum))
                res = Math.max(res, i - firstAppear.get(sum));
            else firstAppear.put(sum, i);
        }
        return res;
    }
}
