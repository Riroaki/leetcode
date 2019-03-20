public class FourSum2 {
    // O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length, res = 0;
        Map<Integer, Integer> sums1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for  (int j = 0; j < n; j++) {
                int tmp = A[i] + B[j];
                sums1.put(tmp, sums1.getOrDefault(tmp, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = C[i] + D[j];
                res += sums1.getOrDefault(-tmp, 0);
            }
        }
        return res;
    }
}
