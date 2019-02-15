public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        int[] minSmallerIndex = new int[n], maxLargerIndex = new int[n];
        int maxFromRightIndex = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            int maxIndex = -1;
            for (int j = n - 1; j > i; j--) {
                if (A[j] >= A[i]) {
                    if (maxIndex == -1 || A[j] <= A[maxIndex]) maxIndex = j;
                }
            }
            if (maxIndex != -1 && A[i] <= A[maxIndex]) maxLargerIndex[i] = maxIndex;
            int minIndex = -1;
            for (int j = n - 1; j > i; j--) {
                if (A[j] <= A[i]) {
                    if (minIndex == -1 || A[j] >= A[minIndex]) minIndex = j;
                }
            }
            if (minIndex != -1 && A[i] >= A[minIndex]) minSmallerIndex[i] = minIndex;
        }
        // 测试每一个开头是否合法
        int res = 1;
        for (int start = n - 2; start >= 0; start--) {
            boolean oddJump = true;
            int currentIndex = start;
            while (currentIndex < n - 1) {
                if (oddJump) {
                    if (minSmallerIndex[currentIndex] == 0) break;
                    else currentIndex = minSmallerIndex[currentIndex];
                } else if (maxLargerIndex[currentIndex] == 0) break;
                else currentIndex = maxLargerIndex[currentIndex];
                oddJump = !oddJump;
            }
            if (currentIndex == n - 1) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new OddEvenJump().oddEvenJumps(new int[]{10, 13, 12, 14, 15}));
        System.out.println(new OddEvenJump().oddEvenJumps(new int[]{2, 3, 1, 1, 4}));

    }
}
