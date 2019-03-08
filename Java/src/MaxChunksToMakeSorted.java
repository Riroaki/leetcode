public class MaxChunksToMakeSorted {
    // 这是一个简单的思路，但是不是最优的。。。
        // 记录from和to，以及count，保证当前chunk中从from到to之间的所有数都出现了
        // 注意更新的时候，from和to更新为to + 1
    public int maxChunksToSortedNaive(int[] arr) {
        int count = 0, from = 0, to = arr[0], res = 0, n = arr.length;
        for (int num : arr) {
            if (num > to)
                to = num;
            count++;
            if (count == to - from + 1) {
                res++;
                count = 0;
                from = to = to + 1;
            }
        }
        return res;
    }

    // 这个做法。。我服气
    // 因为保证不出现重复元素，所以只要i和max相等
    // 那么前面部分就能够组成一个Chunk
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }
}
