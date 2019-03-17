public class CountOfSmallerNumbersAfterSelf {
    // Use binary search and insertion sort.
    // Naive version, 35%
    public List<Integer> countSmaller(int[] nums) {
        // 始终在开头插入的话，选择linkedlist而不是arraylist
        List<Integer> sorted = new ArrayList<>(), res = new LinkedList<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            int lo = 0, hi = sorted.size();
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (sorted.get(mi) < nums[i])
                    lo = mi + 1;
                else
                    hi = mi;
            }
            res.add(0, lo);
            sorted.add(lo, nums[i]);
        }
        return res;
    }
}
