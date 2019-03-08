public class AddTwoNumbers {
    // 简单，100%
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0), tmp = res; // dummy head
        while (carry > 0 || l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            tmp.next = new ListNode(carry % 10);
            tmp = tmp.next;
            carry /= 10;
        }
        return res.next;
    }
}
