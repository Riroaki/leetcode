// 这题和"能盛最多水"题目的区别在于，这题需要考虑的是l到r之间所有的木板的最小值作为总高度
public class LargestRectangleInHistogram {
    // 使用Sort之前：427 ms, faster than 12.19% of Java
    // 使用Sort之后：1 ms, faster than 100.00% of Java
    // 思路：对于每一段区间，都存在一个最小值
    // 对于最小值，无非就是三种可能：
    // 1：要么整段面积最大，2、3：要么最小值左边或者最小值右边（均不包含最小值）的面积最大，采用分治法递归解决；
    // 遇到有序排列的区间，采用递归会降低效率，于是只要单独计算并且比较就可以
    public int largestRectangleArea(int[] heights) {
        return largestRect(heights, 0, heights.length - 1);
    }

    private int largestRect(int[] heights, int start, int end) {
        if (start > end) return 0;
        if (start == end) return heights[start];
        int minIndex = start;
        // 使用是否有序排列的变量可以显著提高效率
        // 这里可以检测双向（变大或者变小的顺序）
        int inc = 0, dec = 0;
        for (int i = start + 1; i <= end; i++) {
            if (heights[i] < heights[minIndex]) minIndex = i;
            if (heights[i] > heights[i - 1]) inc++; // 升序
            else if (heights[i] < heights[i - 1]) dec--; // 降序
        }
        int res = 0;
        // 升序
        if (dec == 0) {
            for (int i = start; i <= end; i++)
                res = Math.max(res, heights[i] * (end - i + 1));
        } // 降序
        else if (inc == 0) {
            for (int i = start; i <= end; i++)
                res = Math.max(res, heights[i] * (i - start + 1));
        } // 无序
        else {
            res = Math.max(Math.max(largestRect(heights, minIndex + 1, end), largestRect(heights, start, minIndex - 1)),
                    heights[minIndex] * (end - start + 1));
        }
        return res;
    }

    // 这是第一反应的做法，MLE内存超限
    public int largestRectangleAreaNaive(int[] heights) {
        int bound = heights.length;
        if (bound == 0) return 0;
        if (bound == 1) return heights[0];
        // min[i][j] 是指从i到j的最小值（含i和j）
        int[][] min = new int[bound][bound];
        for (int i = 0; i < bound; i++) {
            min[i][i] = heights[i];
            for (int j = i + 1; j < bound; j++) {
                min[i][j] = Math.min(heights[j], min[i][j - 1]);
            }
        }
        int res = 0;
        for (int i = 0; i < bound; i++) {
            for (int j = i; j < bound; j++) {
                int area = min[i][j] * (j - i + 1);
                res = Math.max(res, area);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
