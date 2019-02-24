import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappyNaive(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int tmp = 0;
            while (n > 0) {
                int digit = n % 10;
                tmp += digit * digit;
                n /= 10;
            }
            n = tmp;
        }
        return n == 1;
    }

    // 高级：弗洛伊德环形检测算法，判断迭代过程、链表是否有环形成
    private int helper(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = helper(slow);
            fast = helper(helper(fast));
        } while (slow != fast);
        return slow == 1;
    }

    // 另外还有找规律，从0-9的算法。。这个我觉得不太好，毕竟每道题你都要花时间找规律
}
