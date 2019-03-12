import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {
    //  简单做法。用堆，如果heapify的话就是O(n)，然后堆取最小元素k次，取反。（贪心算法）
    public int largestSumAfterKNegationsNaive(int[] A, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : A)
            minHeap.offer(num);
        for (int i = 0; i < K; i++) {
            int num = minHeap.poll();
            num = -num;
            minHeap.offer(num);
        }
        int res = 0;
        while (!minHeap.isEmpty())
            res += minHeap.poll();
        return res;
    }

    // 同样是O（n lgn）算法（因为需要排序），空间复杂度O(1),简洁明了
    // 我们遍历一遍数组，如果遇到负数，将它取反；
    // 最后如果取反的机会没有用光（如果没有用光，数组应该全都是非负的），
    // 那么看他是奇数次还是偶数次，偶数次的话不会影响（对正数取反偶数次），奇数次的话把最小的正数取反
    public int largestSumAfterKNegations(int[] A, int K) {
        int res = 0, minPositive = Integer.MAX_VALUE;
        Arrays.sort(A);
        for (int num : A) {
            if (num < 0 && K > 0) {
                num = -num;
                K--;
            }
            res += num;
            minPositive = Math.min(num, minPositive);
        }
        if (K % 2 == 0)
            return res;
        else
            return res - minPositive * 2;
    }

    // heapify的O（n）算法
    // ...
}
