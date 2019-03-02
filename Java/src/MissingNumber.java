public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length, total = (n + 1)*n/2, sum = 0;
        for (int num : nums)
            sum += num;
        return total - sum;
    }

    // Using XOR
    public int missingNumberXOR(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++)
            missing ^= i ^ nums[i];
        return missing;
    }
}
