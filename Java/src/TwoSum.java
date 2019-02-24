import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (numbers.containsKey(target - n))
                return new int[]{numbers.get(target - n), i};
            numbers.put(n, i);
        }
        return new int[]{};
    }
}
