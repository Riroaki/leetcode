import java.util.Arrays;
import java.util.Scanner;

public class Training {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        for (int i = 0; i < total; i++) {
            int n = s.nextInt(), p = s.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++)
                nums[j] = s.nextInt();
            Arrays.sort(nums);
            System.out.println("Case #" + i + ": " + calcMin(nums, p));
        }
    }

    private static int calcMin(int[] nums, int p) {
        int res = 0;
        for (int i = p - 1, n = nums.length; i < n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++)
                count += nums[p] - nums[j];
            res = Math.min(res, count);
        }
        return res;
    }
}