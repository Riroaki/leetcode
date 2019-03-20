public class RotateList {
    // 6ms 100%.
    // dummy head is a great design.
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        int n = 0;
        ListNode dummy = new ListNode(0), curr = dummy, tmp;
        dummy.next = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        // n = number of nodes in list
        // curr: end of list
        curr.next = head;
        k = n - (k % n);
        curr = dummy;
        // curr -> node before the node that will become new head.
        while (k > 0) {
            curr = curr.next;
            k--;
        }
        // tmp is new head.
        tmp = curr.next;
        curr.next = null;
        return tmp;
    }
}
