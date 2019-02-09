public class HIndex2 {
    // 二分的难题
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int lo = 0, hi = n - 1;
        // 基本的二分模版
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2, essayCount = n - mid;
            if (citations[mid] < essayCount) lo = mid + 1;
            else hi = mid;
        }
        if (citations[lo] == 0) return 0;
        return n - lo;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex2().hIndex(new int[]{0, 1, 3, 6, 5}));
    }
}
