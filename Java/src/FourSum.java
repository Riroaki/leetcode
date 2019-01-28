import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return new NSum().nSum(nums, target, 4);
    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
