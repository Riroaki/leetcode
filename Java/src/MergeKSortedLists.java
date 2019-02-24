import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 因为ListNode不能被比较，所以不能用PriorityQueue
// 需要自己实现堆
public class MergeKSortedLists {
    // Omitted: definition for singly-linked list.
    // 冲着解决问题的思路，只需要写一个比较器comparator然后使用PriorityQueue就可以：
    public ListNode mergeKListsSimple(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2) {
                int numbera = o1.val;
                int numberb = o2.val;
                if(numberb < numbera) return 1;
                else if(numberb > numbera) return -1;
                else return 0;
            }
        };
        PriorityQueue<ListNode> nodeHeap = new PriorityQueue<>(cmp);
        ListNode res = new ListNode(-1), tmp = res;
        for(ListNode head: lists)
            if(head != null) nodeHeap.offer(head);
        while(!nodeHeap.isEmpty()) {
            tmp.next = nodeHeap.poll();
            tmp =  tmp.next;
            if(tmp.next != null) nodeHeap.add(tmp.next);
        }
        return res.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> nodeHeap = new ArrayList<>();
        ListNode res = new ListNode(-1), tmp = res;
        nodeHeap.add(null);// dummy head,为了使堆的下标编号从1开始
        for (ListNode head : lists)
            if (head != null) nodeHeap.add(head);
        int n = nodeHeap.size();
        if (n == 1) return null;
        for (int i = n >> 1; i > 0; i--) {
            // 小元素从底部上滤
            while (i < n) {
                int left = i << 1, right = left + 1, smallest = i;
                if (left < nodeHeap.size() && nodeHeap.get(left).val < nodeHeap.get(smallest).val)
                    smallest = left;
                if (right < nodeHeap.size() && nodeHeap.get(right).val < nodeHeap.get(smallest).val)
                    smallest = right;
                if (smallest != i) {
                    ListNode tmpNode = nodeHeap.get(smallest);
                    nodeHeap.set(smallest, nodeHeap.get(i));
                    nodeHeap.set(i, tmpNode);
                }
                i = smallest;
            }
        }
        // 依次弹出元素
        while (!nodeHeap.isEmpty()) {
            tmp.next = nodeHeap.get(1);
            for (int index = 1; index < nodeHeap.size(); ) {
                int left = index << 1, right = left + 1, smaller = left;
                if (left < nodeHeap.size()) nodeHeap.set(index, nodeHeap.get(left));
                if (right < nodeHeap.size() && nodeHeap.get(right).val < nodeHeap.get(smaller).val) {
                    nodeHeap.set(index, nodeHeap.get(right));
                    smaller = right;
                }
                index = smaller;
            }
            nodeHeap.remove(--n);
            tmp = tmp.next;
            if (tmp.next != null) {
                nodeHeap.add(tmp.next);
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        ListNode res = new MergeKSortedLists().mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
