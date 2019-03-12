public class KthLargestElementInStream {
    final PriorityQueue<Integer> q;
    final int k;
    // 因为最小堆每次都会把最小值排除，所以其实剩下来的都是数组中最大的值
    // 插入新值的时候，如果堆已满，如果堆的最小值比n还要大，那么就不用插入了，反正n都是会被排除的；
    // 否则，排除最小，插入新值，再取min一气呵成
    public KthLargestElementInStream(int[] nums, int k) {
        this.k = k;
        q = new PriorityQueue<>();
        for (int n : nums)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}
