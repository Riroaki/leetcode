import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDiff = k + 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                minDiff = Math.min(i - map.get(nums[i]), minDiff);
                map.replace(nums[i], i);
            } else map.put(nums[i], i);
        }
        return minDiff <= k;
    }
}
