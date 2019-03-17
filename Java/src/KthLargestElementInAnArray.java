public class KthLargestElementInArray {
    // n log k
    public int findKthLargest1(int[] nums, int k) {
        if (k > nums.length)
            return -1;
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int num : nums) {
            if (q.size() >= k) {
                if (q.peek() < num) {
                    q.poll();
                    q.offer(num);
                }
            } else
                q.offer(num);
        }
        return q.peek();
    }

    // n log n
    public int findKthLargest2(int[] nums, int k) {
        if (k > nums.length)
            return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


}
