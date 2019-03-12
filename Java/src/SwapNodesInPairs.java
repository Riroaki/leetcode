public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0), pre = dummy, first = head;
        dummy.next = head;
        while (first != null) {
            ListNode second = first.next;
            if (second == null)
                break;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            // move to next pair
            pre = first;
            first = first.next;
        }
        return dummy.next;
    }
}
