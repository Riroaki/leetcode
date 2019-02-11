import java.util.Arrays;

public class MaximumGap {
    public int maximumGapNaive(int[] nums) {
        int maxDiff = 0, n = nums.length;
        if (n < 2) return 0;
        int index = 0;
        Arrays.sort(nums);
        while (index < n - 1) {
            int currentDiff = nums[index + 1] - nums[index];
            do {
                index++;
            } while (index < n - 1 && nums[index + 1] - nums[index] == currentDiff);
            maxDiff = Math.max(maxDiff, currentDiff);
        }
        return maxDiff;
    }

    public int maximumGap(int[] nums) {
        int maxDiff = 0, n = nums.length;
        if (n < 2) return 0;
        int max = nums[0], min = max;
        for (int num : nums) {
            if (num > max) {
                maxDiff = Math.max(maxDiff, num - max);
                max = num;
            } else if (num < min) {
                maxDiff = Math.max(maxDiff, min - num);
                min = num;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumGap().maximumGap(new int[]{3, 6, 9, 13, 20, 40}));
        System.out.println(new MaximumGap().maximumGap(new int[]{15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740}));
    }
}
