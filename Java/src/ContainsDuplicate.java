import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    // 简单想法1：用sort，排序后遍历一遍，看看是否存在重复值的情况
    public boolean containsDuplicateNaive1(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) if (nums[i] == nums[i + 1]) return true;
        return false;
    }

    // 简单想法2：用hashMap，遍历一遍并存下，如果过程中出现已经在map中的元素就返回true，否则返回false；
    public boolean containsDuplicateNaive2(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int num : nums) {
            if (numberMap.containsKey(num)) return true;
            else numberMap.put(num, 0);
        }
        return false;
    }

    // 简单想法3：用hashSet，遍历一遍并存下，用add的结果表示是否添加成功（即是否已经存在相同元素）
    public boolean containsDuplicateNaive3(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> numberSet = new HashSet<>();
        for (int num : nums)
            if (!numberSet.add(num)) return true;
        return false;
    }

    // 这。。。O（n2）竟然是最快的？
    // 巧合而已吧，只是因为测试数据比较弱，这个算法是错误的！
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) break;
                else if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 4, 3, 4}));
    }
}
