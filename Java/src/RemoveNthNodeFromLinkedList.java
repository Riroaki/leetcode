public class RemoveNthNodeFromLinkedList {
    // 5ms，100%
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode tmp = head, dummy = new ListNode(0);
        dummy.next = head;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        // 非法的n
        if (count < n)
            return head;
        ListNode a = dummy;
        // 走到删除节点的前一个节点
        for (int i = 0; i < count - n; i++)
            a = a.next;
        a.next = a.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEndSingleRound(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 1; i < n; i++) {// fast和slow需要差n-1个节点
            fast = fast.next;
            // Invalid n
            if (fast == null)
                return head;
        }
        // fast到倒数第二个的时候，slow在倒数n+1的位置（n的左边1个的位置）
        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
