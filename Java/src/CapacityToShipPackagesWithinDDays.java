public class CapacityToShipPackagesWithinDDays {
    // Binary search.
    private boolean canShip(int c, int[] nums, int d) {
        int curr = 0, currDay = 0, n = nums.length;
        while (curr < n) {
            currDay++;
            int tmp = nums[curr];
            while (++curr < n && nums[curr] + tmp <= c)
                tmp += nums[curr];
        }
        return currDay <= d;
    }

    public int shipWithinDays(int[] weights, int D) {
        int max = 0;
        for (int num : weights)
            max = Math.max(num, max);
        int lo = max, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!canShip(mi, weights, D))
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
}
