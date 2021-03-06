import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    // 更简洁的版本，十分巧妙，让A和B走过了相同的路程
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB, tailA = null, tailB = null;
        if (headA == null || headB == null)
            return null;
        while (a != b) {
            if (a.next == null) {
                tailA = a;
                a = headB;
            } else
                a = a.next;
            if (b.next == null) {
                tailB = b;
                b = headA;
            } else
                b = b.next;
            if (tailA != null && tailB != null && tailA != tailB)
                return null;
        }
        return a;
    }

    // O(n)的时间和空间复杂度，使用set
    public ListNode getIntersectionNodeNaive(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> nodes = new HashSet<>();
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!nodes.add(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    // 1ms 100%
    // 数数。比较长度，让长的先走一段，两个一样长的起点之后，各自走一步然后比较，直到末尾
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int la = 0, lb = 0;
        ListNode copyA = headA, copyB = headB;
        while (headA != null) {
            la++;
            headA = headA.next;
        }
        while (headB != null) {
            lb++;
            headB = headB.next;
        }
        // 让headA变成更长的那个链表
        if (la < lb) {
            int tmp = la;
            la = lb;
            lb = tmp;
            headA = copyB;
            headB = copyA;
        } else {
            headA = copyA;
            headB = copyB;
        }
        // 让长的先走一段
        while (la > lb) {
            headA = headA.next;
            la--;
        }
        while (la > 0) {
            la--;
            headA = headA.next;
            headB = headB.next;
            if (headA == headB) return headA;
        }
        return null;
    }
}
