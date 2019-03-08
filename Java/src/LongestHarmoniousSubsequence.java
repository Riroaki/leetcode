import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    // 这题其实没啥难度，也没啥变化。。就是用一个map存出现次数，然后对map里面元素和比他大1的元素出现次数相加
    // 但是这里比较好的就是使用了getOrDefault，提高了效率的操作。值得学习
    public int findLHS(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);
        int res = 0;
        for (int key : count.keySet()) {
            if (count.containsKey(key + 1))
                res = Math.max(res, count.get(key) + count.get(key + 1));
        }
        return res;
    }
}
