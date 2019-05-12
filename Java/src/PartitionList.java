public class PartitionList {
    // Two list method. 0ms 100%
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0), big = new ListNode(0),
            curr = head, smallHead = small, bigHead = big;
        while (curr != null) {
            if (curr.val < x) {
                small.next = curr;
                small = small.next;
            } else {
                big.next = curr;
                big = big.next;
            }
            curr = curr.next;
        }
        small.next = bigHead.next;
        big.next = null;
        return smallHead.next;
    }
}
