// 这题和"能盛最多水"题目的区别在于，这题需要考虑的是l到r之间所有的木板的最小值作为总高度
public class LargestRectangleInHistogram {
    // 使用Sort之前：427 ms, faster than 12.19% of Java
    // 使用Sort之后：1 ms, faster than 100.00% of Java
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

    // MLE，内存超限
    public int largestRectangleAreaNaive(int[] heights) {
        int bound = heights.length;
        if (bound == 0) return 0;
        if (bound == 1) return heights[0];
        // min[i][j] means the min value between i and j.
        int[][] min = new int[bound][bound];
        for (int i = 0; i < bound; i++) {
            min[i][i] = heights[i];
            for (int j = i + 1; j < bound; j++) {
                min[i][j] = heights[j] < min[i][j - 1] ? heights[j] : min[i][j - 1];
            }
        }
        int res = 0;
        for (int i = 0; i < bound; i++) {
            for (int j = i; j < bound; j++) {
                int area = min[i][j] * (j - i + 1);
                if (area > res) res = area;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
