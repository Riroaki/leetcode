public class TrappingRainWater {
    // 原理很简单，因为每个积水区间中间不会有比区间两端更高的值
    // 复杂度O(n)，9ms，95%
    public int trap(int[] height) {
        int res = 0, n = height.length;
        if (n < 3) return 0;
        int i = 0, j = n - 1;
        // 去掉左边递增的区间和右边递减的区间（因为不会有积水）
        while (i < n - 1 && height[i] <= height[i + 1]) i++;
        while (j > 0 && height[j] <= height[j - 1]) j--;
        int leftIndex = i, rightIndex = i;
        while (rightIndex < j) {
            // 找到比左端更高的，或者比左端矮但是最高的
            int belowHighestIndex = -1;
            for (int tmp = rightIndex + 1; tmp <= j; tmp++) {
                if (height[tmp] >= height[leftIndex]) {
                    rightIndex = tmp;
                    break;
                } else if (belowHighestIndex == -1 || height[belowHighestIndex] <= height[tmp])
                    belowHighestIndex = tmp;
            }
            // 如果没有更高，那就取矮中最高的
            if (rightIndex == leftIndex) rightIndex = belowHighestIndex;
            // 计算中间面积
            int h = Math.min(height[leftIndex], height[rightIndex]), currentArea = 0;
            for (leftIndex++; leftIndex < rightIndex; leftIndex++)
                currentArea += h - height[leftIndex];
            res += currentArea;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new TrappingRainWater().trap(new int[]{4, 2, 3}));
        System.out.println(new TrappingRainWater().trap(new int[]{5, 2, 1, 2, 1, 5}));
        System.out.println(new TrappingRainWater().trap(new int[]{2, 8, 5, 5, 6, 1, 7, 4, 5}));
    }
}
