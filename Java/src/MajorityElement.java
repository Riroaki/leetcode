public class MajorityElement {
    // 最简单的代码是：
    // Arrays.sort(nums);
    // return nums[nums.length / 2];

    // 这是时间复杂度为O（n）的做法。
    // 用times存储当前元素current出现次数，遇到相同则+1，遇到不同的就-1，减到负数表示这个元素肯定出现不是一半的元素
    // 如果不能保证最后元素是否是出现一半的元素，那么。。返回的将不是一半的数，而是随序列的情况而定。
    public int majorityElement(int[] nums) {
        int current = 0, times = 0;
        for (int num : nums) {
            if (times == 0) current = num;
            times += current == num ? 1 : -1;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(
                new int[]{3, 2, 3}
        ));
        System.out.println(new MajorityElement().majorityElement(
                new int[]{2, 2, 1, 1, 1, 2, 2}
        ));
        // 不存在majority element
        System.out.println(new MajorityElement().majorityElement(
                new int[]{1, 1, 2, 2, 2, 3, 3}
        ));
        System.out.println(new MajorityElement().majorityElement(
                new int[]{1, 1, 3, 3, 2, 2, 2}
        ));
    }
}
