public class AddTwoNumbers2 {
    // Use list.
    // 之所以不用int存这个数，是因为可能溢出！
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> nums1 = new ArrayList<>(),
            nums2 = new ArrayList<>(), res = new ArrayList<>();
        ListNode dummy = new ListNode(0), curr = dummy;
        while (l1 != null) {
            nums1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            nums2.add(l2.val);
            l2 = l2.next;
        }
        for (int i = l1.size() - 1, j = l2.size() - 1, carry = 0;
                carry > 0 || i >= 0 || j >= 0; ) {
            if (i >= 0)
                carry += nums1.get(i);
            if (j >= 0)
                carry += nums2.get(j);
            res.add(carry % 10);
            carry /= 10;
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            curr.next = new ListNode(res.get(i));
            curr = curr.next;
        }
        return dummy.next;
    }

    // stack
    // 也就是说不管是list还是stack，都需要3个东西来存下数据
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>(), res = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 !=  null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0), curr = dummy;
        for (int carry = 0; carry > 0 || !s1.isEmpty() || !s2.isEmpty(); ) {
            if (!s1.isEmpty())
                carry += s1.pop();
            if (!s2.isEmpty())
                carry += s2.pop();
            res.push(carry % 10);
            carry /= 10;
        }
        while (!res.isEmpty()) {
            curr.next = new ListNode(res.pop());
            curr = curr.next;
        }
        return dummy.next;
    }
}
