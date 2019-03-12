public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode[] group = new ListNode[k + 2];
        while (true) {
            int index;
            for (index = 1; index < k + 2 && group[index - 1] != null; index++)
                group[index] = group[index - 1].next;
            if (index < k + 2)
                break;
            group[0].next = group[k];
            group[1].next = group[k + 1];
            for (int i = 2; i < k + 1; i++)
                group[i].next = group[i - 1];
            group[0] = group[1];
        }
        return dummy.next;
    }
}
