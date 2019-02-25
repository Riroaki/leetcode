import java.util.Arrays;

public class FriendsOfAppropriateAges {
    // Not friend:
    // age[B] <= 0.5 * age[A] + 7
    // age[B] > age[A]
    // age[B] > 100 && age[A] < 100
    private int find(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int numFriendRequestsNaive(int[] ages) {
        Arrays.sort(ages);
        int res = 0, n = ages.length, equalMax = n - 1;
        for (int i = 0; i < n; i++) {
            int bound = ages[i] / 2 + 8;
            if (ages[equalMax] != ages[i]) {
                equalMax = i;
                while (equalMax < n && ages[equalMax] == ages[i]) equalMax++;
                equalMax--;
            }
            int index = find(ages, 0, equalMax, bound);
//            System.out.println("index=" + index + ",eq=" + equalMax);
            res += equalMax - index;
        }
        return res;
    }

    // 用121存所有年龄的人
    // 本质和桶排序类似。这里用了两个数组，一个存的是单个年龄的人数，另一个是从0到N岁的人的总数。
    // 后者用来计算在某个年龄区间的人数。
    public int numFriendRequests(int[] ages) {
        int[] people = new int[121], sum = new int[121];
        int maxAge = 0, res = 0;
        for (int num : ages) {
            people[num]++;
            maxAge = Math.max(maxAge, num);
        }
        for (int i = 1; i <= maxAge; i++) sum[i] = sum[i - 1] + people[i];
        // 这里从15岁开始算，因为更小的不可能有朋友(妙啊)
        for (int i = 15; i <= maxAge; i++) {
            if (people[i] == 0) continue;// 这个年龄段没有人，不用计算
            int bound = i / 2 + 7;
            res += (sum[i] - sum[bound] - 1) * people[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FriendsOfAppropriateAges().numFriendRequests(
                new int[]{16, 16}
        ));
        System.out.println(new FriendsOfAppropriateAges().numFriendRequests(
                new int[]{16, 17, 18}
        ));
        System.out.println(new FriendsOfAppropriateAges().numFriendRequests(
                new int[]{20, 30, 100, 110, 120}
        ));
    }
}
