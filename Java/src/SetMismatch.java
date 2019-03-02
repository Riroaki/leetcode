public class SetMismatch {
    // nums包含1-n的数，但有一个数重复，有一个数丢失
    // 所以这里采用的技巧是，遇到nums[i]，将nums[|nums[i]| - 1]设置成负数
    // 那么在设置前如果已经是负数，说明之前设置过，所以这个|nums[i]|就是重复的数（这个时候不要再取负数了）；
    // 遍历设置过后，如果遇到一个正数，说明它没有被设置过，所以它的下标+1就是缺失的数。
    // 在允许修改数组的条件下，这个是个好主意。。。O(1) space, O(n) time.
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0)
                res[0] = index + 1;
            else
                nums[index] = -nums[index];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res[1] = i + 1;
        }
        return res;
    }

    public int[] findErrorNumsNaive(int[] nums) {
        int n = nums.length;
        boolean[] isSet = new boolean[n + 1];
        int[] res = new int[2];
        for (int num : nums) {
            if (isSet[num])
                res[0] = num;
            else
                isSet[num] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!isSet[i])
                res[1] = i;
        }
        return res;
    }
}
