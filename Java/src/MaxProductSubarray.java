public class MaxProductSubarray {
    // 来自discussion，巧妙的思路：当前的最大值一定是在三个值里面取到：
    // 当前的数，之前的乘积最小值乘当前的数，之前的乘积最大值乘当前的数
    // （必须包含当前的数，这里的min和max不是"从0到上一个数"出现过的最大最小值，而是包含上一个数的最大最小值）
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = nums[0], currentMin = nums[0], currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = currentMax, tmpMin = currentMin;
            currentMax = Math.max(nums[i], Math.max(tmpMax * nums[i], tmpMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(tmpMax * nums[i], tmpMin * nums[i]));
            // 这里对0做判断好像并没有什么区别（时间反而变长了？）
//            if (nums[i] == 0) currentMax = currentMin = 0;
//            else {
//                int tmpMax = currentMax, tmpMin = currentMin;
//                currentMax = Math.max(nums[i], Math.max(tmpMax * nums[i], tmpMin * nums[i]));
//                currentMin = Math.min(nums[i], Math.min(tmpMax * nums[i], tmpMin * nums[i]));
//            }
            res = Math.max(currentMax, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{2, -3, 0, 4}));
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{-1, 0, -2,}));
    }
}
