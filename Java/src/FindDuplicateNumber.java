public class FindDuplicateNumber {
    // 最初想法，而且时间复杂度最低，0ms。
    // 用一个数组存，O(n)的时间和空间复杂度
    public int findDuplicateNaive(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int n = nums.length;
        int[] appear = new int[n];
        for (int num : nums) if (++appear[num] == 2) return num;
        return -1;
    }

    // 这道题的本质和LinkedListCycle2是一回事。
    // 注意这里nums[i]始终在0到n之间，这是重要条件
    // 假如出现了两个数相等，那么这个数一定是环路next(x)=arr[x]的起始点
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicateNumber().findDuplicate(new int[]{18, 13, 14, 17, 9, 19, 7, 17, 4, 6, 17, 5, 11, 10, 2, 15, 8, 12, 16, 17}));
        System.out.println(new FindDuplicateNumber().findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
