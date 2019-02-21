public class SquaresOfSortedArray {
    // Return 0's or the first positive number's index
    private int findZero(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        int n = A.length, positive = findZero(A), negative = positive - 1, fill = 0;
        int[] res = new int[n];
        if (A[positive] == 0) {
            positive++;
            res[fill++] = 0;
        }
        while (positive < n && negative >= 0) {
            int a = A[positive], b = A[negative];
            if (a + b < 0) {
                res[fill++] = a * a;
                positive++;
            } else {
                res[fill++] = b * b;
                negative--;
            }
        }
        while (positive < n) {
            res[fill++] = A[positive] * A[positive];
            positive++;
        }
        while (negative >= 0) {
            res[fill++] = A[negative] * A[negative];
            negative--;
        }
        return res;
    }
}
