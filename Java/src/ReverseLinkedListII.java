public class ReverseLinkedListII {
    // Naive version, hard to understand... still 100%
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 不需要交换
        if (m == n)
            return head;
        int index = 1;
        // 用before记录交换的节点前一个（或者交换的第一个）节点
        // curr和next用于逆序
        ListNode before = head, curr = null, next = null;
        // 找到逆序的前一个节点，即m-1
        while (index < m - 1) {
            before = before.next;
            index++;
        }
        // 当m == 1的时候，循环得到的是交换的第一个节点
        if (index == m)
            // This means m == 1, so we won't need to care the nodes before.
            curr = before;
        // 循环得到前一个节点，所以curr记录
        else
            curr = before.next;
        // next记录curr的下一个节点
        next = curr.next;
        // Reverse from m to n.
        // 设置index记录curr的位置，curr始终在序号为index的节点位置
        index = m;
        while (index < n && next != null) {
            // next的下一个指向curr，并将变成原来next的下一个节点
            // curr将变成next
            ListNode tmp = next.next;
            next.next = curr;
            curr = next;
            next = tmp;
            index++;
            // System.out.println(curr.val + " " + next.val);
        }
        // 循环结束的时候，curr指向n号节点（逆序的尽头），next指向不参与交换的节点，也可能是null

        // 这里安排后事……
        // 如果不是从第一个就开始交换，那么返回head
        // 并把此前没有改变的、第m号节点（现在是逆序的末尾，但是由before.next保存着）的下一个节点指向n+1节点（或者null）
        // 而且把第m-1号节点的指针指向第n号节点
        if (m != 1) {
            before.next.next = next;
            before.next = curr;
            return head;
        } else {
        // 如果是从第一个节点开始交换，那么返回的是第n个节点也就是逆序末尾（现在是开头）
        // 这里before指着第m号节点，m现在是新的末尾，需要指向n+1号节点
            before.next = next;
            return curr;
        }
    }

    // Use a dummy head to avoid condition checking.
    public ListNode reverseBetweenDummy(ListNode head, int m, int n) {
        if (head == null)
            return null;
        if (m == n)
            return head;
        ListNode dummy = ListNode(0), before, curr, next;
        dummy.next = head;
        before = dummy;
        for (int i = 0; i < m - 1; i++)
            before = before.next;
        curr = before.next;
        next = curr.next;
        for (int i = 0; i < n - m; i++) {
            curr.next = next.next;
            next.next = before.next;
            before.next = next;
            next = curr.next;
        }
        return dummy.next;
    }
}
