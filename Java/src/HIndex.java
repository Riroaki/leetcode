public class HIndex {
    // 其实原理就是桶排序bucket sort
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int[] bucket = new int[n + 1];
        // bucket代表citation刚好为N的文章个数
        for (int citation : citations) {
            if (citation > n) bucket[n]++;
            else bucket[citation]++;
        }
        for (int i = n, count = 0; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new HIndex().hIndex(new int[]{0}));
        System.out.println(new HIndex().hIndex(new int[]{3, 1, 2}));
    }
}
