public class RemoveDuplicatesFromSortedList2 {
    // 2 ptrs, parent -> node before current node
    // curr -> ndoe to be detected whether has dups.
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), parent = dummy, curr = head;
        dummy.next = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val)
                curr = curr.next;
            if (parent.next != curr) {// duplicates exist
                curr = curr.next;
                parent.next = curr;
            } else {// no duplicates
                parent = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    // 如果需要保留一个副本，思路也类似
    public ListNode delete(ListNode head) {
        ListNode dummy = new ListNode(0), first = head, second = head;
        dummy.next = head;
        while (second != null) {
            while (second.next != null && second.next.val == second.val)
                second = second.next;
            if (first != second) {// duplicates exist
                second = second.next;
                first.next = second;
            } else {// no duplicates
                first = second = second.next;
            }
        }
        return dummy.next;
    }
}
