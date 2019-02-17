import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycleNaive(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (; head != null; head = head.next) {
            if (!set.add(head)) return true;
        }
        return false;
    }

    // 非常精妙的解，使用O（1）的时间就解决了问题。
    // 这里每一次循环，fast都比slow多走一步；如果存在循环，总有一天会出现slow=fast（被追上）
    // 重点在于设置循环的边界条件以执行顺序！
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = head;
        System.out.println(new LinkedListCycle().hasCycle(head));
    }
}
