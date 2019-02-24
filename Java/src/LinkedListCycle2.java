public class LinkedListCycle2 {
    // 这个。。。需要数学的分析
    // 设出发点位置为A，环路起始点为B，他们相遇点为C
    // 两个快慢节点相遇在C，设AC=k，则2AC（快节点走过的路程）-AC=k=n*c（环路长度）；
    // 设BC=m，AB=s（即我们要求的点），那么有s=k-m
    // 而k=n*c，s=n*c-m=(n-1)*c+(c-m)，也就是说，从C出发走AB的长度就会到达B
    // 所以在相遇之后，再找一个慢点从A出发，走过AB长度到达B，此时从C出发的慢点也会到达B
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)break;
        }
        if(fast==null||fast.next==null)return null;
        slow = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
