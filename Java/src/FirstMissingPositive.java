import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingPositive {
    class Interval {
        int left, right;

        Interval(int l, int r) {
            left = l;
            right = r;
        }
    }

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        List<Interval> intervalList = new ArrayList<>();
        for (int num : nums) {
            if (num <= 0)
                continue;
            if (intervalList.isEmpty())
                intervalList.add(new Interval(num, num));
            else {
                Interval tmp = intervalList.get(intervalList.size() - 1);
                if (tmp.right + 1 == num) {
                    tmp.right++;
                    intervalList.set(intervalList.size() - 1, tmp);
                } else if (tmp.right + 1 < num)
                    break;
            }
        }
        if (intervalList.isEmpty() || intervalList.get(0).left > 1)
            return 1;
        return intervalList.get(intervalList.size() - 1).right + 1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{
                1, 2, 0
        }));
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{
                3, 4, -1, 1
        }));
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{
                7, 8, 9, 10, 11, 13
        }));
    }
}
